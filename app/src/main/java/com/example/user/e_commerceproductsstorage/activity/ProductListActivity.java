package com.example.user.e_commerceproductsstorage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
