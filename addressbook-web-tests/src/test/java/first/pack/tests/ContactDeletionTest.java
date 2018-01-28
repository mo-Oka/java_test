package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(1,"First", "Last", null, null, null,"some address in a middle of nowhere",null, null, null,null, null, null, null));
    }
  }

  @Test
  public void testContactDeletion(){
    app.getContactHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("First", "Last", "nick", "company1", "senior", "some address in a middle of nowhere", "1234567890", "first.last@email.em", "1", "June", "1990", "test1","test note"));
    }
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().clickAlert();
    app.getContactHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
