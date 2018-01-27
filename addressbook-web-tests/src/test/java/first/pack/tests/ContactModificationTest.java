package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(1,"First", "Last", "some address in a middle of nowhere"));
    }
    app.getContactHelper().clickEditContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Name1-2","Last1-2","address1-2");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
