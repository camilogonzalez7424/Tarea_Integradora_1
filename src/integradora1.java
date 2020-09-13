import java.util.Scanner;
public class integradora1{
	public static final int BLACK=1300000;
	public static final int WHITE=2600000;
	public static final int PAINTING=980000;
		public static void main(String[] args){
		    Scanner reader = new Scanner(System.in);
		    System.out.println("Ingrese la cantidad de materiales que contiene la lista");
		    int materials = reader.nextInt();
		    String[] names = new String[materials];
		    double[] amount = new double[materials];
		    String[] typeuse = new String[materials];
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
	}
}