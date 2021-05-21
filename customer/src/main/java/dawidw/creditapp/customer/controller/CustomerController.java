package dawidw.creditapp.customer.controller;

import dawidw.creditapp.customer.model.CreateCustomerRequest;
import dawidw.creditapp.customer.model.CustomerDTO;
import dawidw.creditapp.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomersForCreditIds(@RequestParam List<UUID> creditIds) {
        return ResponseEntity.ok(customerService.getCustomersForCreditIds(creditIds));
    }

    @PostMapping
    public Long createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

}
