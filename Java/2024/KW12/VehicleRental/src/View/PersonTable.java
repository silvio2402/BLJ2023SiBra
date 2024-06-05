package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import Model.*;
import Model.Person.*;

class PersonTableModel extends AbstractTableModel {

  private List<Person> people;

  public PersonTableModel(List<Person> people) {
    this.people = people;
  }

  @Override
  public int getRowCount() {
    return people.size();
  }

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Person person = people.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return person.firstName;
      case 1:
        return person.lastName;
      case 2:
        return person.address;
      case 3:
        return person.birthdate;
      case 4:
        return person.telephone;
      case 5:
        return person.email;
      default:
        return null;
    }
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "First Name";
      case 1:
        return "Last Name";
      case 2:
        return "Address";
      case 3:
        return "Birthdate";
      case 4:
        return "Telephone";
      case 5:
        return "Email";
      default:
        return null;
    }
  }

}

public class PersonTable extends JScrollPane {
  JTable table;
  PersonTableModel tableModel;

  public PersonTable() {
    super();
    tableModel = new PersonTableModel(DataStore.getCustomers());
    table = new JTable(tableModel);
    table.setAutoCreateRowSorter(true);
    setViewportView(table);
  }

}