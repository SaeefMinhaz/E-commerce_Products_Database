package com.example.user.e_commerceproductsstorage.productsDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.e_commerceproductsstorage.model.Product;

import java.util.ArrayList;

/**
 * Created by SHOVON on 12/26/2017.
 */

public class ProductDBSource {
    private ProductsDBHelper productsDBHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Product product;

    public ProductDBSource(Context context) {
        productsDBHelper = new ProductsDBHelper(context);
    }

    public void open(){
        sqLiteDatabase = productsDBHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public boolean addProduct(Product product){
        this.open();
        ContentValues values = new ContentValues();
        values.put(ProductsDBHelper.COL_NAME,product.getProductName());
        values.put(ProductsDBHelper.COL_DESCRIPTION,product.getProductDescription());
        values.put(ProductsDBHelper.COL_PRICE,product.getProductPrice());
        long id = sqLiteDatabase.insert(ProductsDBHelper.TABLE_PRODUCT, null, values);
        this.close();
        if (id> 0){
            return true;
        }else {
            return false;
        }

    }

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> products = new ArrayList<>();
        this.open();

        Cursor cursor = sqLiteDatabase.query(ProductsDBHelper.TABLE_PRODUCT,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() >0){
            for(int i =0; i<cursor.getCount(); i++){
                int id = cursor.getInt(cursor.getColumnIndex(ProductsDBHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(ProductsDBHelper.COL_NAME));
                String details = cursor.getString(cursor.getColumnIndex(ProductsDBHelper.COL_DESCRIPTION));
                String price = cursor.getString(cursor.getColumnIndex(ProductsDBHelper.COL_PRICE));

                product = new Product(id, name,details,price);
                products.add(product);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return products;
    }

    public boolean updateProduct(Product product, int rowId){
        this.open();
        ContentValues values = new ContentValues();
        values.put(ProductsDBHelper.COL_NAME,product.getProductName());
        values.put(ProductsDBHelper.COL_DESCRIPTION,product.getProductDescription());
        values.put(ProductsDBHelper.COL_PRICE,product.getProductPrice());
        int updatedId =  sqLiteDatabase.update(ProductsDBHelper.TABLE_PRODUCT, values,ProductsDBHelper.COL_ID+" =?",
                new String[]{String.valueOf(rowId)});
        if (updatedId >0){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteProduct(int rowId){
        this.open();
        int deletedId = sqLiteDatabase.delete(ProductsDBHelper.TABLE_PRODUCT,productsDBHelper.COL_ID+" =? ",new String[]{String.valueOf(rowId)});
        this.close();
        if (deletedId> 0){
            return true;
        }else {
            return false;
        }
    }


}
