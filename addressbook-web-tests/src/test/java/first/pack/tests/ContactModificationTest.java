package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("First", "Last", "nick", "company1", "senior", "some address in a middle of nowhere", "1234567890", "first.last@email.em", "1", "June", "1990", "test1","test note"));
    }
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().goToContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Name1-2","Last1-2","nick1-2","company1-2","title1-2","address1-2","123","qw@qw.qw","2","December","2000",null,"note1-2"), false);
    app.getContactHelper().submitContactModification();
  }
}
