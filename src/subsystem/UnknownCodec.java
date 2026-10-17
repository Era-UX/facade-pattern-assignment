package subsystem;

public class UnknownCodec implements Codec {
    private final String originalType;

    public UnknownCodec(String originalType) {
        this.originalType = originalType;
    }

    @Override
    public String getType() {
        return originalType;
    }

    @Override
    public boolean isSupported() {
        return false;
    }
}