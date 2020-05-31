package microservicesbackend.expenseaccountservice.repository;

import microservicesbackend.expenseaccountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "Select * FROM Account a WHERE a.id_user = :id_user AND a.is_visible = false",nativeQuery = true)
    Account getInvisibleAccount(@Param("id_user") Long idUser);

    List<Account> findAllByIdUser(Long idUser);

}
