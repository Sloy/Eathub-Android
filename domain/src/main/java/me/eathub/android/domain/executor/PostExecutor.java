package me.eathub.android.domain.executor;

public interface PostExecutor {

    void post(Runnable runnable);
}
