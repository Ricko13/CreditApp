package dawidw.creditapp.credit.model.credit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDTO implements Serializable {

    private UUID creditId;
    private String firstName;
    private String surname;
    private String pesel;
    private String productName;
    private BigDecimal value;
    private String creditName;

}
