package cl.santotomas.restaurantevolcan.data.model;

import androidx.room.ColumnInfo;

public class UsuarioConRol {

    @ColumnInfo(name = "id_usuario")
    public int idUsuario;

    @ColumnInfo(name = "id_rol")
    public int idRol;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password_hash")
    public String passwordHash;

    @ColumnInfo(name = "nombre_completo")
    public String nombreCompleto;

    @ColumnInfo(name = "activo")
    public int activo;

    @ColumnInfo(name = "nombre_rol")
    public String nombreRol;
}
