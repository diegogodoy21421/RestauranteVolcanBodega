package cl.santotomas.restaurantevolcan.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cl.santotomas.restaurantevolcan.data.dao.UsuarioDao;
import cl.santotomas.restaurantevolcan.data.entity.RolEntity;
import cl.santotomas.restaurantevolcan.data.entity.UsuarioEntity;

@Database(
        entities = {RolEntity.class, UsuarioEntity.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(2);

    public abstract UsuarioDao usuarioDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "restaurante_volcan.db"
                            )
                            .addCallback(SEED_CALLBACK)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback SEED_CALLBACK = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            db.execSQL("INSERT INTO ROL (id_rol, nombre_rol, descripcion) VALUES " +
                    "(1, 'Administrador', 'Acceso administrativo'), " +
                    "(2, 'Bodega', 'Operación de inventario')");

            db.execSQL("INSERT INTO USUARIO " +
                    "(id_usuario, id_rol, username, password_hash, nombre_completo, activo) VALUES " +
                    "(1, 1, 'admin', " +
                    "'240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', " +
                    "'Administrador Volcán', 1), " +
                    "(2, 2, 'bodega', " +
                    "'3e2388e8ceddc313076daab3e4eb98a3feb2c0da2464e9c632eff130483208eb', " +
                    "'Encargado de Bodega', 1), " +
                    "(3, 2, 'inactivo', " +
                    "'942847c088f463648246a2b21a483fbeb51ab92a75c45aaa808c9fea8a9b701a', " +
                    "'Usuario Inactivo', 0)");
        }
    };
}
