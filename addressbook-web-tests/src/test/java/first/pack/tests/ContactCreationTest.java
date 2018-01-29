package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.contact().goToHomePage();
    Set<ContactData> before = app.contact().all();
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
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
