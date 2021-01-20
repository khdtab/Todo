package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.model.Person;

import static org.junit.Assert.assertEquals;


public class PersonTest
{
    @Test
    public void testCreatingPerson() throws Exception {
        Person person = new Person(1,"khaled","Tayeb");

        assertEquals(person.getPersonId(),1);
        assertEquals(person.getFirstName(),"khaled");
        assertEquals(person.getLastName(),"Tayeb");
    }
}
