package com.example.xplore

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private val DATABASE_NAME = "MAPS_REPOSITORY"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "MAPS"
        private val ID = "id"
        private val IMG = "img"
        private val ADDRESS = "address"
        private  val LATITUDE = "latitude"
        private val LONGITUDE = "longitude"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $IMG TEXT, $ADDRESS TEXT, $LATITUDE DOUBLE, $LONGITUDE DOUBLE)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertItem(mapItems: MapItems){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(IMG, mapItems.img)
        contentValues.put(ADDRESS, mapItems.address)
        contentValues.put(LATITUDE, mapItems.latitude)
        contentValues.put(LONGITUDE, mapItems.longitude)


        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getallitems():ArrayList<MapItems>{
        var list: ArrayList<MapItems> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()){
            do {
                val id= result.getInt(result.getColumnIndex(ID).toInt())
                val img= result.getString(result.getColumnIndex(IMG).toInt())
                val address= result.getString(result.getColumnIndex(ADDRESS).toInt())
                val latitude= result.getDouble(result.getColumnIndex(LATITUDE).toInt())
                val longitude= result.getDouble(result.getColumnIndex(LONGITUDE).toInt())
                list.add(MapItems(id, img, address, latitude, longitude))
            } while (result.moveToNext())
            db.close()
            return list
        }
        return list
    }

    fun deleteitems(id: Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "id=?", arrayOf(id.toString()))
        db.close()
    }
}