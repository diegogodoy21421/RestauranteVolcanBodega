package cl.santotomas.restaurantevolcan.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "ROL",
        indices = {@Index(value = {"nombre_rol"}, unique = true)}
)
public class RolEntity {

    @PrimaryKey
    @ColumnInfo(name = "id_rol")
    public int idRol;

    @ColumnInfo(name = "nombre_rol")
    public String nombreRol;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    public RolEntity(int idRol, String nombreRol, String descripcion) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
    }
}
