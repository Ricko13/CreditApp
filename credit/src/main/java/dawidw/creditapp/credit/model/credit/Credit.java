package dawidw.creditapp.credit.model.credit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Type(type = "uuid-char")
    @Column(name = "CreditId")
    private UUID creditId = UUID.randomUUID();

    @NotBlank
    @Column(name = "CreditName")
    private String creditName;

    public Credit(@NotBlank String creditName) {
        this.creditName = creditName;
    }
}
