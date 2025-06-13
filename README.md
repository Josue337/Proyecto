# Sistema de Gestión de Cafetería Universitaria (POO - Java)

## Descripción
Sistema de consola para administrar productos, clientes y pedidos en una cafetería universitaria, implementando conceptos avanzados de Programación Orientada a Objetos.

## Requisitos Técnicos
- **Java JDK 8+**
- **6 clases mínimas**:
  - 1 clase abstracta (`Producto`)
  - 2 clases hijas (`Comida`, `Bebida`)
  - 1 interfaz (`Descuento`)
  - 2 clases adicionales (`Cliente`, `Pedido`)
  - 1 clase principal (`Cafeteria`)

## Estructura POO
- **Herencia**: `Producto` → `Comida`/`Bebida`
- **Polimorfismo**: Métodos abstractos `mostrarDetalles()` y `preparar()`
- **Encapsulamiento**: Atributos privados con getters/setters
- **Composición**: `Pedido` contiene arreglo de `Producto`
- **Interfaz**: `Descuento` implementada en `Bebida` y `Cafeteria`

## Funcionalidades
- **Menú interactivo** con opciones para:
  - Gestión de clientes (agregar/listar/buscar)
  - Gestión de productos (comidas/bebidas con descuentos)
  - Gestión de pedidos (crear/consultar)
  - Informes estadísticos

## Validaciones
- Control de duplicados (IDs clientes/códigos productos)
- Límites de capacidad en arreglos
- Tipos de datos correctos en entradas

## Uso
1. Compilar: `javac *.java`
2. Ejecutar: `java Main`
3. Seguir menú interactivo

## Notas
- Proyecto académico para Universidad de Pamplona
- Usa arreglos estáticos (no ArrayList)
- Métodos void para acciones principales
- Cumple con todos los requerimientos de POO especificados

**"Formando líderes para la construcción de un nuevo país en paz"**  
Universidad de Pamplona - 2024