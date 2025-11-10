import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WordMatch ggame;

        System.out.println("mississippi:");
        WordMatch game1 = new WordMatch("mississippi");
        System.out.println(game1.scoreGuess("i"));
        System.out.println(game1.scoreGuess("iss"));
        System.out.println(game1.scoreGuess("issipp"));
        System.out.println(game1.scoreGuess("mississippi"));

        System.out.println("aaaabb:");
        WordMatch game2 = new WordMatch("aaaabb");
        System.out.println(game2.scoreGuess("a"));
        System.out.println(game2.scoreGuess("aa"));
        System.out.println(game2.scoreGuess("aaa"));
        System.out.println(game2.scoreGuess("aabb"));
        System.out.println(game2.scoreGuess("c"));

        System.out.println("Concatenation:");
        WordMatch game = new WordMatch("Concatenation");
        System.out.println(game.scoreGuess("ten"));
        System.out.println(game.scoreGuess("nation"));
        System.out.println(game.findBetterGuess("ten", "nation"));
        System.out.println(game.scoreGuess("con"));
        System.out.println(game.scoreGuess("cat"));
        System.out.println(game.findBetterGuess("con", "cat"));

        System.out.println("Challenge:");
        System.out.println(read());

    }
    public static int read() throws FileNotFoundException{
        int totScore = 0;
        File guessesFile = new File("Guesses.txt");
        Scanner guessesScan = new Scanner(guessesFile);
        while (guessesScan.hasNextLine()){
            String word = guessesScan.next();
            String fisrtGuess = guessesScan.next();
            String secondGuess = guessesScan.next();
            WordMatch game = new WordMatch(word);
            String betterGuess = game.findBetterGuess(fisrtGuess, secondGuess);
            int scoreOfBetterGuesses = game.scoreGuess(betterGuess);
            totScore += scoreOfBetterGuesses;
        }
        return totScore;
    }
}