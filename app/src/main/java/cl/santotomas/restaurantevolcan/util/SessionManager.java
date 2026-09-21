package cl.santotomas.restaurantevolcan.util;

import android.content.Context;
import android.content.SharedPreferences;

import cl.santotomas.restaurantevolcan.model.AuthResult;

public class SessionManager {

    private static final String PREFS_NAME = "volcan_session";
    private static final String KEY_LOGGED_IN = "logged_in";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_ROLE = "role";

    private final SharedPreferences preferences;

    public SessionManager(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void save(AuthResult result) {
        preferences.edit()
                .putBoolean(KEY_LOGGED_IN, true)
                .putInt(KEY_USER_ID, result.getUserId())
                .putString(KEY_USERNAME, result.getUsername())
                .putString(KEY_FULL_NAME, result.getFullName())
                .putString(KEY_ROLE, result.getRoleName())
                .apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(KEY_LOGGED_IN, false);
    }

    public String getFullName() {
        return preferences.getString(KEY_FULL_NAME, "Usuario");
    }

    public String getRoleName() {
        return preferences.getString(KEY_ROLE, "Sin rol");
    }

    public void clear() {
        preferences.edit().clear().apply();
    }
}
