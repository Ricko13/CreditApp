package dawidw.creditapp.credit.controller;

import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import dawidw.creditapp.credit.model.credit.CreditDTO;
import dawidw.creditapp.credit.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    @PostMapping
    public ResponseEntity<UUID> createCredit(@RequestBody CreateCreditRequest request) {
        return ResponseEntity.ok(creditService.creteCredit(request));
    }

    @GetMapping
    public ResponseEntity<List<CreditDTO>> getCredits() {
        return ResponseEntity.ok(creditService.getCredits());
    }

}
