/*
    In this class is where the Die Combinations 
    are defined to be used in the Rolls

 */
package dados;

import java.util.Random;
/*
*   Para generar valor entre min y max
*   Random rdm = new Random();
*   int <randomcontainer> = rdm.nextInt((max- min)+1) + min;
*/

public class DieComb {
    int quant;  //quantos :B
    int faces;
    int mods = 0;
    
    /*
    * Pick up the modifiers and set them
    */
    public void SetMods (int m){
        mods = m;
    }
    
    /*
    * Set the quantity of dice and their faces, one kind of dice
    * b = how many faces?
    * a = how many dices?
    */
    public void SetQuantAndFaces(int a, int b) {
        quant = a;
        faces = b;
    } 
    
    /**
     *  The Roll is produced and stored
     *  
     * @return list of the results of the roll
     *         in the first position the modifier
     *         in the last the total of the roll
     *         in the middle the individual rolls
     */
    public int[] Roll(){
        Random rdm;
        rdm = new Random();
        int[] tir;                  //Create the list
        tir = new int[quant + 2];
        
        tir[0] = mods;              //Assign Modifiers
        tir[quant+1] = tir[0];
        
        for (int i = 1; i < quant+1; i++){
            tir[i] = rdm.nextInt(faces)+ 1; //min = 1 ; max = faces
            tir[quant+1] += tir[i];   // quant +1, cause out of bounds
        }
        
        return tir;
    }
    
}
