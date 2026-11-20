// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application;

import domain.model.LoanEvent;
import domain.port.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class NotificationEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(NotificationEventHandler.class);
    
    private final NotificationService notificationService;

    public NotificationEventHandler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void handleEvent(LoanEvent event) {
      throw new UnsupportedOperationException("TODO(reto): handleEvent");
    }
}