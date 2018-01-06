package first.pack;

import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() {
    goToGroupPage("groups");
    initGroupCreation("new");
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation("submit");
    goToGroupPage("group page");
  }

}
