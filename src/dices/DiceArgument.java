package dices;

public class DiceArgument{
	private String argument;
	private int quant;
	private int sides;
	private int mod;
	
	public DiceArgument(String arg) throws InvalidDiceCommandException{
		if(isValidDiceCommand(arg)){
			this.argument = arg;
		}
		else throw new InvalidDiceCommandException();
	}
	
	/**
     * @param comm command form command line
     * @return true if the command is valid, false if not
     */
    public boolean isValidDiceCommand (String comm){
    	String quant = "";
    	String faces = "";
    	String mod = "";
    	
    	//if starts with a character, false
    	if (Character.isDigit(comm.charAt(0))){
    		int i = 0;
    		
            //THIS COULD BE MODULARIZED
            
    		//while there is numbers, build the quant, if I find a letter, exit
    		while (i < comm.length() && comm.charAt(i) != 'd' && comm.charAt(i) != 'D'){
    			if(Character.isDigit(comm.charAt(i))){
    				quant += comm.charAt(i);
    			}
    			else {
    				return false;
    			}
    			i++;
    		}
    		this.quant = Integer.parseInt(quant);
    		i++;
    		//go for the faces
    		while( i < comm.length() && comm.charAt(i) != '+' && comm.charAt(i) != '-'){
    			if(Character.isDigit(comm.charAt(i))){
    				faces += comm.charAt(i);
    			}
    			else {
    				return false;
    			}
    			i++;
    		}
    		this.sides = Integer.parseInt(faces);
    		
    		//now that i have quant and faces, check if they are cero
    		//you can't roll 0 dices or a dice with 0 sides
    		// if I reach the end of the String
    		if(i == comm.length()){
    			this.mod = 0;
    			return true;
    		}
    		
    		//get the sign of the modifier
    		mod += comm.charAt(i++);
    		
    		//check the modifier
    		while(i < comm.length()){
    			if(Character.isDigit(comm.charAt(i))){
    				mod += comm.charAt(i);
        			i++;
    			}else {
    				return false;
    			}
    			this.mod = Integer.parseInt(mod);
    		}
    		
    		return true;
    	} //end if first character is digit
    	
    	return false;
    	
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
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.argument;
    }
}

