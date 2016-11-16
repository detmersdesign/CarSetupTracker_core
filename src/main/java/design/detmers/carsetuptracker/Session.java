package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Session extends Activity {
    public static int parseInteger( String string, int defaultValue ) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e ) {
            return defaultValue;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        Intent intent = getIntent();
        if(intent.hasExtra("corner")) {
            String junkA = intent.getStringExtra("corner");

            //Toast.makeText(this, junkA, Toast.LENGTH_SHORT).show();

            TextView textView = (TextView) findViewById(R.id.corners);
            String label = junkA + " corner";
            textView.setText(label);
        }
    }

    public void accept(View view) {
        // pass stuff back
        Intent intent = new Intent(this, Session_Top.class);

        final TextView editA =  (TextView) findViewById(R.id.corners);
        String garbage = editA.getText().toString();
        intent.putExtra("corner", garbage);

        final EditText edit1 =  (EditText) findViewById(R.id.textI);
        String Ivalue = edit1.getText().toString();
        final EditText edit2 =  (EditText) findViewById(R.id.textM);
        String Mvalue = edit2.getText().toString();
        final EditText edit3 =  (EditText) findViewById(R.id.textO);
        String Ovalue = edit3.getText().toString();
        final EditText edit4 =  (EditText) findViewById(R.id.textPSI);
        String PSI = edit4.getText().toString();

        ////////TESTING///////////////////
        DBHandler db = new DBHandler(this);
        int last = db.getSessCount();
        Ses_Logs s = db.getSess(last);

        int[] stuff = new int[4];
        stuff[0] = parseInteger(Ivalue,0);
        stuff[1] = parseInteger(Mvalue,0);
        stuff[2] = parseInteger(Ovalue,0);
        stuff[3] = parseInteger(PSI,0);
//        for (int lst=0; lst<4; lst++){
//            Toast.makeText(this, String.valueOf(stuff[lst]), Toast.LENGTH_SHORT).show();
//        }
        if(intent.hasExtra("corner")){
                String CSW = intent.getStringExtra("corner");
                //Toast.makeText(this,CSW, Toast.LENGTH_SHORT).show();
                if (CSW.equals("LF corner")){
                    db.addLF(s, stuff);
//                    Toast.makeText(this,"LF->", Toast.LENGTH_SHORT).show();
                }
                if (CSW.equals("RF corner")){
                    db.addRF(s, stuff);
//                    Toast.makeText(this, "RF->", Toast.LENGTH_SHORT).show();
                }
                if (CSW.equals("LR corner")){
                    db.addLR(s, stuff);
//                    Toast.makeText(this,"LR->", Toast.LENGTH_SHORT).show();
                }
                if (CSW.equals("RR corner")){
                    db.addRR(s, stuff);
//                    Toast.makeText(this,"RR->", Toast.LENGTH_SHORT).show();
                }
        }
        ////////TESTING///////////////////

        startActivity(intent);
    }
}
