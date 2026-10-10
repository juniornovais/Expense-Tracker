package boot.spring.expenseTracker.repository;

import boot.spring.expenseTracker.entitie.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
