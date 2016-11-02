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
        ////////TESTING///////////////////
        DBHandler db = new DBHandler(this);
        // Clear DB
        List<Shop> shops = db.getAllShops();
        for (Shop shop : shops) {
            db.deleteShop(shop);
        }
        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new Shop(1, "Dockers", "475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addShop(new Shop(2, "Dunkin Donuts", "White Plains, NY 10601"));
        db.addShop(new Shop(3, "Pizza Porlar", "North West Avenue, Boston , USA"));
        db.addShop(new Shop(4, "Town Bakers", "Beverly Hills, CA 90210, USA"));
        ////////TESTING///////////////////


        // pass stuff back
        Intent intent = new Intent(this, Session_Top.class);
        intent.putExtra("testZZ", 7000.0);

        final TextView editA =  (TextView) findViewById(R.id.corners);
        String garbage = editA.getText().toString();
        intent.putExtra("corner", garbage);

        final EditText edit1 =  (EditText) findViewById(R.id.textI);
        String Ivalue = edit1.getText().toString();
        intent.putExtra("Ivalue", Ivalue);
        final EditText edit2 =  (EditText) findViewById(R.id.textM);
        String Mvalue = edit2.getText().toString();
        intent.putExtra("Mvalue", Mvalue);
        final EditText edit3 =  (EditText) findViewById(R.id.textO);
        String Ovalue = edit3.getText().toString();
        intent.putExtra("Ovalue", Ovalue);
        final EditText edit4 =  (EditText) findViewById(R.id.textPSI);
        String PSI = edit4.getText().toString();
        intent.putExtra("PSI", PSI);
        startActivity(intent);
    }
}
