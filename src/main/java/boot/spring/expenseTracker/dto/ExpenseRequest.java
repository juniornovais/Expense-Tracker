package boot.spring.expenseTracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(
        String description,
        BigDecimal Amount,
        LocalDate date
) {
}
