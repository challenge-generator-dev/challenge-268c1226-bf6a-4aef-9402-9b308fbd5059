package domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/*
 * Evento de dominio que se emite cuando un prestamo es aprobado.
 * El identificador y el instante del evento llegan desde fuera: el dominio no genera
 * su propia identidad ni su propio reloj, lo que permite reproducir el evento y
 * detectar duplicados de forma determinista.
 */
public record LoanEvent(
        UUID eventId,
        UUID loanId,
        String customerId,
        double amount,
        Instant approvalTimestamp,
        String status,
        String eventType) {

    public static final String STATUS_APPROVED = "APPROVED";
    public static final String TYPE_LOAN_APPROVED = "LOAN_APPROVED";

    public LoanEvent {
        Objects.requireNonNull(eventId, "eventId cannot be null");
        Objects.requireNonNull(loanId, "loanId cannot be null");
        Objects.requireNonNull(approvalTimestamp, "approvalTimestamp cannot be null");
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("customerId cannot be null or empty");
        }
        if (Double.isNaN(amount) || amount <= 0) {
            throw new IllegalArgumentException("amount must be a positive number");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("status cannot be null or empty");
        }
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("eventType cannot be null or empty");
        }
    }

    public static LoanEvent createLoanApprovedEvent(UUID eventId, UUID loanId, String customerId,
                                                    double amount, Instant approvalTimestamp) {
        return new LoanEvent(
                eventId,
                loanId,
                customerId,
                amount,
                approvalTimestamp,
                STATUS_APPROVED,
                TYPE_LOAN_APPROVED
        );
    }

    public boolean isApproved() {
        return STATUS_APPROVED.equals(status);
    }

    public boolean isIdempotentKeyValid() {
        return eventId != null && loanId != null;
    }
}