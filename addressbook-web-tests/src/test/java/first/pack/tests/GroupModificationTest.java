package first.pack.tests;

import first.pack.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1-2","test2-2","test3-3"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
  }
}
