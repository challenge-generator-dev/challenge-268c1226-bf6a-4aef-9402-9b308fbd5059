// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import domain.model.LoanEvent;
import domain.port.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class EventBusIntegrationAdapter {

    private static final Logger logger = LoggerFactory.getLogger(EventBusIntegrationAdapter.class);

    private final EventBus eventBus;

    public EventBusIntegrationAdapter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publishEvent(String topic, String message) {
      throw new UnsupportedOperationException("TODO(reto): publishEvent");
    }

    private LoanEvent parseMessageToEvent(String message) {
      throw new UnsupportedOperationException("TODO(reto): parseMessageToEvent");
    }

    public Mono<Void> publishEventAsync(String topic, LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): publishEventAsync");
    }

    public boolean validateTopic(String topic) {
      throw new UnsupportedOperationException("TODO(reto): validateTopic");
    }
}