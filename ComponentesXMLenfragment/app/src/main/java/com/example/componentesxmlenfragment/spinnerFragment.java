package com.example.componentesxmlenfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class spinnerFragment extends Fragment {
    String[] paises={"Argentina", "Bolivia", "Brazil", "Colombia", "Chile"};
    int[] banderas = {R.drawable.argentina, R.drawable.bolivia, R.drawable.brazil, R.drawable.colombia, R.drawable.chile};
    Spinner spinner;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spinner, container, false);
        spinner = view.findViewById(R.id.spinner);
        PaisesAdapter adaptador1 = new PaisesAdapter();
        spinner.setAdapter(adaptador1);
        return view;

    }

    class PaisesAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int position) {
            return paises[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.itemspinner, parent, false);

            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView tv1 = convertView.findViewById(R.id.tvpais);
            iv1.setImageResource(banderas[position]);
            tv1.setText(paises[position]);

            return convertView;
        }
    }
}