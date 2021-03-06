package com.mysampleapp.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.amazonaws.mobile.user.signin.FacebookSignInProvider;
import com.mysampleapp.R;

/**
 * Created by HP on 6/12/2016.
 */
public class Categories_fragment2 extends Fragment {
    private ProgressDialog loading;
    GridView grid;
    String[] cat= {
            "Recharge",
            "Travel",
            "Fashion",
            "Electronics",
            "Food & Dining",
            "Gifts & Jewellary",
            "Beauty & Health",
            "Home Furnishing ",
            "Entertainment",
            "Sports & Fitness",
            "Web Hosting",
            "Education",
            "Miscellaneous"
    };
    int[] imageId ={
            R.drawable.recharge,
            R.drawable.travelicon,
            R.drawable.fashion,
            R.drawable.giftsicon,
            R.drawable.baby,
            R.drawable.giftsicon,
            R.drawable.fashion,
            R.drawable.furniture,
            R.drawable.recharge,
            R.drawable.shopping,
            R.drawable.travelicon,
            R.drawable.baby,
            R.drawable.furniture,
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories_layout2, container, false);
    }
    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        GridView gridview=(GridView) getActivity().findViewById(R.id.grid);
        final GridAdapter gridadapter= new GridAdapter(getActivity(),cat,imageId);
        gridview.setAdapter(gridadapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
           /* Intent i=new Intent(Intent.ACTION_VIEW);
             i.setData(Uri.parse(gridadapter.getItem(position).getImageUrlString()));
        startActivity(i);}});*/
               // Toast.makeText(getActivity(), "You Clicked at " + cat[+position], Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),category_show.class);
                i.putExtra("cat",cat[+position]);
                getActivity().startActivity(i);
            }
        });
    }

}
