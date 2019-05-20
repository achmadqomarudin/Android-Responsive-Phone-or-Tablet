package com.example.achmadqomarudin.njajalaplikasipart2.ui;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.achmadqomarudin.njajalaplikasipart2.R;
import com.example.achmadqomarudin.njajalaplikasipart2.data.AndroidImageAsset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Achmad Qomarudin on 30/08/2017.
 */

public class BodyPartFragment extends Fragment {

    /*Final string untuk information list berdasarkan image dan list index*/
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    /*Tag untuk logging*/
    private static final String TAG = "BodyPartFragment";
    /*Variable untuk store list image source berdasarkan index tampilan fragment*/
    private List<Integer> mImageIds;
    private int mListIndex;

    public List<Integer> getmImageIds() {
        return mImageIds;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public int getmListIndex() {
        return mListIndex;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    public BodyPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /*Load saved state (list dari list image dan list index) jika ada*/
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        /*set gambar untuk ditampilkan*/
//        imageView.setImageResource(AndroidImageAsset.getHeads().get(0));

        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "Fragmentnya list id nya kosong!");
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX, mListIndex);
    }
}
