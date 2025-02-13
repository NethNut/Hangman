public class Game {
    public String hiddenWord;
    public String fillerWord;
    public int attemptsLeft;

    public Game(String word, int attempts) {
        hiddenWord = word;
        fillerWord = "";
        for (int i = 0; i < word.length(); i++) {
            fillerWord += "_";
        }
        attemptsLeft = attempts;
    }

    public String getfillerWord() {
        return fillerWord;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void decreaseAttempts() {
        attemptsLeft = attemptsLeft - 1;
    }

    public void revealLetter(String guessedLetter) {
        String newfillerWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.substring(i, i + 1).equals(guessedLetter)) {
                newfillerWord += guessedLetter;
            } else {
                newfillerWord += fillerWord.substring(i, i + 1);
            }
        }
        fillerWord = newfillerWord;
    }

    public boolean isWordGuessed() {
        return fillerWord.equals(hiddenWord);
    }
}