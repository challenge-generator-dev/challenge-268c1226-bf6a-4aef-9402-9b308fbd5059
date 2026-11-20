// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application;

import domain.model.LoanEvent;
import domain.port.EventBus;
import reactor.core.publisher.Mono;

public class LoanEventPublisher {

    private final EventBus eventBus;

    public LoanEventPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publishEvent(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): publishEvent");
    }
}