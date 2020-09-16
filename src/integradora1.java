//Recordar pasar los mensajes ingles poco a poco.
import java.util.Scanner; //Importar Scanner
public class integradora1{
	public static Scanner reader = new Scanner(System.in); //Declarar el Scanner como variable globla o atributo.
	public static final int ROUGHCONSTRUCTION=1300000; //Constate para los valores fijos de la mano de obra negra. 
	public static final int FINALCONSTRUCTION=2600000; //Constate para los valores fijos de la mano de obra blanca. 
	public static final int PAINTING=980000; //Constate para los valores fijos de la pintura. 
		public static void main(String[] args){
		    System.out.println("Ingrese la cantidad de materiales que contiene la lista");
		    int materials = reader.nextInt(); //Variable input, utilizada para dar el tamaño de la y asimismo a los array.
		    String[] names = new String[materials]; //Array utilizado para los nombres de cada material.
		    double[] amount = new double[materials]; //Array utilizado para la cantidad de cada material.
		    String[] typeuse = new String[materials]; //Array utilizado para el tipo de utilidad de cada material.
			double[] homeCenter=new double[materials]; //Array utilizado para los valores de los materiales en HomeCenter.
			double[] hardwarestore=new double[materials];//Array utilizado para los valores de los materiales en la ferreteria del centro.
			double[] neighborhood=new double[materials];//Array utilizado para los valores de los materiales en la ferreteria del barrio.
		    reader.nextLine();
		    for(int i = 0;i<materials;i++){
		        System.out.println("Ingrese el nombre del material "+(i+1));
		        names[i] = reader.nextLine();
		       
		        System.out.println("Ingrese la cantidad del material "+(i+1)+" es decir: " + names[i]);
		        amount[i] = reader.nextDouble();
				reader.nextLine();
		        System.out.println("Ingrese el tipo de utilizacion del material "+(i+1)+" es decir: " + names[i]);
		        typeuse[i] = reader.nextLine();
				
		    }
			/*for(int i=0;i<materials;i++){
			System.out.println("El precio del producto "+names[i]+" en HomeCenter es "+valuesH(names,homeCenter,materials));
			}*/
	}
	/*Problema para el Camilo del futuro, estos metodos no se como devolverlos para imprimir, pero si guardan los datos.
	Posible solucion convertirlos tambien como void para imprimirlos (Investigar)*/
	public static double[] valuesH(String[] names, double[] homeCenter, int materials){
	
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria HomeCenter.");
			homeCenter[i]=reader.nextDouble();
		}
		return homeCenter;

}
	
	public static double[] valuesC(String[] names, double[] hardwarestore, int materials){
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria del centro.");
			hardwarestore[i]=reader.nextDouble();
		}
		return hardwarestore;
}
	
	public static double[] valuesB(String[] names, double[] neighborhood, int materials){
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria del barrio.");
			neighborhood[i]=reader.nextDouble();
		}
		return neighborhood;
}
	
}