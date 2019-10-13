 
package com.motiv.example.dao
import android.content.Context
import android.os.Handler
import androidx.room.*
import java.util.*
import java.util.concurrent.*

public class DaoRepositoryFactory {

    private var NUMBER_OF_CORES: Int = Runtime.getRuntime().availableProcessors()
    private var KEEP_ALIVE_TIME: Long = 1
    private var KEEP_ALIVE_TIME_UNIT: TimeUnit = TimeUnit.SECONDS
    private var mDecodeWorkQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()

    private var daoRepository: DaoRepository

    constructor(context: Context) {
        val handler = Handler()
        val myRoomDatabase = Room.databaseBuilder(context, MyRoomDatabase::class.java, MyRoomDatabase.DATABASE_NAME).build()
        val executor = ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mDecodeWorkQueue)
        this.daoRepository = DaoRepository(handler, myRoomDatabase, executor)
    }

    companion object {
        @Volatile private var INSTANCE: DaoRepository? = null
        fun getInstance(context: Context): DaoRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(context).also { INSTANCE = it }
            }
        private fun buildInstance(context: Context) = DaoRepositoryFactory(context).daoRepository
    }
}
