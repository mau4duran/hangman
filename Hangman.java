import java.io.Console;

public class Hangman {
    
    public static void main(String[] args) {
       
      //The following creates a new object of class "game" and name game with an Answer of "TreeHouse" 

      Game game = new Game("treehouse");

      //a char is a type of content. Example char myGuess = 'A';

      //example.indexOF('x')

      Prompter prompter = new Prompter(game);

      prompter.play();
      
      

    }


}