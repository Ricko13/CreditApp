package dawidw.creditapp.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductDTO implements Serializable {

    private Long id;
    private UUID creditId;
    private String productName;
    private BigDecimal value;


}
