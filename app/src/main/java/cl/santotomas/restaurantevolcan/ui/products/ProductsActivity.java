package cl.santotomas.restaurantevolcan.ui.products;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Arrays;

import cl.santotomas.restaurantevolcan.R;
import cl.santotomas.restaurantevolcan.databinding.ActivityProductsBinding;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> categories = ArrayAdapter.createFromResource(
                this, R.array.product_categories, android.R.layout.simple_spinner_item);
        categories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(categories);

        ProductAdapter adapter = new ProductAdapter(Arrays.asList(
                new ProductAdapter.ProductItem("Harina", "Insumos secos", "Stock: 18 kg", true),
                new ProductAdapter.ProductItem("Tomate", "Verduras", "Stock: 12 kg", true),
                new ProductAdapter.ProductItem("Aceite vegetal", "Abarrotes", "Stock: 4 unidades", true),
                new ProductAdapter.ProductItem("Queso", "Refrigerados", "Stock: 2 kg · Bajo", false)
        ));
        binding.recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerProducts.setAdapter(adapter);

        binding.buttonApplyFilter.setOnClickListener(view -> Toast.makeText(
                this,
                getString(R.string.filter_applied, binding.spinnerCategory.getSelectedItem()),
                Toast.LENGTH_SHORT).show());
        binding.buttonBack.setOnClickListener(view -> finish());
    }
}
