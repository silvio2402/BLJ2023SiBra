package View;

import java.time.LocalDate;

import javax.swing.*;

import Model.DataStore;
import Model.Contract.*;
import Model.Person.*;
import Model.Vehicle.*;

public class EditContractFrame extends JFrame {
  private JTextField contractTextField;

  // Contract specific fields
  // RentalContract
  private JComboBox<Person> renterComboBox;
  private JComboBox<Vehicle> vehicleComboBox;
  private Contract contract;

  public EditContractFrame(Contract contract) {
    super(contract == null ? "Add Contract" : "Edit Contract");

    this.contract = contract;

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400, 350);
    setLocationRelativeTo(null);

    createUI();

    setVisible(true);
  }

  public EditContractFrame() {
    this(null);
  }

  private void createUI() {
    JScrollPane scrollPane = new JScrollPane();

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel contractTextLabel = new JLabel("Contract");
    contractTextField = new JTextField();
    panel.add(contractTextLabel);
    panel.add(contractTextField);

    JLabel renterLabel = new JLabel("Renter");
    renterComboBox = new JComboBox<>();
    for (Person person : DataStore.getCustomers()) {
      renterComboBox.addItem(person);
    }
    panel.add(renterLabel);
    panel.add(renterComboBox);

    JLabel vehicleLabel = new JLabel("Vehicle");
    vehicleComboBox = new JComboBox<>();
    for (Vehicle vehicle : DataStore.getVehicles()) {
      vehicleComboBox.addItem(vehicle);
    }
    panel.add(vehicleLabel);
    panel.add(vehicleComboBox);

    if (contract != null) {
      contractTextField.setText(contract.toString());
      if (contract instanceof RentalContract) {
        RentalContract rentalContract = (RentalContract) contract;
        renterComboBox.setSelectedItem(rentalContract.renter);
        vehicleComboBox.setSelectedItem(rentalContract.vehicle);
      }
    }

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(this::saveButtonActionPerformed);
    panel.add(saveButton);

    scrollPane.setViewportView(panel);
    add(scrollPane);
  }

  private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      if (renterComboBox.getSelectedItem() == null || vehicleComboBox.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Please select a renter and vehicle", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      Person renter = (Person) renterComboBox.getSelectedItem();

      Vehicle vehicle = (Vehicle) vehicleComboBox.getSelectedItem();

      if (contract == null)
        DataStore.addContract(new RentalContract(renter, vehicle, null, null, 0));
      else {
        if (contract instanceof RentalContract) {
          RentalContract rentalContract = (RentalContract) contract;
          rentalContract.renter = renter;
          rentalContract.vehicle = vehicle;
        }
      }

      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
