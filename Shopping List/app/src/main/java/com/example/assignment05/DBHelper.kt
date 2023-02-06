package com.example.assignment05

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private val DATABASE_NAME = "ITEM_REPOSITORY"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "ITEM"
        private val ID = "id"
        private val IMG = "img"
        private val NAME = "name"
        private  val DETAIL = "detail"
        private val QUANTITY = "quantitiy"
        private val SIZE = "size"
        private val URGENT = "urgent"
        private val BOUGHT = "bought"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $IMG INTEGER, $NAME TEXT, $DETAIL TEXT, $QUANTITY TEXT, $SIZE TEXT, $URGENT TEXT, $BOUGHT TEXT)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }
    fun insertItem(items: items){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(IMG, items.img)
        contentValues.put(NAME, items.name)
        contentValues.put(DETAIL, items.detail)
        contentValues.put(QUANTITY, items.quantity)
        contentValues.put(SIZE, items.size)
        contentValues.put(URGENT, items.urgent)
        contentValues.put(BOUGHT, items.bought)

        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getallitems(): ArrayList<items> {
        var itemlist: ArrayList<items> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()){
            do {
                val id= result.getInt(result.getColumnIndex(ID).toInt())
                val img= result.getInt(result.getColumnIndex(IMG).toInt())
                val name= result.getString(result.getColumnIndex(NAME).toInt())
                val detail= result.getString(result.getColumnIndex(DETAIL).toInt())
                val quantity= result.getString(result.getColumnIndex(QUANTITY).toInt())
                val size= result.getString(result.getColumnIndex(SIZE).toInt())
                val urgent= result.getString(result.getColumnIndex(URGENT).toInt())
                val bought= result.getString(result.getColumnIndex(BOUGHT).toInt())
                itemlist.add(items(id, img, name, detail, quantity, size, urgent, bought))
            } while (result.moveToNext())
            db.close()
            return itemlist
        }
        return itemlist
    }
    fun deleteitems(id: Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "id=?", arrayOf(id.toString()))
        db.close()
    }
    fun updateitems(items: items){
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(IMG, items.img)
        contentValues.put(NAME, items.name)
        contentValues.put(DETAIL, items.detail)
        contentValues.put(QUANTITY, items.quantity)
        contentValues.put(SIZE, items.size)
        contentValues.put(URGENT, items.urgent)
        contentValues.put(BOUGHT, items.bought)

        db.update(TABLE_NAME, contentValues, "id=?", arrayOf(items.id.toString()))
        db.close()

    }

}