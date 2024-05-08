import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskCollection implements Iterable<Task> {
    private List<Task> tasks;

    public TaskCollection() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void updateTask(int index, Task newTask) {
        tasks.set(index, newTask);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public void sortTasks() {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                if (task1.getPriority() != task2.getPriority()) {
                    return task2.getPriority() - task1.getPriority();
                } else {
                    return task1.getName().compareTo(task2.getName());
                }
            }
        });
    }
}