package com.example.cepnm.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cepnm.MainActivity
import com.example.cepnm.R
import com.example.cepnm.data.Point
import com.example.cepnm.viewmodel.PointViewModel
import kotlinx.coroutines.launch

class AddEditPointActivity : AppCompatActivity() {

    private val viewModel: PointViewModel by viewModels()
    private var editingId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_point)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDesc = findViewById<EditText>(R.id.etDescription)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val lat = intent.getDoubleExtra(MainActivity.EXTRA_LAT, MainActivity.WARSAW.latitude)
        val lon = intent.getDoubleExtra(MainActivity.EXTRA_LON, MainActivity.WARSAW.longitude)

        // If an id is passed, we are editing (not used in our current flow, but supported)
        editingId = intent.getLongExtra("edit_id", -1L).takeIf { it != -1L }

        if (editingId != null) {
            lifecycleScope.launch {
                val p = viewModel.getById(editingId!!)
                p?.let {
                    etTitle.setText(it.title)
                    etDesc.setText(it.description)
                }
            }
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim().ifEmpty { "Bez tytułu" }
            val desc = etDesc.text.toString().trim()
            if (editingId != null) {
                lifecycleScope.launch {
                    val p = Point(id = editingId!!, title = title, description = desc, lat = lat, lon = lon)
                    viewModel.update(p)
                    finish()
                }
            } else {
                val newPoint = Point(title = title, description = desc, lat = lat, lon = lon)
                viewModel.insert(newPoint) { _ ->
                    finish()
                }
            }
        }
    }
}
