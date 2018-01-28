package first.pack.appmanager;

import first.pack.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    clickDropdown("bday", contactData.getDay());
    clickDropdown("bmonth", contactData.getMonth());
    type(By.name("byear"), contactData.getYear());

    if(creation) {
      clickDropdown("new_group", contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("notes"), contactData.getNotes());
  }

  public void submitContactForm() {
    click(By.name("submit"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void clickEditContact(int index) {
    wd.findElements(By.cssSelector("#maintable td:nth-child(8) a")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void clickAlert() {
    wd.switchTo().alert().accept();
    wd.switchTo().defaultContent();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactForm();
  }

  public void modify(int index, ContactData contact) {
    clickEditContact(index);
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    clickAlert();
    goToHomePage();
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("#maintable tr"));
    elements.remove(0);
    for (WebElement element : elements){
      List<WebElement>  row = element.findElements(By.cssSelector("td"));
      String firstName = row.get(2).getText();
      String lastName = row.get(1).getText();
      String address = row.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAddress(address));
    }
    return contacts;
  }
}
