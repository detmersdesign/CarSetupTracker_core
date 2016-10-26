package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Session extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        Intent intent = getIntent();
        if(intent.hasExtra("corner")) {
            String junkA = intent.getStringExtra("corner");

            Toast.makeText(this, junkA, Toast.LENGTH_SHORT).show();

            TextView textView = (TextView) findViewById(R.id.corners);
            textView.setText(junkA + " corner");
        }
    }

    public void accept(View view) {
        //pass stuff back
        Intent intent = new Intent(this, Session_Top.class);
        intent.putExtra("testZZ", 7000.0);

        final EditText edit1 =  (EditText) findViewById(R.id.textI);
        String Ivalue = edit1.getText().toString();
        intent.putExtra("Ivalue", Ivalue);
        final EditText edit2 =  (EditText) findViewById(R.id.textM);
        String Mvalue = edit2.getText().toString();
        intent.putExtra("Mvalue", Mvalue);
        final EditText edit3 =  (EditText) findViewById(R.id.textO);
        String Ovalue = edit3.getText().toString();
        intent.putExtra("Ovalue", Ovalue);
        startActivity(intent);
    }
}
