package hossny.myhossny.amitproject.ui.activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import hossny.myhossny.amitproject.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    NavController navController;
    //TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   setup();


        Toast.makeText(this, "my test branch", Toast.LENGTH_SHORT).show();



//        tokenManager = new TokenManager(this);
//        String s= tokenManager.getToken();
//        Log.d("ddddddddddddd", "onCreate: "+s);
    }



    protected void setup(){
        bottomNavigationView=findViewById(R.id.bottpm_nav);
        navController= Navigation.findNavController(this,R.id.na);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
}