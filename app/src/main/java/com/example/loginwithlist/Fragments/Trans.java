package com.example.loginwithlist.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.loginwithlist.R;

import java.util.ArrayList;
import java.util.HashMap;


public class Trans extends Fragment {
    Switch tg1;

    //Array of countries
    String [] countries = new String[]{

            "Afghanistan",
            "Albania",
            "Algeria",
            "American Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antarctica",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan", "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bermuda",
            "Bolivia",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cape Verde",
            "Central African Republic",
            "Chile",
            "Chad",
            "China",
            "Colombia",
            "Comoros",
            "Democratic Republic",
            "Congo",
            "Republic of (Brazzaville)",
            "Cook Islands",
            "Costa Rica",
            "Cote dIvoire",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czech Republic",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "East Timor Timor-Leste",
            "Ecuador",
            "Egypt"
    };
    // array to store boolean status
    boolean[] status = {
            true,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            false,
            false,
            false,
            true,
            false,
            true,
            false,
            true
    } ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trans, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        if(savedInstanceState!=null){
            status = savedInstanceState.getBooleanArray("status");
        }

        String email = getActivity().getIntent().getExtras().getString("EMAIL");
        Toast.makeText(getActivity(), ""+email, Toast.LENGTH_SHORT).show();


        final ArrayList<HashMap<String, Object>> aList = new ArrayList<HashMap<String, Object>>();

        for(int i=0;i<50;i++){
            HashMap<String, Object> hm = new HashMap<String,Object>();
            hm.put("txt", countries[i]);
            hm.put("stat",status[i]);
            aList.add(hm);
        }


        final ListView lv_Countries = (ListView) view.findViewById(R.id.lv_Countries);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final ListView l_View = (ListView) parent;

                ArrayAdapter adapter = (ArrayAdapter) l_View.getAdapter();
                 final Switch tglAll = (Switch) view.findViewById(R.id.tgl_AllStatus);
                RelativeLayout relativeLayout = (RelativeLayout) view;
                tg1 = (Switch) relativeLayout.getChildAt(1);


                String strStatus = "" ;
                if(tg1.isChecked()){
                    tg1.setChecked(false);
                    strStatus = "Off";
                    status[position] = false;
                }else{
                    tg1.setChecked(true);
                    strStatus = "On";
                    status[position] = true;
                }
                tglAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for(int i=0; i < l_View.getChildCount(); i++){
                            RelativeLayout itemLayout = (RelativeLayout) lv_Countries.getChildAt(i);
                            Switch cb = (Switch)itemLayout.findViewById(R.id.tgl_status);
                            if(tglAll.isChecked()){
                                cb.setChecked(true);
                            }else {
                                cb.setChecked(false);
                            }


                        }
                    }
                });

            }
        };
        lv_Countries.setOnItemClickListener(itemClickListener);

        // list which stores name of country and status


        // Keys used in Hashmap
        final String[] from = {"txt","stat" };

        // Ids of views in listview_layout
        final int[] to = { R.id.txt_CountryName, R.id.tgl_status};


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                                             R.layout.lv_layout, R.id.txt_CountryName, countries);
        lv_Countries.setAdapter(adapter);


        final SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                searchView.clearFocus();
                lv_Countries.setAdapter(adapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
    }

    /** Saving the current state of the activity
     * for configuration changes [ Portrait <=> Landscape ]
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBooleanArray("status", status);

    }
    }

