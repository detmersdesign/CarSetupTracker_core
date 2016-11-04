package design.detmers.carsetuptracker;

/**
 * Created by mdetm on 11/1/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private static final String KEY_TLFM = "LFO_t";
    private static final String KEY_TLFI = "LFO_t";
    private static final String KEY_PLF = "LF_p";

    private static final String KEY_TRFI = "LFO_t";
    private static final String KEY_TRFM = "LFO_t";
    private static final String KEY_TRFO = "LFO_t";
    private static final String KEY_PRF = "RF_p";

    private static final String KEY_TLRO = "LRO_t";
    private static final String KEY_TLRM = "LRO_t";
    private static final String KEY_TLRI = "LRO_t";
    private static final String KEY_PLR = "LR_p";

    private static final String KEY_TRRI = "LRO_t";
    private static final String KEY_TRRM = "LRO_t";
    private static final String KEY_TRRO = "LRO_t";
    private static final String KEY_PRR = "RR_p";

    private static final String KEY_NOTES = "notes";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SESS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT,"
        + KEY_TLFO + " REAL," + KEY_TLFM + " REAL,"
        + KEY_TLFI + " REAL," + KEY_PLF  + " REAL,"
        + KEY_TRFI + " REAL," + KEY_TRFM + " REAL,"
        + KEY_TRFO + " REAL," + KEY_PRF  + " REAL,"
        + KEY_TLRO + " REAL," + KEY_TLRM + " REAL,"
        + KEY_TLRI + " REAL," + KEY_PLR  + " REAL,"
        + KEY_TRRI + " REAL," + KEY_TRRM + " REAL,"
        + KEY_TRRO + " REAL," + KEY_PRR  + " REAL,"
        + KEY_NOTES + " TEXT," + ")";
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
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        ContentValues values = new ContentValues();
        values.put(KEY_DATE, formattedDate);
        // Inserting Row
        System.out.println("Current time => " + c.getTime());
        db.insert(TABLE_SESS, null, values);
        db.close(); // Closing database connection
    }

    public void addLF(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Left Front Corner Information
        int[] temp = sess.getLF();
        values.put(KEY_TLFI, temp[0]); // Inner Temps
        values.put(KEY_TLFM, temp[1]); // Middle Temps
        values.put(KEY_TLFO, temp[2]); // Outer Temps
        values.put(KEY_PLF, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(sess.getId())});
        db.close(); // Closing database connection
    }

    public void addRF(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Right Front Corner Information
        int[] temp = sess.getRF();
        values.put(KEY_TRFI, temp[0]); // Inner Temps
        values.put(KEY_TRFM, temp[1]); // Middle Temps
        values.put(KEY_TRFO, temp[2]); // Outer Temps
        values.put(KEY_PRF, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(sess.getId())});
        db.close(); // Closing database connection
    }

    public void addLR(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Left Rear Corner Information
        int[] temp = sess.getLR();
        values.put(KEY_TLRI, temp[0]); // Inner Temps
        values.put(KEY_TLRM, temp[1]); // Middle Temps
        values.put(KEY_TLRO, temp[2]); // Outer Temps
        values.put(KEY_PRF, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(sess.getId())});
        db.close(); // Closing database connection
    }

    public void addRR(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // Right Rear Corner Information
        int[] temp = sess.getRR();
        values.put(KEY_TRRI, temp[0]); // Inner Temps
        values.put(KEY_TRRM, temp[1]); // Middle Temps
        values.put(KEY_TRRO, temp[2]); // Outer Temps
        values.put(KEY_PRR, temp[3]); // Pressure
        // updating row
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(sess.getId())});
        db.close(); // Closing database connection
    }
    public void addNote(Ses_Logs sess) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOTES, "test");  //Session Notes
        db.update(TABLE_SESS, values, KEY_ID + " = ?",
        new String[]{String.valueOf(sess.getId())});
        db.close(); // Closing database connection
    }

    // Getting one shop
    public Ses_Logs getSess(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SESS, new String[]{KEY_ID,
                KEY_TLFI, KEY_TLFM, KEY_TLFO, KEY_PLF,
                KEY_TRFI, KEY_TRFM, KEY_TRFO, KEY_PRF,
                KEY_TLRI, KEY_TLRM, KEY_TLRO, KEY_PLR,
                KEY_TRRI, KEY_TRRM, KEY_TRRO, KEY_PRR, KEY_NOTES}, KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Ses_Logs contact = new Ses_Logs(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)),
                Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)),
                Integer.parseInt(cursor.getString(15)), Integer.parseInt(cursor.getString(16)),
                cursor.getString(17));
        // return shop
        return contact;
    }
    // Getting All Shops
    public List<Ses_Logs> getAllSess() {
        List<Ses_Logs> sessList = new ArrayList<Ses_Logs>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_SESS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Ses_Logs sess = new Ses_Logs(Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)),
                        Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                        Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)),
                        Integer.parseInt(cursor.getString(11)), Integer.parseInt(cursor.getString(12)),
                        Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)),
                        Integer.parseInt(cursor.getString(15)), Integer.parseInt(cursor.getString(16)),
                        cursor.getString(17));
                // Adding contact to list
                sessList.add(sess);
            } while (cursor.moveToNext());
        }

        // return contact list
        return sessList;
    }
    // Getting shops Count
    public int getSessCount() {
        String countQuery = "SELECT * FROM " + TABLE_SESS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
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
}