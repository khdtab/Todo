package se.lexicon.model;

public class Todo {
    private int todoId;
    private String description;
    private boolean done;
    private Person assignee;

    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
         this.done =false;
         this.assignee=null;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}
