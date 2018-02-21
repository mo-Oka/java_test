package first.pack.tests;

import first.pack.appmanager.ApplicationManager;
import first.pack.model.ContactData;
import first.pack.model.Contacts;
import first.pack.model.GroupData;
import first.pack.model.Groups;
import org.hamcrest.junit.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters" + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      MatcherAssert.assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData()
                      .withId(g.getId())
                      .withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      MatcherAssert.assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData()
                              .withId(g.getId())
                              .withFirstName(g.getFirstName())
                              .withLastName(g.getLastName())
                              .withAddress(g.getAddress())
                      //.withAllEmail(g.getAllEmails())
                      //.withAllPhones(g.getAllPhones())
              )
              .collect(Collectors.toSet())));
    }
  }
}