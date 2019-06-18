package casita_robada;

public class Mazo {
	protected Carta [] mazo; // array que va a contener las cartas
	private int cant_palo;// cantidad de palos
	private int cant_num; // cantidad de numero
	protected int total; // total de cartas
	protected int cant;



	// Constructor que recibe los palos y los numeros 
	//para mazo de cartas
	public Mazo (String []palo, String [] num) {

		cant_palo = palo.length; //guardo el largo del array "palo"
		cant_num = num.length; //guardo el largo del array "num"
		total = cant_palo * cant_num; //calculo el total de cartas
		cant = total;
		mazo = new Carta [total]; //creo el array de objetos del tipo Carta

		llenar(palo,num); //invoco el metodo para llenar el array "mazo"
	}
	
	//constructor para mano y casa
	public Mazo(int cant) {
		this.total=0;
		this.cant=cant;
		mazo=new Carta [cant];
		for(int i=0;i<cant;i++) {
			mazo[i]=null;
		}
	}
	
	//cant de cartas que hay en el mazo
	public int getTotal() {
		return total;
	}


	// el metodo 'llenar' solo sirve adentro del objeto
	private void llenar (String []palo, String [] num) {
		int h=0;//h es para moverme en "mazo"
		int i;//es para moverme en "palo"
		int j;// es para moverme en "num"

		//me muevo en los arrays "num" , "palo"y "mazo" para crear las cartas
		for(i=0 ; i < cant_palo ; i++) {

			for(j=0; j < cant_num && h< total ;j++,h++) {

				//voy creando cartas con sus correspondientes atributos
				// y la direcciones las guardo en el array "mazo" una x una
				this.mazo[h] = new Carta(num[j],palo[i]);
			}
		}
	}

	//metodo para mostrar las cartas
	public void mostrar () {
		
		for(int i=0;i<cant && mazo[i]!=null;i++) {
			System.out.print("| P"+i+"|\t");
		}
		System.out.print("\n");
		for(int i=0;i<cant && mazo[i]!=null;i++) {
			System.out.print(" ___\t");
		}
		System.out.print("\n");
		for(int i=0;i<cant && mazo[i]!=null;i++) {
			//para pasar string a numero
			int numero = Integer.parseInt(mazo[i].getnum());
			
			if(numero >= 0 && numero <=9) {
				System.out.print("| "+mazo[i].getnum()+" |\t");
			}
			else {
				System.out.print("| "+mazo[i].getnum()+"|\t");
			}
			
		}
		System.out.print("\n");
		for(int i=0;i<cant && mazo[i]!=null;i++) {
			System.out.print("| "+mazo[i].getpalo()+" |\t");
		}
		System.out.print("\n");
	}
	
	//metodo para sacar carta del mazo
	public Carta getCarta(int pos) {
			//obtengo la carta
			Carta carta = mazo[pos];
			
			//la saco del mazo
			for(int i=pos; i<cant;i++) {
				
				if(i==total-1) {
					mazo[i]=null;
					total=total-1;
					break;
				}
				mazo[i]=mazo[i+1];
				
			}
			
		return carta;
	}
	
	//metodo para añadir carta al mazo
	public void addCarta(Carta carta) {
		for(int i=0;i<cant;i++) {
			if(mazo[i] == null) {
				mazo[i]= carta;
				total=total+1;
				break;
			}
		}
	}
	
	
}
