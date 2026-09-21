package cl.santotomas.restaurantevolcan.ui.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.santotomas.restaurantevolcan.databinding.ItemProductBinding;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<ProductItem> items;

    public ProductAdapter(List<ProductItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding = ItemProductBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductBinding binding;

        ProductViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ProductItem item) {
            binding.textProductName.setText(item.name);
            binding.textProductCategory.setText(item.category);
            binding.textProductStock.setText(item.stock);
            binding.checkAvailable.setChecked(item.available);
        }
    }

    public static class ProductItem {
        final String name;
        final String category;
        final String stock;
        final boolean available;

        public ProductItem(String name, String category, String stock, boolean available) {
            this.name = name;
            this.category = category;
            this.stock = stock;
            this.available = available;
        }
    }
}
