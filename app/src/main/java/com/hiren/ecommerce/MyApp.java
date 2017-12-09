package com.hiren.ecommerce;

import android.app.Application;

import com.hiren.ecommerce.Modules.AppModule;
import com.hiren.ecommerce.Modules.NetModule;
import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;


public class MyApp extends Application {

    private NetComponet mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(FlowConfig.builder(this)
                .addDatabaseConfig(DatabaseConfig.builder(ProductDatabase.class)
                        .databaseName("MyDataBase")
                        .build())
                .build());

        mNetComponent = DaggerNetComponet.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }

    public NetComponet getNetComponent(){
        return mNetComponent;
    }
}
