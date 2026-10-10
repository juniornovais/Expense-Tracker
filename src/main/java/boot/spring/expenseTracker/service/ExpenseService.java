package boot.spring.expenseTracker.service;

import boot.spring.expenseTracker.dto.ExpenseRequest;
import boot.spring.expenseTracker.dto.ExpenseResponse;
import boot.spring.expenseTracker.dto.ExpenseSummaryResponse;
import boot.spring.expenseTracker.entitie.Expense;
import boot.spring.expenseTracker.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseResponse created(ExpenseRequest dto) {
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

    public ExpenseResponse show(Long id) {
    Expense expense = expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("expense not found."));

    return new ExpenseResponse(
            expense.getId(),
            expense.getDescription(),
            expense.getAmount(),
            expense.getDate()
    );
    }

    public List<ExpenseResponse> showAll() {
        return expenseRepository.findAll().stream()
                .map(expense -> new ExpenseResponse(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate()
                )).toList();
    }

    public ExpenseSummaryResponse summaryResume() {
        BigDecimal total =  showAll().stream()
                .map(ExpenseResponse::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ExpenseSummaryResponse(total);
    }


    public ExpenseSummaryResponse summaryResumeMonth(LocalDate date) {
        int currentYear = LocalDate.now().getYear();
        BigDecimal totalMonth = showAll().stream()
                .filter(m -> m.date().getMonth() == date.getMonth()
                    && m.date().getYear() == date.getYear()
                 )
                .map(ExpenseResponse::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ExpenseSummaryResponse(totalMonth);
    }

    public void delete(Long id) {
        if(!expenseRepository.existsById(id)) {
            throw new RuntimeException("Espense not found.");
        }

        expenseRepository.deleteById(id);

    }
}
