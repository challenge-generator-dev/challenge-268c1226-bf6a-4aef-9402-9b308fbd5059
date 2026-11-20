// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application;

import domain.model.LoanEvent;
import domain.port.NotificationService;
import java.time.Instant;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class IntegrationTestService {

    private static final Logger logger = LoggerFactory.getLogger(IntegrationTestService.class);

    private final NotificationService notificationService;

    public IntegrationTestService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void testIntegration() {
      throw new UnsupportedOperationException("TODO(reto): testIntegration");
    }

    private LoanEvent createTestEvent() {
      throw new UnsupportedOperationException("TODO(reto): createTestEvent");
    }

    private void validateEvent(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): validateEvent");
    }

    public Mono<Void> testEventWithMissingData(String customerId, double amount) {
      throw new UnsupportedOperationException("TODO(reto): testEventWithMissingData");
    }

    public Mono<Void> testDuplicateEvent(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): testDuplicateEvent");
    }

    public Mono<Void> testInvalidEventPublishing(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): testInvalidEventPublishing");
    }
}