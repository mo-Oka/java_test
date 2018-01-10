package first.pack.tests;

import org.testng.annotations.Test;

public class TestGroupDeletion extends TestBase {

    @Test
    public void GroupDeletionTest() {
        app.goToGroupPage("groups");
        app.selectGroup();
        app.deleteSelectedGroups();
        app.goToGroupPage("group page");
    }

}
