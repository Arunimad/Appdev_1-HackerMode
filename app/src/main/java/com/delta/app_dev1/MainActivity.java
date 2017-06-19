package com.delta.app_dev1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;



public class MainActivity extends AppCompatActivity
 {



    int r = 0, g = 0, b = 0;
    int i = 50;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final Button b1 = (Button) findViewById(R.id.Button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.layout1);


                if (r != 250)
                {
                    r += i;
                    currentLayout.setBackgroundColor(Color.rgb(r, g, b));
                }
                else
                    {
                        r=0;
                        currentLayout.setBackgroundColor(Color.rgb(r, g, b));
                    }


            }
        });



        final Button b2 = (Button) findViewById(R.id.Button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.layout1);


                if (g != 250) {

                    g += i;
                    currentLayout.setBackgroundColor(Color.rgb(r, g, b));
                }
                else {

                        g=0;
                       currentLayout.setBackgroundColor(Color.rgb(r, g, b));

                }
            }
        });


        final Button b3 = (Button) findViewById(R.id.Button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.layout1);



                if (b != 250) {
                    b += i;
                    currentLayout.setBackgroundColor(Color.rgb(r, g, b));
                }
                else {

                        b=0;
                        currentLayout.setBackgroundColor(Color.rgb(r, g, b));

                }
            }
        });





        Button b4 = (Button) findViewById(R.id.button10);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r=0;
                g=0;
                b=0;



            }
        });



        SharedPreferences settings_r = getSharedPreferences("pref_r", Context.MODE_PRIVATE);
        int lastr = settings_r.getInt("pref_r",1);
        r=lastr;


        SharedPreferences settings_g = getSharedPreferences("pref_g", Context.MODE_PRIVATE);
        int lastg = settings_g.getInt("pref_g",1);
        g=lastg;


        SharedPreferences settings_b = getSharedPreferences("pref_b", Context.MODE_PRIVATE);
        int lastb = settings_b.getInt("pref_b",1);
        b=lastb;







        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {



                                Button b7 = (Button) findViewById(R.id.button7);
                                b7.setText(String.valueOf(r));

                                Button b8 = (Button) findViewById(R.id.button8);
                                b8.setText(String.valueOf(g));


                                Button b9 = (Button) findViewById(R.id.button9);
                                b9.setText(String.valueOf(b));



                                RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.layout1);
                                currentLayout.setBackgroundColor(Color.rgb(r, g, b));







                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();










    }
     @Override
     protected void onStop() {
         super.onStop();

         SharedPreferences settings_r = getSharedPreferences("pref_r", Context.MODE_PRIVATE);
         SharedPreferences.Editor ed_r = settings_r.edit();
         ed_r.putInt("pref_r", r);
         ed_r.commit();

         SharedPreferences settings_g = getSharedPreferences("pref_g", Context.MODE_PRIVATE);
         SharedPreferences.Editor ed_g = settings_g.edit();
         ed_g.putInt("pref_g", g);
         ed_g.commit();

         SharedPreferences settings_b = getSharedPreferences("pref_b", Context.MODE_PRIVATE);
         SharedPreferences.Editor ed_b = settings_b.edit();
         ed_b.putInt("pref_b", b);
         ed_b.commit();










     }
}















