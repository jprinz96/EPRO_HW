package org.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StreamFilter {

    //Filter nach Genre
    public List<Stream> filterByGenre(List<Stream> streams, Genre genre) {
        List<Stream> filteredStreamsByGenre = new ArrayList<>();
        for (Stream stream : streams) {
            if (stream.getGenre() == genre) {
                filteredStreamsByGenre.add(stream);
            }
        }

        return filteredStreamsByGenre;
    }

    //TreeMap fpr die Streaming-Charts in aufsteigender Reihenfolge und ohne Doppelte
    public static Map<Integer, Stream> streamingChartsMap(List<Stream> streams, Genre genre) {
        Map<Integer, Stream> charts = new TreeMap<>();

        for (Stream stream : streams) {
            if (stream.getGenre() != genre)
                continue; //Genre-Filter (wenn der Ausgewählte Filter ich dem Genre entspricht -> continue)

            int counter = stream.getStreamCounter();

            if (charts.containsKey(counter)) {
                Stream kept = charts.get(counter);
                System.out.printf("Skipped: %s - %s ... because %s - %s was added first. (Nr.%d)%n",
                        stream.getInterpret(), stream.getSong(), kept.getInterpret(), kept.getSong(), counter);
                continue;
            }
            charts.put(counter, stream);
        }
        return charts;
    }

    //Aufgabe Abfrage Mindest-Stream
    public List<Stream> filterByStreamingCount(List<Stream> streams, int minStream) {
        List<Stream> filteredListByStreamingCount = new ArrayList<>();
        for (Stream stream : streams) {
            if (stream.getStreamCounter() >= minStream) {
                filteredListByStreamingCount.add(stream);
            }
        }
        return filteredListByStreamingCount;

    }


}
