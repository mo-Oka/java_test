package first.pack.appmanager;

import first.pack.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
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

  public void goToContactPage() {
    click(By.cssSelector("#maintable td:nth-child(8) a"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void deleteSelectedContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void clickAlert() {
    wd.switchTo().alert().accept();
    wd.switchTo().defaultContent();
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }
}
