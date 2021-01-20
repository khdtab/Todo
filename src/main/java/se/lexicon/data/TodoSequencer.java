package se.lexicon.data;

public class TodoSequencer {
    private static int todoId;


    public TodoSequencer() {
        todoId = 0;
    }

    public int nextTodoId() {
        todoId++;
        return todoId;
    }

    public void reset() {
        todoId = 0;
    }


}
