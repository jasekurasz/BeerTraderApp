package com.jim.demo1.Inventory;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.jim.demo1.Post.Beer;
import com.jim.demo1.R;
import com.jim.demo1.Tools.RequestSingleton;

import java.util.List;

/**
 * Created by Jim on 4/13/2015.
 */
public class Inventory_Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Beer> inventoryList;

    ImageLoader mImageLoader;
    ImageView pic;

    public Inventory_Adapter(Activity activity, List<Beer> bList) {
        this.activity = activity;
        this.inventoryList = bList;
    }

    @Override
    public int getCount() {
        return inventoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return inventoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (convertView == null) {
            if (inflater == null)
                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.inventory_list_row, parent, false);
        }

        pic = (ImageView) row.findViewById(R.id.inventoryLablePic);
        TextView theBeerName = (TextView) row.findViewById(R.id.inventoryBeerName);
        TextView theBreweryName = (TextView) row.findViewById(R.id.inventoryBrewery);

        Beer b = inventoryList.get(position);
        theBeerName.setText(b.getBeer_name());
        theBreweryName.setText(b.getBrewery());
        mImageLoader = RequestSingleton.getInstance(activity.getApplicationContext()).getImageLoader();
        mImageLoader.get(b.getImgUrl(), ImageLoader.getImageListener(pic, 0, 0));
        return row;
    }
}