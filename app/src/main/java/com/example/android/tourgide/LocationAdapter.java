package com.example.android.tourgide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_view, parent, false);
        }

        Location currentWord = getItem(position);

        TextView locationName = (TextView) listItemView.findViewById(R.id.location_name);

        locationName.setText(currentWord.getLocationName());

        TextView locationAddress = (TextView) listItemView.findViewById(R.id.location_address);

        locationAddress.setText(currentWord.getLocationAddress());

        TextView locationOpeningTime = (TextView) listItemView.findViewById(R.id.location_opening_time);

        locationOpeningTime.setText(currentWord.getLocationOpeningTime());

        TextView locationWebsite = (TextView) listItemView.findViewById(R.id.location_website);

        locationWebsite.setText(currentWord.getLocationWebsite());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {

            imageView.setImageResource(currentWord.getImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        } else {

            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
