package design.detmers.carsetuptracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//public class Session_Top extends Activity {
public class Session_Top extends Activity implements View.OnClickListener {
    Button land_LF,land_LR,land_RF,land_RR;
    Button vert_LF,vert_LR,vert_RF,vert_RR;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session__top);

        Intent intent = getIntent();
//        if(intent.hasExtra("testZZ")) {
//            double junkA = intent.getDoubleExtra("testZZ", 99);
//            String junkB = String.valueOf(junkA);
//
//            Toast.makeText(this, junkB, Toast.LENGTH_SHORT).show();
//        }

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
            Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).show();

            if(intent.hasExtra("Ivalue")) {
                String junkA = intent.getStringExtra("Ivalue");
                final TextView L_LFO =  (TextView) findViewById(R.id.land_textLFO);
                L_LFO.setText(junkA);
            }
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
