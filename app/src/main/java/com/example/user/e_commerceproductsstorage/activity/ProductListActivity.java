package com.example.user.e_commerceproductsstorage.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.e_commerceproductsstorage.Adapter.ProductAdapter;
import com.example.user.e_commerceproductsstorage.R;
import com.example.user.e_commerceproductsstorage.model.Product;
import com.example.user.e_commerceproductsstorage.productsDB.ProductDBSource;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ListView listView;
    private ProductAdapter productAdapter;
    private ArrayList<Product>products;
    private ProductDBSource productDBSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        listView = (ListView) findViewById(R.id.productListLV);
        productDBSource = new ProductDBSource(this);
        products = productDBSource.getAllProduct();

        productAdapter = new ProductAdapter(this,products);
        listView.setAdapter(productAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int rowId = products.get(position).getProductID();
                String name = products.get(position).getProductName();
                String details = products.get(position).getProductDescription();
                String price = products.get(position).getProductPrice();

                startActivity(new Intent(ProductListActivity.this, ProductDetailsActivity.class)
                        .putExtra("id", rowId)
                        .putExtra("name",name)
                        .putExtra("details", details)
                        .putExtra("price", price));
            }
        });
    }
}
