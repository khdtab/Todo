package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.TodoItems;
import se.lexicon.model.Todo;

import static org.junit.Assert.assertEquals;


public class TodoItemsTest
{
    @Test
    public void testAddPerson() {
        TodoItems items = new TodoItems();
        Todo todo = items.add("description1");

        assertEquals("description1",todo.getDescription());
        assertEquals(1,items.size());

        items.add("description2");
        assertEquals(2,items.size());
    }

    @Test
    public void testClear() {
        TodoItems items = new TodoItems();
        Todo todo = items.add("description1");

        items.clear();
        assertEquals(0,items.size());
    }

    @Test
    public void testFind() {
        TodoItems items = new TodoItems();
        Todo todo = items.add("description1");

        assertEquals(todo.getTodoId(),items.find(todo.getTodoId()).getTodoId());
    }


}
