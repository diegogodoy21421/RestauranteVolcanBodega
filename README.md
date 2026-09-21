# Restaurante Volcán SpA - Prototipo Android

Proyecto académico desarrollado en **Java** para Android Studio. Presenta un
prototipo navegable del Sistema de Gestión de Bodega de Restaurante Volcán SpA.

## Integrantes

- Diego Godoy
- Johan Cofre
- Adrian Anzoategui
- Jeremy Rodriguez

## Acceso de demostración

| Usuario | Contraseña | Rol |
|---|---|---|
| `admin` | `admin123` | Administrador |

El acceso es una validación local simulada y **no utiliza base de datos**, de
acuerdo con las instrucciones de la evaluación.

## Flujo navegable

```text
Presentación → Login → Menú principal
                         ├─ Productos
                         ├─ Movimientos
                         └─ Control de stock
```

Todos los botones principales están conectados a sus Activity correspondientes.

## Activity incluidos

- `WelcomeActivity`: presentación atractiva de la aplicación.
- `LoginActivity`: validación visual con credenciales de demostración.
- `DashboardActivity`: menú de acceso a los módulos.
- `ProductsActivity`: catálogo de productos con filtro visual.
- `MovementsActivity`: simulación de entradas y salidas.
- `StockActivity`: capacidad, valoración y alertas de stock bajo.

## Elementos de interfaz demostrados

- Layouts: `ConstraintLayout`, `LinearLayout` y `TableLayout`.
- Widgets: `CheckBox`, `RadioButton`, `ProgressBar`, `RatingBar` e `ImageView`.
- Contenedores: `Spinner`, `RecyclerView`, `ScrollView` y `CardView`.
- Otros elementos: `TextView`, `Button`, campos de texto y mensajes `Toast` y
  `Snackbar`.

## Prototipo visual

El archivo `PROTOTIPO_VISUAL.png`, ubicado en la raíz del proyecto, corresponde
al diseño visual solicitado para la presentación. Fue preparado como pieza de
diseño independiente y no es una captura del Activity ejecutándose.

## Configuración

- Lenguaje: Java
- minSdk: 30
- targetSdk: 30
- compileSdk: 35
- Dispositivo recomendado: Pixel 5 con Android 11 (API 30)

## Alcance

Esta versión se concentra en diseño, navegación y uso de componentes Android.
Los datos de productos y movimientos son demostrativos y no se almacenan.
