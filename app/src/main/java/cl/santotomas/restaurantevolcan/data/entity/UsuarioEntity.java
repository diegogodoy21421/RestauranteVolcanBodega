package cl.santotomas.restaurantevolcan.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "USUARIO",
        foreignKeys = @ForeignKey(
                entity = RolEntity.class,
                parentColumns = "id_rol",
                childColumns = "id_rol",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.RESTRICT
        ),
        indices = {
                @Index(value = {"username"}, unique = true),
                @Index(value = {"id_rol"})
        }
)
public class UsuarioEntity {

    @PrimaryKey(autoGenerate = true)
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

    public UsuarioEntity(int idUsuario, int idRol, String username,
                         String passwordHash, String nombreCompleto, int activo) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.username = username;
        this.passwordHash = passwordHash;
        this.nombreCompleto = nombreCompleto;
        this.activo = activo;
    }
}
