package com.example.asus.otutest.otu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by Mushfique on 17-Nov-16.
 */
public  class Signup extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }



    public void onSignUpClick(View v) {

        if (v.getId() == R.id.signupbutton) {
            EditText name = (EditText) findViewById(R.id.TFname);
            EditText email = (EditText) findViewById(R.id.TFEmail);
            EditText username = (EditText) findViewById(R.id.signupusername);
            EditText pass1 = (EditText) findViewById(R.id.pass1);
            EditText pass2 = (EditText) findViewById(R.id.pass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String usernamestr = username.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str)) {
                //Mainpage popup
                Toast pass = Toast.makeText(Signup.this, "Password don't match", Toast.LENGTH_SHORT);
                pass.show();
            }

            else{
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUsername(usernamestr);
                c.setPassword(pass1str);

                helper.insertContact(c);


                Toast pass = Toast.makeText(Signup.this, "Password match, Log in now", Toast.LENGTH_SHORT);
                pass.show();
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);

            }





        }


    }


 }



