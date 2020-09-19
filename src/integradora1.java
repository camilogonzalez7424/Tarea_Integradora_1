import java.util.Scanner; //Importar Scanner
/**
 * Clase integradora1 <br>
 *
 * main class <br>
 *
 * @author Camilo G.
 * @since 1.0
 */
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
		    int[] typeuse = new int[materials]; //Array utilizado para el tipo de utilidad de cada material.
			double[] homeCenter=new double[materials]; //Array utilizado para los valores de los materiales en HomeCenter.
			double[] hardwarestore=new double[materials];//Array utilizado para los valores de los materiales en la ferreteria del centro.
			double[] neighborhood=new double[materials];//Array utilizado para los valores de los materiales en la ferreteria del barrio.
		    reader.nextLine(); //limpiar el buffer
		    for(int i = 0;i<materials;i++){
		        System.out.println("Ingrese el nombre del material "+(i+1));
		        names[i] = reader.nextLine();
		       
		        System.out.println("Ingrese la cantidad del material "+(i+1)+" es decir: " + names[i]);
		        amount[i] = reader.nextDouble();
		        System.out.println("Digite el número correspondiente al tipo de utilizacion del material "+(i+1)+" es decir: " + names[i]);
				System.out.println("Obra Negra = 1\nObra Blanca = 2\nPintura = 3"); //Dato confiar en el usuario.
		        typeuse[i] = reader.nextInt();
				reader.nextLine();
		    }
			
			double[] valuesHomecenter=valuesH(names,homeCenter,materials);
			double[] valuesHardwarestore=valuesC(names,hardwarestore,materials);
			double[] valuesNeighborhood=valuesB(names,neighborhood,materials);
			boolean blackCheck = fin1(typeuse,materials);
			boolean whiteCheck = fin2(typeuse,materials);
			boolean paintingCheck = fin3(typeuse,materials);
			System.out.println("El valor total de los productos en HomeCenter es de "+totalFinalH(materials,homeCenter,amount,blackCheck,whiteCheck,paintingCheck));
			System.out.println("El valor total de los productos en la ferreteria del centro es de "+totalFinalC(materials,hardwarestore,amount,blackCheck,whiteCheck,paintingCheck));
			System.out.println("El valor total de los productos en la ferreteria del barrio es de "+totalFinalB(materials,neighborhood,amount,blackCheck,whiteCheck,paintingCheck));
			
			delevery(names,materials,amount,valuesHomecenter,valuesHardwarestore,valuesNeighborhood);
			list(materials,names,typeuse);
		}
	
	 /** 
     * Save the price of the materials in HomeCenter. <br>
	 * <b> pre: </b> previus arrays got to be filled.
     * @param names Type String. 
     * @param homeCenter Type Double.
     * @param materials Type Int.
	 * @return returns what the user enters.
     */
	public static double[] valuesH(String[] names, double[] homeCenter, int materials){
	
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria HomeCenter.");
			homeCenter[i]=reader.nextDouble();
		}
		return homeCenter;

}
	/** 
     * Save the price of the materials in central hardware store. <br>
	 * <b> pre: </b> previus arrays got to be filled.
     * @param names Type String. 
     * @param hardwarestore Type Double.
     * @param materials Type Int.
	 * @return returns what the user enters.
     */
	public static double[] valuesC(String[] names, double[] hardwarestore, int materials){
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria del centro.");
			hardwarestore[i]=reader.nextDouble();
		}
		return hardwarestore;
}
	/** 
     * Save the price of the materials in the hardware store of the neighborhood. <br>
	 * <b> pre: </b> previus arrays got to be filled.
     * @param names Type String. 
     * @param neighborhood Type Double.
     * @param materials Type Int.
	 * @return returns what the user enters.
     */
	public static double[] valuesB(String[] names, double[] neighborhood, int materials){
		for(int i = 0;i<materials;i++){
		System.out.println("Digite el valor del material: "+(i+1)+" es decir "+names[i]+" en la ferreteria del barrio.");
			neighborhood[i]=reader.nextDouble();
		}
		return neighborhood;
}
	/** 
     * Calculate the total price of the materials in HomeCenter. <br>
	 * <b> pre: </b> previus arrays got to be filled.
	 * @param materials Type Int.
     * @param amount Type Double. 
     * @param homeCenter Type Double.
	 * @param blackCheck Type Boolean.
	 * @param whiteCheck Type Boolean.
	 * @param paintingCheck Type Boolean.
	 * @return returns the total value of the materials in HomeCenter.
     */
	public static double totalFinalH(int materials, double[] homeCenter, double[] amount, boolean blackCheck, boolean whiteCheck, boolean paintingCheck){
		double totalHome = 0;
		for(int i = 0;i<materials;i++){
		totalHome+= amount[i]*homeCenter[i];
		
		}
		if(blackCheck==true){
			totalHome=totalHome+ROUGHCONSTRUCTION;
		}if(whiteCheck==true){
			totalHome=totalHome+FINALCONSTRUCTION;
		}if(paintingCheck==true){
			totalHome=totalHome+PAINTING;		
		}
		
	return totalHome;
	}
	/** 
     * Calculate the total price of the materials in central hardware store. <br>
	 * <b> pre: </b> previus arrays got to be filled.
	 * @param materials Type Int.
     * @param amount Type Double. 
     * @param hardwarestore Type Double.
	 * @param blackCheck Type Boolean.
	 * @param whiteCheck Type Boolean.
	 * @param paintingCheck Type Boolean.
	 * @return returns the total value of the materials in central hardware store.
     */
	public static double totalFinalC(int materials, double[] hardwarestore, double[] amount, boolean blackCheck, boolean whiteCheck, boolean paintingCheck){
		double totalhardwarestore = 0;
		for(int i = 0;i<materials;i++){
		totalhardwarestore+= amount[i]*hardwarestore[i];
		
		}
		if(blackCheck==true){
			totalhardwarestore=totalhardwarestore+ROUGHCONSTRUCTION;
		}if(whiteCheck==true){
			totalhardwarestore=totalhardwarestore+FINALCONSTRUCTION;
		}if(paintingCheck==true){
			totalhardwarestore=totalhardwarestore+PAINTING;		
		}
	return totalhardwarestore;
	}
	/** 
     * Calculate the total price of the materials in the hardware store of the neighborhood. <br>
	 * <b> pre: </b> previus arrays got to be filled.
	 * @param materials Type Int.
     * @param amount Type Double. 
     * @param neighborhood Type Double.
	 * @param blackCheck Type Boolean.
	 * @param whiteCheck Type Boolean.
	 * @param paintingCheck Type Boolean.
	 * @return returns the total value of the materials in the hardware store of the neighborhood.
     */
	public static double totalFinalB(int materials, double[] neighborhood, double[] amount,boolean blackCheck, boolean whiteCheck, boolean paintingCheck){
		double totalneighborhood = 0;
		for(int i = 0;i<materials;i++){
		totalneighborhood+= amount[i]*neighborhood[i];
		
		}
		if(blackCheck==true){
			totalneighborhood=totalneighborhood+ROUGHCONSTRUCTION;
		}if(whiteCheck==true){
			totalneighborhood=totalneighborhood+FINALCONSTRUCTION;
		}if(paintingCheck==true){
			totalneighborhood=totalneighborhood+PAINTING;		
		}
	return totalneighborhood;
	}

	
	
	public static boolean fin1(int[] typeuse, int materials){
	
		boolean x = false;
		
		for(int i=0;i<materials;i++){
		switch(typeuse[i]) {
			case 1:
				x = true;
				break;
			case 2:
				break;
			case 3:
				break;
			default:
	
		}
		}
		return x;
	}
	public static boolean fin2(int[] typeuse, int materials){
	
		boolean y = false;
		
		for(int i=0;i<materials;i++){
		switch(typeuse[i]) {
			case 1:
				break;
			case 2:
				y= true;
				break;
			case 3:
				break;
			default:
	
		}
		}
		return y;
	}
	public static boolean fin3(int[] typeuse, int materials){
	
		boolean z = false;
		
		for(int i=0;i<materials;i++){
		switch(typeuse[i]) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				z = true;
				break;
			default:
		}
			
		}
		return z;
	}
	
	public static void delevery(String[] names,int materials,double[] amount,double[] valuesHomecenter,double[] valuesHardwarestore,double[] valuesNeighborhood){
		double[] bestprice1 = new double[materials];
		double totalbest = 0;
		for(int i = 0; i<materials;i++){
			if(valuesHomecenter[i]<valuesHardwarestore[i]){
				bestprice1[i] = valuesHomecenter[i];
				System.out.println("El mejor lugar para comprar "+names[i]+" es "+"HomeCenter "+"con un precio de: "+bestprice1[i]);
			}else if(valuesHomecenter[i]>valuesHardwarestore[i]){
				bestprice1[i] = valuesHardwarestore[i];
				System.out.println("El mejor lugar para comprar "+names[i]+" es "+"la ferreteria del centro "+"con un precio de. "+bestprice1[i]);
			}
		}
		for(int i = 0; i<materials;i++){
			if(bestprice1[i]<valuesNeighborhood[i]){
				bestprice1[i] = bestprice1[i];
			}else if(bestprice1[i]>valuesNeighborhood[i]){
				bestprice1[i] = valuesNeighborhood[i];
				System.out.println("El mejor lugar para comprar "+names[i]+" es "+"la ferreteria del barrio "+"con un precio de "+bestprice1[i]);
			}
		}
		
		for(int i = 0; i<materials;i++){
			totalbest+= amount[i]*bestprice1[i];
		}
		System.out.println("El valor total de los materiales sin envios es: "+totalbest);
		
		System.out.println("Ingrese su ubicación\n 1: North \n 2: Center \n 3: South");
		int user = reader.nextInt();
		location place = null;
        switch (user) {
            case 1:
                place = location.NORTH;
                break;
            case 2:
                place = location.CENTER;
                break;
            case 3:
                place = location.SOUTH;
                break;
				default:
        }
		switch(place){
			case NORTH:
				if(totalbest<80000){
					System.out.println("El valor total de los materiales con envios es: "+(totalbest+120000));
				}else if(totalbest<300000){
					System.out.println("El valor total de los materiales con envios es: "+(totalbest+28000));
				}else if(totalbest>=300000){
					System.out.println("El valor total de los materiales con envios es: "+totalbest);
				}
				break;
			case CENTER:
				if(totalbest<80000){
					System.out.println("El valor total de los materiales con envios es: "+(totalbest+50000));
				}else if(totalbest<300000){
					System.out.println("El valor total de los materiales con envios es: "+totalbest);
				}else if(totalbest>=300000){
					System.out.println("El valor total de los materiales con envios es: "+totalbest);
				}
				break;
			case SOUTH:
				if(totalbest<80000){
					System.out.println("El valor total de los materiales con envios es: "+(totalbest+120000));
				}else if(totalbest<300000){
					System.out.println("El valor total de los materiales con envios es: "+(totalbest+50000));
				}else if(totalbest>=300000){
					System.out.println("El valor total de los materiales con envios es: "+totalbest);
				}
				break;
					default:
	
				}
		
		
	}
	
	public static void list(int materials,String[] names,int[] typeuse){
		int i = 0;
		use[] lista = new use[materials];
		while(i<materials){
			if(typeuse[i]==1){
				lista[i] = use.BLACK;
			}else if(typeuse[i]==2){
				lista[i] = use.WHITE;
			}else if(typeuse[i]==3){
				lista[i] = use.PAINTING;
			}
				i++;		
		}
		for(int j = 0; j<materials;j++){
			if(lista[j] == use.BLACK){
				System.out.println("Los materiales de obra Negra son; ");
				System.out.println(names[j]);
			}
		}
	for(int j = 0; j<materials;j++){
			if(lista[j] == use.WHITE){
				System.out.println("Los materiales de obra Blanca son; ");
				System.out.println(names[j]);
			}
		}
		for(int j = 0; j<materials;j++){
			if(lista[j] == use.PAINTING){
				System.out.println("Los materiales de Pintura son; ");
				System.out.println(names[j]);
			}
		}
	}
}