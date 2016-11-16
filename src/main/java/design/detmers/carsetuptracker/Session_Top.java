package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.List;
//import android.widget.EditText;
//import android.widget.Toast;

//public class Session_Top extends Activity {
public class Session_Top extends Activity implements View.OnClickListener {
    Button land_LF,land_LR,land_RF,land_RR;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session__top);

//        Intent intent = getIntent();
//        if(intent.hasExtra("testZZ")) {
//            double junkA = intent.getDoubleExtra("testZZ", 99);
//            String junkB = String.valueOf(junkA);
//
//            Toast.makeText(this, junkB, Toast.LENGTH_SHORT).show();
//        }

        ////////TESTING///////////////////
        DBHandler mdb = new DBHandler(this);

        //find newly created session i.e. last one
        int last = mdb.getSessCount();
        Ses_Logs new_ses = mdb.getSess(last);

        String dt = new_ses.getDate();
        //Toast.makeText(this, "holy crap-" + dt, Toast.LENGTH_SHORT).show();

//        int[] thing = new int[4];
//        List<Ses_Logs> total = mdb.getAllSess();
//        for (Ses_Logs item : total) {
//            thing = item.getLF();
//            String log = "Id: " + item.getId() + " ,Name: " + thing[0];
//            // Writing shops to log
//            Toast.makeText(this,"Shop: : " + log,Toast.LENGTH_SHORT).show();
//        }
        ////////TESTING///////////////////

        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMetrics().
                heightPixels)
        {
            land_LF = (Button) findViewById(R.id.land_buttonLF);
            land_LR = (Button) findViewById(R.id.land_buttonLR);
            land_RF = (Button) findViewById(R.id.land_buttonRF);
            land_RR = (Button) findViewById(R.id.land_buttonRR);
            land_LF.setOnClickListener(this);
            land_LR.setOnClickListener(this);
            land_RF.setOnClickListener(this);
            land_RR.setOnClickListener(this);/**/
            //Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).show();

            //Old bad method....no longer using, left as helpful reference
//            if(intent.hasExtra("corner")){
//                String CSW = intent.getStringExtra("corner");
//                switch (CSW) {
//                    case "LF corner":
//                        if (intent.hasExtra("Ivalue")) {
//                            String junkA = intent.getStringExtra("Ivalue");
//                            final TextView L_LFI = (TextView) findViewById(R.id.land_textLFI);
//                            L_LFI.setText(junkA);
//                        }
//                        if (intent.hasExtra("Mvalue")) {
//                            String junkA = intent.getStringExtra("Mvalue");
//                            final TextView L_LFM = (TextView) findViewById(R.id.land_textLFM);
//                            L_LFM.setText(junkA);
//                        }
//                    default:
//                }
//            }
            //get all values from database
            int[] Cdata;

//            //set all values to screen from database
            //Left Front
            Cdata = new_ses.getLF();
            final TextView L_LFI = (TextView) findViewById(R.id.land_textLFI);
            L_LFI.setText(String.valueOf(Cdata[0]));
            final TextView L_LFM = (TextView) findViewById(R.id.land_textLFM);
            L_LFM.setText(String.valueOf(Cdata[1]));
            final TextView L_LFO = (TextView) findViewById(R.id.land_textLFO);
            L_LFO.setText(String.valueOf(Cdata[2]));

            //Right Front
            Cdata = new_ses.getRF();
            final TextView L_RFI = (TextView) findViewById(R.id.land_textRFI);
            L_RFI.setText(String.valueOf(Cdata[0]));
            final TextView L_RFM = (TextView) findViewById(R.id.land_textRFM);
            L_RFM.setText(String.valueOf(Cdata[1]));
            final TextView L_RFO = (TextView) findViewById(R.id.land_textRFO);
            L_RFO.setText(String.valueOf(Cdata[2]));

            //Left Rear
            Cdata = new_ses.getLR();
            final TextView L_LRI = (TextView) findViewById(R.id.land_textLRI);
            L_LRI.setText(String.valueOf(Cdata[0]));
            final TextView L_LRM = (TextView) findViewById(R.id.land_textLRM);
            L_LRM.setText(String.valueOf(Cdata[1]));
            final TextView L_LRO = (TextView) findViewById(R.id.land_textLRO);
            L_LRO.setText(String.valueOf(Cdata[2]));

            //Right Rear
            Cdata = new_ses.getRR();
            for (int cnt=0; cnt<3; cnt++){
                Toast.makeText(this,"RR->"+Cdata[cnt],Toast.LENGTH_SHORT).show();
            }
            final TextView L_RRI = (TextView) findViewById(R.id.land_textRRI);
            L_RRI.setText(String.valueOf(Cdata[0]));
            final TextView L_RRM = (TextView) findViewById(R.id.land_textRRM);
            L_RRM.setText(String.valueOf(Cdata[1]));
            final TextView L_RRO = (TextView) findViewById(R.id.land_textRRO);
            L_RRO.setText(String.valueOf(Cdata[2]));
        }
//        else
//        {
//            vert_LF = (Button) findViewById(R.id.vert_buttonLF);
//            vert_LR = (Button) findViewById(R.id.vert_buttonLR);
//            vert_RF = (Button) findViewById(R.id.vert_buttonRF);
//            vert_RR = (Button) findViewById(R.id.vert_buttonRR);
//            vert_LF.setOnClickListener(this);
//            vert_LR.setOnClickListener(this);
//            vert_RF.setOnClickListener(this);
//            vert_RR.setOnClickListener(this);/**/
//            Toast.makeText(this,"Screen switched to Portrait mode", Toast.LENGTH_SHORT).show();
//        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Session.class);
        switch (v.getId()) {
            case R.id.land_buttonLF:
                //open alignment settings
                intent.putExtra("corner", "LF");
                startActivity(intent);
                break;
            case R.id.land_buttonLR:
                //open alignment settings
                intent.putExtra("corner", "LR");
                startActivity(intent);
                break;
            case R.id.land_buttonRF:
                //open alignment settings
                intent.putExtra("corner", "RF");
                startActivity(intent);
                break;
            case R.id.land_buttonRR:
                //open alignment settings
                intent.putExtra("corner", "RR");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
