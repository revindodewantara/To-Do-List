import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}

class TodoList {
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Tugas ditambahkan: " + task.getDescription());
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsDone();
            System.out.println("Tugas selesai: " + task.getDescription());
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Tidak ada tugas dalam daftar.");
        } else {
            System.out.println("Daftar Tugas:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Tandai Tugas Selesai");
            System.out.println("3. Lihat Daftar Tugas");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan deskripsi tugas: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Masukkan nomor tugas yang selesai: ");
                    int taskIndex = scanner.nextInt();
                    todoList.markTaskAsDone(taskIndex);
                    break;
                case 3:
                    todoList.listTasks();
                    break;
                case 4:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
