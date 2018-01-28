package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().goToHomePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData()
              .withFirstName("First123")
              .withLastName("Last")
              .withAddress("some address in a middle of nowhere"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstName("First1")
            .withLastName("Last1")
            .withNickName("Nick1")
            .withCompanyName("company1")
            .withTitle("senior1")
            .withAddress("some address in a middle of nowhere1")
            .withHomePhone("00000000000")
            .withEmail("first111@email.em")
            .withDay("15")
            .withMonth("May")
            .withYear("2000")
            .withGroup("test1")
            .withNotes("test note1");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
