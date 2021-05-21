package dawidw.creditapp.customer.repository;

import dawidw.creditapp.customer.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> { //JpaRepository


    @Query("SELECT customer FROM Customer customer WHERE customer.creditId IN :creditIds")
    List<Customer> getCustomersForCreditIds(@Param("creditIds") List<UUID> creditIds);

}
