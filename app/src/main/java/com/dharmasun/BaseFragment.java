package com.dharmasun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import com.dharmasun.data.AppData;

import javax.inject.Inject;

import rx.Subscription;

public abstract class BaseFragment extends Fragment {

  /*  @Inject
    protected RxBus bus;*/

    @Inject
    protected AppData data;

    protected Subscription eventSubscription;
    private boolean subscribeToEvents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       App.component(getActivity()).inject(this);
    }


    @Override
    public void onResume() {
        super.onResume();
  /*      if (this.subscribeToEvents)
            eventSubscription = bus.toObserverable().subscribe(this::onEvent);*/
    }

    @Override
    public void onPause() {
    /*    if (eventSubscription != null && !eventSubscription.isUnsubscribed()) {
            eventSubscription.unsubscribe();
        }*/
        super.onPause();
    }

    public boolean consumedBackPress() {
        return false;
    }

    public void onEvent(Object event) {
    }

    protected void subscribeToEvents() {
        this.subscribeToEvents = true;
    }

  /*  public void onTokenExpired() {
        if (isAdded())
            handleTokenExpired(getActivity());
    }*/
}
