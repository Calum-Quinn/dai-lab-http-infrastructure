package ch.heig.dai.lab.httpinfrastructure;

public class Todo {
    private String task;
    private boolean completed;

    public Todo() {
    }

    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
