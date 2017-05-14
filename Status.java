package com.example.asus.otutest.otu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mushfique on 21-Nov-16.
 */
public class Status extends Activity {
   /**
    public String status_string;
    //////////////////////////////////////////
    private static final String TWITTER_KEY = "84W5mYVF9qm5outcaiufXQs8m";
    private static final String TWITTER_SECRET = "mQ65CroeRJCOgiS2suXHvWbsW6LX28WY3jDHgYEDoG5IPf8boY";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());
        setContentView(R.layout.status);
       TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("just setting up my Fabricjjjjjjjjjjj.");
        builder.show();

//////////////////////////////////////////////
        Button statusUpdateFinalButton = (Button) findViewById(R.id.statusUpdateFinalButton);
        EditText status_edit = (EditText) findViewById(R.id.editTextStatus);

        status_string = status_edit.toString();


        /////////////////////////////////////


///////////////////////////////

//////////////////////////////

    }

    public void onUpdateStatusClick(View v) {

        if (v.getId() == R.id.statusUpdateFinalButton)

        {
            TweetComposer.Builder builder = new TweetComposer.Builder(this)
                    .text(status_string);
            builder.show();

        }
    }

*/

   String status_string;

    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.status);
    }

    public void onClickFinalUpdate(View v) {

        if (v.getId() == R.id.statusUpdateFinalButton) {


            EditText status_edit = (EditText) findViewById(R.id.editTextStatus);

            status_string = status_edit.getText().toString();
            Intent i = new Intent(Status.this, Update_Twitt.class);
            i.putExtra("tweet",status_string);
            startActivity(i);
            }

        }


}














































