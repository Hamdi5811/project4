public class Task {
    private String name;
    private String description;
    private int priority;

    public Task(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task name: " + name +
                " | Description: " + description +
                " | Priority: " + priority;
    }
    public static Task fromString(String taskString) {
        String[] parts = taskString.split(",");
        String name = parts[0].substring(7, parts[0].length() - 1);
        String description = parts[1].substring(8, parts[1].length() - 2);
        int priority = Integer.parseInt(parts[2].substring(7, parts[2].length() - 1));
        return new Task(name, description, priority);
    }
}





