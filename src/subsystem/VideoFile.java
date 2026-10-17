package subsystem;

import exception.VideoConversionException;

public class VideoFile {
    private final String name;
    private final String codecType;

    public VideoFile(String name) {
        if (name == null || name.isBlank() || !name.contains(".")) {
            throw new VideoConversionException(
                    "Operation failed: VideoFile initialization. Invalid file name provided: " + name
            );
        }
        this.name = name;
        this.codecType = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getCodecType() {
        return codecType;
    }
}