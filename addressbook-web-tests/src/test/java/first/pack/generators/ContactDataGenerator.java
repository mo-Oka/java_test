package first.pack.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import first.pack.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCSV(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXML(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJSON(contacts, new File(file));
    } else {
      System.out.println("Unrecognizable format" + format);
    }
  }

  private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
              contact.getFirstName(),
              contact.getLastName(),
              contact.getNickName(),
              contact.getCompanyName(),
              contact.getTitle(),
              contact.getAddress(),
              contact.getHomePhone(),
              contact.getMobilePhone(),
              contact.getWorkPhone(),
              contact.getEmail(),
              contact.getEmail2(),
              contact.getEmail3(),
              contact.getYear(),
              contact.getGroup(),
              contact.getNotes()
              //contact.getPhoto()
              ));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    File photo = new File("src/test/resources/stru.jpg");
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstName(String.format("First %s", i))
              .withLastName(String.format("Last %s", i))
              .withNickName(String.format("nick%s", i))
              .withCompanyName(String.format("company%s", i))
              .withTitle(String.format("senior%s", i))
              .withAddress(String.format("address %s", i))
              .withHomePhone(String.format("333%s", i))
              .withMobilePhone(String.format("222%s", i))
              .withWorkPhone(String.format("111%s", i))
              .withEmail(String.format("first%s.last%s@email.em", i, i))
              .withEmail2(String.format("first%s.last%s@email2.em", i, i))
              .withEmail3(String.format("first%s.last%s@email3.em", i, i))
              .withDay("1")
              .withMonth("June")
              .withYear(String.format("199%s", i))
              .withGroup("test1")
              .withNotes(String.format("test note %s", i)))
              //.withPhoto(photo))
      ;
    }
    return contacts;
  }
}