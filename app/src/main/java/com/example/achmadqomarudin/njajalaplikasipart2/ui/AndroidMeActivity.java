package com.example.achmadqomarudin.njajalaplikasipart2.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.achmadqomarudin.njajalaplikasipart2.R;
import com.example.achmadqomarudin.njajalaplikasipart2.data.AndroidImageAsset;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        /*Cek apakah nilainya tersimpan atau tidak*/
        if (savedInstanceState == null) {

            /*Buat BodyPartFragment instance dan menampilkan menggunakan FragmentManager*/
            BodyPartFragment headFragment = new BodyPartFragment();

            headFragment.setmImageIds(AndroidImageAsset.getHeads());
            headFragment.setmListIndex(1);

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            /*Fragment Head*/
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            /*Fragment Body*/
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageIds(AndroidImageAsset.getBodys());
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            /*Fragment Leg*/
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setmImageIds(AndroidImageAsset.getLegs());
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();

        }
    }
}
