package casita_robada;

public class Mesa {

	Mazo mazo= new Mazo(20);

	//metodo para obtener cant de cartas que hay
	int get_cantCartas() {
		return mazo.getTotal();
	}


	Carta sacarCarta (int pos) {
		Carta carta = mazo.getCarta(pos);

		return carta;

	}

	//metodo para pasar las cartas de la mesa
	public Mazo pass_mazo() {
		return mazo;
	}

	//metodo para sacar de la mesa una carta
	public void add_toMesa(Carta carta) {
		mazo.addCarta(carta);

	}

	//metodo para ver las carta de la mesa
	public void ver_mesa() {
		mazo.mostrar();
	}
}
