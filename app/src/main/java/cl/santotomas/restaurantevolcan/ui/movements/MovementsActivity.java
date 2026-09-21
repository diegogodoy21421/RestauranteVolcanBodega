package cl.santotomas.restaurantevolcan.ui.movements;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.santotomas.restaurantevolcan.R;
import cl.santotomas.restaurantevolcan.databinding.ActivityMovementsBinding;

public class MovementsActivity extends AppCompatActivity {

    private ActivityMovementsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovementsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> products = ArrayAdapter.createFromResource(
                this, R.array.movement_products, android.R.layout.simple_spinner_item);
        products.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerProduct.setAdapter(products);

        binding.buttonRegisterMovement.setOnClickListener(view -> {
            String type = binding.radioEntry.isChecked()
                    ? getString(R.string.entry)
                    : getString(R.string.exit);
            Toast.makeText(this,
                    getString(R.string.movement_demo_message, type),
                    Toast.LENGTH_SHORT).show();
        });
        binding.buttonBack.setOnClickListener(view -> finish());
    }
}
