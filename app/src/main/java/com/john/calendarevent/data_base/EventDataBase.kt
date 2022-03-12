package com.john.calendarevent.data_base

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.john.calendarevent.data.Data
import com.john.calendarevent.model.Event
import io.reactivex.Completable
import io.reactivex.Single

@Database(entities = [Event::class], version = 1)
abstract  class EventDataBase : RoomDatabase(){
    abstract fun getEventsDAO(): EventsDAO
}
@Dao
interface EventsDAO{
    @Insert(onConflict = REPLACE)
    fun insertEvent(event: Event): Completable

    @Query("SELECT * FROM event WHERE id IN (:evenId)")
    fun getEventById(evenId: String): Single<Event>
    @Query("SELECT * FROM event")
    fun getAllItem(): Single<Data>

    @Delete
    fun deleteEvent(event: Event): Completable
}