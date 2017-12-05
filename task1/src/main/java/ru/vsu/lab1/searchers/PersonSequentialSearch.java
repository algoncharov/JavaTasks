package ru.vsu.lab1.searchers;

import ru.vsu.lab1.*;

public class PersonSequentialSearch implements PersonSearcher {
    public PersonRepository search(PersonRepository arr, PersonSearchTester t) throws Exception {
        PersonRepository res = new PersonRepository();
        for (int i = 0; i < arr.getLength(); i++) {
            if (t.test(arr.get(i))) {
                res.add(arr.get(i));
            }
        }
        return res;
    }
}
