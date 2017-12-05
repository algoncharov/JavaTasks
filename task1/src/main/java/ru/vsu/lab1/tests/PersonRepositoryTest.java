package ru.vsu.lab1.tests;

import org.joda.time.LocalDate;
import org.junit.Test;
import ru.vsu.lab1.Person;
import ru.vsu.lab1.PersonRepository;
import ru.vsu.lab1.comparators.PersonIDComparator;
import ru.vsu.lab1.searchers.PersonSequentialSearch;
import ru.vsu.lab1.searchtests.NameIsPashaAndIDIs10Test;
import ru.vsu.lab1.sorters.PersonBubbleSort;

import static org.junit.Assert.*;

public class PersonRepositoryTest {

    @Test
    public void toArray() {
        Person[] testarr = new Person[5];
        PersonRepository testrep = new PersonRepository();
        for (int i = 0; i < 5; i++) {
            testarr[i] = new Person("test" + i,i, LocalDate.now());
            testrep.add(testarr[i]);
        }
        assertArrayEquals(testarr,testrep.toArray());
    }

    @Test
    public void getLength() {
        PersonRepository testrep = new PersonRepository();
        for (int i = 0; i < 5; i++) {
            testrep.add(new Person("test" + i,i, LocalDate.now()));
        }
        assertEquals(testrep.getLength(),5);
    }

    @Test
    public void get() throws Exception {
        PersonRepository testrep = new PersonRepository();
        Person t = new Person("test" ,1, LocalDate.now());
        testrep.add(t);
        assertEquals(testrep.get(0),t);
    }

    @Test
    public void set() throws Exception {
        PersonRepository testrep = new PersonRepository();
        Person t = new Person("test" ,1, LocalDate.now());
        testrep.add(t);
        Person t1 = new Person("asdasd" ,2, LocalDate.now());

        testrep.set(0,t1);
        assertEquals(testrep.get(0),t1);
    }

    @Test
    public void remove() throws Exception {
        Person[] testarr = new Person[5];
        Person[] testarr1 = new Person[4];
        PersonRepository testrep = new PersonRepository();
        for (int i = 0; i < 4; i++) {
            testarr[i] = new Person("test" + i,i, LocalDate.now());
            testrep.add(testarr[i]);
            testarr1[i] = testarr[i];
        }

        testarr[4] = new Person("test" + 4,4, LocalDate.now());
        testrep.add(testarr[4]);

        testrep.remove(4);
        assertArrayEquals(testrep.toArray(),testarr1);
        assertEquals(testrep.getLength(),4);
    }

    @Test
    public void sort() throws Exception {
        Person[] testarr = new Person[5];
        PersonRepository testrep = new PersonRepository();
        for (int i = 0; i < 5; i++) {
            testrep.add(new Person("test" + i,20 - i, LocalDate.now()));
            testarr[i] = new Person("test" + i,16 + i, LocalDate.now());
        }
        PersonRepository sortarr = testrep.sort(new PersonBubbleSort(), new PersonIDComparator());

        for (int i = 0; i < 5; i++) {
            assertEquals(sortarr.get(i).getId(),testarr[i].getId());
        }


    }

    @Test
    public void search() throws Exception {
        PersonRepository testrep = new PersonRepository();
        Person p = new Person("Pasha",10, LocalDate.now());
        for (int i = 0; i < 4; i++) {
            testrep.add(new Person("test" + i,20 - i, LocalDate.now()));
        }
        testrep.add(p);

        PersonRepository searchres = testrep.search(new PersonSequentialSearch(), new NameIsPashaAndIDIs10Test());
        assertEquals(searchres.get(0).toString(),p.toString());
    }
}