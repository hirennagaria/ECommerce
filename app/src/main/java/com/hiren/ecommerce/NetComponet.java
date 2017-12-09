package com.hiren.ecommerce;

import com.hiren.ecommerce.Modules.AppModule;
import com.hiren.ecommerce.Modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponet {

    void inject(MainActivity activity);
}
