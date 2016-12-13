package dices;

public class InvalidDiceCommandException extends Exception {
	private String message;
	
	public InvalidDiceCommandException(){
		this.message = "Invalid Command";
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
}
