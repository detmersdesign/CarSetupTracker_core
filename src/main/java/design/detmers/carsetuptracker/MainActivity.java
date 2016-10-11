package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    Button buttonOne,buttonTwo,buttonThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.session);
        buttonTwo = (Button) findViewById(R.id.dev_s);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.session:
                //open session test
                Intent intent1 = new Intent(this, Session.class);
                startActivity(intent1);
                break;
            case R.id.dev_s:
                //open dev
                Intent intent2 = new Intent(this, Session_Top.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}