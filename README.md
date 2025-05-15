# TPO Proceso de Desarrollo de Software

Repositorio correspondiente al Trabajo Práctico Obligatorio de la materia **Proceso de Desarrollo de Software**, dictada en el primer cuatrimestre del tercer año de la carrera de Ingeniería en Informática en **UADE**.

## Grupo de trabajo
- Juan Manuel Ferreño
- Juan Manuel Guida
- Nehuel Adolfo Marcos
- Santiago Mussi
- Nicolás Martín Szafranko
- Marcos Villar

## Contenido del repositorio
- `Model`: contiene el código fuente del sistema desarrollado en Java.
- `StarUML`: incluye las distintas versiones del diagrama UML del proyecto.
    - **Versión actual:** 6

---

## Informe de Justificación del Diseño del Diagrama UML

### 1. Menú Digital y Productos

**Requerimiento:**  
El sistema debe ofrecer un menú digital con categorías como entradas, platos principales, postres y bebidas. Cada producto debe tener nombre, descripción, precio y una lista de ingredientes con advertencias sobre alérgenos
**Diseño:**
- Se define la clase `Menu`, que agrupa una lista de objetos `ProductoMenu`.
- `ProductoMenu` posee atributos como `nombre`, `descripcion`, `precio`, y una lista de `alergenicos`, junto con un booleano `contieneAlergenos`
- Se implementan subclases de `ProductoMenu` (`Entrada`, `PlatoPrincipal`, `Postre`, `Bebida`) para representar las distintas categorías del menú
- La clase `Ingrediente` asocia ingredientes a los productos e incluye la información sobre alérgenos
---

### 2. Selección de Productos y Creación de Pedido

**Requerimiento:**  
Los clientes deben poder seleccionar productos para su pedido. El sistema debe calcular el total automáticamente

**Diseño:**
- La clase `Cliente` incluye métodos como `elegirProducto(menu: Menu)` y `pagarPedido(pedido: Pedido, medio: MedioDePago)`
- `Pedido` contiene una lista de `ProductoMenu` y métodos como `calcularTotal()` y `confirmarPedido()`
- Se establece una relación de composición entre `Cliente` y `Pedido`
---

### 3. Aplicación de Cupones de Descuento

**Requerimiento:**  
Los clientes pueden aplicar cupones, los cuales deben ser validados por el sistema
**Diseño:**
- `Pedido` se asocia a la clase `Orden`, que puede incluir un cupón
- `Orden` utiliza un `ValidadorDescuento`, que implementa el método `validarDescuento(cupon: String)` para verificar su validez
---

### 4. Opciones de Pago

**Requerimiento:**  
El sistema debe permitir el pago mediante tarjeta de crédito o débito.

**Diseño:**
- Se define la interfaz `IPagable` con el método `pagar(monto: Float)`
- Las clases `TarjetaCredito` y `TarjetaDebito` implementan esta interfaz
- `Pedido` se asocia a `IPagable` para gestionar el proceso de pago
---

### 5. Estado del Pedido

**Requerimiento:**  
El pedido debe atravesar distintos estados, desde “En espera” hasta “Entregado”. Los empleados podrán actualizar el estado
**Diseño:**
- Se define la enumeración `EstadoPedido` con los posibles estados del pedido
- `Pedido` incluye un atributo `estado`
- Las subclases de `Empleado` (`Mesero`, `Chef`, `Administrativo`) poseen el método `cambiarEstado(pedido: Pedido)`
---

### 6. Notificaciones Automáticas

**Requerimiento:**  
Los clientes deben ser notificados automáticamente cuando el estado de su pedido cambia, ya sea por aplicación o correo electrónico
**Diseño:**
- Se implementa la interfaz `INotificacion`, con el método `enviarNotificacion(estado: EstadoPedido)`
- Se crean dos adaptadores: `AppNotifAdapter` y `EmailNotifAdapter`
- Estas implementaciones se integran con el cliente para recibir las notificaciones correspondientes
---

### 7. Facturación

**Requerimiento:**  
Una vez entregado el pedido, se debe generar y enviar una factura al cliente
**Diseño:**
- `Pedido` se asocia a la clase `Factura`, que contiene los datos `montoTotal` y `Fecha`
- `Factura` implementa el método `enviarPorCorreo(correo: String)`
- Se utiliza el patrón de diseño Factory mediante la clase `FacturaFactory` para su generación
---

## Conclusión

El diseño presentado responde de manera precisa a los requerimientos funcionales del sistema. El modelo hace uso adecuado de los principios de diseño orientado a objetos como herencia, composición y encapsulamiento e incorpora patrones como *Factory* y *Adapter* para mejorar la mantenibilidad y extensibilidad de la solución. Se busca así una arquitectura robusta y adaptable, alineada con las necesidades de un restaurante moderno que incorpora herramientas digitales.
