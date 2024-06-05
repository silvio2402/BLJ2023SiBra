package View;

import javax.swing.*;
import java.awt.event.*;

import Model.DataStore;
import Model.Vehicle.Vehicle;

public class VehiclesPanel extends JPanel {
  private VehicleTable vehicleTable;

  public VehiclesPanel() {
    super();
    createUI();
  }

  private void createUI() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setAlignmentX(LEFT_ALIGNMENT);

    JButton addVehicleButton = new JButton("Add Vehicle");
    addVehicleButton.addActionListener(this::addVehicleButtonActionPerformed);
    buttonPanel.add(addVehicleButton);

    JButton editVehicleButton = new JButton("Edit Vehicle");
    editVehicleButton.addActionListener(this::editVehicleButtonActionPerformed);
    buttonPanel.add(editVehicleButton);

    JButton removeVehicleButton = new JButton("Remove Vehicle");
    removeVehicleButton.addActionListener(this::removeVehicleButtonActionPerformed);
    buttonPanel.add(removeVehicleButton);

    add(buttonPanel);

    vehicleTable = new VehicleTable();
    add(vehicleTable);
  }

  private void addVehicleButtonActionPerformed(ActionEvent evt) {
    EditVehicleFrame<Vehicle> editVehicleFrame = new EditVehicleFrame<Vehicle>();

    editVehicleFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        vehicleTable.tableModel.fireTableDataChanged();
      }
    });
  }

  private void editVehicleButtonActionPerformed(ActionEvent evt) {
    int selectedRow = vehicleTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a Vehicle to edit", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Vehicle vehicle = DataStore.getVehicles().get(vehicleTable.table.convertRowIndexToModel(selectedRow));

    EditVehicleFrame<Vehicle> editVehicleFrame = new EditVehicleFrame<Vehicle>(vehicle);

    editVehicleFrame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        vehicleTable.tableModel.fireTableDataChanged();
      }
    });

  }

  private void removeVehicleButtonActionPerformed(ActionEvent evt) {
    int selectedRow = vehicleTable.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Please select a Vehicle to remove", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }

    Vehicle vehicle = DataStore.getVehicles().get(vehicleTable.table.convertRowIndexToModel(selectedRow));

    int result = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to remove " + vehicle.name + "?",
        "Remove Vehicle", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      DataStore.getVehicles().remove(vehicle);
      vehicleTable.tableModel.fireTableDataChanged();
    }
  }

}
