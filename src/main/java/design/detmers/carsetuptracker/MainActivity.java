package design.detmers.carsetuptracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    Button buttonOne,buttonTwo,buttonThree;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.align_set);
        buttonTwo = (Button) findViewById(R.id.session);
        buttonThree = (Button) findViewById(R.id.dev_s);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);

        ///////////////TESTING////////////////////////
        DBHandler mdb = new DBHandler(this);
        // Clear DB
        List<Ses_Logs> total = mdb.getAllSess();
        for (Ses_Logs item : total) {
            mdb.deleteSess(item);
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.align_set:
                //open alignment settings
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Your Title");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                break;
            case R.id.session:
                DBHandler mdb = new DBHandler(this);
                mdb.addSess();
                //open session test
                Intent intent1 = new Intent(this, Session_Top.class);
                startActivity(intent1);
                break;
            case R.id.dev_s:
                //open dev
                Intent intent2 = new Intent(this, AndroidDatabaseManager.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}