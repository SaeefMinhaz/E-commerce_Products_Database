package com.example.user.e_commerceproductsstorage.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.e_commerceproductsstorage.R;
import com.example.user.e_commerceproductsstorage.model.Product;
import com.example.user.e_commerceproductsstorage.productsDB.ProductDBSource;

public class MainActivity extends AppCompatActivity {
    private EditText productNameET;
    private EditText productPriceET;
    private EditText productDescriptionET;
    private Product product;
    private ProductDBSource productDBSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productNameET = findViewById(R.id.productNameET);
        productPriceET = findViewById(R.id.productPriceET);
        productDescriptionET = findViewById(R.id.productDescriptionET);

        productDBSource = new ProductDBSource(this);
    }

    public void addProduct(View view) {
        String name = productNameET.getText().toString();
        String details = productDescriptionET.getText().toString();
        String price = productPriceET.getText().toString();
        if(name.isEmpty()){
            productNameET.setError("input data");
        } else if(details.isEmpty()){
            productDescriptionET.setError("insert data");
        } else if(price.isEmpty()){
            productPriceET.setError("input data");
        }else {
            product = new Product(name, details, price);
            boolean status = productDBSource.addProduct(product);
            if (status){
                Toast.makeText(this,"Congrates!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,ProductListActivity.class));
            }else {
                Toast.makeText(this,"you did a mistake", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
