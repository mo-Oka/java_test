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

  public ContactData(String firstName, String lastName, String nickName, String title, String companyName, String address, String homePhone, String email, String year, String notes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.companyName = companyName;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.year = year;
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
}
