import exceptions.InvalidWordException;

enum LetterState {
  CORRECT,
  PRESENT,
  ABSENT
}

public class WordleGame {
  private String word;
  private boolean hardMode;
  private String previousGuess = "     ";
  private LetterState[] previousResult = new LetterState[5];

  public WordleGame(WordList wordList, boolean hardMode) {
    this.word = wordList.getRandomWord();
    this.hardMode = hardMode;
  }

  public WordleGame(WordList wordList) {
    this(wordList, false);
  }

  public LetterState[] guessWord(String guess) throws InvalidWordException {
    if (guess.length() != 5) {
      throw new InvalidWordException("Guess must be 5 letters long.");
    }
    LetterState[] result = new LetterState[this.word.length()];
    guess = guess.toLowerCase();
    for (int i = 0; i < this.word.length(); i++) {
      char letter = this.word.charAt(i);
      char guessLetter = guess.charAt(i);
      LetterState previousLetterResult = this.previousResult[i];

      if (this.hardMode && previousLetterResult == LetterState.CORRECT && guessLetter != letter) {
        throw new InvalidWordException("You cannot change a correct letter.");
      }

      if (letter == guessLetter) {
        result[i] = LetterState.CORRECT;
      } else if (this.word.indexOf(guessLetter) != -1) {
        result[i] = LetterState.PRESENT;
      } else {
        result[i] = LetterState.ABSENT;
      }
    }

    // check all previously present letters are in the guess
    for (int i = 0; i < this.word.length(); i++) {
      char letter = this.word.charAt(i);
      char guessLetter = guess.charAt(i);
      char previousGuessLetter = this.previousGuess.charAt(i);
      LetterState previousLetterResult = this.previousResult[i];
      if (previousLetterResult == LetterState.PRESENT && guessLetter != letter
          && guess.indexOf(previousGuessLetter) == -1) {
        throw new InvalidWordException("You cannot remove a previously present letter.");
      }
    }

    this.previousGuess = guess;
    this.previousResult = result;
    return result;
  }

  public boolean isCorrect(String guess) {
    return this.word.equals(guess);
  }
}
