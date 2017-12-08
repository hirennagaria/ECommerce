package com.hiren.ecommerce;

import android.app.Application;


public class MyApp extends Application {

    private NetComponet mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponet.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }

    public NetComponet getNetComponent(){
        return mNetComponent;
    }
}
