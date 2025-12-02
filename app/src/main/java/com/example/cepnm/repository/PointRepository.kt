package com.example.cepnm.repository

import com.example.cepnm.data.Point
import com.example.cepnm.data.PointDao
import kotlinx.coroutines.flow.Flow

class PointRepository(private val dao: PointDao) {
    fun getAll(): Flow<List<Point>> = dao.getAll()
    suspend fun insert(point: Point): Long = dao.insert(point)
    suspend fun update(point: Point) = dao.update(point)
    suspend fun delete(point: Point) = dao.delete(point)
    suspend fun getById(id: Long): Point? = dao.getById(id)
}
