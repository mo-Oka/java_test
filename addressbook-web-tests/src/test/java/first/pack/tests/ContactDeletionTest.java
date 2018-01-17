package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("First", "Last", "nick", "company1", "senior", "some address in a middle of nowhere", "1234567890", "first.last@email.em", "1", "June", "1990", "test1","test note"));
    }
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().goToContactPage();
    app.getContactHelper().deleteSelectedContact();
    //app.getContactHelper().clickAlert();
  }
}
