package com.example.achmadqomarudin.njajalaplikasipart2.data;

import android.content.Intent;

import com.example.achmadqomarudin.njajalaplikasipart2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Achmad Qomarudin on 30/08/2017.
 */

public class AndroidImageAsset {

    private static final List<Integer> heads = new ArrayList<Integer>() {{
        add(R.drawable.head1);
        add(R.drawable.head2);
        add(R.drawable.head3);
        add(R.drawable.head4);
        add(R.drawable.head5);
        add(R.drawable.head6);
        add(R.drawable.head7);
        add(R.drawable.head8);
        add(R.drawable.head9);
        add(R.drawable.head10);
        add(R.drawable.head11);
        add(R.drawable.head12);
    }};

    private static final List<Integer> bodys = new ArrayList<Integer>() {{
        add(R.drawable.body1);
        add(R.drawable.body2);
        add(R.drawable.body3);
        add(R.drawable.body4);
        add(R.drawable.body5);
        add(R.drawable.body6);
        add(R.drawable.body7);
        add(R.drawable.body8);
        add(R.drawable.body9);
        add(R.drawable.body10);
        add(R.drawable.body11);
        add(R.drawable.body12);
    }};

    private static final List<Integer> legs = new ArrayList<Integer>() {{
        add(R.drawable.legs1);
        add(R.drawable.legs2);
        add(R.drawable.legs3);
        add(R.drawable.legs4);
        add(R.drawable.legs5);
        add(R.drawable.legs6);
        add(R.drawable.legs7);
        add(R.drawable.legs8);
        add(R.drawable.legs9);
        add(R.drawable.legs10);
        add(R.drawable.legs11);
        add(R.drawable.legs12);
    }};

    private static final List<Integer> all = new ArrayList<Integer>() {{
       addAll(heads);
        addAll(bodys);
        addAll(legs);
    }};

    public static List<Integer> getHeads() {
        return heads;
    }

    public static List<Integer> getBodys() {
        return bodys;
    }

    public static List<Integer> getLegs() {
        return legs;
    }

    public static List<Integer> getAll() {
        return all;
    }
}
