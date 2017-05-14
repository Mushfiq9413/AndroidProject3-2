package com.example.asus.otutest.otu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

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
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;

/**
 * Created by Mushfique on 23-Dec-16.
 */
public class Update_Twitt extends AppCompatActivity {
    private static final String TWITTER_KEY = "84W5mYVF9qm5outcaiufXQs8m";
    private static final String TWITTER_SECRET = "mQ65CroeRJCOgiS2suXHvWbsW6LX28WY3jDHgYEDoG5IPf8boY";
  protected   int success_flag=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authconfig = new TwitterAuthConfig(TWITTER_KEY,TWITTER_SECRET);
        Fabric.with(this, new Twitter(authconfig));
        String tweet_status =  getIntent().getStringExtra("tweet");

        setContentView(R.layout.mainpage);


        // Do something with result, which provides a TwitterSession for making API calls
        TwitterSession session = Twitter.getSessionManager().getActiveSession();
        /**NEW ADD*/

        ///////////
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;
        Log.d("MUSHFIQUE",token);
        Log.d("MUSHFIQUE",secret);
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient(session);

      Call<Tweet> call = twitterApiClient.getStatusesService().update(tweet_status, null, false, null, null, null, false, false, null);

       /// Call<Tweet> call = twitterApiClient.getStatusesService().update("Hello, world", null, false,null,null,null,false,false,null);
        call.enqueue(new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                Log.d("MUSHFIQUE","success");
               success_flag=1;
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("MUSHFIQUE","failed");
            }
        });



        StatusesService statusesService = Twitter.getApiClient(session).getStatusesService();
        statusesService.update(tweet_status, null, false, null, null, null, false, false, null);



    }
}
