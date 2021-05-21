package dawidw.creditapp.credit.repository;

import dawidw.creditapp.credit.model.credit.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    Optional<Credit> findByCreditId(UUID uuid);
}
