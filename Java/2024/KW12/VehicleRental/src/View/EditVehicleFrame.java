package View;

import javax.swing.*;
import java.awt.event.*;

import Model.DataStore;
import Model.Vehicle.*;

public class EditVehicleFrame<T extends Vehicle> extends JFrame {
  private JComboBox<String> typeComboBox;
  private JTextField nameField;
  private JTextField manufactureYearField;
  private JTextField vinField;
  private JTextField newPriceField;
  private JTextField currentPriceField;
  private JTextField odometerField;

  // Vehicle specific fields
  // LuxuryCar
  private JTextField horsePowerField;

  // Motorhome
  private JTextField waterCapacityField;

  // SmallCar
  private JTextField seatsField;
  private JTextField trunkCapacityField;

  // Trailer
  private JTextField lengthField;

  // Truck
  private JTextField payloadCapacityField;

  private T vehicle;

  private JLabel typeLabel;
  private JLabel nameLabel;
  private JLabel manufactureYearLabel;
  private JLabel vinLabel;
  private JLabel newPriceLabel;
  private JLabel currentPriceLabel;
  private JLabel odometerLabel;
  private JLabel horsePowerLabel;
  private JLabel waterCapacityLabel;
  private JLabel seatsLabel;
  private JLabel trunkCapacityLabel;
  private JLabel lengthLabel;
  private JLabel payloadCapacityLabel;

  public EditVehicleFrame(T vehicle) {
    super(vehicle == null ? "Add Vehicle" : "Edit Vehicle");

    this.vehicle = vehicle;

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(400, 350);
    setLocationRelativeTo(null);

    createUI();

    setVisible(true);
  }

  public EditVehicleFrame() {
    this(null);
  }

  private void createUI() {
    JScrollPane scrollPane = new JScrollPane();

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    typeLabel = new JLabel("Type");
    String vehicleType;
    if (vehicle instanceof LuxuryCar) {
      vehicleType = "LuxuryCar";
    } else if (vehicle instanceof Motorhome) {
      vehicleType = "Motorhome";
    } else if (vehicle instanceof SmallCar) {
      vehicleType = "SmallCar";
    } else if (vehicle instanceof Trailer) {
      vehicleType = "Trailer";
    } else if (vehicle instanceof Truck) {
      vehicleType = "Truck";
    } else {
      vehicleType = null;
    }
    typeComboBox = new JComboBox<>(
        new String[] { "LuxuryCar", "Motorhome", "SmallCar", "Trailer", "Truck" });
    typeComboBox.setSelectedItem(vehicleType);
    typeComboBox.setEnabled(vehicle == null);
    typeComboBox.addActionListener(e -> updateVehicleSpecificFieldVisibility());
    panel.add(typeLabel);
    panel.add(typeComboBox);

    nameLabel = new JLabel("Name");
    nameField = new JTextField();
    panel.add(nameLabel);
    panel.add(nameField);

    manufactureYearLabel = new JLabel("Manufacture Year");
    manufactureYearField = new JTextField();
    panel.add(manufactureYearLabel);
    panel.add(manufactureYearField);

    vinLabel = new JLabel("VIN");
    vinField = new JTextField();
    panel.add(vinLabel);
    panel.add(vinField);

    newPriceLabel = new JLabel("New Price");
    newPriceField = new JTextField();
    panel.add(newPriceLabel);
    panel.add(newPriceField);

    currentPriceLabel = new JLabel("Current Price");
    currentPriceField = new JTextField();
    panel.add(currentPriceLabel);
    panel.add(currentPriceField);

    odometerLabel = new JLabel("Odometer");
    odometerField = new JTextField();
    panel.add(odometerLabel);
    panel.add(odometerField);

    // Vehicle specific fields

    horsePowerLabel = new JLabel("Horse Power");
    horsePowerField = new JTextField();
    horsePowerLabel.setVisible(false);
    horsePowerField.setVisible(false);
    panel.add(horsePowerLabel);
    panel.add(horsePowerField);

    waterCapacityLabel = new JLabel("Water Capacity");
    waterCapacityField = new JTextField();
    waterCapacityLabel.setVisible(false);
    waterCapacityField.setVisible(false);
    panel.add(waterCapacityLabel);
    panel.add(waterCapacityField);

    seatsLabel = new JLabel("Seats");
    seatsField = new JTextField();
    seatsLabel.setVisible(false);
    seatsField.setVisible(false);
    panel.add(seatsLabel);
    panel.add(seatsField);

    trunkCapacityLabel = new JLabel("Trunk Capacity");
    trunkCapacityField = new JTextField();
    trunkCapacityLabel.setVisible(false);
    trunkCapacityField.setVisible(false);
    panel.add(trunkCapacityLabel);
    panel.add(trunkCapacityField);

    lengthLabel = new JLabel("Length");
    lengthField = new JTextField();
    lengthLabel.setVisible(false);
    lengthField.setVisible(false);
    panel.add(lengthLabel);
    panel.add(lengthField);

    payloadCapacityLabel = new JLabel("Payload Capacity");
    payloadCapacityField = new JTextField();
    payloadCapacityLabel.setVisible(false);
    payloadCapacityField.setVisible(false);
    panel.add(payloadCapacityLabel);
    panel.add(payloadCapacityField);

    if (vehicle != null) {
      nameField.setText(vehicle.name);
      manufactureYearField.setText(String.valueOf(vehicle.manufactureYear));
      vinField.setText(vehicle.vin);
      newPriceField.setText(String.valueOf(vehicle.newPrice));
      currentPriceField.setText(String.valueOf(vehicle.currentPrice));
      if (vehicle.odometer != null)
        odometerField.setText(String.valueOf(vehicle.odometer));

      switch (vehicleType) {
        case "LuxuryCar":
          horsePowerField.setText(String.valueOf(((LuxuryCar) vehicle).horsePower));
          break;
        case "Motorhome":
          waterCapacityField.setText(String.valueOf(((Motorhome) vehicle).waterCapacity));
          break;
        case "SmallCar":
          seatsField.setText(String.valueOf(((SmallCar) vehicle).seats));
          trunkCapacityField.setText(String.valueOf(((SmallCar) vehicle).trunkCapacity));
          break;
        case "Trailer":
          lengthField.setText(String.valueOf(((Trailer) vehicle).length));
          break;
        case "Truck":
          payloadCapacityField.setText(String.valueOf(((Truck) vehicle).payloadCapacity));
          break;

        default:
          break;
      }
    }

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(this::saveButtonActionPerformed);
    panel.add(saveButton);

    scrollPane.setViewportView(panel);
    add(scrollPane);
  }

  private void updateVehicleSpecificFieldVisibility() {
    String vehicleType = (String) typeComboBox.getSelectedItem();

    horsePowerField.setVisible(vehicleType.equals("LuxuryCar"));
    horsePowerLabel.setVisible(vehicleType.equals("LuxuryCar"));

    waterCapacityField.setVisible(vehicleType.equals("Motorhome"));
    waterCapacityLabel.setVisible(vehicleType.equals("Motorhome"));

    seatsField.setVisible(vehicleType.equals("SmallCar"));
    seatsLabel.setVisible(vehicleType.equals("SmallCar"));

    trunkCapacityField.setVisible(vehicleType.equals("SmallCar"));
    trunkCapacityLabel.setVisible(vehicleType.equals("SmallCar"));

    lengthField.setVisible(vehicleType.equals("Trailer"));
    lengthLabel.setVisible(vehicleType.equals("Trailer"));

    odometerField.setVisible(!vehicleType.equals("Trailer"));
    odometerLabel.setVisible(!vehicleType.equals("Trailer"));

    payloadCapacityField.setVisible(vehicleType.equals("Truck"));
    payloadCapacityLabel.setVisible(vehicleType.equals("Truck"));
  }

  private void saveButtonActionPerformed(ActionEvent evt) {
    try {
      String name = nameField.getText();
      int manufactureYear = Integer.parseInt(manufactureYearField.getText());
      String vin = vinField.getText();
      double newPrice = Double.parseDouble(newPriceField.getText());
      double currentPrice = Double.parseDouble(currentPriceField.getText());
      Integer odometer = null;
      if (!odometerField.getText().isEmpty()) {
        odometer = Integer.parseInt(odometerField.getText());
      }

      String vehicleType = (String) typeComboBox.getSelectedItem();

      switch (vehicleType) {
        case "LuxuryCar":
          int horsePower = Integer.parseInt(horsePowerField.getText());
          if (vehicle == null) {
            DataStore
                .addVehicle(new LuxuryCar(name, manufactureYear, vin, newPrice, currentPrice, odometer, horsePower));
          } else {
            ((LuxuryCar) vehicle).horsePower = horsePower;
          }
          break;
        case "Motorhome":
          Integer waterCapacity = Integer.parseInt(waterCapacityField.getText());
          if (vehicle == null) {
            DataStore.addVehicle(new Motorhome(name, manufactureYear, vin, newPrice,
                currentPrice, odometer, waterCapacity));
          } else {
            ((Motorhome) vehicle).waterCapacity = waterCapacity;
          }
          break;
        case "SmallCar":
          int seats = Integer.parseInt(seatsField.getText());
          Integer trunkCapacity = Integer.parseInt(trunkCapacityField.getText());
          if (vehicle == null) {
            DataStore.addVehicle(new SmallCar(name, manufactureYear, vin, newPrice,
                currentPrice, odometer, seats, trunkCapacity));
          } else {
            ((SmallCar) vehicle).seats = seats;
            ((SmallCar) vehicle).trunkCapacity = trunkCapacity;
          }
          break;
        case "Trailer":
          double length = Double.parseDouble(lengthField.getText());
          if (vehicle == null) {
            DataStore.addVehicle(new Trailer(name, manufactureYear, vin, newPrice,
                currentPrice, length));
          } else {
            ((Trailer) vehicle).length = length;
          }
          break;
        case "Truck":
          Integer payloadCapacity = Integer.parseInt(payloadCapacityField.getText());
          if (vehicle == null) {
            DataStore.addVehicle(new Truck(name, manufactureYear, vin, newPrice,
                currentPrice, odometer, payloadCapacity));
          } else {
            ((Truck) vehicle).payloadCapacity = payloadCapacity;
          }
          break;

        default:
          break;
      }

      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
