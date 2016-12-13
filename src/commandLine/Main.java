package commandLine;
import dices.*;

public class Main {
	public static void main(String[] args) {
		try{
			DiceCombination test = new DiceCombination(new DiceArgument("3d6+3"));
			
			Roll tirada = new Roll(test.roll());

			System.out.println(new CommandLineRollFormatter().showRoll(test, tirada));
			
		}
		catch(InvalidDiceCommandException e){
			System.out.println(e.getMessage());
		}
	}
}
