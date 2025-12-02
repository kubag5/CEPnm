package pl.kubag5.cepnm.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PointDao {
    @Query("SELECT * FROM points")
    fun getAll(): Flow<List<Point>>

    @Query("SELECT * FROM points WHERE id = :id")
    suspend fun getById(id: Long): Point?

    @Insert
    suspend fun insert(point: Point): Long

    @Update
    suspend fun update(point: Point)

    @Delete
    suspend fun delete(point: Point)
}
