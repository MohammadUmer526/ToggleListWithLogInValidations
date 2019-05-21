package com.example.loginwithlist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.RelativeLayout;

import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;


import com.example.loginwithlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transaction extends AppCompatActivity {
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
//                El Salvador, Equatorial Guinea, Eritrea, Estonia, Ethiopia, Faroe Islands, Fiji, Finland, France, French Guiana, French Polynesia, Gabon, Gambia, Georgia, Germany, Ghana, Gibraltar, Greece, Greenland, Grenada, Guadeloupe, Guam, Guatemala, Guinea, Guinea-Bissau, Guyana, Haiti, Honduras, Hong Kong, Hungary, Iceland, India, Indonesia, Iran, Iraq, Ireland, Italy, Jamaica, Japan, Jordan, Kazakhstan, Kenya, Kiribati, Korea (North Korea), Korea (South Korea), Kuwait, Kyrgyzstan, Lao PDR, Latvia, Lebanon, Lesotho, Liberia, Libya, Liechtenstein, Lithuania, Luxembourg, Macao, Macedonia Rep. of, Madagascar, Malawi, Malaysia, Maldives, Mali, Malta, Marshall Islands, Martinique, Mauritania, Mauritius, Mexico, Micronesia, Moldova, Monaco, Mongolia, Montenegro, Montserrat, Morocco, Mozambique, Myanmar Burma, Namibia, Nauru, Nepal, Netherlands, Netherlands Antilles, New Caledonia, New Zealand, Nicaragua, Niger, Nigeria, Niue, Northern Mariana Islands, Norway, Oman, Pakistan, Palau, Palestine, Panama, Papua New Guinea, Paraguay, Peru, Philippines, Poland, Portugal, Puerto Rico, Qatar, Reunion Island, Romania, Russia, Rwanda, Saint Kitts and Nevis, Saint Lucia, Saint Vincent and the, Samoa, San Marino, Sao Tome and Príncipe, Saudi Arabia, Senegal, Serbia, Seychelles, Sierra Leone, Singapore, Slovakia, Slovenia, Solomon Islands, Somalia, South Africa, Spain, Sri Lanka, Sudan, Suriname, Swaziland, Sweden, Switzerland, Syria, Taiwan, Tajikistan, Tanzania, Thailand, Tibet, Timor-Leste (East Timor), Togo, Tonga, Trinidad and Tobago, Tunisia, Turkey, Turkmenistan, Tuvalu, Uganda, Ukraine, United Arab Emirates, United Kingdom, United States, Uruguay, Uzbekistan, Vanuatu, Vatican City State, Venezuela, Vietnam, Virgin Islands (British), Virgin Islands (U.S.), Wallis and Futuna Islands, Western Sahara, Yemen, Zambia, Zimbabwe

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);


        /** Restore from the previous state if exists */
        if(savedInstanceState!=null){
            status = savedInstanceState.getBooleanArray("status");
        }


        final ListView lv_Countries = (ListView) findViewById(R.id.lv_Countries);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView l_View = (ListView) parent;

                SimpleAdapter adapter = (SimpleAdapter) l_View.getAdapter();
                HashMap hm = (HashMap) adapter.getItem(position);

                RelativeLayout relativeLayout = (RelativeLayout) view;
                Switch tg1 = (Switch) relativeLayout.getChildAt(1);

                String strStatus = "" ;
                if(tg1.isChecked()){
                    tg1.setChecked(false);
                    strStatus = "Off";
                    status[position] = false;
                }else{
                    tg1.setChecked((true));
                    strStatus = "On";
                    status[position] = true;
                }
                Toast.makeText(getBaseContext(), (String) hm.get("txt") + " : " + strStatus,
                        Toast.LENGTH_SHORT).show();
            }
        };
        lv_Countries.setOnItemClickListener(itemClickListener);

        // list which stores name of country and status
        List<HashMap<String, Object>> aList = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<10;i++){
            HashMap<String, Object> hm = new HashMap<String,Object>();
            hm.put("txt", countries[i]);
            hm.put("stat",status[i]);
            aList.add(hm);
        }


        // Keys used in Hashmap
        String[] from = {"txt","stat" };

        // Ids of views in listview_layout
        int[] to = { R.id.txt_CountryName, R.id.tgl_status};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        final SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.lv_layout, from, to);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.lv_layout, R.id.txt_CountryName, countries);
        lv_Countries.setAdapter(adapter);

        final SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                searchView.clearFocus();
                return true;
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBooleanArray("status", status);


    }
    /** Saving the current state of the activity
     * for configuration changes [ Portrait <=> Landscape ]
     */

}
