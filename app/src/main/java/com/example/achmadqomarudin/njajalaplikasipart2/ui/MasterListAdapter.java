package com.example.achmadqomarudin.njajalaplikasipart2.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Achmad Qomarudin on 30/08/2017.
 */

public class MasterListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Integer> mImageIds;

    public MasterListAdapter(Context context, List<Integer> imageIds) {

        mContext = context;
        mImageIds = imageIds;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<Integer> getmImageIds() {
        return mImageIds;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            /*jika view tidak mengulang, maka membuat ImageView baru untuk menghandle image*/
            imageView = new ImageView(mContext);
            /*Definisi layout paramater*/
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
}
