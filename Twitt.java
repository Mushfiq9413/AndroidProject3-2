package com.example.asus.otutest.otu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.fabric.sdk.android.Fabric;
import retrofit2.Call;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

/**
 * Created by ASUS on 06-Dec-16.
 */

public class Twitt extends AppCompatActivity {


    private static final String TWITTER_KEY = "84W5mYVF9qm5outcaiufXQs8m";
    private static final String TWITTER_SECRET = "mQ65CroeRJCOgiS2suXHvWbsW6LX28WY3jDHgYEDoG5IPf8boY";

    TwitterLoginButton loginButton;
    TwitterSession need;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authconfig = new TwitterAuthConfig(TWITTER_KEY,TWITTER_SECRET);
        Fabric.with(this, new Twitter(authconfig));
        setContentView(R.layout.twitt);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession session = Twitter.getSessionManager().getActiveSession();
                /**NEW ADD*/
              need=Twitter.getSessionManager().getActiveSession();
               ///////////
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                Log.d("MUSHFIQUE",token);
                Log.d("MUSHFIQUE",secret);
                TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient(session);
/**
                Call<Tweet> call = twitterApiClient.getStatusesService().update("Hello, world", null, false,null,null,null,false,false,null);
                call.enqueue(new Callback<Tweet>() {
                    @Override
                    public void success(Result<Tweet> result) {
                        Log.d("MUSHFIQUE","success");
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        Log.d("MUSHFIQUE","failed");
                    }
                });
 */
 }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.d("MUSHFIQUE",exception.getLocalizedMessage());

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
    //////////////////////////////////////////
   // String str =  getIntent().getStringExtra("twitt");

}
