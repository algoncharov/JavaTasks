package ru.vsu.lab1.searchtests;

import ru.vsu.lab1.Person;
import ru.vsu.lab1.PersonSearchTester;

public class NameIsPashaAndIDIs10Test implements PersonSearchTester
{
    @Override
    public boolean test(Person p) {
        return p.getName() == "Pasha" && p.getId() == 10;
    }
}
