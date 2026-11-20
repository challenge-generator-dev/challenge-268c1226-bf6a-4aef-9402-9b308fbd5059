package com.example.reto;

import application.IntegrationTestService;
import application.LoanEventPublisher;
import application.NotificationEventHandler;
import domain.model.LoanEvent;
import domain.port.EventBus;
import domain.port.NotificationService;
import infrastructure.adapter.EventBusAdapter;
import infrastructure.adapter.EventBusIntegrationAdapter;
import infrastructure.adapter.EventConsumerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.UUID;

@SpringBootApplication
@EnableKafka
public class LoanManagementApplication {

    private static final Logger logger = LoggerFactory.getLogger(LoanManagementApplication.class);

    public static void main(String[] args) {
        logger.info("Iniciando aplicacion de Gestion de Prestamos...");
        SpringApplication.run(LoanManagementApplication.class, args);
        logger.info("Aplicacion de Gestion de Prestamos iniciada correctamente");
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Bean
    public EventBus eventBus(ObjectMapper objectMapper) {
        logger.info("Configurando EventBus adapter");
        return new EventBusAdapter(objectMapper);
    }

    @Bean
    public NotificationService notificationService() {
        logger.info("Configurando servicio de notificaciones");
        return new NotificationService() {
            @Override
            public reactor.core.publisher.Mono<Void> sendNotification(LoanEvent event) {
                logger.info("Enviando notificacion para evento: {} - Prestamo: {} - Cliente: {}",
                        event.eventType(), event.loanId(), event.customerId());
                return reactor.core.publisher.Mono.empty();
            }

            @Override
            public reactor.core.publisher.Mono<Boolean> isEventProcessed(String eventId) {
                logger.debug("Verificando si evento ya fue procesado: {}", eventId);
                return reactor.core.publisher.Mono.just(false);
            }
        };
    }

    @Bean
    public LoanEventPublisher loanEventPublisher(EventBus eventBus) {
        logger.info("Configurando publicador de eventos de prestamos");
        return new LoanEventPublisher(eventBus);
    }

    @Bean
    public NotificationEventHandler notificationEventHandler(NotificationService notificationService) {
        logger.info("Configurando manejador de eventos de notificacion");
        return new NotificationEventHandler(notificationService);
    }

    @Bean
    public EventConsumerAdapter eventConsumerAdapter(EventBus eventBus, ObjectMapper objectMapper) {
        logger.info("Configurando adaptador de consumo de eventos");
        return new EventConsumerAdapter(eventBus, objectMapper);
    }

    @Bean
    public EventBusIntegrationAdapter eventBusIntegrationAdapter(EventBus eventBus) {
        logger.info("Configurando adaptador de integracion de bus de eventos");
        return new EventBusIntegrationAdapter(eventBus);
    }

    @Bean
    public IntegrationTestService integrationTestService(NotificationService notificationService) {
        logger.info("Configurando servicio de pruebas de integracion");
        return new IntegrationTestService(notificationService);
    }
}