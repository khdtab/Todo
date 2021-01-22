package se.lexicon.data;

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
}
