package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("First", "Last", "nick", "senior", "company1", "some address in a middle of nowhere", "1234567890", "first.last@email.em", "1990", "test note"), "1", "June", "test1");
    app.getContactHelper().submitContactForm();
  }

}
