package cl.santotomas.restaurantevolcan.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import cl.santotomas.restaurantevolcan.data.repository.LoginRepository;
import cl.santotomas.restaurantevolcan.model.AuthResult;

public class LoginViewModel extends AndroidViewModel {

    private final LoginRepository repository;
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(false);
    private final MutableLiveData<AuthResult> authResult = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new LoginRepository(application);
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public LiveData<AuthResult> getAuthResult() {
        return authResult;
    }

    public void login(String username, String password) {
        loading.setValue(true);
        repository.login(username, password, result -> {
            loading.setValue(false);
            authResult.setValue(result);
        });
    }
}
