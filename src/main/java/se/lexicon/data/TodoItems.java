package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo;

public class TodoItems {
    private static Todo[] todos;
    protected static TodoSequencer sequencer;


    public TodoItems() {
        todos = new Todo[0];
        sequencer = new TodoSequencer();
    }

    public int size() {
        return todos.length;
    }

    public Todo[] findAll() {
        return todos;
    }

    public Todo find(int todoId) {
        Todo result = null;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i].getTodoId() == todoId) {
                result = todos[i];
            }
        }
        return result;
    }


    public Todo add(String description) {
        int todoId = sequencer.nextTodoId();
        Todo t = new Todo(todoId, description);

        increaseSize();
        todos[todos.length - 1] = t;
        return t;
    }


    //helper method
    protected void increaseSize() {
        Todo[] temp = new Todo[todos.length + 1];

        for (int i = 0; i < todos.length; i++) {
            temp[i] = todos[i];
        }
        todos = temp;
    }


    public void clear() {
        todos = new Todo[0];
    }


    public Todo[] findByDoneStatus(boolean doneStatus) {
        Todo[] result = new Todo[todos.length];
        int resultIndex = 0;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i].isDone() == doneStatus) {
                result[resultIndex] = todos[i];
                resultIndex++;
            }
        }
        return result;
    }

    public Todo[] findByAssignee(int personId) {
        Todo[] result = new Todo[todos.length];
        int resultIndex = 0;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i].getAssignee().getPersonId() == personId) {
                result[resultIndex] = todos[i];
                resultIndex++;
            }
        }
        return result;
    }

    public Todo[] findByAssignee(Person assignee) {
        Todo[] result = null;
        if (assignee != null) {
            result = new Todo[todos.length];
            System.out.println(todos.length);
            int resultIndex = 0;
            for (int i = 0; i < todos.length; i++) {
                Todo todo = todos[i];
                if (todo != null) {
                    if (todo.getAssignee() != null) {
                        if (todo.getAssignee().equals(assignee)) {
                            result[resultIndex] = todo;
                            resultIndex++;

                        }
                    }
                }
            }
        }
        return result;
    }

    public Todo[] findUnassignedTodoItems() {
        Todo[] result = new Todo[todos.length];
        int resultIndex = 0;
        for (Todo todo : todos) {
            if (todo.getAssignee() == null) {
                result[resultIndex] = todo;
                resultIndex++;
            }
        }
        return result;
    }

    public  Todo[] remove(int id)
    {
        int index =-1;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i].getTodoId() == id) {
                index = i;
            }
        }

        if (index < 0 || index >= todos.length) {
            return todos;
        }

        Todo[] result = new Todo[todos.length - 1];
        // Copy the elements except the index from original array to the other array
        for (int i = 0, k = 0; i < todos.length; i++) {
            if (i == index) {
                continue;
            }
            result[k++] = todos[i];
        }
        return result;
    }

}
