
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0){
			System.out.println("No arguments");
		}
		else if (args.length > 1) {
			System.out.println("Too many arguments");
		}
		else {
			DieComb d = new DieComb(args[0]);
			
			d.roll();
			System.out.println(d.toString());
		}
		
	}

}
