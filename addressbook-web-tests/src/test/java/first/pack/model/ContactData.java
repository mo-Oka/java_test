package first.pack.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contacts")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String nickName;
  @Expose
  @Column(name = "company")
  private String companyName;
  @Expose
  private String title;
  @Expose
  @Type(type = "text")
  private String address;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Expose
  @Type(type = "text")
  private String email;
  @Expose
  @Column(name = "bday", columnDefinition = "TINYINT(1) DEFAULT 0")
  private String day;
  @Expose
  @Column(name = "bmonth")
  private String month;
  @Expose
  @Column(name = "byear")
  private String year;
  @Expose
  @Transient
  private String group;
  @Expose
  @Type(type = "text")
  private String notes;
  @Transient
  private String allPhones;
  @Type(type = "text")
  private String email2;
  @Type(type = "text")
  private String email3;
  @Transient
  private String allEmails;
  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", companyName='" + companyName + '\'' +
            ", title='" + title + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email='" + email + '\'' +
            ", day='" + day + '\'' +
            ", month='" + month + '\'' +
            ", year='" + year + '\'' +
            ", group='" + group + '\'' +
            ", notes='" + notes + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
            '}';
  }

  public int getId() {
    return id;
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

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withDay(String day) {
    this.day = day;
    return this;
  }

  public ContactData withMonth(String month) {
    this.month = month;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmail(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(nickName, that.nickName) &&
            Objects.equals(companyName, that.companyName) &&
            Objects.equals(title, that.title) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(day, that.day) &&
            Objects.equals(month, that.month) &&
            Objects.equals(year, that.year) &&
            Objects.equals(notes, that.notes) &&
            Objects.equals(allPhones, that.allPhones) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(allEmails, that.allEmails);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstName, lastName, nickName, companyName, title, address, homePhone, mobilePhone, workPhone, email, day, month, year, notes, allPhones, email2, email3, allEmails);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }
}
