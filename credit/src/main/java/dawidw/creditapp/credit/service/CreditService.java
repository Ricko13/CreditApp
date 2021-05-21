package dawidw.creditapp.credit.service;

import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import dawidw.creditapp.credit.model.credit.CreditDTO;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    UUID creteCredit(CreateCreditRequest request);

    List<CreditDTO> getCredits();
}
