package com.dharmasun;

import com.dharmasun.data.AppData;
import com.dharmasun.utils.TypeFaceProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by brain on 1/8/18.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    TypeFaceProvider getTypefaceProvider();

    void inject(BaseActivity baseActivity);

    void inject(BaseFragment baseFragment);

    AppData provideData();
}
