package dawidw.creditapp.credit;

import dawidw.creditapp.credit.client.CustomerClient;
import dawidw.creditapp.credit.client.ProductClient;
import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import dawidw.creditapp.credit.model.credit.Credit;
import dawidw.creditapp.credit.model.credit.CreditDTO;
import dawidw.creditapp.credit.model.customer.CustomerDTO;
import dawidw.creditapp.credit.model.product.ProductDTO;
import dawidw.creditapp.credit.repository.CreditRepository;
import dawidw.creditapp.credit.service.CreditService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
//@TestPropertySource("file:src/test/resources/jdbc.properties")  //todo configure in memory db for tests - connects to main db now
class CreditServiceIT {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditRepository creditRepository;

    @MockBean
    private CustomerClient customerClient;

    @MockBean
    private ProductClient productClient;

    @Test
    void contextLoads() {
        assertThat(creditService).isNotNull();
    }

    @Test
    void givenCorrectDataWhenCreateCreditShouldCreateEntity() {
        CreateCreditRequest request = buildCreateCreditRequest(BigDecimal.TEN);
        UUID uuid = creditService.creteCredit(request);
        Optional<Credit> created = creditRepository.findByCreditId(uuid);
        Assertions.assertTrue(created.isPresent());
        Assertions.assertEquals(request.getCreditName(), created.get().getCreditName());
    }

    @Test
    void givenIncorrectValueWhenCreateCreditShouldThrowException() {
        assertThrows(ConstraintViolationException.class, () ->
                creditService.creteCredit(buildCreateCreditRequest(new BigDecimal("10.000"))));
    }

    @Test
    void givenCreatedCreditThenGetCreditsShouldReturnPopulatedCreditDTO() {
        CreateCreditRequest request = buildCreateCreditRequest(BigDecimal.TEN);
        UUID creditId = creditService.creteCredit(request);

        when(productClient.getProducts(any())).thenReturn(singletonList(getProductDtoFromRequest(request, creditId)));
        when(customerClient.getCustomers(any())).thenReturn(singletonList(getCustomerDtoFromRequest(request, creditId)));

        List<CreditDTO> credits = creditService.getCredits();
        credits.forEach(creditDTO -> {
            if (creditDTO.getCreditId().equals(creditId)) {
                assertEquals(request.getFirstName(), creditDTO.getFirstName());
                assertEquals(request.getValue(), creditDTO.getValue());
            }
        });
    }

    private ProductDTO getProductDtoFromRequest(CreateCreditRequest request, UUID creditId) {
        return ProductDTO.builder()
                .creditId(creditId)
                .productName(request.getProductName())
                .value(request.getValue())
                .build();
    }

    private CustomerDTO getCustomerDtoFromRequest(CreateCreditRequest request, UUID creditId) {
        return CustomerDTO.builder()
                .creditId(creditId)
                .firstName(request.getFirstName())
                .surname(request.getSurname())
                .pesel(request.getPesel())
                .build();
    }


    private CreateCreditRequest buildCreateCreditRequest(BigDecimal value) {
        return CreateCreditRequest.builder()
                .creditName("credit")
                .firstName("name")
                .surname("surname")
                .pesel("12345678")
                .productName("product")
                .value(value)
                .build();
    }

}
