package com.example.tic_tac_toe_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class twoplayer_Activity extends AppCompatActivity {
    private String S = "X";
    private int s = 1,X=0,O=0,Moves=0;
    int[][] board = new int[3][3];
    int mooves = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayer);
    }
    public Boolean Check_if_won(int i,int j){
        int Val = board[i][j];
        Boolean chk1 = true, chk2=true;
        for(int k=0;k<3;k++){
            if(board[k][j]!=Val)chk1=false;
            if(board[i][k]!=Val)chk2=false;
        }
        if(chk1||chk2)return true;
        Log.d("I J ","hor/ver");
        chk1 = true; chk2=true;
        for(int k=0;k<3;k++){
            if(board[k][k]!=Val)chk1=false;
            if(board[k][2-k]!=Val)chk2=false;
        }
        if(chk1||chk2)return true;
        return false;
    }

    public void clean_board(){
        for(int i = 0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;
            }
        }
        ((Button)(findViewById(R.id.button1))).setText("");
        ((Button)(findViewById(R.id.button1))).setEnabled(true);
        ((Button)(findViewById(R.id.button2))).setText("");
        ((Button)(findViewById(R.id.button2))).setEnabled(true);
        ((Button)(findViewById(R.id.button3))).setText("");
        ((Button)(findViewById(R.id.button3))).setEnabled(true);
        ((Button)(findViewById(R.id.button4))).setText("");
        ((Button)(findViewById(R.id.button4))).setEnabled(true);
        ((Button)(findViewById(R.id.button5))).setText("");
        ((Button)(findViewById(R.id.button5))).setEnabled(true);
        ((Button)(findViewById(R.id.button6))).setText("");
        ((Button)(findViewById(R.id.button6))).setEnabled(true);
        ((Button)(findViewById(R.id.button7))).setText("");
        ((Button)(findViewById(R.id.button7))).setEnabled(true);
        ((Button)(findViewById(R.id.button8))).setText("");
        ((Button)(findViewById(R.id.button8))).setEnabled(true);
        ((Button)(findViewById(R.id.button9))).setText("");
        ((Button)(findViewById(R.id.button9))).setEnabled(true);
    }

    public void click_xo(View v){
        Button b = (Button)v;
        int I=0,J=0; mooves++;
        switch (b.getId()) {
            case R.id.button1:
                I = 0; J = 0;
                break;
            case R.id.button2:
                I = 0; J = 1;
                break;
            case R.id.button3:
                I = 0; J = 2;
                break;
            case R.id.button4:
                I = 1; J = 0;
                break;
            case R.id.button5:
                I = 1; J = 1;
                break;
            case R.id.button6:
                I = 1; J = 2;
                break;
            case R.id.button7:
                I = 2; J = 0;
                break;
            case R.id.button8:
                I = 2; J = 1;
                break;
            case R.id.button9:
                I = 2; J = 2;
                break;
        }
        if(board[I][J]==0)board[I][J]=s;
        b.setText(S);
        b.setEnabled(false);
        if(Check_if_won(I,J)){
            Context context = getApplicationContext();
            CharSequence text = S+"  Won !!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            clean_board();

            if(S=="X")X++;
            else O++;

            TextView neal = findViewById(R.id.neal);
            neal.setText(X+" - "+O);

            S="X"; s=1; mooves=0;
            return;
        }
        if(mooves==9){
            Context context = getApplicationContext();
            CharSequence text = "Draw!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            clean_board();
            S="X"; s=1; mooves = 0;
            return;
        }
        if(S == "X")S="O";
        else S="X";
        if(s == 1)s=-1;
        else s=1;
    }
}