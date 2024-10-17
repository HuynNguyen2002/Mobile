package Product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.R;

import java.util.ArrayList;
import java.util.List;

public class Product_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        String categoryName = getIntent().getStringExtra("category_name");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textViewCategory = findViewById(R.id.categoryName);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageViewCategory = findViewById(R.id.imgCategoryDetail);
        textViewCategory.setText(categoryName);
        imageViewCategory.setImageResource(getIntent().getIntExtra("category_image", 0));

        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        productList = getProductsForCategory(categoryName);

        productAdapter = new ProductAdapter(this, productList);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(productAdapter);

    }
    private List<Product> getProductsForCategory(String categoryName) {
        List<Product> products = new ArrayList<>();

        // Ví dụ: thêm các sản phẩm khác nhau dựa trên tên category
        if (categoryName.equals("Các món sợi")) {
            products.add(new Product("Burger", 5.99, R.drawable.cuon1));
            products.add(new Product("Pizza", 7.99, R.drawable.cuon1));
        } else if (categoryName.equals("Đồ uống")) {
            products.add(new Product("Coca-Cola", 1.99, R.drawable.cuon1));
            products.add(new Product("Pepsi", 1.89, R.drawable.cuon1));
        } else if (categoryName.equals("Món tráng miệng")) {
            products.add(new Product("Kem", 3.99, R.drawable.cuon1));
            products.add(new Product("Bánh ngọt", 4.99, R.drawable.cuon1));
        }

        return products;
    };
}