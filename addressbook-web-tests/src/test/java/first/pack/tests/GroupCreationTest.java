package first.pack.tests;

import first.pack.model.GroupData;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage("groups");
    app.getGroupHelper().initGroupCreation("new");
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation("submit");
    app.getNavigationHelper().goToGroupPage("group page");
  }

}
