package com.temp.usamamaqbool.assignment4task2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
  Button abc=(Button)findViewById(R.id.abc);Button cbf=(Button)findViewById(R.id.cbf);}protected void goToabcActivity(View view) {Intent intent = new Intent(getApplicationContext(),abc.class);startActivity(intent);}protected void goTocbfActivity(View view) {Intent intent = new Intent(getApplicationContext(),cbf.class);startActivity(intent);}}