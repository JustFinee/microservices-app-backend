package microservicesbackend.expenseaccountservice.repository;

import microservicesbackend.expenseaccountservice.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory,Long> {
}
