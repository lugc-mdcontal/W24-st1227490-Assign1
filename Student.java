import java.util.ArrayList;
import java.util.List;

public class Student {
  private static final List<String> goodActs = List.of("Pool", "Chess", "Running", "Soccer", "Art");
  private static final int maxStudentNum = 8;

  private String firstName;
  private String lastName;
  private String studentNum;
  private List<String> acts;

  public Student(String firstName, String lastName, String studentNum, List<String> acts) {
    setFirstName(firstName);
    setLastName(lastName);
    setStudentNum(studentNum);
    setActs(acts);
  }

  private String fixName(String name) {
    if (name.length() >= 1)
      return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

    // Throw error
    throw new IllegalArgumentException("Name cannot be empty");
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = fixName(firstName);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = fixName(lastName);
  }

  public String getStudentNum() {
    return studentNum;
  }

  public void setStudentNum(String studentNum) {
    if (studentNum.length() == maxStudentNum) {
      this.studentNum = studentNum;
      return;
    }

    throw new IllegalArgumentException("Student number must be 8 characters long, and a number");
  }

  public List<String> getActs() {
    return acts;
  }

  public void setActs(List<String> acts) {
    if (isGoodActs(acts)) {
      this.acts = acts;
      return;
    }

    throw new IllegalArgumentException("Activity not in the list");
  }

  private boolean isGoodActs(List<String> acts) {
    // Go through each act, and see if its in the actual one
    // If not, return false, which means one was not found
    for (String currAct : acts) {
      if (!goodActs.contains(currAct)) {
        return false;
      }
    }
    return true;
  }
}
