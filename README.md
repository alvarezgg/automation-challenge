# automation-challenge

## Pre-requisitos

#### :small_red_triangle_down: [Java >= 1.8](https://www.oracle.com/java/technologies/downloads/)
#### :small_red_triangle_down: [Maven](https://maven.apache.org)

---

## Ejecucion de tests

En una terminal, dentro del directorio raíz, ejecutar:

```mvn clean test -DsuiteXmlFile=src/test/resources/suites/AllTests.xml```

Nota: El archivo a ejecutar, en este caso es AllTests.xml. Sustituir en base a necesidad.

El archivo <strong>config.properties</strong> podrá ser modificado para ejecutar en distintos navegadores (parametro <strong>browser</strong>) 

---

## Evidencias
El framework emplea la herramienta de reporting provista por TestNG para generación de documentos de evidencia, se encontrarán en el directorio <strong>target/surefire-reports</strong>

En caso de existir test fallidos, se encontraran las capturas de pantalla en el directorio <strong>fail_evidences</strong>