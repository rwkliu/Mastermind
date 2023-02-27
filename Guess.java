import java.util.Scanner;

public class Guess {
  private String playerGuess;

  public Guess() {
    this.playerGuess = null;
  }
  
  public String getPlayerGuess() {
    return this.playerGuess;
  }

  public void getInput() {
    Scanner input = new Scanner(System.in);
    input.reset();
    if (input.hasNext()) {
      this.playerGuess = input.next();
    } else {
      this.playerGuess = null;
    }
    // input.close();
  }

  public boolean validInput() {
    if (playerGuess.length() != 4) {
      return false;
    }

    for (char c : playerGuess.toCharArray()) {
      if (c < '0' || c > '8') {
        return false;
      }
    }
    return true;
  }

  public boolean matchSecretCode(String secretCode) {
    int misplaced = 0;
    int wellPlaced = 0;

    if (playerGuess.equals(secretCode)) {
      System.out.println("Congratz! You did it!");
      return true;
    } 
    for (int i = 0; i < 4; i++) {
      if (playerGuess.charAt(i) == secretCode.charAt(i)) {
        wellPlaced++;
      } else if (secretCode.contains(playerGuess.substring(i,i))) {
        misplaced++;
      }
    }
    System.out.println("Well placed pieces: " + wellPlaced);
    System.out.println("Misplaced pieces: " + misplaced);
    return false;
  }
}