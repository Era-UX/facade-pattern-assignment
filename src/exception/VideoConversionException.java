package exception;

public class VideoConversionException extends RuntimeException {
    public VideoConversionException(String message) {
        super(message);
    }

    public VideoConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}