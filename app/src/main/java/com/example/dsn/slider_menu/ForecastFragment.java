package com.example.dsn.slider_menu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DSN on 2/23/2015.
 */
public class ForecastFragment extends Fragment {
    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] forecast = {
                "Today -sunny 35c",
                "Tomo -sunny 35c",
                "Sun -sunny 35c",
                "Mon -sunny 35c",
                "Tue -sunny 35c",
                "Tue -sunny 35c",
                "Tue -sunny 35c",
                "Tue -sunny 35c"
        };

        List<String> forecastWeek = new ArrayList<String>(
                Arrays.asList(forecast)
        );
        final ArrayAdapter forecastAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,R.id.list_item_forecast_textview,forecastWeek
        );

        ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),((TextView) view).getText(),Toast.LENGTH_SHORT).show();
                //  String forecast1;
                String forecast = forecastAdapter.getItem(position).toString();
                //  forecast1 = ((TextView) view).getText().toString();
                Intent myIntent = new Intent(getActivity(),DetailActivity.class);
                myIntent.putExtra(Intent.EXTRA_TEXT,forecast);
                startActivity(myIntent);
            }
        });
        return rootView;
    }
}

