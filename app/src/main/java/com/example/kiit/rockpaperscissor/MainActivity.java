package com.example.kiit.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock1 , paper1 , scissor1;
    ImageView iv_cpu,iv_me;
    String myChoice , cpuChoice , result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView)findViewById(R.id.iv_cpu);
        iv_me = (ImageView)findViewById(R.id.iv_me);

        rock1 = (Button)findViewById(R.id.rock1);
        paper1 = (Button)findViewById(R.id.paper1);
        scissor1 = (Button)findViewById(R.id.scissor1);
        r = new Random();

        rock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        scissor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissor";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();
            }
        });


    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu == 0){
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }else  if(cpu == 1){
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }else  if(cpu == 2){
            cpuChoice = "scissor";
            iv_cpu.setImageResource(R.drawable.scissor);
        }

        //LOGIC

        if(myChoice.equals("rock") && cpuChoice.equals("paper")){
            result = "YOU LOOSE";
        }else

        if(myChoice.equals("rock") && cpuChoice.equals("scissor")){
            result = "YOU WIN ";
        }else

        if(myChoice.equals("scissor") && cpuChoice.equals("paper")){
            result = "YOU WIN";
        }else

        if(myChoice.equals("scissor") && cpuChoice.equals("rock")){
            result = "YOU LOOSE";
        }else

        if(myChoice.equals("paper") && cpuChoice.equals("rock")){
            result = "YOU WIN";
        }else

        if(myChoice.equals("paper") && cpuChoice.equals("scissor")){
            result = "YOU LOOSE";
        }else

        if(myChoice.equals("rock") && cpuChoice.equals("rock")){
            result = "DRAW ";
        }

        if(myChoice.equals("paper") && cpuChoice.equals("paper")){
            result = "DRAW ";
        }

        if(myChoice.equals("scissor") && cpuChoice.equals("scissor")){
            result = "DRAW";
        }

        Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
    }
}
