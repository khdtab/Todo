package se.lexicon.data;

import se.lexicon.model.Person;

public class People {
    private static Person[] persons;
    protected static PersonSequencer sequencer;


    public People() {
        persons = new Person[0];
        sequencer = new PersonSequencer();
    }

    public int size() {
        return persons.length;
    }

    public  Person[] findAll() {
        return persons;
    }

    public  Person find(int personId) {
        Person result = null;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getPersonId() == personId) {
                result = persons[i];
            }
        }
        return result;
    }


    public Person add(String firstName, String lastName) {
        int personId = sequencer.nextPersonId();
        Person p = new Person(personId, firstName, lastName);

        increaseSize();
        persons[persons.length-1] = p;
        return p;
    }


    //helper method
    protected void increaseSize() {
        Person[] temp = new Person[persons.length + 1];

        for (int i = 0; i < persons.length; i++) {
            temp[i] = persons[i];
        }
        persons = temp;
    }


    public void clear() {
        persons = new Person[0];
    }
}
