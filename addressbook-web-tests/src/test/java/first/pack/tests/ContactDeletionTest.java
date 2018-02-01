package first.pack.tests;

import first.pack.model.ContactData;
import first.pack.model.Contacts;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{

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
  public void testContactDeletion(){
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));

    Contacts after = app.contact().all();
    MatcherAssert.assertThat(after, equalTo(before.without(deletedContact)));
  }

}
