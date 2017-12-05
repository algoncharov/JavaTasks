package ru.vsu.lab1.sorters;

import ru.vsu.lab1.Person;
import ru.vsu.lab1.PersonComparator;
import ru.vsu.lab1.PersonRepository;
import ru.vsu.lab1.PersonSorter;

public class PersonBubbleSort implements PersonSorter {
    public PersonRepository sort(PersonRepository rep, PersonComparator comp) {
        int n = rep.getLength();
        Person[] arr = rep.toArray();
        Person temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if( comp.compare(arr[j-1], arr[j]) > 0){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return  new PersonRepository(arr);
    }
}
