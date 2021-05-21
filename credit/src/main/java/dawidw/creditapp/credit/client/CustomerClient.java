package dawidw.creditapp.credit.client;

import dawidw.creditapp.credit.model.customer.CreateCustomerRequest;
import dawidw.creditapp.credit.model.customer.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "customerclient", url = "${customer.host}")
public interface CustomerClient {

    @PostMapping("/customers")
    void createCustomer(@RequestBody CreateCustomerRequest request);

    @GetMapping("/customers")
    List<CustomerDTO> getCustomers(@RequestParam List<UUID> creditIds);

}
