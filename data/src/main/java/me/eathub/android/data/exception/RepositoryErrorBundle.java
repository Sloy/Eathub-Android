package me.eathub.android.data.exception;

import me.eathub.android.domain.exception.ErrorBundle;

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override public Exception getException() {
        return exception;
    }

    @Override public String getErrorMessage() {
        String message = "Repository Error";
        if (this.exception != null) {
            message = this.exception.getMessage();
        }
        return message;
    }
}
