package com.example.user.e_commerceproductsstorage.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private Button addBtn;
    private Product product;
    private ProductDBSource productDBSource;

    private int rowId;
    private String updateProductName;
    private String updateProductDescription;
    private String updateProductPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productNameET = findViewById(R.id.productNameET);
        productPriceET = findViewById(R.id.productPriceET);
        productDescriptionET = findViewById(R.id.productDescriptionET);
        addBtn = findViewById(R.id.addBtn);

        productDBSource = new ProductDBSource(this);

        //intent from ProductDetailsActivity
        rowId = getIntent().getIntExtra("id",0);
        updateProductName = getIntent().getStringExtra("name");
        updateProductDescription = getIntent().getStringExtra("details");
        updateProductPrice = getIntent().getStringExtra("price");

        productNameET.setText(updateProductName);
        productDescriptionET.setText(updateProductDescription);
        productPriceET.setText(updateProductPrice);
        if (rowId >0){
            addBtn.setText("Update Product");
        }


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

            // Checking rowId for update product or add product
            if (rowId >0){
                product = new Product(rowId,name, details,price);
                boolean status = productDBSource.updateProduct(product, rowId);
                if (status){
                    Toast.makeText(this,"updated!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ProductListActivity.class));
                }else {
                    Toast.makeText(this,"not updated", Toast.LENGTH_SHORT).show();
                }
            //add product
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

    public void showAllProducts(View view) {
        startActivity(new Intent(MainActivity.this,ProductListActivity.class));
    }
}
