package dices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//represents a set of dice
public class DiceCombination {
	
	private DiceArgument argument;
	private int quant = 0; 
	private int sides = 0;
	private int mod = 0;
	
	private ArrayList<Dice> dices;
	
	public DiceCombination(){
		this.dices = new ArrayList<Dice>();
	}
	
	/**
	 * Creates a combination using an valid Dice Argument;
	 * @param argument
	 */
	public DiceCombination(DiceArgument argument){
		this();
		this.argument = argument;
		this.sides = this.argument.getSides();
		this.quant = this.argument.getQuant();
		this.mod = this.argument.getMod();
		
		for(int i = 0; i < quant ; i++){
			dices.add(new Dice(sides));
		}
	}
	
    /**
     *  The roll is produced and stored
     *  
     * @return array containing the results of the roll,
     *         in the first position the modifier,
     *         in the last the total of the roll,
     *         in the middle the individual values
     */
    public int[] roll(){
        int[] tir;                  //Create the Array
        int total = this.mod;
        tir = new int[quant + 2];
        
        int i = 0;
        int result;
        tir[i] = this.mod;
        i++;
        
        for(int j = 0; j < dices.size();j++){
        	result = dices.get(j).roll();
        	total += result;
        	tir[i] = result;
        	i++;
        }
        
        tir[i]=total;
        return tir;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.argument.toString();
    }

	public int getQuant() {
		return quant;
	}

	public int getSides() {
		return sides;
	}

	public int getMod() {
		return mod;
	}
    
    
}