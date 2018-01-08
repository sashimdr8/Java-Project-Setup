package com.dharmasun.data.remote;

import com.google.gson.Gson;

/**
 * Created by brain on 10/10/17.
 */

@SuppressWarnings("unchecked")
public class RemoteRepo {
    private Api api;
    private Gson gson;

    public RemoteRepo(Api api,
                      Gson gson) {
        this.api = api;
        this.gson = gson;
    }
}
