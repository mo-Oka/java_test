package first.pack.tests;

import first.pack.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

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
  public void testContactDeletion(){
    app.contact().goToHomePage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
