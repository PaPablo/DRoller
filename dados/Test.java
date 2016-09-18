
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0){
			System.out.println("No hay argumentos");
		}
		else if (args.length > 1) {
			System.out.println("Mas argumentos de los validos");
		}
		else {
			DieComb d = new DieComb(args[0]);
			
			d.roll();
			System.out.println(d.toString());
		}
		
	}

}
