package com.motiv.example;

import android.content.Context;
import com.motiv.example.dao.DaoRepository;
import io.realm.*;

public class DaoRepositoryFactory {

    private static DaoRepository daoRepository;
    private static DaoRepositoryFactory instance;

    private DaoRepositoryFactory(Context context) {

        this.daoRepository = new DaoRepository(Realm.getDefaultInstance());
    }

    public static DaoRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DaoRepositoryFactory(context);
        }
        return instance.daoRepository;
    }
}
