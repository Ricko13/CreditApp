package dawidw.creditapp.product.repository;

import dawidw.creditapp.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT product FROM Product product WHERE product.creditId IN :creditIds")
    List<Product> getCustomersForCreditIds(@Param("creditIds") List<UUID> creditIds);

}
