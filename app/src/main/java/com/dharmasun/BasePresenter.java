package com.dharmasun;

public interface BasePresenter {
    int LOADING = 1;
    int AVAILABLE = 2;
    int ERROR = 3;

    void start();
}