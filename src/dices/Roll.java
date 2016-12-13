package dices;
/**
 * Class to store a roll of a Set of Dice
 * @author pablo
 *
 */
public class Roll {
	private int[] roll;
	private int imod = 0;
	private int itotal;
	
	public Roll(int[] roll){
		this.roll = roll;
		this.itotal = this.roll.length-1;
	}
	
	public void setRoll(int[] roll) {
		this.roll = roll;
	}
	
	public int[] getRoll(){
		return this.roll;
	}
	
	public int getMod() {
		return roll[imod];
	}
	
	public int getTotal(){
		return roll[itotal];
	}

	public int[] getValues(){
		int[] values = new int[roll.length-2];
		int j = 1;
		for(int i = 0; i < values.length ; i++){
			values[i] = roll[j++];
		}
		return values;
	}
}
