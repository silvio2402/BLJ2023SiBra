package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import Model.*;
import Model.Contract.*;

class ContractTableModel extends AbstractTableModel {

  private List<Contract> contracts;

  public ContractTableModel(List<Contract> contract) {
    this.contracts = contract;
  }

  @Override
  public int getRowCount() {
    return contracts.size();
  }

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Contract contract = contracts.get(rowIndex);
    switch (columnIndex) {
      case 0:
        if (contract instanceof RentalContract) {
          return ((RentalContract) contract).renter.getFullName();
        } else {
          return null;
        }
      case 1:
        if (contract instanceof RentalContract) {
          return ((RentalContract) contract).vehicle.name;
        } else {
          return null;
        }
      case 2:
        if (contract instanceof RentalContract) {
          return ((RentalContract) contract).startDate;
        } else {
          return null;
        }
      case 3:
        if (contract instanceof RentalContract) {
          return ((RentalContract) contract).endDate;
        } else {
          return null;
        }
      case 4:
        if (contract instanceof RentalContract) {
          return ((RentalContract) contract).price;
        } else {
          return null;
        }
      case 5:
        String signatures = "";
        // for (Signature signature : contract.signatures) {
        // signatures += signature.signer.getFullName() + " ";
        // }
        return signatures;
      default:
        return null;
    }
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "Renter";
      case 1:
        return "Vehicle";
      case 2:
        return "Start Date";
      case 3:
        return "End Date";
      case 4:
        return "Price";
      case 5:
        return "Signatures";
      default:
        return null;
    }
  }

}

public class ContractTable extends JScrollPane {
  JTable table;
  ContractTableModel tableModel;

  public ContractTable() {
    super();
    tableModel = new ContractTableModel(DataStore.getContracts());
    table = new JTable(tableModel);
    table.setAutoCreateRowSorter(true);
    setViewportView(table);
  }

}