package first.pack.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String companyName;
  private final String address;
  private final String homePhone;
  private final String email;
  private final String year;
  private final String notes;
  private final String day;
  private final String month;
  private String group;

  public ContactData(String firstName, String lastName, String nickName, String companyName, String title, String address, String homePhone, String email, String day, String month, String year, String group, String notes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.companyName = companyName;
    this.title = title;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
    this.group = group;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getYear() {
    return year;
  }

  public String getNotes() {
    return notes;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }
  public String getGroup() {
    return group;
  }
}
