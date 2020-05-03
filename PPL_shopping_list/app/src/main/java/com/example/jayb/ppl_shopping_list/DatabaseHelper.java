package com.example.jayb.ppl_shopping_list;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME0 = "items0_table";
    private static final String TABLE_NAME = "items_table";
    private static final String TABLE_NAME2 = "items2_table";
    private static final String TABLE_NAME3 = "items3_table";
    private static final String TABLE_NAME4 = "items4_table";
    private static final String TABLE_NAME5 = "items5_table";
    private static final String TABLE_NAME6 = "items6_table";
    private static final String TABLE_NAME7 = "items7_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";



    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Toast.makeText(this,"reached oncreate", )
        System.out.print("ONCREATE");
        String createTable0 = "CREATE TABLE " + TABLE_NAME0 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable0);
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable);
        String createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable2);
        String createTable3 = "CREATE TABLE " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable3);
        String createTable4 = "CREATE TABLE " + TABLE_NAME4 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable4);
        String createTable5 = "CREATE TABLE " + TABLE_NAME5 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable5);
        String createTable6 = "CREATE TABLE " + TABLE_NAME6 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable6);
        String createTable7 = "CREATE TABLE " + TABLE_NAME7 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable7);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item, int pos) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);
        long result = -1;
        //Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        if(pos == 0) {
            result = db.insert(TABLE_NAME0, null, contentValues);
        }
        if(pos == 1) {
            result = db.insert(TABLE_NAME, null, contentValues);
        }
        if(pos == 3){
            result = db.insert(TABLE_NAME3, null, contentValues);

        }
        if(pos == 2){

            result = db.insert(TABLE_NAME2, null, contentValues);

        }
        if(pos == 4){

            result = db.insert(TABLE_NAME4, null, contentValues);

        }
        if(pos == 5){

            result = db.insert(TABLE_NAME5, null, contentValues);

        }
        if(pos == 6){

            result = db.insert(TABLE_NAME6, null, contentValues);

        }
        if(pos == 7){

            result = db.insert(TABLE_NAME7, null, contentValues);

        }


        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getData(int temp){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = null;
        if(temp == 0) {
            query = "SELECT * FROM " + TABLE_NAME0;
        }
        if(temp == 1) {
            query = "SELECT * FROM " + TABLE_NAME;
        }
        if(temp == 3) {
            query = "SELECT * FROM " + TABLE_NAME3;
        }
        if(temp == 2){
            query = "SELECT * FROM " + TABLE_NAME2;
        }
        if(temp == 4){
            query = "SELECT * FROM " + TABLE_NAME4;
        }
        if(temp == 5){
            query = "SELECT * FROM " + TABLE_NAME5;
        }
        if(temp == 6){
            query = "SELECT * FROM " + TABLE_NAME6;
        }
        if(temp == 7){
            query = "SELECT * FROM " + TABLE_NAME7;
        }


        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param name
     * @return
     */
    public Cursor getItemID(String name, int temp){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = null;
        if(temp == 1) {
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                    " WHERE " + COL2 + " = '" + name + "'";
        }
        if(temp == 0) {
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME0 +
                    " WHERE " + COL2 + " = '" + name + "'";
        }
        if(temp == 3) {
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME3 +
                    " WHERE " + COL2 + " = '" + name + "'";
        }
        if(temp == 2){
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME2 +
                    " WHERE " + COL2 + " = '" + name + "'";

        }
        if(temp == 4){
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME4 +
                    " WHERE " + COL2 + " = '" + name + "'";

        }
        if(temp == 5){
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME5 +
                    " WHERE " + COL2 + " = '" + name + "'";

        }
        if(temp == 6){
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME6 +
                    " WHERE " + COL2 + " = '" + name + "'";

        }
        if(temp == 7){
            query = "SELECT " + COL1 + " FROM " + TABLE_NAME7 +
                    " WHERE " + COL2 + " = '" + name + "'";

        }
      //  else if(temp == 2){



        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */
    public void updateName(String newName, int id, String oldName, int temp){
        SQLiteDatabase db = this.getWritableDatabase();
        String query=null;
        if(temp == 1) {
            query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 0) {
            query = "UPDATE " + TABLE_NAME0 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 3) {
            query = "UPDATE " + TABLE_NAME3 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 2) {
            query = "UPDATE " + TABLE_NAME2 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 4) {
            query = "UPDATE " + TABLE_NAME4 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 5) {
            query = "UPDATE " + TABLE_NAME5 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 6) {
            query = "UPDATE " + TABLE_NAME6 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }
        if(temp == 7) {
            query = "UPDATE " + TABLE_NAME7 + " SET " + COL2 +
                    " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + oldName + "'";
        }

        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name, int temp){
        SQLiteDatabase db = this.getWritableDatabase();
        String query=null;
        if(temp == 1) {
            query = "DELETE FROM " + TABLE_NAME + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";

        }
        if(temp == 0) {
            query = "DELETE FROM " + TABLE_NAME0 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";

        }
        if(temp == 3) {
            query = "DELETE FROM " + TABLE_NAME3 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";

        }
        if(temp == 2){
            query = "DELETE FROM " + TABLE_NAME2 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";
        }
        if(temp == 4){
            query = "DELETE FROM " + TABLE_NAME4 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";
        }
        if(temp == 5){
            query = "DELETE FROM " + TABLE_NAME5 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";
        }
        if(temp == 6){
            query = "DELETE FROM " + TABLE_NAME6 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";
        }
        if(temp == 7){
            query = "DELETE FROM " + TABLE_NAME7 + " WHERE "
                    + COL1 + " = '" + id + "'" +
                    " AND " + COL2 + " = '" + name + "'";
        }

        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

}


























