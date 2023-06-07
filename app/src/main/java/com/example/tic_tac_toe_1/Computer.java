package com.example.tic_tac_toe_1;

import static java.lang.Math.max;
import static java.lang.Math.min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;


import java.util.*;



public class Computer extends AppCompatActivity {

    public class ret{
        int i,j;
        ret(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public String S = "X";
    public int s = 1,X=0,O=0;
    public int[][] board = new int[3][3];
    public int mooves = 0;
    public Map<Integer, Button> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        map.put(1,(Button)(findViewById(R.id.button1)));
        map.put(2,(Button)(findViewById(R.id.button2)));
        map.put(3,(Button)(findViewById(R.id.button3)));
        map.put(4,(Button)(findViewById(R.id.button4)));
        map.put(5,(Button)(findViewById(R.id.button5)));
        map.put(6,(Button)(findViewById(R.id.button6)));
        map.put(7,(Button)(findViewById(R.id.button7)));
        map.put(8,(Button)(findViewById(R.id.button8)));
        map.put(9,(Button)(findViewById(R.id.button9)));

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
    public interface MyCallback {
        void onFirstMethodComplete();
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

    int dfs1(int i,int j,Boolean mv){
        int mx=-1,mn=1,a,q=0;
        board[i][j]=(mv?(1):(-1));
        if(Check_if_won(i,j)){
            board[i][j]=0;
            if(mv)return (-1);
            else return (1);
        }
        if(mv==true)mv=false;
        else mv = true;
        for(int k=0;k<3;k++){
            for(int h =0;h<3;h++){
                if(board[k][h]==0){
                    q+=1;
                    a = dfs1(k,h,mv);
                    mn = min(mn,a);
                    mx = max(mx,a);
                }
            }
        }
        board[i][j]=0;
        if(q == 0)return (0);
        return (mv?mn:mx);
    }

    ret dfs_game(){
        float Omx = -1;int Imx=0,Jmx=0;
        for(int k=0;k<3;k++){
            for(int h =0;h<3;h++){
                if(board[k][h]==0){
                    float a = dfs1(k,h,false);
                    if(a>Omx){
                        Omx = a;
                        Imx = k;
                        Jmx = h;
                    }
                }
            }
        }
        ret ret1 = new ret(Imx,Jmx);
        return ret1;
    }

    public void o_move(){
        S = "O";
        s = -1;
        ret a = dfs_game();
        board[a.i][a.j] = s;
        int btn_num = a.i * 3 +a.j +1;
        Button btn = (map.get(btn_num));

        btn.setText(S);
        btn.setEnabled(false);
        mooves++;

        if(Check_if_won(a.i,a.j)){
            Context context = getApplicationContext();
            CharSequence text = S+"  Won !!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);

            toast.show();

            clean_board();
            if(Objects.equals(S, "X"))X++;
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
        S = "X";
        s = 1;
    }


    public void click_xo(View v) {
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

            if(Objects.equals(S, "X"))X++;
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
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                //I am using UI tread because o_move()
                //interacts with UI
                runOnUiThread(new Runnable() {
                    public void run()
                    {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        o_move();
                    }
                });
            }
        };
        thread1.start();
    }
}