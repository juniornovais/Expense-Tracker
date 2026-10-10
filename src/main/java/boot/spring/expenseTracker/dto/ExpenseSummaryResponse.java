package boot.spring.expenseTracker.dto;

import java.math.BigDecimal;

public record ExpenseSummaryResponse (
        BigDecimal amount
) {
}
