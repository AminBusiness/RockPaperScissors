package com.example.amin_elhasan.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

         final Intent i = new Intent(this,Main2Activity.class);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(5000);
                } catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                      startActivity(i);
                      finish();
                }
            }
        };

        //This whole routine sets a transition from one page to the next
        timer.start();
    }
}
