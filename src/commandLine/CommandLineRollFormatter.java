package commandLine;
import dices.DiceCombination;
import dices.Roll;


public class CommandLineRollFormatter {

	public CommandLineRollFormatter(){
		
	}
	
	public String showRoll(Roll roll){
		String values = this.stringValues(roll.getValues());
		
		String salida = String.format(
    			"Mods:\t%s\n"
    			+ "Values:\t%s\n"
    			+ "Total: \t%d",
    			roll.getMod(),
    			values,
    			roll.getTotal());
		
    	return salida;
		
	}
	
	public String showRoll(DiceCombination combination, Roll roll){
		
		String salida = String.format(
    			"Roll:\t%s\n"
				+ "%s\n",
				combination.toString(),
				showRoll(roll));
		
    	return salida;
	}

	
	private String stringValues(int[] values){
		String ret = "";
		
		for(int i = 0; i< values.length ; i++){
			ret = ret + String.valueOf(values[i]);
			
			if(((i%values.length) == 0) && (i != values.length-1)){
				ret = ret + ", ";
			}
		}
		
		return ret;
	}
}
