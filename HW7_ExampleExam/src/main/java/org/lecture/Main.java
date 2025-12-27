package org.lecture;

import org.lecture.file.StreamingFileReader;
import org.lecture.file.StreamingFileWriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static void main() {

        Scanner scan = new Scanner(System.in);
        //File einlesen
        StreamingFileReader fileReader = new StreamingFileReader();
        List<Stream> streams = fileReader.readSongsFromCSV("streaming.csv");
        StreamFilter streamFilter = new StreamFilter();
        List<Stream> filteredStreams;
        Genre choosenGenre;


        boolean temp = true;
        while (temp == true) {


            StreamManager.menu();
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> {
                    StreamManager.printAllStreams(streams);
                }
                case 2 -> {
                    choosenGenre = StreamManager.askGenre();
                    filteredStreams = streamFilter.filterByGenre(streams, choosenGenre);
                    for (Stream stream : filteredStreams) {
                        System.out.printf("----------- Genre: %s -----------%n", choosenGenre);
                        //Ausgabe ohne Genre wie in Angabe verlangt
                        System.out.println(stream.formatWithoutGenres());
                    }
                }
                case 3 -> {
                    choosenGenre = StreamManager.askGenre();
                    Map<Integer, Stream> streamingChart = StreamFilter.streamingChartsMap(streams, choosenGenre);
                    System.out.printf("----------- Streaming-Charts Genre: %s -----------%n", choosenGenre);
                    StreamManager.listStreamingCharts(streamingChart);
                }
                case 4 -> {
                    int minStream = StreamManager.askMinStream();
                    filteredStreams = streamFilter.filterByStreamingCount(streams, minStream);
                    for (Stream stream : filteredStreams) {
                        System.out.println(stream.formatMinStreaming());
                    }
                }
                case 5 -> {
                    choosenGenre = StreamManager.askGenre();
                    StreamingFileWriter fileWriter = new StreamingFileWriter();
                    try {
                        fileWriter.writeGenreFile(choosenGenre, streams);
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                }
                case 0 -> {
                    temp = false;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }


}
