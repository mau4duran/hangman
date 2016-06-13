import java.io.Console;

public class Prompter{

	private Game mGame;

	//constructor (has the same name of the class)

	public Prompter(Game game){

		mGame=game;

	}

	public void play(){

		while (mGame.getRemainingTries()>0){

			displayProgress();

			promptForGuess();

			

		}

	}


	public boolean promptForGuess(){

		Console console = System.console();

		boolean isHit = false;

		boolean isValidGuess = false;

		while(!isValidGuess){

		String guessAsString = console.readLine("Enter a letter: ");

		char guess = guessAsString.charAt(0);

		try {

			isHit = mGame.applyGuess(guess);

			isValidGuess=true;

		}	catch(IllegalArgumentException iae){

				console.printf("%s. Please try again. \n", iae.getMessage());

		}


		}

		return isHit;
		

	}

	public void displayProgress(){

		// %d refers to a number variable (d is for decimal)

		System.out.printf("You have: %d tries. Try to solve: %s\n", mGame.getRemainingTries(), mGame.getCurrentProgress() );


	}


	//example.charAt(0);

}