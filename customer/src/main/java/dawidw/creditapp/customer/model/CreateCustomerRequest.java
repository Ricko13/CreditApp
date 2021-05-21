package dawidw.creditapp.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomerRequest implements Serializable {

    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    @NotBlank
    private String pesel;
    private UUID creditId;

}
