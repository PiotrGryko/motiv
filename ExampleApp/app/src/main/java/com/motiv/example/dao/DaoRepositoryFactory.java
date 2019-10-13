package com.motiv.example.dao;

import android.content.Context;
import android.os.Handler;
import androidx.room.*;
import java.util.*;
import java.util.concurrent.*;

public class DaoRepositoryFactory {

    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static long KEEP_ALIVE_TIME = 1;
    private static TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static BlockingQueue<Runnable> mDecodeWorkQueue = new LinkedBlockingQueue<Runnable>();
    private static DaoRepository daoRepository;
    private static DaoRepositoryFactory instance;

    private DaoRepositoryFactory(Context context) {
        Handler handler = new Handler();
        MyRoomDatabase myRoomDatabase =
                Room.databaseBuilder(context, MyRoomDatabase.class, MyRoomDatabase.DATABASE_NAME)
                        .build();
        Executor executor =
                new ThreadPoolExecutor(
                        NUMBER_OF_CORES,
                        NUMBER_OF_CORES,
                        KEEP_ALIVE_TIME,
                        KEEP_ALIVE_TIME_UNIT,
                        mDecodeWorkQueue);
        this.daoRepository = new DaoRepository(handler, myRoomDatabase, executor);
    }

    public static DaoRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DaoRepositoryFactory(context);
        }
        return instance.daoRepository;
    }
}
