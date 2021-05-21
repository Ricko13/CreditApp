package dawidw.creditapp.credit.validator;

import dawidw.creditapp.credit.model.credit.CreateCreditRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface CreditValidator {

    default void validate(@Valid CreateCreditRequest request) {
    }

    @Validated
    @Component
    class CreditValidatorImpl implements CreditValidator {

    }

}
