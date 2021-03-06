package first.pack.tests;

import first.pack.model.ContactData;
import first.pack.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().goToHomePage();
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData()
                .withFirstName("First123")
                .withLastName("Last")
                .withAddress("some address in a middle of nowhere"));
      }
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("First1")
            .withLastName("Last1")
            .withNickName("Nick1")
            .withCompanyName("company1")
            .withTitle("senior1")
            .withAddress("some address in a middle of nowhere1")
            .withHomePhone("0000000000")
            .withMobilePhone("")
            .withWorkPhone("")
            .withEmail("first111@email.em")
            .withEmail2("")
            .withEmail3("")
            .withDay("15")
            .withMonth("May")
            .withYear("2000")
            .withNotes("test note1");
    app.contact().goToHomePage();
    app.contact().modify(contact);
    assertThat(app.group().count(), equalTo(before.size()));

    Contacts after = app.db().contacts();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
