package dawidw.creditapp.credit.service;

import com.google.common.collect.Maps;
import dawidw.creditapp.credit.client.CustomerClient;
import dawidw.creditapp.credit.client.ProductClient;
import dawidw.creditapp.credit.mapper.CreditMapper;
import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import dawidw.creditapp.credit.model.credit.Credit;
import dawidw.creditapp.credit.model.credit.CreditDTO;
import dawidw.creditapp.credit.model.customer.CustomerDTO;
import dawidw.creditapp.credit.model.product.ProductDTO;
import dawidw.creditapp.credit.repository.CreditRepository;
import dawidw.creditapp.credit.validator.CreditValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Transactional
@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper mapper;
    private final CreditValidator validator;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public UUID creteCredit(CreateCreditRequest request) {
        validator.validate(request);
        Credit credit = new Credit(request.getCreditName());
        productClient.createProduct(mapper.createProductRequest(request, credit.getCreditId()));
        customerClient.createCustomer(mapper.createCustomerRequest(request, credit.getCreditId()));
        return creditRepository.save(credit).getCreditId();
    }

    @Override
    public List<CreditDTO> getCredits() {
        List<Credit> credits = StreamSupport.stream(creditRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<UUID> creditIds = credits.stream().map(Credit::getCreditId).collect(Collectors.toList());
        return createPopulatedCreditDTO(credits, getCustomers(creditIds), getProducts(creditIds));
    }

    private List<CreditDTO> createPopulatedCreditDTO(List<Credit> credits, Map<UUID, CustomerDTO> customers, Map<UUID, ProductDTO> products) {
        return credits.stream()
                .map(credit -> mapper.toDTO(credit, customers.get(credit.getCreditId()), products.get(credit.getCreditId())))
                .collect(Collectors.toList());
    }

    private Map<UUID, CustomerDTO> getCustomers(List<UUID> creditIds) {
        List<CustomerDTO> customers = customerClient.getCustomers(creditIds);
        return Maps.uniqueIndex(customers, CustomerDTO::getCreditId);
    }

    private Map<UUID, ProductDTO> getProducts(List<UUID> creditIds) {
        List<ProductDTO> products = productClient.getProducts(creditIds);
        return Maps.uniqueIndex(products, ProductDTO::getCreditId);
    }

}
