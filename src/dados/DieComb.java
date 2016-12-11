/*
    In this class is where the Die Combinations 
    are defined to be used in the Rolls

 */

import java.util.Arrays;
import java.util.Random;
/*
*   Para generar valor entre min y max
*   Random rdm = new Random();
*   int <randomcontainer> = rdm.nextInt((max- min)+1) + min;
*/

public class DieComb {
    private int quant;  //quantos :B
    private int faces;
    private int mod;
    private String title;
    int[] tirada;

   
    /**
     * 
     * @param quant How many die you want to roll
     * @param faces The faces of those
     * @param mod 	Roll Modifier
     */
    
    public DieComb(int quant, int faces, int mod){
    	this.quant = quant;
    	this.faces = faces;
    	this.mod = mod;
    	this.title = String.format("%dd%d%d", this.quant,this.faces,this.mod);
    }
    
    /**
     * @param quant How many die you want to roll
     * @param faces The faces of those
     * If you dont pass a modifier, it becomes a 0
     */
    public DieComb(int quant, int faces){
    	this(quant, faces, 0);
    }
    
    /**
     * 
     * @param command argument from command line
     */
    public DieComb(String command){
    	this.diceCommand(command);
    	this.title = command;
    }
    
    /**
     * @param mod Modifier of the roll (by default is 0)
     */
    public void setMod(int mod){
        this.mod = mod;
    }
    
    
    /**
     *  The roll is produced and stored
     *  
     * @return array containing the results of the roll
     *         in the first position, the modifier
     *         in the last, the total of the roll
     *         in the middle, the individual rolls
     */
    public int[] roll(){
        Random rdm;
        rdm = new Random();
        int[] tir;                  //Create the list
        tir = new int[quant + 2];
        
        tir[0] = mod;              //Assign Modifiers
        tir[quant+1] = tir[0];
        if(quant != 0 && faces != 0){
        	for (int i = 1; i < quant+1; i++){
                tir[i] = rdm.nextInt(faces)+ 1; //min = 1 ; max = faces
                tir[quant+1] += tir[i];   // quant +1, cause out of bounds
            }
        } else{
        	tir[1] += 0;
        }
        Arrays.sort(tir);
        this.tirada = tir;
        return tir;
    }
    
    private String getMods(){
    	String out = "";
    	if(this.mod > 0) out += "+";
    	else out += "-";
    	
    	out += this.mod;
    	
    	return out;
    }
    
    private String valores(){
    	String salida = "";
    	for(int i = 1; i< this.tirada.length-1; i++){
    		salida += this.tirada[i] + " ";
    	}
    	return salida;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	
    	String salida = String.format(
    			"Roll:\t%s\n"
    			+ "Mods:\t%s\n"
    			+ "Values:\t%s\n"
    			+ "Total: \t%d",
    			this.title,
    			this.getMods(),
    			this.valores(),
    			this.tirada[tirada.length-1]);
    	return salida;
    }
    
    /**
     * @param comm command form command line
     * @return true if the command is valid, false if not
     */
    public boolean diceCommand(String comm){
    	String quant = "";
    	String faces = "";
    	String mod = "";
    	
    	//if starts with a character, false
    	if (Character.isDigit(comm.charAt(0))){
    		int i = 0;
    		
            //THIS COULD BE MODULARIZED
            
    		//while there is numbers, build the quant, if I find a letter, exit
    		while (comm.charAt(i) != 'd' && comm.charAt(i) != 'D' && i < comm.length()){
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
    		this.faces = Integer.parseInt(faces);
    		
    		//now that i have quant and faces, check if they are cero
    		//you can't roll 0 dices or a dice with 0 sides
    		// if I reache the end of the String
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
    
    
}
