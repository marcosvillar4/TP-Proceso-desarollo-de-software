# TPO Proceso de Desarrollo de Software

Repositorio para archivos del TPO de la materia de **Proceso de Desarrollo de Software**, dada en el primer cuatrimestre del tercer año de Ingeniería en Informática en la **UADE**.

## Grupo
- Juan Manuel Ferreño
- Juan Manuel Guida
- Nehuel Adolfo Marcos
- Santiago Mussi
- Nicolás Martín Szafranko
- Marcos Villar

## Contenido
- `Sistema_de_Gestion`: Carpeta que contiene el código Java del proyecto.
- `StarUML`: Carpeta que contiene las versiones del diagrama UML del proyecto. **Última versión: 6**

---

## Informe de Justificación de Diseño del Diagrama UML

### 1. Menú Digital y Productos

**Requerimiento:**  
El sistema debe ofrecer un menú digital con categorías como entradas, platos principales, postres y bebidas. Cada producto debe tener nombre, descripción, precio y una lista de ingredientes con advertencias sobre alérgenos.

**Justificación de Diseño:**
- Se define la clase `Menu`, que contiene una lista de `ProductoMenu`, representando cada ítem del menú.
- `ProductoMenu` posee atributos como `nombre`, `descripcion`, `precio` y una lista de `alergenicos`, así como un booleano `contieneAlergenos`.
- Se utilizan subclases de `ProductoMenu` (`Entrada`, `PlatoPrincipal`, `Postre`, `Bebida`) para representar explícitamente las distintas categorías.
- La clase `Ingrediente` permite asociar ingredientes con cada producto e incluye información sobre alérgenos.

---

### 2. Selección de Productos y Creación de Pedido

**Requerimiento:**  
Los clientes deben poder seleccionar productos para su pedido. El sistema debe calcular el total automáticamente.

**Justificación de Diseño:**
- La clase `Cliente` incluye una operación `elegirProducto(menu: Menu)` y `pagarPedido(pedido: Pedido, medio: MedioDePago)`.
- `Pedido` contiene una lista de productos (`platos: List<ProductoMenu>`) y métodos `calcularTotal()` y `confirmarPedido()`.
- Se establece una relación de composición entre `Cliente` y `Pedido`.

---

### 3. Aplicación de Cupones de Descuento

**Requerimiento:**  
Los clientes pueden aplicar cupones, que deben ser validados.

**Justificación de Diseño:**
- `Pedido` está asociado a `Orden`, que incluye un cupón.
- `Orden` utiliza un `ValidadorDescuento` para validar el cupón mediante `validarDescuento(cupon: String)`.

---

### 4. Opciones de Pago

**Requerimiento:**  
El sistema debe permitir el pago con tarjeta de crédito o débito.

**Justificación de Diseño:**
- Se define la interfaz `IPagable` con el método `pagar(monto: Float)`.
- `TarjetaCredito` y `TarjetaDebito` implementan esta interfaz.
- `Pedido` se asocia a `IPagable` para manejar los pagos.

---

### 5. Estado del Pedido

**Requerimiento:**  
El pedido debe cambiar de estado desde "En espera" hasta "Entregado", y empleados pueden actualizarlo.

**Justificación de Diseño:**
- Se define una enumeración `EstadoPedido` con los estados posibles.
- `Pedido` tiene un atributo `estado: EstadoPedido`.
- `Empleado` (y sus subclases `Mesero`, `Chef`, `Administrativo`) implementan `cambiarEstado(pedido: Pedido)`.

---

### 6. Notificaciones Automáticas

**Requerimiento:**  
Los clientes deben recibir notificaciones por app o correo cuando cambia el estado del pedido.

**Justificación de Diseño:**
- Se define la interfaz `INotificacion` con el método `enviarNotificacion(estado: EstadoPedido)`.
- Se implementan los adaptadores `AppNotifAdapter` y `EmailNotifAdapter`.
- Estas clases se integran en el contexto del `Cliente` para el envío automático.

---

### 7. Facturación

**Requerimiento:**  
Cuando el pedido es entregado, se genera y envía una factura al cliente.

**Justificación de Diseño:**
- `Pedido` se asocia a `Factura`, que contiene `montoTotal` y `fecha`.
- `Factura` incluye el método `enviarPorCorreo(correo: String)`.
- Se utiliza el patrón Factory con la clase `FacturaFactory` para su creación.

---

## Conclusión

El modelo diseñado en el diagrama UML refleja de forma precisa y estructurada todos los requerimientos del sistema.  
Se aplican principios de diseño orientado a objetos como **herencia**, **composición**, **encapsulamiento** y patrones como **Factory** y **Adapter**.  
Esto garantiza una solución **flexible, mantenible y escalable**, adaptada a las necesidades de un restaurante moderno con funcionalidades digitales integradas.
