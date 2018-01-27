package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(1,"First", "Last", null, null, null,"some address in a middle of nowhere",null, null, null,null, null, null, null));
    }
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "First1", "Last1", "Nick1","company1", "senior", "some address in a middle of nowhere1", "1234567890", "first.last@email.em", "1", "June", "1990", "test1", "note1");
    app.getContactHelper().clickEditContact(before.size() - 1);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
