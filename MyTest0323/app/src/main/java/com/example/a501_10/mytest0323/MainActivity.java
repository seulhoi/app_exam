package com.example.a501_10.mytest0323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText_num1, editText_num2;
    TextView textView_re;
    Button btn_plus, btn_minus, btn_gob,btn_na;
    String input_num1,input_num2;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_num1 = (EditText)findViewById(R.id.editText_num1);
        editText_num2 = (EditText)findViewById(R.id.editText_num2);
        textView_re = (TextView)findViewById(R.id.textView_re);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_gob = (Button)findViewById(R.id.btn_gob);
        btn_na = (Button)findViewById(R.id.btn_na);

        //4.리스너객체등록
        BtnPlusListener btnPlusListener = new BtnPlusListener();
        BtnMinusListener btnMinusListener = new BtnMinusListener();
        BtnGobListener btnGobListener = new BtnGobListener();
        BtnNaListener btnNaListener = new BtnNaListener();

        //5.객체의 리스너 등록
        btn_plus.setOnClickListener(btnPlusListener);
        btn_minus.setOnClickListener(btnMinusListener);
        btn_gob.setOnClickListener(btnGobListener);
        btn_na.setOnClickListener(btnNaListener);

    }
//덧셈
    class BtnPlusListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            input_num1 = editText_num1.getText().toString();
            input_num2 = editText_num2.getText().toString();
            result = Integer.parseInt(input_num1) + Integer.parseInt(input_num2);
            textView_re.setText("계산결과 : " + result);

        }

    }
  //뺄셈
  class BtnMinusListener implements View.OnClickListener{

      @Override
      public void onClick(View view) {
          input_num1 = editText_num1.getText().toString();
          input_num2 = editText_num2.getText().toString();
          result = Integer.parseInt(input_num1) - Integer.parseInt(input_num2);
          textView_re.setText("계산결과 : " + result);

      }
  }

 //곱셈
 class BtnGobListener implements View.OnClickListener{

     @Override
     public void onClick(View view) {
         input_num1 = editText_num1.getText().toString();
         input_num2 = editText_num2.getText().toString();
         result = Integer.parseInt(input_num1) * Integer.parseInt(input_num2);
         textView_re.setText("계산결과 : " + result);

     }
 }

 //나눗셈
 class BtnNaListener implements View.OnClickListener{

     @Override
     public void onClick(View view) {
         input_num1 = editText_num1.getText().toString();
         input_num2 = editText_num2.getText().toString();
         result = Integer.parseInt(input_num1) / Integer.parseInt(input_num2);
         textView_re.setText("계산결과 : " + result);
     }
 }


}
