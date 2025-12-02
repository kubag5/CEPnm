package pl.kubag5.cepnm.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import pl.kubag5.cepnm.MainActivity
import pl.kubag5.cepnm.R
import pl.kubag5.cepnm.data.Point
import pl.kubag5.cepnm.viewmodel.PointViewModel
import kotlinx.coroutines.launch

class PointDetailActivity : AppCompatActivity() {

    private val viewModel: PointViewModel by viewModels()
    private var currentPoint: Point? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_detail)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvDesc = findViewById<TextView>(R.id.tvDescription)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        val id = intent.getLongExtra(MainActivity.EXTRA_POINT_ID, -1L)
        if (id == -1L) {
            finish()
            return
        }

        lifecycleScope.launch {
            val p = viewModel.getById(id)
            currentPoint = p
            p?.let {
                tvTitle.text = it.title
                tvDesc.text = it.description
            }
        }

        btnEdit.setOnClickListener {
            currentPoint?.let {
                val intent = Intent(this, AddEditPointActivity::class.java)
                intent.putExtra("edit_id", it.id)
                intent.putExtra(MainActivity.EXTRA_LAT, it.lat)
                intent.putExtra(MainActivity.EXTRA_LON, it.lon)
                startActivity(intent)
                finish()
            }
        }

        btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Usuń punkt")
                .setMessage("Czy na pewno chcesz usunąć ten punkt?")
                .setPositiveButton("Usuń") { _, _ ->
                    currentPoint?.let { p ->
                        viewModel.delete(p) {
                            finish()
                        }
                    }
                }
                .setNegativeButton("Anuluj", null)
                .show()
        }
    }
}
