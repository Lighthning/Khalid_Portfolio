package com.example.xplore

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.File
import java.util.*

private const val REQUEST_CODE = 42
private const val PERMISSION_ID = 2
private lateinit var picfile: File
private lateinit var fusedLocationClient: FusedLocationProviderClient
private const val FILE_NAME = "photo.jpg"
private var latitude:Double = 0.0
private var longitude:Double = 0.0
private var Addresstxt: String? = null

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var dbHelper = DBHelper(this)
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val launchcamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        picfile = getPhotoFile(FILE_NAME)
        val fileProvider = FileProvider.getUriForFile(this, "com.example.xplore.provider", picfile)
        launchcamera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        launchcamera.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
        startActivityForResult(launchcamera, REQUEST_CODE)
    }

    private fun getloc(context: Context): Boolean {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers: List<String> = locationManager.getProviders(true)
        var location: Location? = null
        for (i in providers.size - 1 downTo 0) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_ID)

                var locman: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                return locman.isProviderEnabled(LocationManager.GPS_PROVIDER) || locman.isProviderEnabled(
                    LocationManager.NETWORK_PROVIDER)
            }
            location= locationManager.getLastKnownLocation(providers[i])

            if (location != null)
                break
        }
        if (location != null) {
            latitude = location.latitude
            longitude = location.longitude

            addresscal()
        }
        return true
    }

    private fun addresscal(): Boolean {
        val geocoder = Geocoder(this, Locale.getDefault())
        var addresses = geocoder.getFromLocation(latitude, longitude,1)
        val addressfinal = addresses?.get(0)?.getAddressLine(0)
        Addresstxt = addressfinal.toString()
        return true
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory= getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName,System.currentTimeMillis().toString() +".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            getloc(this)

            val imgpath = picfile.absolutePath

            dbHelper.insertItem(MapItems(imgpath, Addresstxt.toString(), latitude, longitude))
            println(dbHelper.getallitems())
            supportFragmentManager.beginTransaction().replace(R.id.container, Maps()).commit()
            supportFragmentManager.beginTransaction().addToBackStack(null)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}