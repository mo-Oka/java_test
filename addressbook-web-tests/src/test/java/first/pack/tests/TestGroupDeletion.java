package first.pack.tests;

import org.testng.annotations.Test;

public class TestGroupDeletion extends TestBase {

    @Test
    public void GroupDeletionTest() {
        app.getNavigationHelper().goToGroupPage("groups");
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().goToGroupPage("group page");
    }

}
