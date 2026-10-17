package subsystem;

import java.io.File;

public class AudioMixer {
    public File fix(String convertedVideoData, String outputFileName) {
        System.out.println("AudioMixer: fixing audio tracks for " + convertedVideoData + "...");
        return new File(outputFileName);
    }
}