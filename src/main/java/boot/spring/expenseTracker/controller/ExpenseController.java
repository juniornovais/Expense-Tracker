package boot.spring.expenseTracker.controller;

import boot.spring.expenseTracker.dto.ExpenseRequest;
import boot.spring.expenseTracker.dto.ExpenseResponse;
import boot.spring.expenseTracker.dto.ExpenseSummaryResponse;
import boot.spring.expenseTracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponse> createdExpense(@RequestBody ExpenseRequest expenseRequest) {
        ExpenseResponse expenseResponse = expenseService.created(expenseRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(expenseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> showExpense(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.show(id));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> showExpenseAll(){
        return ResponseEntity.ok(expenseService.showAll());
    }

    @GetMapping("/summary")
    public ResponseEntity<ExpenseSummaryResponse> summary() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(expenseService.summaryResume());
    }

    @GetMapping("/summary/month")
    public ResponseEntity<ExpenseSummaryResponse> summaryMonth(@RequestParam("data") LocalDate data){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(expenseService.summaryResumeMonth(data));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
