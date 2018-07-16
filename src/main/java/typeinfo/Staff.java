package typeinfo;

import java.util.ArrayList;

/**
 * @author zhongwei Date: 18-2-12 Time: 上午9:42.
 */

public class Staff extends ArrayList<Position> {
  public void add(String title, Person person) {
    add(new Position(title, person));
  }

  public void add(String... titles) {
    for(String title : titles) {
      add(new Position(title));
    }
  }
  public Staff(String... titles) { add(titles); }

  public boolean positianAvailable(String title) {
    for(Position position : this) {
      if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
        return true;
      }
    }
    return false;
  }

  public void fillPostion(String title, Person hire) {
    for(Position position : this) {
      if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
        position.setPerson(hire);
        return;
      }
    }
    throw new RuntimeException("Position " + title + " not available");
  }

  public static void main(String[] args) {
    Staff staff =
      new Staff("President", "CTO", "Marketing Manager", "Product Manager", "Project Lead",
        "Software Engineer", "Software Engineer", "Software Engineer", "Test Engineer",
        "Technical Writer");
    staff.fillPostion("President",
      new Person("Me", "Last", "The Top, Lonely At"));
    staff.fillPostion("Project Lead",
      new Person("Janet", "Planner", "THe Burbs"));
    if(staff.positianAvailable("Software Engineer")) {
      staff.fillPostion("Software Enginerr", new Person("Bob", "Coder", "Bright Light City"));
    }
    System.out.println(staff);
  }
}
