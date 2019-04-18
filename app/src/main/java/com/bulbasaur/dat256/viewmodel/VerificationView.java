package com.bulbasaur.dat256.viewmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.bulbasaur.dat256.R;
import com.bulbasaur.dat256.services.Database.Authenticator;
import com.bulbasaur.dat256.services.Database.PhoneAuthenticator;

public class VerificationView extends AppCompatActivity {
    private EditText first, second, third, fourth, fifth, sixth;
    private Authenticator authenticator;
    private String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_view);
        first =  (EditText)findViewById(R.id.FirstNumber);
        second = (EditText)findViewById(R.id.SecondNumber);
        third = (EditText)findViewById(R.id.ThirdNumber);
        fourth = (EditText)findViewById(R.id.FourthNumber);
        fifth = (EditText)findViewById(R.id.FifthNumber);
        sixth = (EditText)findViewById(R.id.SixthNumber);
        authenticator= new PhoneAuthenticator(this);
        init();

        // "Skicka till nästa fönster"
        }

    private boolean checkCode(){

        if(first.length()==1 && second.length()==1 && third.length()==1 && fourth.length()==1 && fifth.length()==1 && sixth.length()==1){
            code = first.toString() + second.toString() + third.toString() + fourth.toString() + fifth.toString() + sixth.toString();
            authenticator.verify(code);
               if(authenticator.status()== Authenticator.VerificationStatus.COMPLETED) {
                    return true;
               }
               return true;
        }
        return false;
    }


    private void init(){
        first.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                if (s.length() ==1 ) {
                    second.requestFocus();
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });


        second.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    third.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        third.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    fourth.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

        });
         fourth.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {
                 if (s.length() == 1) {
                     fifth.requestFocus();
                 }
             }

             public void beforeTextChanged(CharSequence s, int start, int count,
                                           int after) {

             }

             public void onTextChanged(CharSequence s, int start, int before,
                                       int count) {

             }


         });
        fifth.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    sixth.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }


        });
    }
}
