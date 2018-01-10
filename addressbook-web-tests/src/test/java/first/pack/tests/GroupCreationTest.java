package first.pack.tests;

import first.pack.model.GroupData;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() {
    app.goToGroupPage("groups");
    app.initGroupCreation("new");
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation("submit");
    app.goToGroupPage("group page");
  }

}
