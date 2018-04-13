package typeinfo;

/**
 * @author zhongwei Date: 18-2-12 Time: 上午9:35.
 */
public class Position {
  private String title;
  private Person person;

  public Position(String title, Person person) {
    this.title = title;
    this.person = person;
  }

  public Position(String jobTitle) {
    this.title = jobTitle;
    this.person = Person.NULL;
  }

  public String getTitle() { return this.title; }

  public void setTitle(String newTitle) { this.title = newTitle; }

  public Person getPerson() { return this.person; }

  public void setPerson(Person newPerson) {
    this.person = newPerson;
    if (this.person == null) {
      this.person = Person.NULL;
    }
  }
  public String toString() {
    return "title:" + title + " " + person;
  }

}
