package com.example.achmadqomarudin.njajalaplikasipart2.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.achmadqomarudin.njajalaplikasipart2.R;
import com.example.achmadqomarudin.njajalaplikasipart2.data.AndroidImageAsset;

/**
 * Created by Achmad Qomarudin on 31/08/2017.
 */

public class MasterListFragment extends Fragment {

    /*mendenefinisikan interface OnImageClickListener, dan trigger callback di host activity*/
    OnImageClickListener mCallback;

    /*OnImageClickListener listener, panggil method di host activity yg bernama onImageSelected*/
    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    /*Override Attach untuk memastikan kalau container activity sudah terimplementasi callback*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageListener");
        }
    }

    public MasterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        /*get reference ke Gridview ke fragment_master_list xml layout*/
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        /*Buat Adapter*/
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAsset.getAll());

        /*set adapter ke gridview*/
        gridView.setAdapter(mAdapter);

        /*Set click listener di Gridview dan trigger callback onImageSelected ketika item di klik*/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallback.onImageSelected(position);
            }
        });

        return rootView;
    }
}
