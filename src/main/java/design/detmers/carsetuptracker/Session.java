package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Session extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        Intent intent = getIntent();
        if(intent.hasExtra("corner")) {
            String junkA = intent.getStringExtra("corner");

            //Toast.makeText(this, junkA, Toast.LENGTH_SHORT).show();

            TextView textView = (TextView) findViewById(R.id.corners);
            textView.setText(junkA + " corner");
        }
    }

    public void accept(View view) {
        // pass stuff back
        Intent intent = new Intent(this, Session_Top.class);
        intent.putExtra("testZZ", 7000.0);

        final TextView editA =  (TextView) findViewById(R.id.corners);
        String garbage = editA.getText().toString();
        intent.putExtra("corner", garbage);

        final EditText edit1 =  (EditText) findViewById(R.id.textI);
        String Ivalue = edit1.getText().toString();
//        intent.putExtra("Ivalue", Ivalue);
        final EditText edit2 =  (EditText) findViewById(R.id.textM);
        String Mvalue = edit2.getText().toString();
//        intent.putExtra("Mvalue", Mvalue);
        final EditText edit3 =  (EditText) findViewById(R.id.textO);
        String Ovalue = edit3.getText().toString();
//        intent.putExtra("Ovalue", Ovalue);
        final EditText edit4 =  (EditText) findViewById(R.id.textPSI);
        String PSI = edit4.getText().toString();
//        intent.putExtra("PSI", PSI);

        ////////TESTING///////////////////
        DBHandler_orig db1 = new DBHandler_orig(this);

        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db1.addShop(new Shop(1, Ivalue, "475 Brannan St #330, San Francisco, CA 94107, United States"));
        db1.addShop(new Shop(2, "Dunkin Donuts", "White Plains, NY 10601"));
        db1.addShop(new Shop(3, Mvalue, "North West Avenue, Boston , USA"));
        db1.addShop(new Shop(4, Ovalue, "Beverly Hills, CA 90210, USA"));

        DBHandler db = new DBHandler(this);
        int last = db.getSessCount();
        Ses_Logs s = db.getSess(last);

        int[] stuff = new int[4];
        stuff[0] = Integer.parseInt(Ivalue);
        stuff[1] = Integer.parseInt(Mvalue);
        stuff[2] = Integer.parseInt(Ovalue);
        stuff[3] = Integer.parseInt(PSI);

        if(intent.hasExtra("corner")){
                String CSW = intent.getStringExtra("corner");
                switch (CSW) {
                    case "LF corner":
                        db.addLF(s, stuff);
                    case "RF corner":
                        db.addRF(s, stuff);
                    case "LR corner":
                        db.addLR(s, stuff);
                        Toast.makeText(this,"Left-Rear",Toast.LENGTH_SHORT).show();
                    case "RR corner":
                        db.addRR(s, stuff);
                    default:
                }
        }
        ////////TESTING///////////////////

        startActivity(intent);
    }
}
