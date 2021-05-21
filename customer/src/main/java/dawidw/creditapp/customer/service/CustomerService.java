package dawidw.creditapp.customer.service;

import dawidw.creditapp.customer.model.CreateCustomerRequest;
import dawidw.creditapp.customer.model.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getCustomersForCreditIds(List<UUID> creditIds);

    Long createCustomer(CreateCustomerRequest request);

}
