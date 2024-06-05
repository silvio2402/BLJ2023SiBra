package View;

import javax.swing.*;
import java.awt.event.*;

import Model.DataStore;
import Model.Contract.Contract;

public class ContractsPanel extends JPanel {
  private ContractTable contractTable;

  public ContractsPanel() {
    super();
    createUI();
  }

  private void createUI() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setAlignmentX(LEFT_ALIGNMENT);

    JButton addContractButton = new JButton("Add Contract");
    addContractButton.addActionListener(this::addContractButtonActionPerformed);
    buttonPanel.add(addContractButton);

    JButton editContractButton = new JButton("Edit Contract");
    editContractButton.addActionListener(this::editContractButtonActionPerformed);
    buttonPanel.add(editContractButton);

    JButton removeContractButton = new JButton("Remove Contract");
    removeContractButton.addActionListener(this::removeContractButtonActionPerformed);
    buttonPanel.add(removeContractButton);

    add(buttonPanel);

    contractTable = new ContractTable();
    add(contractTable);
  }

  private void addContractButtonActionPerformed(ActionEvent evt) {
    EditContractFrame editContractFrame = new EditContractFrame();
    editContractFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        contractTable.tableModel.fireTableDataChanged();
      }
    });
  }

  private void editContractButtonActionPerformed(ActionEvent evt) {
    int selectedRow = contractTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a contract to edit", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Contract contract = DataStore.getContracts().get(contractTable.table.convertRowIndexToModel(selectedRow));

    EditContractFrame editContractFrame = new EditContractFrame(contract);

    editContractFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        contractTable.tableModel.fireTableDataChanged();
      }
    });

  }

  private void removeContractButtonActionPerformed(ActionEvent evt) {
    int selectedRow = contractTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a contract to remove", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Contract contract = DataStore.getContracts().get(contractTable.table.convertRowIndexToModel(selectedRow));

    int result = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to remove "
            /* + contract.firstName + " " + contract.lastName */ + "?",
        "Remove Contract", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      DataStore.getContracts().remove(contract);
      contractTable.tableModel.fireTableDataChanged();
    }
  }

}
