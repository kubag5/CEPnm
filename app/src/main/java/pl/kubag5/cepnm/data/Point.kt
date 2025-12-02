package pl.kubag5.cepnm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "points")
data class Point(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val lat: Double,
    val lon: Double,
    val createdAt: Long = System.currentTimeMillis()
)
