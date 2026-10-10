package boot.spring.expenseTracker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseRequest(
        String description,
        BigDecimal Amount,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date
) {
}
