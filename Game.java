public class Game {
  private String mAnswer;

  //The following (two) variables are created to store when a person guesses a letter right or misses 

  private String mHits;

  private String mMisses;


  /*the following variable is related to the number of tries a user has to guess the word, therefore it is public,
   it is static because it is not limited to the class and final because the content of the variable is going to be constant */

  public static final int MAX_MISSES=7;
  
  //The following is a constructor that sets an answer to the variable mAnswer
  public Game(String Answer) {

    mAnswer = Answer; 

    mHits = "";

    mMisses = "";

  }



  //the code that follows makes sure that a guess is a letter
  private char validateGuess(char letter){

  	if(! Character.isLetter(letter)){

  		throw new IllegalArgumentException("A letter is required");

  	} letter = Character.toLowerCase(letter);



  	if (mMisses.indexOf(letter)>=0 || mHits.indexOf(letter)>=0){

		throw new IllegalArgumentException(letter + " has already been guessed");

	}


	return letter;

  }


  //method that allows us to apply a guess toward a puzzle

  public boolean applyGuess(char letter){

  	letter = validateGuess(letter);

  	//in this case, index of is used in order to find out if the guessed letter is contained in the Answer to the game

  	boolean isHit = mAnswer.indexOf(letter) >= 0; 

  	if(isHit) {

  		mHits += letter;

  	} else {

  		mMisses += letter;

  	}

  	return isHit;

  }

  // .toCharArray() : método que convierte un String en un array de Characters

  public String getCurrentProgress(){

  	String progress="";

  	for (char letter : mAnswer.toCharArray()) {
  		char display= '-';

  		if(mHits.indexOf(letter) >= 0){

  			display = letter; 

  		}

  		progress += display;

  	}

  	return progress;

  }

  public int getRemainingTries(){

  	return MAX_MISSES - mMisses.length();

  }

}













