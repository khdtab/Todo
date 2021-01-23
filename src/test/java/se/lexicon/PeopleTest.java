package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.People;
import se.lexicon.data.TodoItems;
import se.lexicon.model.Person;
import se.lexicon.model.Person;

import static org.junit.Assert.assertArrayEquals;
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

    @Test
    public void testRemove() {
        People people = new People();

        Person todo = people.add("khaled1","tayeb");
        Person todo2 = people.add("khaled2","tayeb");
        Person todo3 = people.add("khaled3","tayeb");


        Person [] expected={todo,todo2};
        Person [] result = people.remove(3);

        assertArrayEquals(expected,result);
    }

}
