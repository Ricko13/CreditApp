package dawidw.creditapp.customer.service;

import dawidw.creditapp.customer.mapper.CustomerMapper;
import dawidw.creditapp.customer.model.CreateCustomerRequest;
import dawidw.creditapp.customer.model.CustomerDTO;
import dawidw.creditapp.customer.repository.CustomerRepository;
import dawidw.creditapp.customer.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerValidator customerValidator;

    @Override
    public Long createCustomer(CreateCustomerRequest request) {
        //todo validator instead of @Valid on controller
        //todo walidacja czy istnieje już dla takiego pesel+creditId > I WTEDY W WALIDATORZE DAJESZ @Valid i gitara
        customerValidator.valid(request);
        return customerRepository.save(customerMapper.toEntity(request)).getId();
    }

    @Override
    public List<CustomerDTO> getCustomersForCreditIds(List<UUID> creditIds) { //todo @NotEmpty
        return customerRepository.getCustomersForCreditIds(creditIds).stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

}
