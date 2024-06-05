package View;

import javax.swing.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    super("Vehicle Rental Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);
    setLocationRelativeTo(null);

    createUI();

    setVisible(true);
  }

  private void createUI() {
    JTabbedPane tabbedPane = new JTabbedPane();

    tabbedPane.addTab("Customers", new CustomersPanel());
    tabbedPane.addTab("Vehicles", new VehiclesPanel());
    tabbedPane.addTab("Contracts", new ContractsPanel());
    // tabbedPane.addTab("Contracts", new ContractTable()); // Not implemented
    // tabbedPane.addTab("Black List", new BlackListTable()); // Not implemented
    tabbedPane.addTab("Test", new JLabel("Hello World"));

    add(tabbedPane);
  }

}