package cl.santotomas.restaurantevolcan.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import cl.santotomas.restaurantevolcan.R;
import cl.santotomas.restaurantevolcan.databinding.ActivityLoginBinding;
import cl.santotomas.restaurantevolcan.model.AuthResult;
import cl.santotomas.restaurantevolcan.ui.dashboard.DashboardActivity;
import cl.santotomas.restaurantevolcan.util.SessionManager;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLoggedIn()) {
            openDashboard();
            return;
        }

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        configureActions();
        observeViewModel();
    }

    private void configureActions() {
        binding.buttonLogin.setOnClickListener(view -> validateAndLogin());
        binding.editPassword.setOnEditorActionListener((view, actionId, event) -> {
            validateAndLogin();
            return true;
        });
    }

    private void observeViewModel() {
        viewModel.getLoading().observe(this, isLoading -> {
            boolean loading = Boolean.TRUE.equals(isLoading);
            binding.progressLogin.setVisibility(loading ? View.VISIBLE : View.GONE);
            binding.buttonLogin.setEnabled(!loading);
            binding.editUsername.setEnabled(!loading);
            binding.editPassword.setEnabled(!loading);
        });

        viewModel.getAuthResult().observe(this, result -> {
            if (result == null) {
                return;
            }

            if (result.getStatus() == AuthResult.Status.SUCCESS) {
                if (binding.checkRemember.isChecked()) {
                    sessionManager.save(result);
                }
                Intent intent = new Intent(this, DashboardActivity.class);
                intent.putExtra(DashboardActivity.EXTRA_FULL_NAME, result.getFullName());
                intent.putExtra(DashboardActivity.EXTRA_ROLE_NAME, result.getRoleName());
                startActivity(intent);
                finish();
                return;
            }

            String message;
            if (result.getStatus() == AuthResult.Status.INACTIVE_USER) {
                message = getString(R.string.error_inactive);
            } else if (result.getStatus() == AuthResult.Status.ERROR) {
                message = getString(R.string.error_database);
            } else {
                message = getString(R.string.error_credentials);
            }
            Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_LONG).show();
        });
    }

    private void validateAndLogin() {
        binding.layoutUsername.setError(null);
        binding.layoutPassword.setError(null);

        String username = binding.editUsername.getText() == null
                ? "" : binding.editUsername.getText().toString().trim();
        String password = binding.editPassword.getText() == null
                ? "" : binding.editPassword.getText().toString();

        if (username.isEmpty()) {
            binding.layoutUsername.setError(getString(R.string.error_required_user));
            binding.editUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            binding.layoutPassword.setError(getString(R.string.error_required_password));
            binding.editPassword.requestFocus();
            return;
        }

        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager keyboard = (InputMethodManager)
                    getSystemService(INPUT_METHOD_SERVICE);
            keyboard.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }

        viewModel.login(username, password);
    }

    private void openDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
