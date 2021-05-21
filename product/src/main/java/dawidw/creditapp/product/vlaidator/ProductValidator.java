package dawidw.creditapp.product.vlaidator;

import dawidw.creditapp.product.model.CreateProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface ProductValidator {

    default void validate(@Valid CreateProductRequest request) {
    }

    @Validated
    @Component
    class ProductValidatorImpl implements ProductValidator {

    }

}
