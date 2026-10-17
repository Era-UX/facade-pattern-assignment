import exception.VideoConversionException;
import facade.VideoConversionFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class VideoConversionFacadeTest {

    private VideoConversionFacade converter;

    @BeforeEach
    void setUp() {
        converter = new VideoConversionFacade();
    }

    @Test
    void givenOggVideo_whenConvertedToMp4_thenReturnsMp4File() {
        File convertedFile = whenVideoIsConverted("presentation.ogg", "mp4");
        thenFileHasExpectedName(convertedFile, "presentation.mp4");
    }

    @Test
    void givenMp4Video_whenConvertedToOgg_thenReturnsOggFile() {
        File convertedFile = whenVideoIsConverted("lecture_recording.mp4", "ogg");
        thenFileHasExpectedName(convertedFile, "lecture_recording.ogg");
    }

    @Test
    void givenUnsupportedTargetFormat_whenConverted_thenThrowsVideoConversionException() {
        assertThrows(
                VideoConversionException.class,
                () -> whenVideoIsConverted("video.ogg", "avi")
        );
    }

    @Test
    void givenNullFileName_whenConverted_thenThrowsVideoConversionException() {
        assertThrows(
                VideoConversionException.class,
                () -> whenVideoIsConverted(null, "mp4")
        );
    }

    // Domain-Specific Testing Language (Chapter 9)
    private File whenVideoIsConverted(String sourceFile, String targetFormat) {
        return converter.convertVideo(sourceFile, targetFormat);
    }

    private void thenFileHasExpectedName(File resultFile, String expectedName) {
        assertNotNull(resultFile);
        assertEquals(expectedName, resultFile.getName());
    }
}