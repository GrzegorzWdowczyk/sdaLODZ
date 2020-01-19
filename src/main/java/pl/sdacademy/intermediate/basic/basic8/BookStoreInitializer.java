package pl.sdacademy.intermediate.basic.basic8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStoreInitializer {

    static void initBookStore()  {
        List<Book> books = new ArrayList<>();
        String linkFile = "C:\\Users\\grzegorz.wdowczyk\\IdeaProjects\\Programowanie2\\src\\main\\resources\\books.txt";

        try (
                FileReader reader = new FileReader(linkFile);
                BufferedReader bookFile = new BufferedReader(reader)) {
            String line = bookFile.readLine();
            while (line != null) {
                String[] splitLine = line.split("\\|");
                String title = splitLine[0];
                String author = splitLine[1];
                int yearPushlished = Integer.valueOf(splitLine[2]);
                int numberOfPages = Integer.valueOf(splitLine[3]);
                double price = Double.valueOf(splitLine[4]);
                Genre genre = Genre.valueOf(splitLine[5]);
                Book book = Book.builder()
                        .title(title)
                        .author(author)
                        .yearPushlished(yearPushlished)
                        .numberOfPages(numberOfPages)
                        .price(price)
                        .genre(genre)
                        .build();
                System.out.println(book);
                line = bookFile.readLine();
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
