// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.port.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class EventConsumerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumerAdapter.class);
    private static final int MAX_RETRY_ATTEMPTS = 3;
    
    private final EventBus eventBus;
    private final ObjectMapper objectMapper;

    public EventConsumerAdapter(EventBus eventBus, ObjectMapper objectMapper) {
        this.eventBus = eventBus;
        this.objectMapper = objectMapper;
    }

    public void consumeEvent(String message) {
      throw new UnsupportedOperationException("TODO(reto): consumeEvent");
    }

    private void handleRetry(String message) {
      throw new UnsupportedOperationException("TODO(reto): handleRetry");
    }
}