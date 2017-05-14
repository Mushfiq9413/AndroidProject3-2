package com.example.asus.otutest.otu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.login_button) {
            EditText a =(EditText)findViewById(R.id.TFusername);
            String str;
            str = a.getText().toString();
            EditText b =(EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {

                Intent i = new Intent(MainActivity.this, Mainpage.class);
                i.putExtra("Username",str);
                startActivity(i);
            }

            else{
                Toast temp = Toast.makeText(MainActivity.this, "Username or Password don't match", Toast.LENGTH_SHORT);
                temp.show();
            }


        }

        if (v.getId() == R.id.signinbutton) {
            Intent i = new Intent(MainActivity.this, Signup.class);
            startActivity(i);
        }


    }
/*

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

            }



        }


    }
    */



}