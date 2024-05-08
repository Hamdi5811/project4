import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List tasks by priority.");
        System.out.println("(0) Exit.");

        int option = input.nextInt();
        input.nextLine();

        while (option != 0) {
            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    listTasksByPriority();
                    break;
                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }

            System.out.println("Please choose an option:");
            option = input.nextInt();
            input.nextLine();
        }
    }

    public static void addTask() {
        try {
            System.out.println("Enter a task title:");
            String title = input.nextLine();

            System.out.println("Enter a task description:");
            String description = input.nextLine();

            System.out.println("Enter the priority of the task (0-5):");
            int priority = input.nextInt();
            input.nextLine();

            Task newTask = new Task(title, description, priority);
            tasks.add(newTask);

            System.out.println("Task added successfully:");
            System.out.println(newTask);
        } catch (Exception e) {
            System.out.println("Error adding task. Please enter valid input.");
        }
    }

    public static void removeTask() {
        try {
            System.out.println("Enter the index of the task to remove (1-" + tasks.size() + "):");
            int index = input.nextInt();
            input.nextLine();

            if (index >= 1 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid index. No task removed.");
            }
        } catch (Exception e) {
            System.out.println("Error removing task. Please enter a valid index.");
        }
    }

    public static void updateTask() {
        try {
            System.out.println("Enter the index of the task to update (1-" + tasks.size() + "):");
            int index = input.nextInt();
            input.nextLine();

            if (index >= 1 && index <= tasks.size()) {
                Task taskToUpdate = tasks.get(index - 1);

                System.out.println("Enter a new task description:");
                String description = input.nextLine();
                taskToUpdate.setDescription(description);

                System.out.println("Task updated successfully:");
                System.out.println(taskToUpdate);
            } else {
                System.out.println("Invalid index. No task updated.");
            }
        } catch (Exception e) {
            System.out.println("Error updating task. Please enter a valid index and description.");
        }
    }

    public static void listTasks() {
        System.out.println("Listing all tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Index: " + (i + 1) + " | " + tasks.get(i));
        }
    }

    public static void listTasksByPriority() {
        try {
            System.out.println("Enter the priority to list tasks (0-5):");
            int priority = input.nextInt();
            input.nextLine();

            System.out.println("Listing tasks with priority " + priority + ":");
            for (Task task : tasks) {
                if (task.getPriority() == priority) {
                    System.out.println(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Error listing tasks by priority. Please enter a valid priority.");
        }
    }
    static void serializeSimple() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("tasks.json")) {
            JsonElement taskList = null;
            gson.toJson(taskList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deSerializeSimple() {
        try (FileReader reader = new FileReader("tasks.json")) {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Task>>() {
            }.getType();
            Main.tasks = gson.fromJson(jsonElement, type);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

