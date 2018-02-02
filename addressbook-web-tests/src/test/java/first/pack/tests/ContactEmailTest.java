package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().goToHomePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstName("First123")
              .withLastName("Last")
              .withAddress("some address in a middle of nowhere"));
    }
  }

  @Test
  public void testContactEmails(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact){
    return Stream.of(contact.getEmail(),
            contact.getEmail2(),
            contact.getEmail3()).filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));

  }
}

