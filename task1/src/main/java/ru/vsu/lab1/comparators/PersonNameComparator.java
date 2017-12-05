package ru.vsu.lab1.comparators;

import ru.vsu.lab1.Person;
import ru.vsu.lab1.PersonComparator;

public class PersonNameComparator implements PersonComparator {
    public int compare(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
}
