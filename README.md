# Implementación de eventos de dominio entre servicios

El sistema de gestión de préstamos y el sistema de notificaciones deben comunicarse de manera asíncrona mediante eventos. El sistema de gestión de préstamos publica eventos cuando se aprueba un préstamo, y el sistema de notificaciones consume estos eventos para enviar notificaciones a los clientes. Debes implementar la publicación y el consumo de eventos de dominio entre estos servicios, con manejo de reintentos y consumo idempotente para evitar duplicados.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Comunicación asíncrona con eventos entre servicios |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** Spring Boot 3.5
- **Version:** Java 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Publicación de eventos

**Objetivo:** Implementar la publicación de eventos de dominio desde el sistema de gestión de préstamos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica los eventos de dominio que deben publicarse cuando se aprueba un préstamo.
- Implementa la publicación de estos eventos de manera asíncrona.
- Asegúrate de que la publicación de eventos sea idempotente para evitar duplicados.

**Entregable:** Sistema de gestión de préstamos que publica eventos de dominio de manera asíncrona y idempotente.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de un broker de mensajes para la publicación de eventos.
- Investiga patrones de diseño para garantizar la idempotencia en la publicación de eventos.

</details>

### Fase 2: Consumo de eventos

**Objetivo:** Implementar el consumo de eventos de dominio en el sistema de notificaciones.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica los eventos de dominio que debe consumir el sistema de notificaciones.
- Implementa el consumo de estos eventos de manera asíncrona.
- Asegúrate de que el consumo de eventos sea idempotente para evitar duplicados.
- Implementa un mecanismo de reintentos para manejar fallos transitorios en el consumo de eventos.

**Entregable:** Sistema de notificaciones que consume eventos de dominio de manera asíncrona, idempotente y con reintentos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de un broker de mensajes para el consumo de eventos.
- Investiga patrones de diseño para garantizar la idempotencia en el consumo de eventos.

</details>

### Fase 3: Integración y verificación

**Objetivo:** Integrar y verificar la comunicación asíncrona entre el sistema de gestión de préstamos y el sistema de notificaciones.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Integra el sistema de gestión de préstamos y el sistema de notificaciones.
- Verifica que los eventos se publiquen y consuman correctamente.
- Asegúrate de que los eventos repetidos no dupliquen efectos.
- Realiza pruebas de carga y verifica el comportamiento del sistema bajo condiciones de alta demanda.

**Entregable:** Sistema integrado que comunica de manera asíncrona el sistema de gestión de préstamos y el sistema de notificaciones, con verificación de funcionamiento correcto y manejo de eventos repetidos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de pruebas y monitoreo para verificar el comportamiento del sistema.
- Considera el uso de cargas de prueba para simular condiciones de alta demanda.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los eventos de dominio y cómo se utilizan en la comunicación asíncrona entre servicios?
- **paraQueSirve**: ¿Para qué sirve la comunicación asíncrona entre servicios mediante eventos de dominio?
- **comoSeUsa**: ¿Cómo se implementa la publicación y el consumo de eventos de dominio entre servicios?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar la comunicación asíncrona entre servicios mediante eventos de dominio?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de la comunicación asíncrona entre servicios mediante eventos de dominio?

## Criterios de Evaluacion

- Implementación correcta de la publicación de eventos de dominio desde el sistema de gestión de préstamos.
- Implementación correcta del consumo de eventos de dominio en el sistema de notificaciones.
- Garantía de idempotencia en la publicación y consumo de eventos para evitar duplicados.
- Implementación de un mecanismo de reintentos para manejar fallos transitorios en el consumo de eventos.
- Integración y verificación correcta de la comunicación asíncrona entre el sistema de gestión de préstamos y el sistema de notificaciones.

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

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ha trabajado solo con llamadas síncronas entre servicios | chequeo estatico (code): prohibe `HttpClient`, `RestTemplate`, `WebClient` | Verificada |

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
