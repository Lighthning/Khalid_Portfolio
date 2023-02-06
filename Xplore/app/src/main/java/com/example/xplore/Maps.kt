package com.example.xplore

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.ArrayList

class Maps : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    private var items = ArrayList<MapItems>()

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var addresstxt: TextView
    private lateinit var imgview: ImageView
    private lateinit var locbtn:View
    private lateinit var cambtn:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_maps, container, false)
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        addresstxt = view.findViewById(R.id.textViewAddress)
        imgview = view.findViewById(R.id.imageViewAddress)
        locbtn = view.findViewById(R.id.floatingActionloc)
        cambtn = view.findViewById(R.id.floatingActionButtoncam)

        cambtn.setOnClickListener(){
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }


    override fun onMapReady(gmap: GoogleMap) {
        googleMap = gmap
        val dbHelper = context?.let { DBHelper(it) }
        items = dbHelper!!.getallitems()
        googleMap.setOnMarkerClickListener(this)

        for (a in items){
            val latlng = LatLng(a.latitude, a.longitude)
            googleMap.addMarker(MarkerOptions().position(latlng).title(a.id.toString()))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10f))
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        val dbHelper = context?.let { DBHelper(it) }
        items = dbHelper!!.getallitems()
        val m = marker.id.substringAfter("m")
        val idmarker = m.toInt() + 1
        for (a in items){
            println(a.id)
            println(idmarker)
            if (a.id.toString() == idmarker.toString()){
                val img = BitmapFactory.decodeFile(a.img)
                addresstxt.text = a.address
                imgview.setImageBitmap(img)
                return false
            }
        }
        return false
    }
}