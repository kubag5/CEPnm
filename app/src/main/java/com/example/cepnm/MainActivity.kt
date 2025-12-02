package com.example.cepnm

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cepnm.data.Point
import com.example.cepnm.ui.AddEditPointActivity
import com.example.cepnm.ui.PointDetailActivity
import com.example.cepnm.viewmodel.PointViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.MapEventsOverlay

class MainActivity : AppCompatActivity() {

    private lateinit var map: MapView
    private val viewModel: PointViewModel by viewModels()

    companion object {
        val WARSAW = GeoPoint(52.2297, 21.0122)
        const val EXTRA_POINT_ID = "point_id"
        const val EXTRA_LAT = "lat"
        const val EXTRA_LON = "lon"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // osmdroid config - use app user agent
        Configuration.getInstance().userAgentValue = packageName

        setContentView(R.layout.activity_main)
        map = findViewById(R.id.map)

        // basic map setup
        map.setMultiTouchControls(true)
        val controller = map.controller
        controller.setZoom(12.0)
        controller.setCenter(WARSAW)

        // Overlay to catch long-press
        val receiver = object : MapEventsReceiver {
            override fun longPressHelper(p: GeoPoint): Boolean {
                // p nie jest nullable w sygnaturze, więc używaj go bez '?'
                val intent = Intent(this@MainActivity, AddEditPointActivity::class.java)
                intent.putExtra(EXTRA_LAT, p.latitude)
                intent.putExtra(EXTRA_LON, p.longitude)
                startActivity(intent)
                return true // true -> event "skonsumowany"
            }

            override fun singleTapConfirmedHelper(p: GeoPoint): Boolean {
                // zwróć true jeśli chcesz "przechwycić" kliknięcie
                return false
            }
        }

        map.overlays.add(MapEventsOverlay(receiver))

        // FAB for adding at center of map
        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
            val center = map.mapCenter as GeoPoint
            val intent = Intent(this, AddEditPointActivity::class.java)
            intent.putExtra(EXTRA_LAT, center.latitude)
            intent.putExtra(EXTRA_LON, center.longitude)
            startActivity(intent)
        }

        // observe points and draw markers
        viewModel.points.observe(this) { list ->
            refreshMarkers(list)
        }
    }

    private fun refreshMarkers(points: List<Point>) {
        // remove all marker overlays first (but keep MapEventsOverlay at index 0 maybe)
        val overlaysToRemove = map.overlays.filterIsInstance<Marker>()
        overlaysToRemove.forEach { map.overlays.remove(it) }

        points.forEach { p ->
            val marker = Marker(map)
            marker.position = GeoPoint(p.lat, p.lon)
            marker.title = p.title
            marker.subDescription = p.description
            marker.setOnMarkerClickListener { _, _ ->
                val intent = Intent(this, PointDetailActivity::class.java)
                intent.putExtra(EXTRA_POINT_ID, p.id)
                startActivity(intent)
                true
            }
            map.overlays.add(marker)
        }

        // refresh map view
        map.invalidate()
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
