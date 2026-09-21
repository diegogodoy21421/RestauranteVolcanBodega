package cl.santotomas.restaurantevolcan.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import cl.santotomas.restaurantevolcan.data.model.UsuarioConRol;

@Dao
public interface UsuarioDao {

    @Query("SELECT u.id_usuario, u.id_rol, u.username, u.password_hash, " +
            "u.nombre_completo, u.activo, r.nombre_rol " +
            "FROM USUARIO u INNER JOIN ROL r ON r.id_rol = u.id_rol " +
            "WHERE LOWER(u.username) = LOWER(:username) LIMIT 1")
    UsuarioConRol buscarPorUsername(String username);
}
