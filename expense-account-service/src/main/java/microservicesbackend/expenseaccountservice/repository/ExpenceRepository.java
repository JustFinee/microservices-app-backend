package microservicesbackend.expenseaccountservice.repository;

import microservicesbackend.expenseaccountservice.entity.Expence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ExpenceRepository extends JpaRepository<Expence,Long> {

    @Query(value = "Select * FROM Expence e WHERE e.id_user = :id_user AND e.date BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<Expence> getExpences(@Param("id_user") Long idUser, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
