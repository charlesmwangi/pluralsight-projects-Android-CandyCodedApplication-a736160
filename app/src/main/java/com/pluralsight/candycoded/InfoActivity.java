package com.pluralsight.candycoded;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    TextView mapView,phoneView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        mapView = findViewById(R.id.text_view_address);
        mapView.setOnClickListener(onClickListener);
        phoneView = findViewById(R.id.text_view_phone);
        phoneView.setOnClickListener(onClickListener);
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***


    private Intent createMapIntent() {
        //DO something
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("google.navigation:q=618 E South St Orlando, F"));
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        return mapIntent;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         switch(v.getId()){
             case R.id.text_view_address:
                 createMapIntent();
//                  //DO something
//                 Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("google.navigation:q=618 E South St Orlando, F"));
//                 startActivity(mapIntent);
             break;
             case R.id.text_view_phone:
                 createPhoneIntent();
//                  //DO something
//                 Intent callIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" +"(012)345-6789"));
//                 startActivity(callIntent);
             break;
         }

   }
};
            // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
       private Intent createPhoneIntent(){
        //DO something
        Intent callIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" +"(012)345-6789"));
        startActivity(callIntent);
        return callIntent;
    }
}
