# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/application/LoanEventPublisher.java` — La pieza p1 (publicación de eventos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/adapter/EventBusAdapter.java` — La pieza p2 (adaptación a bus de eventos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/NotificationEventHandler.java` — La pieza p3 (manejo de eventos, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/adapter/EventConsumerAdapter.java` — La pieza p4 (consumo de eventos, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/IntegrationTestService.java` — La pieza p5 (prueba de integración, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/adapter/EventBusIntegrationAdapter.java` — La pieza p6 (adaptación de integración al bus de eventos, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Senior L2

### Brecha de conocimiento
Implementa la publicación y el consumo de eventos de dominio entre servicios, con manejo de reintentos y consumo idempotente.

### Reto
- Tema: Comunicación asíncrona con eventos entre servicios
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de eventos de dominio entre servicios
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Publicación de eventos — objetivo: Implementar la publicación de eventos de dominio desde el sistema de gestión de préstamos. — entregable (NO resolver): Sistema de gestión de préstamos que publica eventos de dominio de manera asíncrona y idempotente.
- Fase 2: Consumo de eventos — objetivo: Implementar el consumo de eventos de dominio en el sistema de notificaciones. — entregable (NO resolver): Sistema de notificaciones que consume eventos de dominio de manera asíncrona, idempotente y con reintentos.
- Fase 3: Integración y verificación — objetivo: Integrar y verificar la comunicación asíncrona entre el sistema de gestión de préstamos y el sistema de notificaciones. — entregable (NO resolver): Sistema integrado que comunica de manera asíncrona el sistema de gestión de préstamos y el sistema de notificaciones, con verificación de funcionamiento correcto y manejo de eventos repetidos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/model/LoanEvent.java ===
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

// === ARCHIVO: src/main/java/domain/port/EventBus.java ===
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

// === ARCHIVO: src/main/java/domain/port/NotificationService.java ===
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

// === ARCHIVO: src/main/java/application/LoanEventPublisher.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/EventBusAdapter.java ===
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

// === ARCHIVO: src/main/java/application/NotificationEventHandler.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/EventConsumerAdapter.java ===
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

// === ARCHIVO: src/main/java/application/IntegrationTestService.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/EventBusIntegrationAdapter.java ===
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

// === ARCHIVO: src/main/java/application.properties ===
# Configuración del servidor
server.port=8080
spring.application.name=loan-management

# Configuración de Kafka
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=loan-notification-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer

# Configuración de Actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
management.metrics.enable.jvm=true

# Configuración de logging
logging.level.root=INFO
logging.level.com.example=DEBUG
logging.level.org.springframework.kafka=INFO
logging.level.org.apache.kafka=WARN

# Configuración de Jackson
spring.jackson.serialization.write-dates-as-timestamps=false
spring.jackson.default-property-inclusion=non_null

# Configuración de la aplicación
spring.main.allow-bean-definition-overriding=false
spring.main.banner-mode=console

// === ARCHIVO: src/main/java/LoanManagementApplication.java ===
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
```
