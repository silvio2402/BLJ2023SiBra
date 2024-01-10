import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class is responsible for handling and running a simulation of Conway's
 * Game of Life.
 * 
 * @author surber
 * @author Silvio Braendle
 *
 */
public class Simulation extends Thread {
  private int interval;
  private boolean wrapAround;
  private int[][] field;

  private PropertyChangeSupport pCS;
  private volatile boolean running;

  public Simulation(int interval, boolean wrapAround) {
    this.interval = interval;
    this.wrapAround = wrapAround;

    pCS = new PropertyChangeSupport(this);
    running = true;
  }

  public Simulation(int interval, boolean wrapAround, int[][] field) {
    this(interval, wrapAround);

    this.field = field;
  }

  private boolean isInBounds(int x, int y) {
    return x >= 0 && x < field.length && y >= 0 && y < field[0].length;
  }

  private void update() {
    int[][] newField = new int[field.length][field[0].length];

    // Iterate over all cells
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        // Count the number of living neighbors
        int livingNeighbors = 0;
        for (int k = -1; k <= 1; k++) {
          for (int l = -1; l <= 1; l++) {
            if (k == 0 && l == 0) {
              continue;
            }

            int x = i + k;
            int y = j + l;

            if (wrapAround) {
              x = Math.floorMod(x, field.length);
              y = Math.floorMod(y, field[0].length);
            } else if (!isInBounds(x, y)) {
              continue;
            }

            if (field[x][y] > 0) {
              livingNeighbors++;
            }
          }
        }

        // Apply the rules
        if (field[i][j] > 0) {
          newField[i][j] = (livingNeighbors < 2 || livingNeighbors > 3) ? 0 : 1;
        } else {
          newField[i][j] = (livingNeighbors == 3) ? 1 : 0;
        }
      }
    }

    // Stop if nothing changes
    if (newField == field) {
      stopSimulation();
    }

    pCS.firePropertyChange("field", field, newField);
    field = newField;
  }

  private void startSimulation() {
    while (running) {
      try {
        update();
        Thread.sleep(interval);
      } catch (InterruptedException e) {
      }
    }
  }

  public void stopSimulation() {
    running = false;
  }

  /**
   * inherited from {@link Thread}
   */
  @Override
  public void run() {
    timeoutStart(1000);
    startSimulation();
  }

  private void timeoutStart(int timeout) {
    pCS.firePropertyChange("field", null, field);
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
    }
  }

  public void addListener(PropertyChangeListener pCL) {
    pCS.addPropertyChangeListener(pCL);
  }

  public int getFieldWidth() {
    return field[0].length;
  }

  public int getFieldHeight() {
    return field.length;
  }
}