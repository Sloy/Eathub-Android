package me.eathub.android.domain.executor;

public interface AsyncExecutor {

    void execute(final Runnable runnable);
}
