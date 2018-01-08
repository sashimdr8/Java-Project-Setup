package com.dharmasun.utils.rx;

import android.os.Looper;

import rx.Subscription;

public final class Preconditions {
    public static void checkArgument(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    public static void checkUiThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException(
                    "Must be called from the main thread. Was: " + Thread.currentThread());
        }
    }

    public static void unsubscribe(Subscription... subscriptions) {
        if (subscriptions != null)
            for (int i = 0; i < subscriptions.length; i++) {
                Subscription subscription = subscriptions[i];
                if (subscription != null && !subscription.isUnsubscribed())
                    subscription.unsubscribe();
            }
    }

    private Preconditions() {
        throw new AssertionError("No instances.");
    }
}