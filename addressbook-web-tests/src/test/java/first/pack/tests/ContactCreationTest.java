package first.pack.tests;

import first.pack.model.ContactData;
import first.pack.model.Contacts;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
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
    assertThat(app.contact().count(), equalTo(before.size() + 1));

    Contacts after = app.contact().all();
    MatcherAssert.assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testBadContactCreation() {
//    app.contact().goToHomePage();
//    Contacts before = app.contact().all();
//    ContactData contact = new ContactData()
//            .withFirstName("First123'");
//    app.contact().create(contact);
//    app.contact().goToHomePage();
//    assertThat(app.contact().count(), equalTo(before.size()));
//
//    Contacts after = app.contact().all();
//    MatcherAssert.assertThat(after, equalTo(before));
//  }

}
