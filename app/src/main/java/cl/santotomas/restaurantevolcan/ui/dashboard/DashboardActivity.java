package cl.santotomas.restaurantevolcan.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cl.santotomas.restaurantevolcan.R;
import cl.santotomas.restaurantevolcan.databinding.ActivityDashboardBinding;
import cl.santotomas.restaurantevolcan.ui.login.LoginActivity;
import cl.santotomas.restaurantevolcan.util.SessionManager;

public class DashboardActivity extends AppCompatActivity {

    public static final String EXTRA_FULL_NAME = "extra_full_name";
    public static final String EXTRA_ROLE_NAME = "extra_role_name";

    private ActivityDashboardBinding binding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(this);

        String fullName = getIntent().getStringExtra(EXTRA_FULL_NAME);
        String roleName = getIntent().getStringExtra(EXTRA_ROLE_NAME);

        if (fullName == null) {
            fullName = sessionManager.getFullName();
        }
        if (roleName == null) {
            roleName = sessionManager.getRoleName();
        }

        binding.textWelcome.setText(getString(R.string.welcome_name, fullName));
        binding.textRole.setText(getString(R.string.role_label, roleName));

        binding.buttonLogout.setOnClickListener(view -> logout());
    }

    private void logout() {
        sessionManager.clear();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
