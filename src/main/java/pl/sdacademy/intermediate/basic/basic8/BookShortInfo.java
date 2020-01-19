package pl.sdacademy.intermediate.basic.basic8;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class BookShortInfo {
    String title;
    String author;
    int yearPushlished;
}
