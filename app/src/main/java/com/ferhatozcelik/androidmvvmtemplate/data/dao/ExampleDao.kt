package com.ferhatozcelik.androidmvvmtemplate.data.dao

import androidx.room.*
import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity

@Dao interface ExampleDao {

    @Query("SELECT * FROM example_table")
    fun getExampleData(): List<ExampleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(search: ExampleEntity?)

    @Update
    suspend fun update(search: ExampleEntity)

    @Delete
    suspend fun delete(search: ExampleEntity)
    
}
