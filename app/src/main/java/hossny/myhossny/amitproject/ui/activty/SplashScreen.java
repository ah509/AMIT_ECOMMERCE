package hossny.myhossny.amitproject.ui.activty;

import androidx.appcompat.app.AppCompatActivity;
import hossny.myhossny.amitproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
          intenttologin();
             }
         }, 3000);
        Toast.makeText(this,"hello to Amit",Toast.LENGTH_LONG).show();
    }
    protected void   intenttologin(){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
        finish();
    }
}