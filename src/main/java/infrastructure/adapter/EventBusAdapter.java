// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.LoanEvent;
import domain.port.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class EventBusAdapter implements EventBus {

    private static final Logger logger = LoggerFactory.getLogger(EventBusAdapter.class);
    
    private final ObjectMapper objectMapper;

    public EventBusAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Void> publish(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): publish");
    }

    @Override
    public Mono<Void> subscribe(String eventType, EventHandler handler) {
      throw new UnsupportedOperationException("TODO(reto): subscribe");
    }
}