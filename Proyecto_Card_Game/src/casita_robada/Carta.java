package casita_robada;

public class Carta {
	private String num;// numero de la carta
	private String palo;// palo de la carta

	//constructor
	public Carta(String num,String palo) {
		this.num = num;
		this.palo = palo;
	}

	//obtengo numero de la carta
	public String getnum() {
		return num;
	}
	
	//obtengo palo de la carta
	public String getpalo() {
		return palo;
	}
	
	//metodo que pasa a string los atributos
	public String toString() {
		return (num+" "+palo);
		
	}
}
