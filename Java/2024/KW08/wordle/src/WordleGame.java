enum LetterState {
  CORRECT,
  PRESENT,
  ABSENT
}

public class WordleGame {
  private String word;

  public WordleGame(WordList wordList) {
    this.word = wordList.getRandomWord();
  }

  public LetterState[] guessWord(String guess) {
    LetterState[] result = new LetterState[this.word.length()];
    for (int i = 0; i < this.word.length(); i++) {
      char letter = this.word.charAt(i);
      char guessLetter = guess.charAt(i);
      if (letter == guessLetter) {
        result[i] = LetterState.CORRECT;
      } else if (this.word.indexOf(guessLetter) != -1) {
        result[i] = LetterState.PRESENT;
      } else {
        result[i] = LetterState.ABSENT;
      }
    }
    return result;
  }

  public boolean isCorrect(String guess) {
    return this.word.equals(guess);
  }
}
