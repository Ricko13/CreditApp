package dawidw.creditapp.customer.validator;

import dawidw.creditapp.customer.model.CreateCustomerRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface CustomerValidator {

    default void valid(@Valid CreateCustomerRequest request){};

    @Validated
    @Component
    class CustomerValidatorImpl implements CustomerValidator {

        /*@Override
        public void valid(@Valid CreateCustomerRequest request) {

        }*/
    }

}
