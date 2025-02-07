package ml.vladmikh.projects.bankcard.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ml.vladmikh.projects.bankcard.data.local.dao.CardInfoDao
import ml.vladmikh.projects.bankcard.data.local.entities.CardInfoLocalDataSource

@Database(entities = [CardInfoLocalDataSource::class], version = 3, exportSchema = false)
abstract class CardDataBase: RoomDatabase() {

    abstract fun cardInfoDao(): CardInfoDao
}