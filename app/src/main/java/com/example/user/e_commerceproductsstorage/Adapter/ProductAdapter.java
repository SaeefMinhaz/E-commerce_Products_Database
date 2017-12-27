package com.example.user.e_commerceproductsstorage.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.e_commerceproductsstorage.R;
import com.example.user.e_commerceproductsstorage.model.Product;

import java.util.ArrayList;

/**
 * Created by SHOVON on 12/26/2017.
 */

public class ProductAdapter extends ArrayAdapter<Product>{

    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> products) {
        super(context, R.layout.row_layout,products);
        this.context = context;
        this.products = products;
    }

    class ViewHolder{
        TextView productNameTV;
        ImageView productImageIV;
        TextView productShowPriceTV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_layout,parent, false);
            holder.productImageIV = (ImageView) convertView.findViewById(R.id.productImageIV);
            holder.productNameTV = (TextView) convertView.findViewById(R.id.productNameTV);
            holder.productShowPriceTV = (TextView) convertView.findViewById(R.id.productShowPriceTV);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.productNameTV.setText(products.get(position).getProductName().toString());
        holder.productShowPriceTV.setText(products.get(position).getProductPrice().toString());

        return convertView;
    }
}
