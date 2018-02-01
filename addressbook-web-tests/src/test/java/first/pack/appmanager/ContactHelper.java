package first.pack.appmanager;

import first.pack.model.ContactData;
import first.pack.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase {

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

    if (creation) {
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

  public void clickEditContactById(int id) {
    List<WebElement> rows = wd.findElements(By.cssSelector("#maintable tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> columns = row.findElements(By.cssSelector("td"));
      int checkBoxId = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      if (checkBoxId == id){
        columns.get(7).findElement(By.cssSelector("a")).click();
        break;
      }
    }
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    contactCache = null;
    submitContactForm();
  }

  public void modify(ContactData contact) {
    clickEditContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    goToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    clickAlert();
    contactCache = null;
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

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.cssSelector("#maintable tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> columns = row.findElements(By.cssSelector("td"));
      String lastName = columns.get(1).getText();
      String firstName = columns.get(2).getText();
      String address = columns.get(3).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAddress(address));
    }
    return new Contacts(contactCache);
  }

}
