package com.example.lightsoutgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declaring button variables
    private Button b0 = null;
    private Button b1 = null;
    private Button b2 = null;
    private Button b3 = null;
    private Button b4 = null;
    private Button b5 = null;
    private Button b6 = null;
    private Button b7 = null;
    private Button b8 = null;
    private Button b9 = null;
    private Button b10 = null;
    private Button b11 = null;
    private Button b12 = null;
    private Button b13 = null;
    private Button b14 = null;
    private Button b15 = null;
    private Button b16 = null;
    private Button b17 = null;
    private Button b18 = null;
    private Button b19 = null;
    private Button b20 = null;
    private Button b21 = null;
    private Button b22 = null;
    private Button b23 = null;
    private Button b24 = null;
    private Button reset = null;
    public Button[] board = new Button[25];//an array to keep track of the board buttons

    public boolean[] color = new boolean[25];//an array to keep track of the buttons colors


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the button array to connect to the buttons
        board[0] = findViewById(R.id.b0);
        board[1] = findViewById(R.id.b1);
        board[2] = findViewById(R.id.b2);
        board[3] = findViewById(R.id.b3);
        board[4] = findViewById(R.id.b4);
        board[5] = findViewById(R.id.b5);
        board[6] = findViewById(R.id.b6);
        board[7] = findViewById(R.id.b7);
        board[8] = findViewById(R.id.b8);
        board[9] = findViewById(R.id.b9);
        board[10] = findViewById(R.id.b10);
        board[11] = findViewById(R.id.b11);
        board[12] = findViewById(R.id.b12);
        board[13] = findViewById(R.id.b13);
        board[14] = findViewById(R.id.b14);
        board[15] = findViewById(R.id.b15);
        board[16] = findViewById(R.id.b16);
        board[17] = findViewById(R.id.b17);
        board[18] = findViewById(R.id.b18);
        board[19] = findViewById(R.id.b19);
        board[20] = findViewById(R.id.b20);
        board[21] = findViewById(R.id.b21);
        board[22] = findViewById(R.id.b22);
        board[23] = findViewById(R.id.b23);
        board[24] = findViewById(R.id.b24);
        reset = findViewById(R.id.reset);//button to reset game

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        b17.setOnClickListener(this);
        b18.setOnClickListener(this);
        b19.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b24.setOnClickListener(this);
        reset.setOnClickListener(this);

        boardStart();//start the game by initializing the color array with true/false values
        
        if(gameOver()){
            String s = "Congrats you won";
        }
    }

    //randomly filling the color array with either true or false
    private void boardStart() {
        Random rand = new Random();
        for(int i = 0; i < 25; i++){
            color[i] = rand.nextBoolean();
        }
    }

    public boolean gameOver(){
        int count = 0;
        for(int i = 0; i < 25; i++){
            if(color[i]){
                count++;
            }
        }
        //if all 25 buttons values are true (ie they are black) then the game is won
        if(count == 25){
            return true;
        }
        return false;
    }

    public void changeRight(int j){
        //exiting method if the button is in the right column
        for(int i = 4; i < 25; i += 5){
            if(j == i){
                return;
            }
        }
        //increasing j by one to point to the right button and change its value
        j++;
        if(color[j]){
            color[j] = false;
        }
        else if(!color[j]){
            color[j] = true;
        }
    }

    public void changeLeft(int j){
        //exiting method if the button is in the left column
        for(int i = 0; i < 25; i += 5){
            if(j == i){
                return;
            }
        }
        //decreasing j by one to point to the left button and change its value
        j--;
        if(color[j]){
            color[j] = false;
        }
        else if(!color[j]){
            color[j] = true;
        }
    }

    public void changeAbove(int j){
        //exiting method if the button is in the top row
        for(int i = 0; i < 5; i++){
            if(j == i){
                return;
            }
        }
        //decreasing j by 5 to point to the button above and change its value
        j -= 5;
        if(color[j]){
            color[j] = false;
        }
        else if(!color[j]){
            color[j] = true;
        }
    }

    public void changeBelow(int j){
        //exiting method if the button is in the bottom row
        for(int i = 20; i < 25; i++){
            if(j == i){
                return;
            }
        }
        //increasing j by 5 to point to the button below and change its value
        j += 5;
        if(color[j]){
            color[j] = false;
        }
        else if(!color[j]){
            color[j] = true;
        }
    }


    @Override
    public void onClick(View view) {
        int j;//variable to make copy/pasting if else statement easier

        //find what button was pressed and change the values of that button and the buttons around it
        if(view.getId() == R.id.b0){
            j = 0;
            //changing the value of the buttons around the clicked button
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the clicked button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b1){
            j = 1;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b2){
            j = 2;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b3){
            j = 3;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b4){
            j = 4;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b5){
            j = 5;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b6){
            j = 6;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b7){
            j = 7;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b8){
            j = 8;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b9){
            j = 9;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b10){
            j = 10;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b11){
            j = 11;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b12){
            j = 12;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b13){
            j = 13;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b14){
            j = 14;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b15){
            j = 15;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b16){
            j = 16;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b17){
            j = 17;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b18){
            j = 18;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b19){
            j = 19;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b20){
            j = 20;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b21){
            j = 21;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b22){
            j = 22;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b23){
            j = 23;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.b24){
            j = 24;
            changeRight(j);
            changeLeft(j);
            changeAbove(j);
            changeBelow(j);

            //changing the value of the button
            if(color[j] == true){
                color[j] = false;
            }
            else if(color[j] == false){
                color[j] = true;
            }
        }
        else if(view.getId() == R.id.reset){
            //change all the values back to new random true/false values
            boardStart();
        }

        //going through all the buttons and making their color align with their boolean value
        for(int i = 0; i < 25; i++){
            if(color[i]){
                board[i].setBackgroundColor(Color.BLACK);
            }
            else{
                board[i].setBackgroundColor(Color.WHITE);
            }
        }
    }
}
