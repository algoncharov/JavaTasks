package ru.vsu.lab1;

public class PersonRepository {

    private static int DEF_SIZE =5;

    public Person[] toArray() {
        Person res[] = new Person[length];
        System.arraycopy(data,0,res,0,length);
        return res;
    }

    private Person data[];

    public int getLength() {
        return length;
    }

    private int length;

    private int size;

    public PersonRepository(){
        this.data=new Person[DEF_SIZE];
        this.length = 0;
        this.size= DEF_SIZE;
    }

    public PersonRepository(Person arr[]) {
        this.data = arr;
        this.length = arr.length;
        this.size = arr.length;
    }

    public void add(Person obj){
        if(this.length ==this.size-1){
            //we need to increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.length]=obj;
        this.length++;

    }

    private void increaseSizeAndReallocate() {
        this.size *= 2;
        Person newData[]=new Person[this.size];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data=newData;
    }

    public Person get(int i) throws Exception{
        if(i>this.length -1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        return this.data[i];

    }

    public void set(int i, Person p) throws Exception {
        if(i>this.length -1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        this.data[i] = p;
    }

    public void remove(int i) throws Exception{
        if(i>this.length -1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(i<0){
            throw new Exception("Negative Value");
        }
        System.arraycopy(data, i + 1, data, i, this.data.length - 1 - i);
        this.length--;
    }

    public PersonRepository sort(PersonSorter sorter,PersonComparator comp){
        return sorter.sort(this,comp);
    }

    public PersonRepository search(PersonSearcher ps,PersonSearchTester t) throws Exception {
        return ps.search(this,t);
    }
}
