package com.dharmasun.data.local;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by brain on 10/10/17.
 */

@Singleton
public class LocalRepo {

    private AppPrefs prefs;

    @Inject
    public LocalRepo(AppPrefs prefs) {
        this.prefs = prefs;
    }
}
