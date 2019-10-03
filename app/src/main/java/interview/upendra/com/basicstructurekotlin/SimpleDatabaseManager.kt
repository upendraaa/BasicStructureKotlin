package interview.upendra.com.basicstructurekotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SimpleDatabaseManager{


    val DATABASE_NAME:String = "simpleDatabase"
    val TABLE_PERSON: String = "table_person"

    val COLUMN_ID:String = "column_id";
    val PERSON_ID:String ="person_id";
    val PERSON_NAME:String = "name";

    val DB_VERSION:Int = 1;

    var database:SQLiteDatabase?=null;


    constructor(context: Context)
    {
        val db = DatabaseHelper(context);
        database = db.writableDatabase;
    }


    inner  class DatabaseHelper:SQLiteOpenHelper{

       constructor(context: Context):super(context,DATABASE_NAME,null,DB_VERSION){

       }

        override fun onCreate(db: SQLiteDatabase?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}

