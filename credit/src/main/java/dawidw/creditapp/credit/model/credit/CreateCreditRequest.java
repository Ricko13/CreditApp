package dawidw.creditapp.credit.model.credit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCreditRequest implements Serializable {

    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    @NotBlank
    private String pesel;
    @NotBlank
    private String productName;
    @NotNull
    @Digits(integer = 17, fraction = 2)
    private BigDecimal value;
    @NotBlank
    private String creditName;

}
