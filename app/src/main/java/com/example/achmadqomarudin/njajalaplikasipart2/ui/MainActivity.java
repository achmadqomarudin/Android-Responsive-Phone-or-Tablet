package com.example.achmadqomarudin.njajalaplikasipart2.ui;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.achmadqomarudin.njajalaplikasipart2.R;
import com.example.achmadqomarudin.njajalaplikasipart2.data.AndroidImageAsset;

/**
 * Created by Achmad Qomarudin on 31/08/2017.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    /*variable untuk store nilai pada list index ketika image dipilih, default index = 0*/
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    /*Untuk mengecek apakah menggunakan HP atau Tablet*/
    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.android_me_linear_layout) != null) {
            /*LinearLayout ini hanya akan menginisialisasi untuk two-pane tablet case*/
            mTwoPane = true;

            /*Menghilangkan button ketika di klik next button*/
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);

            /*Mengubah gridview untuk melebihi spasi image ketika di tablet */
            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);

            /*Membuat body baru part fragment*/
            if (savedInstanceState == null) {
                /*di dalam two-pane mode, masukkan inisial BodyPartFragments ke dalam layar*/
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

                /*Membuat head fragment baru*/
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setmImageIds(AndroidImageAsset.getHeads());
                /*Fragment Head*/
                    fragmentManager.beginTransaction()
                            .replace(R.id.head_container, headFragment)
                            .commit();

                /*Fragment Body*/
                    BodyPartFragment bodyFragment = new BodyPartFragment();
                    bodyFragment.setmImageIds(AndroidImageAsset.getBodys());
                    fragmentManager.beginTransaction()
                            .replace(R.id.body_container, bodyFragment)
                            .commit();

                /*Fragment Leg*/
                    BodyPartFragment legFragment = new BodyPartFragment();
                    legFragment.setmImageIds(AndroidImageAsset.getLegs());
                    fragmentManager.beginTransaction()
                            .replace(R.id.leg_container, legFragment)
                            .commit();
            }

        } else {
            mTwoPane = false;
        }
    }

    /*Mendenefinisikan behavior untuk onImageSelected; bikin Toast menampilkan posisi klik*/
    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked : " + position, Toast.LENGTH_SHORT).show();

        /*Based dimana user mengklik, store list index untuk kepala, tubuh, dan kaki*/
        int bodyPartNumber = position /12; //njajal karena semua total gambar ada 6!

        /*Store correct list index no matter dimana image list ketika diclick*/
        int listIndex = position - 12*bodyPartNumber;

        if (mTwoPane) {
            /*Handle twoPaneCase*/
            BodyPartFragment newFragment = new BodyPartFragment();

            /*Set display item untuk body part fragment yg benar*/
            switch (bodyPartNumber) {
                case 0:
                    /*Head Image Telah diklik*/
                    /*memberikan image yang benar untuk fragment yang baru*/
                    newFragment.setmImageIds(AndroidImageAsset.getHeads());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                    break;

                //njajal
                case 1:
                    newFragment.setmImageIds(AndroidImageAsset.getBodys());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                    break;

                case 2:
                    newFragment.setmImageIds(AndroidImageAsset.getLegs());
                    newFragment.setmListIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, newFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                    break;
                default: break;

            }

        } else {
            /*Set display item untuk body part fragment*/
            switch (bodyPartNumber) {
                case 0: headIndex = listIndex;
                    break;
                case 1: bodyIndex = listIndex;
                    break;
                case 2: legIndex = listIndex;
                    break;
                default: break;
            }

            /*Bikin bundle untuk mengirim file ke Activity AndroidMeActivity*/
            Bundle b = new Bundle();
            b.putInt("headIndex", headIndex);
            b.putInt("bodyIndex", bodyIndex);
            b.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(b);

            /*Bikin reference untuk next button dan launch intent ketika button ini di klik*/
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                new AlertDialog.Builder(this)
                        .setTitle("Tentang Aplikasi")
                        .setMessage("Menyusun bagian tubuh android mulai dari kepala, badan, dan kaki.")
                        .show();
                break;

            case R.id.exit:
                new AlertDialog.Builder(this)
                        .setMessage("Apakah anda yakin ingin keluar ?")
                        .setPositiveButton(getString(R.string.ya), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                    finishAffinity();
                                }
                            }
                        })
                        .setNegativeButton(getString(R.string.tidak), null)
                        .show();
                break;
        }
        return true;
    }
}
