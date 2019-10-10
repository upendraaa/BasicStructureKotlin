package interview.upendra.com.basicstructurekotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class LocationActivity : AppCompatActivity() {

    val LOCATION_CODE = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
    }

    fun checkLocationPermission(): Unit {

        if (Build.VERSION.SDK_INT > 23) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) !=
                PackageManager.PERMISSION_GRANTED
            ) {

                requestPermissions(
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_CODE
                )
                return;

            }
        }

    }

    @SuppressLint("MissingPermission")
    fun getLocation() {

        var customLocationListener = CustomLocationListener();
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3,
            3f,
            customLocationListener
        )


    }

    var location: Location? = null;

    inner class CustomLocationListener : LocationListener {

        constructor() : super() {
            location = Location("me")
            location!!.latitude = 0.0
            location!!.longitude = 0.0


        }

        override fun onLocationChanged(currentLocation: Location?) {
            location = currentLocation;

        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }

    }
}
