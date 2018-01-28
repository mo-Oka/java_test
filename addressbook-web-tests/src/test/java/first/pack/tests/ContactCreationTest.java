package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.contact().goToHomePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withFirstName("First123")
            .withLastName("Last")
            .withNickName("nick")
            .withCompanyName("company1")
            .withTitle("senior")
            .withAddress("some address in a middle of nowhere")
            .withHomePhone("1234567890")
            .withEmail("first.last@email.em")
            .withDay("1")
            .withMonth("June")
            .withYear("1990")
            .withGroup("test1")
            .withNotes("test note");
    app.contact().create(contact);
    app.contact().goToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
