package boot.spring.expenseTracker.service;

import boot.spring.expenseTracker.dto.ExpenseRequest;
import boot.spring.expenseTracker.dto.ExpenseResponse;
import boot.spring.expenseTracker.entitie.Expense;
import boot.spring.expenseTracker.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseResponse criar(ExpenseRequest dto) {
        Expense expense = new Expense();

        expense.setDescription(dto.description());
        expense.setAmount(dto.Amount());
        expense.setDate(dto.date());

        Expense expenseSave = expenseRepository.save(expense);

        return new ExpenseResponse(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getDate()
        ) ;
    }
}
