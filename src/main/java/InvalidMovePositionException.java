public class InvalidMovePositionException extends RuntimeException {
    public InvalidMovePositionException() {
        super();
    }

    public InvalidMovePositionException(String message) {
        super(message);
    }

    public InvalidMovePositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMovePositionException(Throwable cause) {
        super(cause);
    }
}
