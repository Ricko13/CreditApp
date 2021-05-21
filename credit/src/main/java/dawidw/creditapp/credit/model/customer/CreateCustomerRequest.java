package dawidw.creditapp.credit.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CreateCustomerRequest implements Serializable {
    private String firstName;
    private String surname;
    private String pesel;
    private UUID creditId;
}
