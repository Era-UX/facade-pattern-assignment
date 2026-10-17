package subsystem;

public class OggCompressionCodec implements Codec {
    @Override
    public String getType() {
        return "ogg";
    }

    @Override
    public boolean isSupported() {
        return true;
    }
}