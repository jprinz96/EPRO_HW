package org.lecture.file;

import org.lecture.Genre;
import org.lecture.Stream;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StreamingFileWriter {
    public void writeGenreFile(Genre genre, List<Stream> streams) throws IOException {
        Path p = Paths.get("src/main/resources/exam/" + genre + "/songs.txt");

        if (Files.notExists(p.getParent())) {
            Files.createDirectories(p.getParent());
        }
        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            for (Stream stream : streams) {
                if (stream.getGenre() == genre) {
                    writeToBW(stream, bw);
                }
            }
        }
        System.out.println("Genre file written: " + genre);
    }

    private static void writeToBW(Stream stream, BufferedWriter bw) throws IOException {
        boolean highlight = stream.getStreamCounter() >= 50;

        if (highlight) bw.write("<strong>\n");

        bw.write(String.format("Artist: %s%n", stream.getInterpret()));
        bw.write(String.format("Album: %s%n", stream.getAlbum()));
        bw.write(String.format("\tSong# %02d%n", stream.getTrackID()));          // 2-stellig
        bw.write(String.format("\t\tSong: %s%n", stream.getSong()));
        bw.write(String.format("Stream-Counter:%02d%n", stream.getStreamCounter())); // 2-stellig

        if (highlight) bw.write("<strong>\n");

        bw.newLine();
        bw.newLine();
    }
}
