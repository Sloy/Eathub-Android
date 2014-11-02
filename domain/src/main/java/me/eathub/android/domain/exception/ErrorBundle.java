package me.eathub.android.domain.exception;

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
