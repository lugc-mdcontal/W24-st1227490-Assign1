import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // to store students
    List<Student> students = new ArrayList<>();

    int numStudents = getInt("Enter the num of students you want to add: ", scanner);
    if (numStudents < 1)
    {
      System.out.println("Need at least one student!");
      return;
    }

    for (int i = 0; i < numStudents; i++) {
      System.out.println("\nStudent " + (i + 1) + ":");
      try {
        students.add(new Student(
            getString("First Name: ", scanner),
            getString("Last Name: ", scanner),
            getString("Student Number: ", scanner),
            getActs(scanner)));
        System.out.println("Student entered!\n");
      } catch (Exception e) {
        // If an exception did happen, we must restart
        // So log the error, an decrement the counter
        System.out.println(e.getMessage() + ", retrying...\n");
        i--;
      }
    }

    System.out.println("\nEntered Students:");
    students.forEach(System.out::println);
  }

  private static List<String> getActs(Scanner scanner) {
    List<String> acts = new ArrayList<>();

    int numActs = getInt("Number of Activities: ", scanner);
    for (int i = 0; i < numActs; i++) {
      acts.add(getString("Enter Activity" + (i + 1) + ": ", scanner));
    }

    return acts;
  }

  private static String getString(String txt, Scanner scanner) {
    System.out.print(txt);
    return scanner.next();
  }

  private static int getInt(String txt, Scanner scanner) {
    System.out.print(txt);
    return scanner.nextInt();
  }
}
