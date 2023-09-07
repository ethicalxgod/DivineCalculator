package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private String no=null;
    private Button btn1, btn0,btn2, btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_plus,btn_minus,btn_equal,btn_del,btn_divide,btn_mul,btn_decimal,btn_ac;
    private TextView result,history;
    double firstno =0;
    double lastno =0;
    String status = null;
    DecimalFormat myformatter = new DecimalFormat("######.######");
    boolean operator = false;
    boolean Atccontrol = true;
    boolean equalcontrol = false;
    String history1,currentresult;
    boolean checkdecimal= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0= findViewById(R.id.zero);
        btn1= findViewById(R.id.one);
        btn2= findViewById(R.id.two);
        btn3= findViewById(R.id.three);
        btn4= findViewById(R.id.four);
        btn5= findViewById(R.id.five);
        btn6= findViewById(R.id.six);
        btn7= findViewById(R.id.seven);
        btn8= findViewById(R.id.eight);
        btn9= findViewById(R.id.nine);
        btn_plus= findViewById(R.id.plus);
        btn_minus= findViewById(R.id.minus);
        btn_ac= findViewById(R.id.Ac);
        btn_decimal= findViewById(R.id.decimal);
        btn_del= findViewById(R.id.del);
        btn_divide= findViewById(R.id.divide);
        btn_equal= findViewById(R.id.equal);
        btn_mul= findViewById(R.id.multiply);

        result = findViewById(R.id.cal_result);
        history = findViewById(R.id.cal_history);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            numberclick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("9");
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no = null;
                checkdecimal = false;
                status =null;
                result.setText("0");
                history.setText(" ");
                firstno =0;
                lastno = 0;
                Atccontrol = true;
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdecimal = false;
                history1 = history.getText().toString();
                currentresult= result.getText().toString();
                history.setText(history1 + currentresult+"+");
                    if(operator){
                        if(status=="multiplication"){
                            multiply();
                        }
                        else if (status=="divide") {
                            divide();
                        }
                        else if (status=="subtraction") {
                            subtract();
                        }
                        else{
                            plus();
                        }
                    }
                    status = "sum";
                    operator = false;
                    no = null;
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdecimal = false;
                history1 = history.getText().toString();
                currentresult= result.getText().toString();
                history.setText(history1 + currentresult+"-");
                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else if (status=="sum") {
                        plus();
                    }
                    else{
                        subtract();
                    }
                }
                status = "subtract";
                operator = false;
                no = null;
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdecimal = false;
                history1 = history.getText().toString();
                currentresult= result.getText().toString();
                history.setText(history1 + currentresult+"*");
                if(operator){
                    if(status=="subtract"){
                        subtract();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else if (status=="sum") {
                        plus();
                    }
                    else{
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                no = null;
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdecimal = false;
                history1 = history.getText().toString();
                currentresult= result.getText().toString();
                history.setText(history1 + currentresult+"/");
                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    }
                    else if (status=="subtract") {
                        subtract();
                    }
                    else if (status=="sum") {
                        plus();
                    }
                    else{
                        divide();
                    }
                }
                status = "divide";
                operator = false;
                no = null;
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator){
                    if(status=="subtract"){
                        subtract();
                    }
                    else if (status=="divide") {
                        divide();
                    }
                    else if (status=="sum") {
                        plus();
                    }
                    else if (status=="multiplication") {
                        multiply();
                    } else{
                        firstno = Double.parseDouble(result.getText().toString());
                    }
                }
                operator = false;
                equalcontrol = true;
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Atccontrol==true){
                    result.setText("0");
                }
                else{
                no = no.substring(0,no.length()-1);
                if(no.length()==0){
                    btn_del.setClickable(false);
                }
                else if (no.contains(".")) {
                    checkdecimal = true;
                }
                else{
                    checkdecimal = false;
                }
                    result.setText(no); }
            }
        });

        btn_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkdecimal==false){
                    if (no==null){
                        no = "0.";
                        checkdecimal= true;
                    }
                    else{
                        no = no + ".";
                        checkdecimal = true;
                    }
                }

                result.setText(no);
            }
        });
    }
    public void numberclick(String view ){
        if(no ==null){
            no = view;
        }
        else if (equalcontrol==true) {
            firstno =0;
            lastno =0;
            no = view;

        } else {
            no = no + view;
        }
        result.setText(no);
        operator = true;
        Atccontrol = false;
        btn_del.setClickable(true);
        equalcontrol=false;
    }
    public void plus(){
        lastno = Double.parseDouble(result.getText().toString());
        firstno = firstno + lastno;

        result.setText(myformatter.format(firstno));
    }
    public void subtract(){
        if(firstno==0){
            firstno = Double.parseDouble(result.getText().toString());
        }
        else{
            lastno = Double.parseDouble(result.getText().toString());
            firstno = firstno -lastno;
        }
        result.setText(myformatter.format(firstno));
    }
    public void multiply(){
        if(firstno==0){
            firstno=1;
            lastno = Double.parseDouble(result.getText().toString());
            firstno = firstno*lastno;
        }
        else{
            lastno = Double.parseDouble(result.getText().toString());
            firstno = firstno*lastno;
        }
        result.setText(myformatter.format(firstno));
    }
    public void divide(){
        if(firstno==0){
            lastno  = Double.parseDouble(result.getText().toString());
            firstno = lastno/1;
        }
        else{
            lastno = Double.parseDouble(result.getText().toString());
            firstno = firstno/lastno;
        }
        result.setText(myformatter.format(firstno));
    }

}