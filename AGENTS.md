# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de eventos de dominio entre servicios**.

| | |
|---|---|
| Tema | Comunicación asíncrona con eventos entre servicios |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con eventos |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.fasterxml.jackson.core:jackson-databind
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-validation
- org.springframework.kafka:spring-kafka

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Publicación de eventos**: Sistema de gestión de préstamos que publica eventos de dominio de manera asíncrona y idempotente.
- **Fase 2 — Consumo de eventos**: Sistema de notificaciones que consume eventos de dominio de manera asíncrona, idempotente y con reintentos.
- **Fase 3 — Integración y verificación**: Sistema integrado que comunica de manera asíncrona el sistema de gestión de préstamos y el sistema de notificaciones, con verificación de funcionamiento correcto y manejo de eventos repetidos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/application/LoanEventPublisher.java` — La pieza p1 (publicación de eventos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/adapter/EventBusAdapter.java` — La pieza p2 (adaptación a bus de eventos, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/NotificationEventHandler.java` — La pieza p3 (manejo de eventos, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/adapter/EventConsumerAdapter.java` — La pieza p4 (consumo de eventos, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/IntegrationTestService.java` — La pieza p5 (prueba de integración, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/adapter/EventBusIntegrationAdapter.java` — La pieza p6 (adaptación de integración al bus de eventos, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Publicación de eventos | publicación de eventos | `src/main/java/application/LoanEventPublisher.java:LoanEventPublisher` | El sistema de gestión de préstamos publica eventos de dominio de manera asíncrona.; La publicación de eventos es idempotente.; La publicación de un evento inválido lanza una excepción.; La publicación de un evento con datos faltantes lanza una excepción. | — | — |
| f1 — Publicación de eventos | adaptación a bus de eventos | `src/main/java/infrastructure/adapter/EventBusAdapter.java:EventBusAdapter` | El sistema de gestión de préstamos publica eventos de dominio de manera asíncrona.; La publicación de eventos es idempotente.; La publicación de un evento inválido lanza una excepción.; La publicación de un evento con datos faltantes lanza una excepción. | — | — |
| f2 — Consumo de eventos | manejo de eventos | `src/main/java/application/NotificationEventHandler.java:NotificationEventHandler` | El sistema de notificaciones consume eventos de dominio de manera asíncrona.; El consumo de eventos es idempotente.; El sistema de notificaciones reintenta el consumo de eventos fallidos.; El sistema de notificaciones maneja correctamente eventos con formato incorrecto. | — | — |
| f2 — Consumo de eventos | consumo de eventos | `src/main/java/infrastructure/adapter/EventConsumerAdapter.java:EventConsumerAdapter` | El sistema de notificaciones consume eventos de dominio de manera asíncrona.; El consumo de eventos es idempotente.; El sistema de notificaciones reintenta el consumo de eventos fallidos.; El sistema de notificaciones maneja correctamente eventos con formato incorrecto. | — | — |
| f3 — Integración y verificación | prueba de integración | `src/main/java/application/IntegrationTestService.java:IntegrationTest` | La comunicación asíncrona entre el sistema de gestión de préstamos y el sistema de notificaciones funciona correctamente.; Los eventos repetidos no duplican efectos en el sistema de notificaciones.; La integración maneja correctamente eventos con datos faltantes.; La integración lanza una excepción cuando se intenta publicar un evento inválido. | — | — |
| f3 — Integración y verificación | adaptación de integración al bus de eventos | `src/main/java/infrastructure/adapter/EventBusIntegrationAdapter.java:EventBusIntegrationAdapter` | La comunicación asíncrona entre el sistema de gestión de préstamos y el sistema de notificaciones funciona correctamente.; Los eventos repetidos no duplican efectos en el sistema de notificaciones.; La integración maneja correctamente eventos con datos faltantes.; La integración lanza una excepción cuando se intenta publicar un evento inválido. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ha trabajado solo con llamadas síncronas entre servicios | chequeo estatico (code): prohibe `HttpClient`, `RestTemplate`, `WebClient` | Verificada |

## Lo que falta y tenes que completar

No se detectaron huecos: estan los archivos declarados, el boilerplate del stack y ninguna referencia quedo colgando. Igual corre el comando de verificacion — que los archivos existan no garantiza que compilen.

### Presentes (12)

- `pom.xml`
- `src/main/java/domain/model/LoanEvent.java`
- `src/main/java/domain/port/EventBus.java`
- `src/main/java/domain/port/NotificationService.java`
- `src/main/java/application/LoanEventPublisher.java`
- `src/main/java/infrastructure/adapter/EventBusAdapter.java`
- `src/main/java/application/NotificationEventHandler.java`
- `src/main/java/infrastructure/adapter/EventConsumerAdapter.java`
- `src/main/java/application/IntegrationTestService.java`
- `src/main/java/infrastructure/adapter/EventBusIntegrationAdapter.java`
- `src/main/java/application.properties`
- `src/main/java/LoanManagementApplication.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/loan/management` (ausente)
- `src/main/java/com/loan/management/domain` (ausente)
- `src/main/java/com/loan/management/domain/model` (ausente)
- `src/main/java/com/loan/management/domain/port` (ausente)
- `src/main/java/com/loan/management/application` (ausente)
- `src/main/java/com/loan/management/infrastructure/adapter` (ausente)
- `src/main/java/com/loan/management/infrastructure/config` (ausente)
- `src/main/resources` (ausente)
- `src/test/java/com/loan/management` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con eventos**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Senior L2
- Brecha que el reto ataca: Implementa la publicación y el consumo de eventos de dominio entre servicios, con manejo de reintentos y consumo idempotente.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
