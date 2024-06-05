package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import Model.*;
import Model.Vehicle.*;

class VehicleTableModel extends AbstractTableModel {

  private List<Vehicle> people;

  public VehicleTableModel(List<Vehicle> people) {
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
    Vehicle vehicle = people.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return vehicle.name;
      case 1:
        return vehicle.manufactureYear;
      case 2:
        return vehicle.vin;
      case 3:
        return vehicle.newPrice;
      case 4:
        return vehicle.currentPrice;
      case 5:
        return vehicle.odometer;
      default:
        return null;
    }
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "Name";
      case 1:
        return "Manufacture Year";
      case 2:
        return "VIN";
      case 3:
        return "New Price";
      case 4:
        return "Current Price";
      case 5:
        return "Odometer";
      default:
        return null;
    }
  }

}

public class VehicleTable extends JScrollPane {
  JTable table;
  VehicleTableModel tableModel;

  public VehicleTable() {
    super();
    tableModel = new VehicleTableModel(DataStore.getVehicles());
    table = new JTable(tableModel);
    table.setAutoCreateRowSorter(true);
    setViewportView(table);
  }

}