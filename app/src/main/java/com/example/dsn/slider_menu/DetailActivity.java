package com.example.dsn.slider_menu;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by DSN on 2/23/2015.
 */
public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            Intent myIntent = getActivity().getIntent();
            // Bundle extra = myIntent.getExtras();
            // String extraString;
            //if(extra != null)
            // {
            //      extraString = extra.getString("STRING_REQUIRED");
            //     ((TextView) rootView.findViewById(R.id.detail_text))
            //              .setText(extraString);
            //  }
            //  if(extra == null){
            //      extraString = "whats up";
            //      ((TextView) rootView.findViewById(R.id.detail_text))
            //             .setText(extraString);
            // }
            if (myIntent != null && myIntent.hasExtra(Intent.EXTRA_TEXT)) {
                // String myString = "Well Done!!";
                String myString = myIntent.getStringExtra(Intent.EXTRA_TEXT);
                ((TextView) rootView.findViewById(R.id.detail_text))
                        .setText(myString);
            }

            return rootView;
        }
    }
}

