package facade;

import exception.VideoConversionException;
import subsystem.*;
import java.io.File;

public class VideoConversionFacade {
    private final CodecFactory codecFactory;
    private final AudioMixer audioMixer;

    public VideoConversionFacade() {
        this.codecFactory = new CodecFactory();
        this.audioMixer = new AudioMixer();
    }

    public File convertVideo(String fileName, String targetFormat) {
        validateInputs(fileName, targetFormat);

        try {
            System.out.println("VideoConversionFacade: conversion started.");
            VideoFile file = new VideoFile(fileName);
            Codec sourceCodec = codecFactory.extract(file);

            Codec destinationCodec = resolveDestinationCodec(targetFormat);
            if (!destinationCodec.isSupported()) {
                throw new VideoConversionException(
                        "Operation failed: Target format resolution. Unsupported target format: " + targetFormat
                );
            }

            String buffer = BitrateReader.read(file, sourceCodec);
            String convertedData = BitrateReader.convert(buffer, destinationCodec);

            String baseName = fileName.substring(0, fileName.lastIndexOf("."));
            String outputFileName = baseName + "." + destinationCodec.getType();

            File result = audioMixer.fix(convertedData, outputFileName);
            System.out.println("VideoConversionFacade: conversion completed successfully -> " + result.getName());
            return result;
        } catch (VideoConversionException e) {
            throw e;
        } catch (Exception e) {
            throw new VideoConversionException(
                    "Operation failed: Video conversion for file '" + fileName + "' to format '" + targetFormat + "'", e
            );
        }
    }

    private Codec resolveDestinationCodec(String format) {
        String normalized = format.toLowerCase().trim();
        if ("mp4".equals(normalized)) {
            return new MPEG4CompressionCodec();
        } else if ("ogg".equals(normalized)) {
            return new OggCompressionCodec();
        }
        return new UnknownCodec(normalized);
    }

    private void validateInputs(String fileName, String targetFormat) {
        if (fileName == null || targetFormat == null || fileName.isBlank() || targetFormat.isBlank()) {
            throw new VideoConversionException(
                    "Operation failed: Input validation. FileName and targetFormat must not be null or empty."
            );
        }
    }
}