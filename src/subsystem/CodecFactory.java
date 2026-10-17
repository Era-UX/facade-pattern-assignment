package subsystem;

public class CodecFactory {
    public Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if ("mp4".equals(type)) {
            System.out.println("CodecFactory: extracting mpeg4 audio/video...");
            return new MPEG4CompressionCodec();
        } else if ("ogg".equals(type)) {
            System.out.println("CodecFactory: extracting ogg audio/video...");
            return new OggCompressionCodec();
        }
        System.out.println("CodecFactory: unknown codec type (" + type + "), using fallback special case...");
        return new UnknownCodec(type);
    }
}