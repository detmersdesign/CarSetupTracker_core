package design.detmers.carsetuptracker;

/**
 * Weeeeee, I'm doing weird stuff
 * Created by mdetm on 11/1/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "sessInfo";
    // Table name
    private static final String TABLE_SESS = "session";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";

    private static final String KEY_TLFO = "LFO_t";
    private static final String KEY_TLFM = "LFM_t";
    private static final String KEY_TLFI = "LFI_t";
    private static final String KEY_PLF = "LF_p";

    private static final String KEY_TRFI = "RFI_t";
    private static final String KEY_TRFM = "RFM_t";
    private static final String KEY_TRFO = "RFO_t";
    private static final String KEY_PRF = "RF_p";

    private static final String KEY_TLRO = "LRO_t";
    private static final String KEY_TLRM = "LRM_t";
    private static final String KEY_TLRI = "LRI_t";
    private static final String KEY_PLR = "LR_p";

    private static final String KEY_TRRI = "RRI_t";
    private static final String KEY_TRRM = "RRM_t";
    private static final String KEY_TRRO = "RRO_t";
    private static final String KEY_PRR = "RR_p";

    private static final String KEY_NOTES = "notes";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SESS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT,"
        + KEY_TLFI + " REAL," + KEY_TLFM + " REAL," + KEY_TLFO + " REAL," + KEY_PLF  + " REAL,"
        + KEY_TRFI + " REAL," + KEY_TRFM + " REAL," + KEY_TRFO + " REAL," + KEY_PRF  + " REAL,"
        + KEY_TLRI + " REAL," + KEY_TLRM + " REAL," + KEY_TLRO + " REAL," + KEY_PLR  + " REAL,"
        + KEY_TRRI + " REAL," + KEY_TRRM + " REAL," + KEY_TRRO + " REAL," + KEY_PRR  + " REAL,"
        + KEY_NOTES + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESS);
        // Creating tables again
        onCreate(db);
    }
    // Adding new Session
    public void addSess() {
        SQLiteDatabase db = this.getWritableDatabase();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        String formattedDate = df.format(c.getTime());
        ContentValues values = new ContentValues();
        values.put(KEY_DATE, formattedDate);
        // Inserting Row
        System.out.println("Current time => " + c.getTime());
        db.insert(TABLE_SESS, null, values);
        db.close(); // Closing database connection
    }

    public void addLF(Ses_Logs xyz, int[] temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Left Front Corner Information
        //int[] temp = sess.getLF();
        values.put(KEY_TLFI, temp[0]); // Inner Temps
        values.put(KEY_TLFM, temp[1]); // Middle Temps
        values.put(KEY_TLFO, temp[2]); // Outer Temps
        values.put(KEY_PLF, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(xyz.getId())});
        db.close(); // Closing database connection
    }

    public void addRF(Ses_Logs xyz, int[] temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Right Front Corner Information
        //int[] temp = sess.getRF();
        values.put(KEY_TRFI, temp[0]); // Inner Temps
        values.put(KEY_TRFM, temp[1]); // Middle Temps
        values.put(KEY_TRFO, temp[2]); // Outer Temps
        values.put(KEY_PRF, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(xyz.getId())});
        db.close(); // Closing database connection
    }

    public void addLR(Ses_Logs xyz, int[] temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Left Rear Corner Information
        //int[] temp = sess.getLR();
        values.put(KEY_TLRI, temp[0]); // Inner Temps
        values.put(KEY_TLRM, temp[1]); // Middle Temps
        values.put(KEY_TLRO, temp[2]); // Outer Temps
        values.put(KEY_PLR, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(xyz.getId())});
        db.close(); // Closing database connection
    }

    public void addRR(Ses_Logs xyz, int[] temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Right Rear Corner Information
        //int[] temp = sess.getRR();
        values.put(KEY_TRRI, temp[0]); // Inner Temps
        values.put(KEY_TRRM, temp[1]); // Middle Temps
        values.put(KEY_TRRO, temp[2]); // Outer Temps
        values.put(KEY_PRR, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(xyz.getId())});
        db.close(); // Closing database connection
    }
    public void addNote(Ses_Logs xyz) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOTES, "test");  //Session Notes
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(xyz.getId())});
        db.close(); // Closing database connection
    }

    // Getting one shop
    public Ses_Logs getSess(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SESS, new String[]{KEY_ID, KEY_DATE,
                KEY_TLFI, KEY_TLFM, KEY_TLFO, KEY_PLF,
                KEY_TRFI, KEY_TRFM, KEY_TRFO, KEY_PRF,
                KEY_TLRI, KEY_TLRM, KEY_TLRO, KEY_PLR,
                KEY_TRRI, KEY_TRRM, KEY_TRRO, KEY_PRR, KEY_NOTES}, KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Ses_Logs contact = new Ses_Logs(cursor.getInt(0),
                cursor.getString(1), cursor.getInt(2),
                cursor.getInt(3), cursor.getInt(4),
                cursor.getInt(5), cursor.getInt(6),
                cursor.getInt(7), cursor.getInt(8),
                cursor.getInt(9), cursor.getInt(10),
                cursor.getInt(11), cursor.getInt(12),
                cursor.getInt(13), cursor.getInt(14),
                cursor.getInt(15), cursor.getInt(16),
                cursor.getInt(17),cursor.getString(18));
        cursor.close();
        // return shop
        return contact;
    }
    // Getting All Shops
    public List<Ses_Logs> getAllSess() {
        List<Ses_Logs> stuff = new ArrayList<Ses_Logs>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_SESS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Ses_Logs item = new Ses_Logs(cursor.getInt(0),
                        cursor.getString(1), cursor.getInt(2),
                        cursor.getInt(3), cursor.getInt(4),
                        cursor.getInt(5), cursor.getInt(6),
                        cursor.getInt(7), cursor.getInt(8),
                        cursor.getInt(9), cursor.getInt(10),
                        cursor.getInt(11), cursor.getInt(12),
                        cursor.getInt(13), cursor.getInt(14),
                        cursor.getInt(15), cursor.getInt(16),
                        cursor.getInt(17), cursor.getString(18));
                // Adding contact to list
                stuff.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return contact list
        return stuff;
    }
    // Getting shops Count
    public int getSessCount() {
        String countQuery = "SELECT * FROM " + TABLE_SESS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        // return count
        return cnt;
    }
    // Updating a shop
    public int updateShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, shop.getName());
//        values.put(KEY_SH_ADDR, shop.getAddress());

        // updating row
        return db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(shop.getId())});
    }

    // Deleting a session
    public void deleteSess(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SESS, KEY_ID + " = ?",
        new String[] { String.valueOf(sess.getId()) });
        db.close();
    }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }
}