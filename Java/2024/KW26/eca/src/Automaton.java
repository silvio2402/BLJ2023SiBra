import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implements an elementary cellular automaton. See
 * {@link https://en.wikipedia.org/wiki/Elementary_cellular_automaton } for
 * clarification.
 *
 */
public class Automaton {

  private String rule;
  private String currentGeneration;

  private List<String> history = new ArrayList<>();

  /**
   * This constructor initializes this Automaton with a given rule and an initial
   * generation. Once initialized, the values cannot be changed later.
   * 
   * @param rule              The rule to determine the value of a cell in the
   *                          next generation. Expected is a String representing a
   *                          binary value between 00000000 and 11111111.
   * @param initialGeneration The first generation of this Automaton, which also
   *                          makes it the basis for all future generations.
   *                          Expected is a String having only ones and zeros and
   *                          a minimal length of 3.
   * 
   * @throws IllegalArgumentException if the given rule doesn't match the pattern
   *                                  <code>[01]{8}</code> or the initial state
   *                                  doesn't match <code>[01]{3,}</code>.
   */
  public Automaton(String rule, String initialGeneration) throws IllegalArgumentException {
    if (!rule.matches("[01]{8}"))
      throw new IllegalArgumentException("The rule must be a binary value of length 8.");
    this.rule = rule;
    if (!initialGeneration.matches("[01]{3,}"))
      throw new IllegalArgumentException("The initial generation must be a binary value of length 3 or more.");
    this.currentGeneration = initialGeneration;
  }

  /**
   * This constructor initializes this Automaton with a given rule and an initial
   * generation. Once initialized, the values cannot be changed later.
   * 
   * @param rule              The rule to determine the value of a cell in the
   *                          next generation. Expected is an integer value
   *                          between 0 and 255.
   * @param initialGeneration The first generation of this Automaton, which also
   *                          makes it the basis for all future generations.
   *                          Expected is a String having only ones and zeros and
   *                          a minimal length of 3.
   */
  public Automaton(int rule, String initialGeneration) {
    this(Integer.toBinaryString(rule | 0b100000000).substring(1), initialGeneration);
  }

  /**
   * This method advances this Automatons generation by one. This is done by using
   * the given rule and the current generation, with the latter changing
   * every time this method gets called. All generations get saved in
   * {@link #history}.
   * 
   * @return a String representing the next generation.
   */
  public String nextGeneration() {
    String nextGeneration = "";
    for (int i = 0; i < this.currentGeneration.length(); i++) {
      int left = i == 0 ? 0 : this.currentGeneration.charAt(i - 1) - '0';
      int center = this.currentGeneration.charAt(i) - '0';
      int right = i == this.currentGeneration.length() - 1 ? 0 : this.currentGeneration.charAt(i + 1) - '0';
      nextGeneration += this.rule.charAt(7 - (left << 2 | center << 1 | right));
    }
    this.history.add(this.currentGeneration);
    this.currentGeneration = nextGeneration;
    return nextGeneration;
  }

  /**
   * This method advances this Automaton by any number of generations. Since with
   * every iteration, {@link #nextGeneration()} gets called, all generations up to
   * the one that was advanced to will get saved in {@link #history}.
   * 
   * @param numGenerations The number of generations to advance.
   */
  public void run(int numGenerations) {
    for (int i = 0; i < numGenerations; i++)
      this.nextGeneration();
  }

  /**
   * This method prints all generations that were recorded up until this point
   * chronologically in the console. The output can be formatted using the
   * arguments, which will replace the 0-states and 1-states respectively.
   * 
   * @param state0Char The character to replace the 0 state with.
   * @param state1Char The character to replace the 1 state with.
   */
  public void printHistory(char state0Char, char state1Char) {
    for (String generation : this.getHistory())
      System.out.println(generation.replace('0', state0Char).replace('1', state1Char));
  }

  public String getBinaryRule() {
    return this.rule;
  }

  public int getIntegerRule() {
    return Integer.parseInt(this.rule, 2);
  }

  public String getCurrentGeneration() {
    return this.currentGeneration;
  }

  public List<String> getHistory() {
    return this.history;
  }
}