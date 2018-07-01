package com.example.ryne.companyview.view.activities.main.injection;

import com.example.ryne.companyview.view.activities.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rynel on 3/8/2018.
 */

@Module
public class MainModule {
    @Provides
    public MainPresenter mainPresenterProvides() {
        return new MainPresenter();
    }
}