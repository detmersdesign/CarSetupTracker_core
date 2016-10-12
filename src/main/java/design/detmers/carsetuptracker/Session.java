package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Session extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        Intent intent = getIntent();
        if(intent.hasExtra("testA")) {
            double junkA = intent.getDoubleExtra("testA", 99);
            String junkB = String.valueOf(junkA);

            Toast.makeText(this, junkB, Toast.LENGTH_SHORT).show();
        }
    }
}
