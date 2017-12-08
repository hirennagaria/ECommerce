package com.hiren.ecommerce;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponet {

    void inject(MainActivity activity);
}
