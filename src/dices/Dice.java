package dices;
import java.util.Random;
//represents a single dice
public class Dice{
	private int sides;

	/**
	*	Constructor 
	* @param sides number of faces of the dice
	*/
	public Dice(int sides){
		this.sides = sides;
	}

	/**
	* Default constructor, creates a D6
	*/
	public Dice(){
		this(6);
	}

	public int roll(){
	Random rdm = new Random();
	int number = rdm.nextInt(this.sides) + 1;
	return number;
	}

}