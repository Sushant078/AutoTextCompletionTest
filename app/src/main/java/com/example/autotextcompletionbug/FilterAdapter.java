package com.example.autotextcompletionbug;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.FilteredArrayAdapter;

import java.util.ArrayList;

public class FilterAdapter extends FilteredArrayAdapter<SampleData> {

    private ArrayList<SampleData> listData;

    public FilterAdapter(Context context, int resource, ArrayList<SampleData> objects) {
        super(context, resource, objects);
        this.listData = objects;
    }

    public void resetData(ArrayList<SampleData> objects) {
        //this.listData.clear();
        this.listData = objects;
        notifyDataSetChanged();
    }

    public void emptyList() {
        this.listData = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public SampleData getItem(int position) {
        return listData.get(position);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.chip_item_data, parent, false);
        }

        SampleData contact = getItem(position);

        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvEmail = convertView.findViewById(R.id.email);
        TextView tvDesignation = convertView.findViewById(R.id.designation);

        if (contact != null && contact.getName() != null && !contact.getName().isEmpty()) {
            tvName.setVisibility(View.VISIBLE);
            tvName.setText(contact.getName());
        } else {
            tvName.setVisibility(View.GONE);
        }

        if (contact.getEmail() != null && !contact.getEmail().isEmpty()) {
            tvEmail.setVisibility(View.VISIBLE);
            tvEmail.setText(String.format("Email: %s", contact.getEmail()));
        } else {
            tvEmail.setVisibility(View.GONE);
        }

        if (contact.getDesignation() != null && !contact.getDesignation().isEmpty()) {
            tvDesignation.setVisibility(View.VISIBLE);
            tvDesignation.setText(String.format("Designation: %s", contact.getDesignation()));
        } else {
            tvDesignation.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    protected boolean keepObject(SampleData person, String mask) {
        mask = mask.toLowerCase();
        return person.getName().toLowerCase().startsWith(mask) || person.getEmail().toLowerCase().startsWith(mask);
    }
}
