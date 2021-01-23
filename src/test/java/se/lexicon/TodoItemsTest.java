package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.TodoItems;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import static org.junit.Assert.*;


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
    @Test
    public void testFindByDoneStatus() {
        TodoItems items = new TodoItems();
        Todo todo = items.add("todo1 description");
        todo.setDone(true);
        Todo todo2 = items.add("tod2 description");
        todo2.setDone(true);

        Todo [] expected={todo,todo2};
        Todo [] result = items.findByDoneStatus(true);

        assertArrayEquals(expected,result);
    }

    @Test
    public void testFindByAssigne() {
        TodoItems items = new TodoItems();

        Person p = new Person(1,"khaled","tayeb");

        Todo todo = items.add("todo1 description");
        todo.setAssignee(p);
        Todo todo2 = items.add("todo2 description");
        todo2.setAssignee(p);
        Todo todo3 = items.add("todo3 description");
        assertNull(todo3.getAssignee());


        Todo [] expected={todo,todo2,null};
        Todo [] result = items.findByAssignee(p);

        assertArrayEquals(expected,result);
    }
    @Test
    public void testFindUnassignedTodoItems() {
        TodoItems items = new TodoItems();

        Person p = new Person(1,"khaled","tayeb");

        Todo todo = items.add("todo1 description");
        todo.setAssignee(p);
        Todo todo2 = items.add("todo2 description");
        todo2.setAssignee(p);
        Todo todo3 = items.add("todo3 description");
        assertNull(todo3.getAssignee());


        Todo [] expected={todo3,null,null};
        Todo [] result = items.findUnassignedTodoItems();

        assertArrayEquals(expected,result);
    }


    @Test
    public void testRemove() {
        TodoItems items = new TodoItems();

        Todo todo = items.add("todo1 description");
        Todo todo2 = items.add("todo2 description");
        Todo todo3 = items.add("todo3 description");


        Todo [] expected={todo,todo3};
        Todo [] result = items.remove(2);

        assertArrayEquals(expected,result);
    }

}
