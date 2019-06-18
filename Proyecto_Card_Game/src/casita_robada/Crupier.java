package casita_robada;

public class Crupier {
	Mazo mazo;// es el mazo total de cartas

	public Crupier(Mazo mazo,int barajeadas) {
		this.mazo = mazo;
		barajear(mazo,barajeadas);

	}

	//metodo que mezcla las cartas del mazo
	private void barajear (Mazo baraja ,int barajeadas) {
		Carta aux; // cajita auxiliar para guardar una carta mientras hago el swap
		int azar_1,azar_2;
		int limite = baraja.mazo.length; // para definir el limite de random 

		for (int i = 0; i < barajeadas; i++) {

			azar_2 = (int) (Math.random() * limite );//numero entre 0-limite
			azar_1 =  (int) (Math.random() * limite );//numero entre 0-limite

			//primero guardo en "aux" la carta que esta en la posicion "azar_2"
			aux	= baraja.mazo[azar_2];

			/*luego la carta que esta en la posicion "azar_1"
			la guardo en la posicion "azar_2"*/
			baraja.mazo[azar_2] = baraja.mazo[azar_1];

			/*por ultimo la carta que estaba en "azar_2" que ahora esta en "aux"
			la guardo en la posicion "azar_1"*/
			baraja.mazo[azar_1] = aux;
		}
	}

	//metodo para verificar la jugada
	public static int check_jugada (Carta [] carta) {
		if( !((carta[0].getnum()).equals(carta[1].getnum())) ) {
			System.out.println("--------Jugada no valida !!!------");
			System.out.println("----------------------------------");
			return -1; // todo mal
		}

		return 1; // todo ok

	}

	//metodo que reparte cartas entre j1,j2 y la mesa
	public int repartir_cartas (Jugador j1,Jugador j2,Mesa mesa) {
		int j=0,i,total;
		if(mazo.getTotal() >= 10) {
			total = mazo.getTotal();
			if (j1.getCant_mano() == 0 && j2.getCant_mano()==0) {
				for(i=0,j=0; i<3;i++,j++) {
					j1.add_toMano(mazo.getCarta(j));
				}
				for(i=0; i<3;i++,j++) {
					j2.add_toMano(mazo.getCarta(j));
				}
			}
			if (mesa.get_cantCartas() < 4) {
				for(i=0; i<4;i++,j++) {
					mesa.add_toMesa(mazo.getCarta(j));
				}
			}
			return total;
		}


		return mazo.getTotal();
	}

	//metodo para ver el mazo total
	public void mostrar_mazo() {
		mazo.mostrar();
	}

	//metodo que muestra los resultados de la ronda
	public void player_score(Jugador j1, Jugador j2) {
		int resultado_1 = j1.casa.getTotal();
		int resultado_2 = j2.casa.getTotal();
		String name_1 = j1.nombre;
		String name_2 = j2.nombre;
		System.out.println("--------Resultados------");
		System.out.println("|----------------------|");
		System.out.println("|Jugador "+name_1+" |");
		System.out.println("|Tiene "+resultado_1+" cartas |");
		System.out.println("|----------------------|");
		System.out.println("|Jugador "+name_2+" |");
		System.out.println("|Tiene "+resultado_2+" cartas |");
		System.out.println("------------------------");

	}
}
