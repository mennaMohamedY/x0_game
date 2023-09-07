package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> gmData;
    int count=0;
    String whoWon="";
    ConstraintLayout constraintLayout;
    int scx=0,sco=0;
    TextView tv_sc1,tv_sc2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.constrain_xo);
        tv_sc1=findViewById(R.id.score_firstplayer);
        tv_sc2=findViewById(R.id.score_secondplayer);
        resetAll();
        
    }

    public void onButtonClick(View view){
        Button btn;
        String playerSymbol;


        if(view instanceof Button){
            btn = ((Button) view);
            if(btn.getText().toString().isEmpty()){
                if(count %2 ==0){
                    btn.setText("X");
                    playerSymbol="X";
                    fillArray(btn,gmData,playerSymbol);

                }else {
                    btn.setText("O");
                    playerSymbol="O";
                    fillArray(btn,gmData,playerSymbol);
                }
                count +=1;
                btn.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.bronzage,null));
            }

            if(checkIfPlayerWon(gmData,"X")){
                    Toast.makeText(getBaseContext(), "Playe_1 X Won", Toast.LENGTH_SHORT).show();
                    scx +=5;

                    //code not completed we need to call the function that will reset all the buttons for new game
                    //and we need to put score of player one in int var score then append it to the setText
                    //we need to set it first to int var so that the score can increase each time player win
                    tv_sc1.setText(scx+"");
                    resetAll();

            }else if(checkIfPlayerWon(gmData,"O")){
                    Toast.makeText(getBaseContext(), "Playe_1 O Won", Toast.LENGTH_SHORT).show();
                    sco+=5;
                    tv_sc2.setText(sco+"");
                    resetAll();
            }else if(count==9){
                Toast.makeText(getBaseContext(), "Draw", Toast.LENGTH_LONG).show();
                resetAll();
            }
            }
    }

    public void fillArray(Button b,ArrayList<String> gameData,String playersymbol){
        if(b.getId()== R.id.btn1){
            gameData.set(0,playersymbol);
        }else if(b.getId()== R.id.btn2){
            gameData.set(1,playersymbol);
        }else if(b.getId()== R.id.btn3){
            gameData.set(2,playersymbol);
        }else if(b.getId()== R.id.btn4){
            gameData.set(3,playersymbol);
        }else if(b.getId()== R.id.btn5){
            gameData.set(4,playersymbol);
        }else if(b.getId()== R.id.btn6){
            gameData.set(5,playersymbol);
        }else if(b.getId()== R.id.btn7){
            gameData.set(6,playersymbol);
        }else if(b.getId()== R.id.btn8){
            gameData.set(7,playersymbol);
        }else if(b.getId()== R.id.btn9){
            gameData.set(8,playersymbol);
        }
    }
    /*
    array{0,1,2
          3,4,5
          6,7,8}
    * */
    public Boolean checkIfPlayerWon(ArrayList<String> gmData,String playersymbol){
        //check if x or O won by rows
        for(int i=0;i<9;i+=3){
            if(gmData.get(i).equals(playersymbol) && gmData.get(i+1).equals(playersymbol) && gmData.get(i+2).equals(playersymbol)){
                return true;
            }
        }
        //check if x or O won by columns
        for(int i=0;i<3;i++){
            if(gmData.get(i).equals(playersymbol) && gmData.get(i+3).equals(playersymbol) && gmData.get(i+6).equals(playersymbol)){
                return  true;
            }
        }
        //check if x or O won by cross
        if(gmData.get(0).equals(playersymbol) && gmData.get(4).equals(playersymbol) && gmData.get(8).equals(playersymbol)){
            return true;
            }
        if(gmData.get(2).equals(playersymbol) && gmData.get(4).equals(playersymbol) && gmData.get(6).equals(playersymbol)){
                return true;
            }
        return false;
    }

    public void resetAll(){
        count=0;
        gmData = new ArrayList<String>(9);
        for(int i=0; i<9;i++){
            gmData.add("");
        }
        for(int i = 0; i< constraintLayout.getChildCount(); i++){
            View v=constraintLayout.getChildAt(i);
            if(v instanceof Button){
                ((Button) v).setText("");
                ((Button) v).setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.purple_700,null));
            }
        }
    }

}