package com.example.hp.phase1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

    private Button Submit;
    private Button SignUp;
    private EditText mob;
    private EditText password;
    final DB db= new DB(this);

    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Submit = (Button) findViewById(R.id.button);
        SignUp = (Button) findViewById(R.id.button2);

       mob = (EditText) findViewById(R.id.number);
       password = (EditText) findViewById(R.id.password);

        Submit.setOnClickListener(new View.OnClickListener() {
                   @Override
                  public void onClick(View v) {
                   String mobile = mob.getText().toString();
                   String Pwd = password.getText().toString();
                   String password= db.checkUser(mobile);
                       if(Pwd.equals(password))
                       {
                           Intent intent = new Intent(context, SignUpPage.class);
                           startActivity(intent);
                       }

                  }
          });


                SignUp.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(context, SignUpPage.class);
                        startActivity(intent);


                    }

                });


            }




    }

