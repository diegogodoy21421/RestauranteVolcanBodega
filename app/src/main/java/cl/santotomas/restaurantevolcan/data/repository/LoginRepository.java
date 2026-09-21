package cl.santotomas.restaurantevolcan.data.repository;

import android.content.Context;

import androidx.annotation.MainThread;

import cl.santotomas.restaurantevolcan.data.AppDatabase;
import cl.santotomas.restaurantevolcan.data.model.UsuarioConRol;
import cl.santotomas.restaurantevolcan.model.AuthResult;
import cl.santotomas.restaurantevolcan.util.HashUtils;

public class LoginRepository {

    public interface LoginCallback {
        void onResult(AuthResult result);
    }

    private final AppDatabase database;

    public LoginRepository(Context context) {
        database = AppDatabase.getDatabase(context);
    }

    public void login(String username, String password, @MainThread LoginCallback callback) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            AuthResult result;
            try {
                UsuarioConRol user = database.usuarioDao().buscarPorUsername(username.trim());

                if (user == null || !HashUtils.sha256(password).equals(user.passwordHash)) {
                    result = AuthResult.failure(AuthResult.Status.INVALID_CREDENTIALS);
                } else if (user.activo != 1) {
                    result = AuthResult.failure(AuthResult.Status.INACTIVE_USER);
                } else {
                    result = AuthResult.success(
                            user.idUsuario,
                            user.username,
                            user.nombreCompleto,
                            user.nombreRol
                    );
                }
            } catch (Exception exception) {
                result = AuthResult.failure(AuthResult.Status.ERROR);
            }

            AuthResult finalResult = result;
            android.os.Handler mainHandler = new android.os.Handler(
                    android.os.Looper.getMainLooper()
            );
            mainHandler.post(() -> callback.onResult(finalResult));
        });
    }
}
