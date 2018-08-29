package com.example.lenovo.sqllitedatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyCoreDatabase extends SQLiteOpenHelper {

    static final private String DB_NAME="Education";
    static final private String DB_TABLE="Students";
    static final private int DB_VER=1;

    Context ctx;
    SQLiteDatabase myDb;

    public MyCoreDatabase(Context context) {
        //super is the constructor class of MyCoreDatabase Class
        super(context, DB_NAME, null, DB_VER);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //FIRST TABLE
        db.execSQL("CREATE TABLE "+DB_TABLE+"(_id integer primary key autoincrement,stu_name text,collage_name text);");
        Toast.makeText(ctx,"TABLE CREATED",Toast.LENGTH_SHORT).show();
        Log.i("Database","Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_TABLE);
        onCreate(db);
        Toast.makeText(ctx,"TABLE  :   UPGRADE ",Toast.LENGTH_SHORT).show();
        Log.i("DATABASE ","UPGRADE");

    }

    public void insertData(String s1,String s2){
        myDb=getWritableDatabase();
        myDb.execSQL("insert into "+DB_TABLE+" (stu_name,collage_name) values('"+s1+"','"+s2+"');");
        Toast.makeText(ctx,"Data saved successfully",Toast.LENGTH_SHORT).show();
        Log.i("DATABASE ","SAVED");
    }

    //which data you want to get write after "get"
    public void getAll(){
        myDb=getReadableDatabase();
        Cursor cr=myDb.rawQuery("Select * from "+DB_TABLE,null);//second argument for passing the value
        //SINCE WE ARE ACCESSING CURSOR SO WE HAVE TO USE "stringBuilder"
        StringBuilder strB=new StringBuilder();

        //TO SHOW DATA ROW WISE
        while (cr.moveToNext()){
            //FIRST ROW DATA
            String s1=cr.getString(1);//Index=1 bcz 0 is already taken by while
            String s2=cr.getString(2);
            strB.append(s1+"            "+s2+" \n");
        }

        Toast.makeText(ctx,strB.toString(),Toast.LENGTH_LONG).show();
        Log.i("DATABASE ","DISPLAYED");
    }
}
