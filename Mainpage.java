package com.example.asus.otutest.otu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mushfique on 16-Nov-16.
 */
public class Mainpage extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        String username =  getIntent().getStringExtra("Username");
        TextView tv= (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }

    public void onUpdateStatusClick(View v) {

        if (v.getId() == R.id.button_update_status)

        {
            Intent i = new Intent(Mainpage.this, Status.class);
            startActivity(i);

        }




    }

    public void onClickIntegrateTwitter(View v)
    {

        Intent i = new Intent(Mainpage.this, Twitt.class);
     ///   i.putExtra("tweet",status_string);
        startActivity(i);


    }




    /**

    String url="https://www.facebook.com";

    public void onClickIntegrateTwitter(View v)
    {
Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

*/


}
