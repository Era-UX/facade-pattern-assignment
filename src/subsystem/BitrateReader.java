package subsystem;

public class BitrateReader {
    public static String read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file " + file.getName() + " using codec " + codec.getType() + "...");
        return "RAW_VIDEO_BUFFER[" + file.getName() + "]";
    }

    public static String convert(String buffer, Codec destinationCodec) {
        System.out.println("BitrateReader: writing file buffer to format " + destinationCodec.getType() + "...");
        return "CONVERTED_STREAM[" + buffer + " -> " + destinationCodec.getType() + "]";
    }
}