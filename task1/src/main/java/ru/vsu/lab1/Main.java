package ru.vsu.lab1;

import org.joda.time.LocalDate;
import ru.vsu.lab1.comparators.PersonIDComparator;
import ru.vsu.lab1.sorters.PersonBubbleSort;

public class Main {
    public static void main(String[] args) {
       PersonRepository repo = new PersonRepository();
       repo.add(new Person("sasha",44, LocalDate.now()));
       repo.add(new Person("pasha",24, LocalDate.now()));
       repo.sort(new PersonBubbleSort(),new PersonIDComparator());


    }
}
