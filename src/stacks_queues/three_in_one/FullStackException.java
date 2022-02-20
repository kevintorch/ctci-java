package stacks_queues.three_in_one;

import java.io.Serial;

public class FullStackException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public FullStackException() {
    }

    public FullStackException(String message) {
        super(message);
    }
}
