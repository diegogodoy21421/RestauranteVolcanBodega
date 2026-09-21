package cl.santotomas.restaurantevolcan.ui.stock;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.santotomas.restaurantevolcan.R;
import cl.santotomas.restaurantevolcan.databinding.ActivityStockBinding;

public class StockActivity extends AppCompatActivity {

    private ActivityStockBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStockBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ratingWarehouse.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                binding.textRatingValue.setText(getString(R.string.rating_value, rating));
            }
        });
        binding.buttonReviewAlerts.setOnClickListener(view -> Toast.makeText(
                this, R.string.alerts_reviewed, Toast.LENGTH_SHORT).show());
        binding.buttonBack.setOnClickListener(view -> finish());
    }
}
