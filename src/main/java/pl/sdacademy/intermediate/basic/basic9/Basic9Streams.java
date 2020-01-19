package pl.sdacademy.intermediate.basic.basic9;

import pl.sdacademy.intermediate.basic.basic2.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Basic9Streams {
    public static void main(String[] args) {
        Stream<String> namesStream = Stream.of("John", "Marry", "George", "Paul", "Alice", "Ann");

        namesStream
                .map(String::toUpperCase)
                .filter(e -> e.contains("A"))
                .sorted(Comparator.reverseOrder())
                .filter(e -> e.endsWith("N"))
                .forEach(e -> System.out.println(e));

        System.out.println("----------------------------------------------------------------------");

        List<String> namesList = Arrays.asList("John", "Marry", "George", "Paul", "Alice", "Ann");

        namesList
                .stream()
                .filter(e -> e.endsWith("n"))
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");

        List<String> namesListF = Arrays.asList("John", "Marry", "George", "Paul", "Alice", "Ann");

        namesListF
                .stream()
                .filter(name -> name.startsWith("Jo"))
                .forEach(System.out::println);


        Person person1 = new Person("Piotr", "Zietek", "Zgierz", 28, 793522944);
        Person person2 = new Person("Adam", "Malysz", "Wisla", 42, 123456789);
        Person person3 = new Person("Kasia", "Kowalska", "Warszawa", 14, 111222333);

        List<Person> allPersons = Arrays.asList(person1, person2, person3);
        System.out.println("----------------------------------------------------------------------");
        allPersons
                .stream()
                .filter(e -> e.getAge() > 18)
                .map(e -> e.getPlaceOfBirth())
                .forEach(e -> System.out.println("Osoba zamieszkała: " + e + " jest pełnoletnia"));

        System.out.println("----------------------------------------------------------------------");

        List<Person> allPersonsTwo = Arrays.asList(person1, person2, person3);
        allPersonsTwo
                .stream()
                .skip(2)
                .forEach(e -> System.out.println("Osoba trzecia na liście to: " + e.getName()));

        System.out.println("----------------------------------------------------------------------");

        List<Person> allPersonsTr = Arrays.asList(person1, person2, person3);
        System.out.println("Dwie pierwsze osoby to: " );
        allPersonsTr
                .stream()
                .limit(2)
                .forEach(e -> System.out.println(e.getName()));

        System.out.println("----------------------------------------------------------------------");

        List<Person> allPersonsFr = Arrays.asList(person1, person2, person3);
        System.out.println("Alfabetycznie odwrotnie: " );
        allPersonsFr
                .stream()
                .map(Person::getName)
                .sorted(Comparator.reverseOrder())
                .forEach(e -> System.out.println(e));

        System.out.println("----------------------------------------------------------------------");

        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(4, 5, 6);
        List<Integer> thirdList = Arrays.asList(7, 8, 9);

        Stream<List<Integer>> streamOfListsS = Stream.of(firstList, secondList, thirdList);

        streamOfListsS
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("--------------------------KONIEC-----------------------------------");

    }

}
