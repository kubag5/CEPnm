package com.example.cepnm.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.cepnm.data.AppDatabase
import com.example.cepnm.data.Point
import com.example.cepnm.repository.PointRepository
import kotlinx.coroutines.launch

class PointViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: PointRepository

    val points: LiveData<List<Point>>

    init {
        val dao = AppDatabase.getInstance(application).pointDao()
        repo = PointRepository(dao)
        points = repo.getAll().asLiveData()
    }

    fun insert(point: Point, onComplete: ((Long) -> Unit)? = null) {
        viewModelScope.launch {
            val id = repo.insert(point)
            onComplete?.invoke(id)
        }
    }

    fun update(point: Point) {
        viewModelScope.launch { repo.update(point) }
    }

    fun delete(point: Point, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch {
            repo.delete(point)
            onComplete?.invoke()
        }
    }

    suspend fun getById(id: Long): Point? {
        return repo.getById(id)
    }
}
