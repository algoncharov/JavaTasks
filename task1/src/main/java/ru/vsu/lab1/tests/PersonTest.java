package ru.vsu.lab1.tests;

import org.joda.time.LocalDate;
import org.junit.Test;
import ru.vsu.lab1.Person;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void showAge() {
        LocalDate d = LocalDate.now();
        Person p = new Person("Pasha",10, LocalDate.now().plusYears(15));
        assertEquals(p.showAge(),15);

    }

    @Test
    public void getName() {
        Person p = new Person("Pasha",10, LocalDate.now());
        assertEquals(p.getName(),"Pasha");
    }

    @Test
    public void setName() {
        Person p = new Person("Pasha",10, LocalDate.now());
        p.setName("Petya");
        assertEquals(p.getName(),"Petya");
    }

    @Test
    public void getId() {
        Person p = new Person("Pasha",10, LocalDate.now());
        assertEquals((int)p.getId(),10);
    }

    @Test
    public void setId() {
        Person p = new Person("Pasha",10, LocalDate.now());
        p.setId(20);
        assertEquals((int)p.getId(),20);
    }

    @Test
    public void getBirthDate() {
        LocalDate d = LocalDate.now();
        Person p = new Person("Pasha",10, LocalDate.now());
        p.setBirthDate(d);
        assertEquals(p.getBirthDate(),d);
    }
}