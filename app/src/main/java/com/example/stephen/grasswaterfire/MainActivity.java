package com.example.stephen.grasswaterfire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int mypoke;
    private int theirpoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chooseHum(View view) {
        ImageView img = (ImageView) findViewById(R.id.yourPoke);
        int id = view.getId();
        if (id == R.id.bulbButton){
            img.setImageResource(R.drawable.bulb);
            mypoke=0;
        } else if (id == R.id.charmButton){
            img.setImageResource(R.drawable.charm);
            mypoke=1;
        } else {
            img.setImageResource(R.drawable.squirt);
            mypoke=2;
        }
        chooseComp();
        compare();
    }

    private void compare() {
        if (mypoke==theirpoke){
            Toast.makeText(this, "Nothing happened...", Toast.LENGTH_SHORT).show();
        } else if ((mypoke==1 && theirpoke==0) || (mypoke==2 && theirpoke==1) || (mypoke==0 && theirpoke==2)){
            Toast.makeText(this, "Your opponent fainted!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "You fainted!", Toast.LENGTH_SHORT).show();
        }
    }


    private void chooseComp() {
        ImageView img= (ImageView) findViewById(R.id.notYourPoke);
        Random randy= new Random();
        theirpoke = randy.nextInt(3);
        if (theirpoke== 0){
            img.setImageResource(R.drawable.bulb);

        }else if(theirpoke== 1){
            img.setImageResource(R.drawable.charm);
        }else{
            img.setImageResource(R.drawable.squirt);
        }
    }

}
