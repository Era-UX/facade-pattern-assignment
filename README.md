# Assignment #4 — Facade Design Pattern (Media/Video Conversion)

## Overview
This project implements the **Facade Design Pattern** (Option A: Media/Video Conversion Facade) in Java 17. It demonstrates how a single facade class (VideoConversionFacade) simplifies interaction with a complex multi-class video processing subsystem while adhering to Clean Code principles from Chapters 7, 8, and 9 of Robert C. Martin's *Clean Code*.

## Project Structure
- Main — Client class interacting solely with the Facade.
- facade.VideoConversionFacade — Facade providing a unified convertVideo(fileName, targetFormat) API.
- subsystem.* — Independent subsystem classes (VideoFile, CodecFactory, BitrateReader, AudioMixer, Codec implementations).
- exception.VideoConversionException — Custom unchecked exception providing rich error context.
- VideoConversionFacadeTest — Clean JUnit 5 unit tests following F.I.R.S.T. and Given-When-Then conventions.

## How to Run
1. Open the project in **IntelliJ IDEA** (JDK 17).
2. Run Main.java to see the console output of the Facade coordinating the subsystem.
3. Run VideoConversionFacadeTest.java to execute the unit test suite.