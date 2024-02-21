import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordList {
  private ArrayList<String> words = new ArrayList<String>();
  private Random rand = new Random();

  public WordList(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner reader = new Scanner(file);
    while (reader.hasNextLine()) {
      String word = reader.nextLine();
      this.words.add(word);
    }
    reader.close();
  }

  public WordList() throws FileNotFoundException {
    this("./src/wordlist.txt");
  }

  public String getRandomWord() {
    int index = rand.nextInt(this.words.size());
    return this.words.get(index);
  }
}
