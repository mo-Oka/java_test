package first.pack.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getContactHelper().goToContactPage();
    app.getContactHelper().deleteSelectedContact();
  }
}