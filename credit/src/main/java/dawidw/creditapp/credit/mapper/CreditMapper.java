package dawidw.creditapp.credit.mapper;

import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import dawidw.creditapp.credit.model.credit.Credit;
import dawidw.creditapp.credit.model.credit.CreditDTO;
import dawidw.creditapp.credit.model.customer.CreateCustomerRequest;
import dawidw.creditapp.credit.model.customer.CustomerDTO;
import dawidw.creditapp.credit.model.product.CreateProductRequest;
import dawidw.creditapp.credit.model.product.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(source = "credit.creditId", target = "creditId")
    @Mapping(source = "credit.creditName", target = "creditName")
    @Mapping(source = "customer.firstName", target = "firstName")
    @Mapping(source = "customer.surname", target = "surname")
    @Mapping(source = "customer.pesel", target = "pesel")
    @Mapping(source = "product.productName", target = "productName")
    @Mapping(source = "product.value", target = "value")
    CreditDTO toDTO(Credit credit, CustomerDTO customer, ProductDTO product);


    default CreateCustomerRequest createCustomerRequest(CreateCreditRequest request, UUID creditId) {
        return CreateCustomerRequest.builder()
                .creditId(creditId)
                .firstName(request.getFirstName())
                .surname(request.getSurname())
                .pesel(request.getPesel())
                .build();
    }

    default CreateProductRequest createProductRequest(CreateCreditRequest request, UUID creditId) {
        return CreateProductRequest.builder()
                .creditId(creditId)
                .productName(request.getProductName())
                .value(request.getValue())
                .build();
    }
}
