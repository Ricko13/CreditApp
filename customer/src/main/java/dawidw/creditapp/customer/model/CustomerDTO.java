package dawidw.creditapp.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomerDTO implements Serializable {

    private Long id;
    private String firstName;
    private String surname;
    private String pesel;
    private UUID creditId;

}
