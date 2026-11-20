package domain.port;

import domain.model.LoanEvent;
import reactor.core.publisher.Mono;

/**
 * Puerto de salida del dominio para la comunicación asíncrona por eventos.
 * La interfaz vive en la capa de dominio; la infraestructura provee la implementación.
 */
public interface EventBus {

    /**
     * Publica un evento de dominio de forma asíncrona.
     * El Mono se completa cuando el evento ha sido entregado al canal.
     */
    Mono<Void> publish(LoanEvent event);

    /**
     * Registra un manejador para un tipo de evento concreto.
     * Cada suscripción recibe únicamente los eventos del tipo indicado.
     */
    Mono<Void> subscribe(String eventType, EventHandler handler);

    /**
     * Contrato que implementa quien consume eventos del bus.
     * Debe ser idempotente: el mismo evento puede llegar más de una vez.
     */
    interface EventHandler {
        Mono<Void> handle(LoanEvent event);
    }
}