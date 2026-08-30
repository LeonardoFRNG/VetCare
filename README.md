# VetCare — Sistema de Gestión para una Clínica Veterinaria

Aplicación de escritorio en **Java SE** para la gestión integral de una clínica veterinaria: propietarios, mascotas, veterinarios, citas, atenciones médicas, medicamentos y usuarios. Desarrollada como simulacro de prueba de desempeño aplicando POO, arquitectura por capas, persistencia JDBC, transacciones y manejo de excepciones.

## Descripción

VetCare centraliza la información que actualmente se administra en agendas físicas y hojas de cálculo, eliminando duplicidad de registros, conflictos de horario entre veterinarios, pérdida de historiales médicos y errores en el control de inventario de medicamentos.

## Caso de uso

VetCare ofrece consulta médica, vacunación, desparasitación, procedimientos menores y seguimiento de tratamientos. La aplicación permite:

- Registrar y consultar propietarios, con sus mascotas asociadas.
- Gestionar veterinarios y sus especialidades.
- Programar citas evitando duplicidad de horario para un mismo veterinario o mascota.
- Registrar atenciones médicas (síntomas, diagnóstico, tratamiento, observaciones) a partir de una cita confirmada.
- Controlar el inventario de medicamentos y descontarlo automáticamente al finalizar una atención, mediante una operación transaccional.
- Consultar el historial médico completo de cada mascota.
- Autenticar usuarios con roles diferenciados: **ADMIN**, **RECEPCIONISTA**, **VETERINARIO**.

## Tecnologías

| Componente | Tecnología |
|---|---|
| Lenguaje | Java 17+ |
| Interfaz de usuario | JOptionPane |
| Persistencia | JDBC |
| Base de datos | MySQL o PostgreSQL |
| Gestión de dependencias | Maven |
| Control de versiones | Git / GitHub |

## Arquitectura por capas

El proyecto se organiza como mínimo en las siguientes capas:

```
src/
└── main/
    └── java/
        └── com/vetcare/
            ├── controller/   # Recibe las acciones de la interfaz y llama a los servicios
            ├── service/      # Reglas de negocio y coordinación de procesos
            ├── repository/   # Contratos (interfaces) + implementaciones JDBC (DAO)
            ├── model/        # Entidades del sistema
            ├── exception/    # Excepciones personalizadas
            ├── config/       # Configuración y conexión a la base de datos
            └── presentation/ # Menús y formularios JOptionPane
```

Reglas de diseño aplicadas:

- Los servicios dependen de **interfaces** de persistencia, no de implementaciones JDBC concretas.
- No se ejecuta SQL desde los controladores ni desde los menús de JOptionPane.
- No se instancian repositorios dentro de los servicios (inyección de dependencias).
- Sin atributos públicos ni catch genéricos que oculten errores.
- Sin conexión global única abierta durante toda la ejecución de la aplicación.

## Módulos funcionales

1. **Propietarios** — registro, consulta, actualización, activación/desactivación, búsqueda por identificación.
2. **Mascotas** — registro asociado a un propietario activo, consulta, historial médico.
3. **Veterinarios** — registro, especialidad, activación/desactivación.
4. **Citas** — programación, cancelación, cambio de estado (`PROGRAMADA`, `CONFIRMADA`, `EN_ATENCION`, `FINALIZADA`, `CANCELADA`), validación de disponibilidad.
5. **Medicamentos** — registro, control de existencias, alerta de bajo inventario.
6. **Atenciones médicas** — inicio desde una cita confirmada, diagnóstico, tratamiento, asociación de medicamentos, finalización transaccional.
7. **Usuarios y autenticación** — login con roles y menús restringidos según permisos.

### Reglas de negocio destacadas

- Un propietario inactivo no puede registrar mascotas ni solicitar citas.
- Un veterinario o una mascota no pueden tener dos citas en la misma fecha y hora.
- Una atención solo puede iniciarse desde una cita confirmada, y una cita solo genera una atención.
- No se puede finalizar una atención sin diagnóstico ni tratamiento/observación.
- No se puede usar un medicamento sin inventario suficiente.

## Diagrama de clases

_Pendiente: agregar imagen o enlace al diagrama de clases (`docs/diagrama-clases.png`)._

## Diagrama entidad-relación

Tablas mínimas sugeridas:

- `owners`
- `pets`
- `veterinarians`
- `appointments`
- `medical_records`
- `medicines`
- `medical_record_medicines`
- `users`

_Pendiente: agregar imagen o enlace al diagrama entidad-relación (`docs/diagrama-er.png`)._

## Configuración de la base de datos

1. Crear la base de datos en MySQL o PostgreSQL.
2. Ejecutar el script `db/script.sql` incluido en el repositorio para crear las tablas.
3. Configurar las credenciales de conexión en `src/main/resources/config.properties` (o clase de configuración equivalente):

```properties
db.url=jdbc:mysql://localhost:3306/vetcare
db.user=usuario
db.password=contraseña
```

## Instrucciones de ejecución

```bash
# Clonar el repositorio
git clone <url-del-repositorio>
cd vetcare

# Compilar el proyecto con Maven
mvn clean install

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="com.vetcare.Main"
```

> Requisitos previos: JDK 17+, Maven, y una instancia de MySQL/PostgreSQL en ejecución con la base de datos ya creada.

## Funcionalidades implementadas

_Marcar según el avance real del proyecto:_

- [ ] Registro y consulta de propietarios
- [ ] Registro y consulta de mascotas
- [ ] Registro y consulta de veterinarios
- [ ] Registro y consulta de medicamentos
- [ ] Inicio de sesión con roles
- [ ] Programación de citas con validación de horarios
- [ ] Inicio y finalización de atención médica (transaccional)
- [ ] Descuento automático de inventario
- [ ] Consulta de historial médico
- [ ] Manejo de excepciones personalizadas

## Excepciones personalizadas

`OwnerNotFoundException`, `DuplicateOwnerDocumentException`, `InactiveOwnerException`, `PetNotFoundException`, `DuplicateVeterinarianLicenseException`, `VeterinarianNotAvailableException`, `AppointmentConflictException`, `InvalidAppointmentStateException`, `MedicineNotFoundException`, `InsufficientStockException`, `MedicalRecordAlreadyExistsException`, `UnauthorizedActionException`.

## Transacción crítica: finalización de atención médica

Al finalizar una atención, en una única transacción se:

1. Registra/actualiza la atención médica.
2. Registra los medicamentos utilizados.
3. Descuenta el inventario correspondiente.
4. Cambia el estado de la cita a `FINALIZADA`.

Si alguna operación falla, se ejecuta `rollback` y no queda ninguna atención finalizada con inventario inconsistente.

## Evidencias de funcionamiento

_Pendiente: agregar capturas de pantalla o video demostrativo del flujo completo (login → registro de propietario → mascota → veterinario → medicamento → cita → atención → historial médico)._

## Estructura del repositorio

```
vetcare/
├── src/
├── db/
│   └── script.sql
├── docs/
│   ├── diagrama-clases.png
│   └── diagrama-er.png
├── pom.xml
└── README.md
```

## Datos del coder

- **Nombre:** _completar_
- **GitHub:** _completar_
- **Fecha:** _completar_

## Licencia

Proyecto académico desarrollado como simulacro de prueba de desempeño.
