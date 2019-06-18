package casita_robada;

public class Casa extends Mazo{

	public Casa(int num) {
		super(num);
	}

	//metodo que agrega 2 cartas
	public void addCarta(Carta [] carta) {
		for(int i=0;i<cant;i++) {
			if(mazo[i] == null) {
				mazo[i]= carta[0];
				mazo[i+1]=carta[1];
				total= total+2;
				break;
			}
		}
	}
}
