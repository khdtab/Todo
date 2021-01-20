package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TodoTest
{
    @Test
    public void testCreatingTodo()  {
        Todo todo = new Todo(1,"description");

        assertEquals(todo.getTodoId(),1);
        assertEquals(todo.getDescription(),"description");



        Todo todo2 = new Todo(2,"description2");
        todo2.setDone(true);

        Person person = new Person(1,"khaled","Tayeb");
        todo2.setAssignee(person);



        assertEquals(todo2.getTodoId(),2);
        assertEquals(todo2.getDescription(),"description2");
        assertTrue(todo2.isDone());
        assertEquals(todo2.getAssignee(),person);


    }
}
