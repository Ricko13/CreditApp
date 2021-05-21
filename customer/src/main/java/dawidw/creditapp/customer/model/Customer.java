package dawidw.creditapp.customer.model;

import lombok.AllArgsConstructor;
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
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Type(type = "uuid-char")
    @Column(name = "CreditID")
    private UUID creditId;

    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @Column(name = "Surname")
    private String surname;

    @NotNull
    @Column(name = "Pesel")
    private String pesel;

    public Customer(@NotNull String firstName, @NotNull String surname, @NotNull String pesel, UUID creditId) {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
        this.creditId = creditId;
    }
}
