package main;

import dados.DieComb;
import ventanas.RollWIndow;


public class DRoller {
    public static void main(String[] args) {
        /*DieComb x = new DieComb();
        int[] t = new int[4];
        x.SetMods(0);
        x.SetQuantAndFaces(2,6);
        try{
        t = x.Roll();
        } catch(ArrayIndexOutOfBoundsException exception){
        System.out.println("Fuera de Rango");
        }
        for(int i = 0; i < 4; i++){
        System.out.println(t[i]);
        }
         */ 

        RollWIndow vent;
        vent = new RollWIndow();
        vent.setVisible(true);
        
    }
    
}
