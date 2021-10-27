package com.example.headsup2

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context):SQLiteOpenHelper(context,"celebrities.db",null,1){
    var sqlDatabase:SQLiteDatabase=writableDatabase
    override fun onCreate(p: SQLiteDatabase?) {

        p!!.execSQL("create table celebrity(name text, taboo1 text,taboo2 text,taboo3 text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun saveData(name :String, taboo1 :String,taboo2 :String,taboo3 :String): Long {
        val cv =ContentValues()
        cv.put("name",name)
        cv.put("taboo1",taboo1)
        cv.put("taboo2",taboo2)
        cv.put("taboo3",taboo3)
       var statue= sqlDatabase.insert("celebrity",null,cv)

        return statue

    }

    @SuppressLint("Range")
    fun getCelebrities():ArrayList<Celebrity>{
        val celebrities: ArrayList<Celebrity> = ArrayList()
        var name: String
        var taboo1: String
        var taboo2: String
        var taboo3: String
        var c:Cursor=sqlDatabase.rawQuery("select * from celebrity",null)

        if(c.moveToFirst()){
            do{
                name= c.getString(c.getColumnIndex("name"))
                taboo1= c.getString(c.getColumnIndex("taboo1"))
                taboo2= c.getString(c.getColumnIndex("taboo2"))
                taboo3= c.getString(c.getColumnIndex("taboo3"))


                celebrities.add(Celebrity( name, taboo1, taboo2, taboo3))

            }while (c.moveToNext())
        }
return celebrities
    }
}