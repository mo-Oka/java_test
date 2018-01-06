package first.pack;

import org.testng.annotations.Test;

public class TestGroupDeletion extends TestBase {

    @Test
    public void GroupDeletionTest() {
        goToGroupPage("groups");
        selectGroup();
        deleteSelectedGroups();
        goToGroupPage("group page");
    }

}
