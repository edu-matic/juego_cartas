package casita_robada;

import java.util.Scanner;

public class Jugador {
	public Casa casa = new Casa(40); //mazo donde van las cartas ganadas
	private Mazo mano = new Mazo(3); //mano del jugador
	public String nombre=null; //nombre del jugador

	//contructor
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	//metodo para saber cuantas cartas hay en la mano
	public int getCant_mano () {
		return mano.getTotal();
	}

	//metodo para tirar una carta en la mesa
	public Carta tirar() {
		Carta carta;
		int pos,check;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Seleccione pos de carta a tirar: ");
		pos = teclado.nextInt();
		check=check_pos(pos);
		if(check == -1) {
			System.out.println("Error!!!!");
			return null;//todo mal
		}
		carta = mano.getCarta(pos);
		return carta;
	}

	//metodo para robar una carta de la mesa
	public int robar(Mazo mazo) {
		Carta carta[]=new Carta[2];
		int pos,check;
		Scanner teclado = new Scanner(System.in);

		//mostrar carta de la mano
		System.out.print("Seleccione pos carta de la mano: ");
		pos = teclado.nextInt();

		check=check_pos(pos);
		if(check == -1) {
			System.out.println("Error!!!!");

		}
		carta[0]= mano.getCarta(pos);

		//mostrar carta de la mesa
		System.out.print("Seleccione pos carta de la mesa: ");
		pos = teclado.nextInt();
		carta[1] = mazo.getCarta(pos);

		//chequeo que este bien
		check=Crupier.check_jugada(carta);
		if(check==1) {
			//agrego las dos cartas a la casa
			casa.addCarta(carta);
		}
		else {
			mano.addCarta(carta[0]);
			mazo.addCarta(carta[1]);
			return -1;//todo mal
		}
		return 0;//todo bien


	}

	//check de posicion correcta
	private int check_pos (int pos) {

		//para robar
		if(0<=pos && pos<=2) {
			return 0;
		}
		else {
			return -1;
		}
	}

	//agregar carta a la mano
	public void add_toMano (Carta add) {
		mano.addCarta(add);
	}

	//ver las cartas de la mano
	public void ver_mano() {
		mano.mostrar();
	}

}
