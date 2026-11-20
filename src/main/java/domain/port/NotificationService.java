package domain.port;

import domain.model.LoanEvent;
import reactor.core.publisher.Mono;

/**
 * Puerto de salida del dominio para el envío de notificaciones a los clientes.
 * El dominio define qué necesita; el adaptador de infraestructura decide cómo lo entrega.
 */
public interface NotificationService {

    /**
     * Envía la notificación asociada a un evento de dominio.
     * Los errores de entrega se propagan como señal de error del Mono para que
     * quien consume el evento decida si reintentar.
     */
    Mono<Void> sendNotification(LoanEvent event);

    /**
     * Indica si un evento ya fue procesado previamente.
     * Permite garantizar el consumo idempotente cuando el broker entrega duplicados.
     */
    Mono<Boolean> isEventProcessed(String eventId);
}