package View;

import javax.swing.*;
import java.awt.event.*;

import Model.DataStore;
import Model.Person.Person;

public class CustomersPanel extends JPanel {
  private PersonTable personTable;

  public CustomersPanel() {
    super();
    createUI();
  }

  private void createUI() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setAlignmentX(LEFT_ALIGNMENT);

    JButton addCustomerButton = new JButton("Add Customer");
    addCustomerButton.addActionListener(this::addCustomerButtonActionPerformed);
    buttonPanel.add(addCustomerButton);

    JButton editCustomerButton = new JButton("Edit Customer");
    editCustomerButton.addActionListener(this::editCustomerButtonActionPerformed);
    buttonPanel.add(editCustomerButton);

    JButton removeCustomerButton = new JButton("Remove Customer");
    removeCustomerButton.addActionListener(this::removeCustomerButtonActionPerformed);
    buttonPanel.add(removeCustomerButton);

    JButton trollButton = new JButton("Nuklearbombe zünden");
    buttonPanel.add(trollButton);

    add(buttonPanel);

    personTable = new PersonTable();
    add(personTable);
  }

  private void addCustomerButtonActionPerformed(ActionEvent evt) {
    EditPersonFrame editPersonFrame = new EditPersonFrame();
    editPersonFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        personTable.tableModel.fireTableDataChanged();
      }
    });
  }

  private void editCustomerButtonActionPerformed(ActionEvent evt) {
    int selectedRow = personTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a customer to edit", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Person person = DataStore.getCustomers().get(personTable.table.convertRowIndexToModel(selectedRow));

    EditPersonFrame editPersonFrame = new EditPersonFrame(person);

    editPersonFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        personTable.tableModel.fireTableDataChanged();
      }
    });

  }

  private void removeCustomerButtonActionPerformed(ActionEvent evt) {
    int selectedRow = personTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a customer to remove", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Person person = DataStore.getCustomers().get(personTable.table.convertRowIndexToModel(selectedRow));

    int result = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to remove " + person.firstName + " " + person.lastName + "?",
        "Remove Customer", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      DataStore.getCustomers().remove(person);
      personTable.tableModel.fireTableDataChanged();
    }
  }

}
