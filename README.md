# Restaurante Volcán SpA - Login Android

Proyecto académico en **Java** para Android Studio. Implementa el requerimiento
**RF-01 - Iniciar sesión** del Sistema de Gestión de Bodega.


## Integrantes

Diego Godoy
Johan Cofre
Adrian Anzoategui
Jeremy Rodriguez

## Usuarios de prueba

| Usuario | Contraseña | Rol | Estado |
|---|---|---|---|
| `admin` | `admin123` | Administrador | Activo |
| `bodega` | `bodega123` | Bodega | Activo |
| `inactivo` | `inactivo123` | Bodega | Inactivo |

El último usuario sirve para demostrar la validación de cuentas inactivas.

## Funcionalidad incluida

- Validación de campos obligatorios.
- Búsqueda de usuario en Room.
- Contraseñas comparadas mediante hash SHA-256.
- Verificación de `activo = 1`.
- Relación `ROL` 1:N `USUARIO`, igual al modelo entregado.
- Opción **Mantener sesión iniciada** con `SharedPreferences`.
- Pantalla posterior al login con nombre y rol.
- Cierre de sesión.
- Interfaz adaptable con `ConstraintLayout`, `LinearLayout`, `ScrollView`,
  `CardView`, `ImageView`, `CheckBox`, `ProgressBar`, textos y botones.

## Estructura principal

```text
data/
  AppDatabase.java
  dao/UsuarioDao.java
  entity/RolEntity.java
  entity/UsuarioEntity.java
  repository/LoginRepository.java
ui/
  login/LoginActivity.java
  login/LoginViewModel.java
  dashboard/DashboardActivity.java
util/
  HashUtils.java
  SessionManager.java
```

## Alcance

Este ZIP entrega el módulo de login solicitado y deja preparado el panel para
continuar con productos, movimientos y stock bajo. Todavía no se implementa el MVP
completo de bodega.

## Estado de la versión

- Versión 1.0: login funcional, validación de usuario activo, sesión opcional y
  panel de bienvenida.
- Siguiente versión propuesta: catálogo de productos y consulta de stock.

