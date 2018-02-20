package first.pack.tests;

import first.pack.model.GroupData;
import first.pack.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
        app.group().create(new GroupData().withName("test1"));
      }
    }
  }

  @Test
  public void testGroupModification(){
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("test1-2")
            .withHeader("test1-2")
            .withFooter("test1-3");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));

    Groups after = app.db().groups();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
