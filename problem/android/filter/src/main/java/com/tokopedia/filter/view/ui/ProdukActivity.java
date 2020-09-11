package com.tokopedia.filter.view.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tokopedia.filter.R;
import com.tokopedia.filter.view.adapter.FilterAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ProdukActivity extends AppCompatActivity implements ActionBottomDialogFragment.ItemClickListener {
    ProdukActivity activity;
    RecyclerView rvContact;
    FilterAdapter filterAdapter;
    private final String TAG = "Chips Example";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        activity = this;
        rvContact = findViewById(R.id.product_list);

//        /*Choice Chip Section*/
//        ChipGroup choiceChipGroup = findViewById(R.id.chip_group_choice);
//        choiceChipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(ChipGroup chipGroup, @IdRes int i) {
//                Log.i(TAG, i + "");
//                Adapt();
//                if ()
//            }
//        });

        getData();
    }

    public void showBottomSheet(View view) {
        ActionBottomDialogFragment addPhotoBottomDialogFragment =
                ActionBottomDialogFragment.newInstance();
        addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                ActionBottomDialogFragment.TAG);
    }
    @Override public void onItemClick(String item) {

    }

    public void getData() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAssets());
            String status = obj.getString("status");
            if (status.equals("Success")) {
                JSONArray contactArray = obj.getJSONArray("products");
                ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
                HashMap<String, String> contact;

                for (int i = 0; i < contactArray.length(); i++) {
                    JSONObject contacts = contactArray.getJSONObject(i);
                    String name = contacts.getString("name");
                    String priceInt = contacts.getString("priceInt");
                    String city = contacts.getString("city");

                    contact = new HashMap<>();
                    contact.put("name", name);
                    contact.put("priceInt", priceInt);
                    contact.put("city", city);

                    contactList.add(contact);
                }
                filterAdapter = new FilterAdapter(activity, contactList);
                rvContact.setLayoutManager(new GridLayoutManager(this,2));
                rvContact.setAdapter(filterAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAssets() {
        String json;
        try {
            InputStream is = getApplicationContext().getAssets().open("products.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
