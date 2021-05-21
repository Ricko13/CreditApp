package dawidw.creditapp.customer.mapper;

import dawidw.creditapp.customer.model.CreateCustomerRequest;
import dawidw.creditapp.customer.model.Customer;
import dawidw.creditapp.customer.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring") //todo po co component model??
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CreateCustomerRequest request);
}
