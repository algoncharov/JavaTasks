package ru.vsu.lab1.sorters;

import ru.vsu.lab1.Person;
import ru.vsu.lab1.PersonComparator;
import ru.vsu.lab1.PersonRepository;
import ru.vsu.lab1.PersonSorter;

public class PersonQuickSort implements PersonSorter {
    public PersonRepository sort(PersonRepository arr, PersonComparator comp) {
        Person res[] = arr.toArray();
        QS(res,0,res.length,comp);
        return new PersonRepository(res);
    }
    private static void QS(Person[] array, int start, int end, PersonComparator comp) {
        if (start < end) {
            int PIndex = partition(array, start, end,comp);
            QS(array, start, PIndex - 1, comp);
            QS(array, PIndex + 1, end, comp);
        }
    }


    private static int partition(Person[] array, int start, int end, PersonComparator comp) {
        Person pivot = array[end];
        int PIndex = start;
        for (int i=start;i<end;i++) {
            if (comp.compare(array[i],pivot) <= 0) {
                swap(array, i, PIndex);
                PIndex++;
            }
        }
        swap(array, PIndex, end);
        return PIndex;
    }


    private static void swap(Person[] array, int initial, int fin) {
        Person temp = array[initial];
        array[initial] = array[fin];
        array[fin] = temp;
    }

}
