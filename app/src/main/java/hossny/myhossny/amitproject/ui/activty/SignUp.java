package hossny.myhossny.amitproject.ui.activty;

import androidx.appcompat.app.AppCompatActivity;
import hossny.myhossny.amitproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {
    EditText name;
    EditText password;
    TextView haveacc;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        init();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     intenttohome();
            }
        });
        haveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
       intentto();
            }
        });
    }
    protected void init(){
        name =findViewById(R.id.email);
        password = findViewById(R.id.password);
        haveacc = findViewById(R.id.have_acc_mssg);
        signup=findViewById(R.id.signup_btn);
    }
    protected void intentto(){
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
    protected void intenttohome (){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}