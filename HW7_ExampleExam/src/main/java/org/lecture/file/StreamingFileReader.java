package org.lecture.file;

import org.lecture.Genre;
import org.lecture.Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StreamingFileReader {

    public List<Stream> readSongsFromCSV(String filename) { //Methode anlegen mit Übergabe der Klasse als Liste
        List<Stream> streams = new ArrayList<>();
        Path path = Paths.get("src", "main", "resources", filename); //Pfad für das CSV File erstellen

        if (Files.notExists(path)) { //Fehlermeldung wenn der Pfad nicht korrekt sein sollte
            System.out.println("File does not exists: " + path.toAbsolutePath());
        }
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine(); //überspringt 1. Zeile
            while ((line = br.readLine()) != null){ //solange das Einlesen nicht null ist weiter Zeilen einlesen
                String[] values = line.split(";"); //Trennzeichen im CSV File angeben

                //Genre;Trackid;Interpret;Album;Song;Stream-Counter
                Genre genre = Genre.valueOf(values[0].toUpperCase());
                int id = Integer.parseInt(values[1]);
                String interpret = values[2];
                String album = values[3];
                String song = values[4];
                int streamCount = Integer.parseInt(values[5]);
                //Instanz von Klasse Song erstellen
                Stream stream = new Stream(genre, id, interpret, album, song, streamCount);
                streams.add(stream);
            }

        } catch (IOException e) {
            System.out.println("Error reading File: " + e.getMessage());
        }


        return streams;
    }


}
