package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.People;
import se.lexicon.model.Person;

import static org.junit.Assert.assertEquals;


public class PeopleTest
{
    @Test
    public void testAddPerson() {
        People people = new People();
        Person person = people.add("khaled","tayeb");

        assertEquals("khaled",person.getFirstName());
        assertEquals("tayeb",person.getLastName());
        assertEquals(1,person.getPersonId());
        assertEquals(1,people.size());

        people.add("khaled2","tayeb2");
        assertEquals(2,people.size());
    }

    @Test
    public void testClear() {
        People people = new People();
        Person person = people.add("khaled","tayeb");

        people.clear();
        assertEquals(0,people.size());
    }

    @Test
    public void testFind() {
        People people = new People();
        Person person = people.add("khaled","tayeb");

        assertEquals(person.getPersonId(),people.find(person.getPersonId()).getPersonId());
    }


}
