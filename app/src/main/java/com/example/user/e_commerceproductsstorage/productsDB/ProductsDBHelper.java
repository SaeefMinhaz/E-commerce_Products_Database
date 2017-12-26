package com.example.user.e_commerceproductsstorage.productsDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SHOVON on 12/26/2017.
 */

public class ProductsDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Product Database";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PRODUCT = "tbl_product";
    public static final String COL_ID = "tbl_id";
    public static final String COL_NAME = "tbl_name";
    public static final String COL_DESCRIPTION = "tbl_description";
    public static final String COL_PRICE = "tbl_price";

    public static final String CREATE_PRODUCT_TABLE = "create table "+TABLE_PRODUCT+
            "("+COL_ID+" integer primary key, "
            + COL_NAME+" text, "
            + COL_DESCRIPTION+" text, "
            + COL_PRICE+" text); ";


    public ProductsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_PRODUCT);
        onCreate(db);
    }
}
