package subsystem;

public class MPEG4CompressionCodec implements Codec {
    @Override
    public String getType() {
        return "mp4";
    }

    @Override
    public boolean isSupported() {
        return true;
    }
}