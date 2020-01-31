package com.example.unicamp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.unicamp.Model.intern;
import com.example.unicamp.R;

import java.util.ArrayList;

public class internAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<intern> interns;
    TextView isbaslik,kurum,date,location;

    public internAdapter(Activity activity, ArrayList<intern> interns) {
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.interns = interns;
    }

    @Override
    public int getCount() {
       return interns.size();
    }

    @Override
    public Object getItem(int position) {
        return interns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.custominternitem,null);

        isbaslik=convertView.findViewById(R.id.isbaslik);
        kurum=convertView.findViewById(R.id.kurum);
        date=convertView.findViewById(R.id.date);
        location=convertView.findViewById(R.id.location);

        intern intern=interns.get(position);
        isbaslik.setText(intern.getTitle());
        kurum.setText(intern.getKurum());
        date.setText(intern.getDate());
        location.setText(intern.getLocation());
        return convertView;
    }
}
