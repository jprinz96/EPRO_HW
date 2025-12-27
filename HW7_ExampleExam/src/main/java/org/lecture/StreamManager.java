package org.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StreamManager {
    private static Scanner scan = new Scanner(System.in);

    public static void menu() {
        System.out.printf("""
                ----------- Menu -----------
                1 - List all streamed Charts
                2 - Filter streams by genres
                3 - Display of streaming charts including counter, without duplicates and in ascending order
                4 - Filter streams by streaming-count
                5 - Save in new file
                0 - Exit
                """);
    }

    //Ausgabe aller Streams
    public static void printAllStreams(List<Stream> streams) {
        System.out.printf("----------- %-50All Streams -----------");
        for (Stream stream : streams) {
            System.out.println(stream);
        }

    }

    //User Abfrage nach Genre
    public static Genre askGenre() {
        System.out.print("Which genre should be searched for?:  ");
        String askedGenre = scan.nextLine().toUpperCase();
        return Genre.valueOf(askedGenre);

    }

    //Ausgabe der TreeMapp (Streaming-Charts)
    public static void listStreamingCharts(Map<Integer, Stream> streamingChart) {
        int ranking = streamingChart.size();

        for (Map.Entry<Integer, Stream> entry : streamingChart.entrySet()) {
            Stream stream = entry.getValue();
            System.out.printf("Nr.%d: %s - %s (Streaming-Counter: %d)%n", ranking, stream.getInterpret(), stream.getSong(), stream.getStreamCounter());
            ranking--;
        }

    }

    //Abfrage Mindest-Stream
    public static int askMinStream() {
        System.out.println("Please tell me the minimum streaming times you wish to filter?");
        int minStream = scan.nextInt();
        scan.nextLine();

        return minStream;

    }
}
