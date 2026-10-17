import facade.VideoConversionFacade;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("funny_cats_video.ogg", "mp4");
        System.out.println("Client received final file: " + mp4Video.getName());
    }
}