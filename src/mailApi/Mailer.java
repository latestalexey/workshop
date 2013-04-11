package mailApi;

import org.jetbrains.annotations.NotNull;

public interface Mailer {
    public void sendMessage(
            @NotNull String email,
            @NotNull String message
    );
}
