package com.example.user.e_commerceproductsstorage.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.e_commerceproductsstorage.R;
import com.example.user.e_commerceproductsstorage.productsDB.ProductDBSource;

public class ProductDetailsActivity extends AppCompatActivity {

    private int rowId;
    private String name;
    private String details;
    private String price;

    private TextView details_productNameTV;
    private TextView details_productDesTV;
    private TextView details_productPriceTV;

    private ProductDBSource productDBSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        details_productNameTV = findViewById(R.id.details_productNameTV);
        details_productDesTV = findViewById(R.id.details_productDesTV);
        details_productPriceTV = findViewById(R.id.details_productPriceTV);

        productDBSource = new ProductDBSource(this);

        rowId = getIntent().getIntExtra("id",0);
        name = getIntent().getStringExtra("name");
        details = getIntent().getStringExtra("details");
        price = getIntent().getStringExtra("price");

        details_productNameTV.setText(name);
        details_productDesTV.setText(details);
        details_productPriceTV.setText(price);
    }

    public void updateProduct(View view) {
        startActivity(new Intent(ProductDetailsActivity.this, MainActivity.class)
                .putExtra("id", rowId)
                .putExtra("name",name)
                .putExtra("details", details)
                .putExtra("price", price));
    }


    public void deleteProduct(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete Item");
        alert.setMessage("Are you sure to delete this item?");
        alert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean status = productDBSource.deleteProduct(rowId);
                    if (status){
                        Toast.makeText(ProductDetailsActivity.this,"deleted",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ProductDetailsActivity.this, ProductListActivity.class));
                    }else{
                        Toast.makeText(ProductDetailsActivity.this,"please try again",Toast.LENGTH_SHORT).show();
                    }
            }
        });

        alert.setNegativeButton("Cancel",null);
        alert.show();
    }
}
