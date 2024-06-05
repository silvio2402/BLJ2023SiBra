package View;

import java.time.LocalDate;

import javax.swing.*;

import Model.DataStore;
import Model.Person.Person;

public class EditPersonFrame extends JFrame {
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField addressField;
  private JTextField birthdateField;
  private JTextField telephoneField;
  private JTextField emailField;
  private Person person;

  public EditPersonFrame(Person person) {
    super(person == null ? "Add Person" : "Edit Person");

    this.person = person;

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400, 350);
    setLocationRelativeTo(null);

    createUI();

    setVisible(true);
  }

  public EditPersonFrame() {
    this(null);
  }

  private void createUI() {
    JScrollPane scrollPane = new JScrollPane();

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel firstNameLabel = new JLabel("First Name");
    firstNameField = new JTextField();
    panel.add(firstNameLabel);
    panel.add(firstNameField);

    JLabel lastNameLabel = new JLabel("Last Name");
    lastNameField = new JTextField();
    panel.add(lastNameLabel);
    panel.add(lastNameField);

    JLabel addressLabel = new JLabel("Address");
    addressField = new JTextField();
    panel.add(addressLabel);
    panel.add(addressField);

    JLabel birthdateLabel = new JLabel("Birthdate");
    birthdateField = new JTextField();
    panel.add(birthdateLabel);
    panel.add(birthdateField);

    JLabel telephoneLabel = new JLabel("Telephone");
    telephoneField = new JTextField();
    panel.add(telephoneLabel);
    panel.add(telephoneField);

    JLabel emailLabel = new JLabel("Email");
    emailField = new JTextField();
    panel.add(emailLabel);
    panel.add(emailField);

    if (person != null) {
      firstNameField.setText(person.firstName);
      lastNameField.setText(person.lastName);
      addressField.setText(person.address);
      if (person.birthdate != null)
        birthdateField.setText(person.birthdate.toString());
      telephoneField.setText(person.telephone);
      emailField.setText(person.email);
    }

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(this::saveButtonActionPerformed);
    panel.add(saveButton);

    scrollPane.setViewportView(panel);
    add(scrollPane);
  }

  private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String address = addressField.getText();
      String birthdateStr = birthdateField.getText();
      LocalDate birthdate;
      if (birthdateStr.isEmpty()) {
        birthdate = null;
      } else {
        birthdate = LocalDate.parse(birthdateStr);
      }
      String telephone = telephoneField.getText();
      String email = emailField.getText();

      if (person == null)
        DataStore.addCustomer(new Person(firstName, lastName, address, birthdate, telephone, email));
      else {
        person.firstName = firstName;
        person.lastName = lastName;
        person.address = address;
        person.birthdate = birthdate;
        person.telephone = telephone;
        person.email = email;
      }

      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
