package casita_robada;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int i,cant_rest_carta;
		Scanner teclado = new Scanner(System.in);

		String [] palo_esp = new String [] {"E","C","O","B"};
		String [] num_esp = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};


		//bienvenida
		Main.msm_bienvenida();
		Thread.sleep(6000);
		System.out.println("\n");
		/*i=0;
		while(i<10) {
			System.out.println("\n");
			i++;
		}*/


		//creo la baraja
		Mazo baraja_esp = new Mazo(palo_esp,num_esp);
		System.out.println("Baraja lista");
		
		//pido los nombres de los jugadores
		System.out.print("Ingrese nombre del jugador 1: ");
		String j1_name = teclado.nextLine();
		System.out.print("Ingrese nombre del jugador 2: ");
		String j2_name = teclado.nextLine();

		// creo jugadores
		Jugador j1,j2;
		j1=new Jugador(j1_name);
		j2=new Jugador(j2_name);

		//Creo al crupier y el mezcla las cartas
		System.out.print("Ingrese cant de barajeadas: ");
		int cant = teclado.nextInt();
		Crupier crupier = new Crupier(baraja_esp,cant);

		//creo la mesa
		Mesa mesa = new Mesa();

		//el crupier reparte las cartas entre los jugadores y la mesa
		cant_rest_carta = crupier.repartir_cartas(j1, j2, mesa);


		//comienza el juego y termina cuando el crupier no puede repartir mas

		while(cant_rest_carta>10) {
			i=0;
			while(i<3) {
				Main.turno(j1, mesa);
				Main.turno(j2, mesa);

				i++;
			}
			crupier.player_score(j1, j2);
			Thread.sleep(3000);
			cant_rest_carta=crupier.repartir_cartas(j1, j2, mesa);		
		}
		//FIN
		System.out.println("Juego terminado :)");
	}


	//funcion de bienvenida
	public static void msm_bienvenida() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("|-----------------------CASITA ROBADA™-----------------------|");
		System.out.println("|               / \\                        / \\               |");
		System.out.println("|              /   \\                      /   \\              |");
		System.out.println("|             /_____\\                    /_____\\             |");
		System.out.println("|             |  _  |                    |  _  |             |");
		System.out.println("|             |_| |_|                    |_| |_|             |");
		System.out.println("|                       ®2019 edugames                       |");
		System.out.println("|                 platform all rights reserved               |");
		System.out.println("--------------------------------------------------------------");
	}


	//funcion para dar el turno al jugador
	public static void turno(Jugador player,Mesa mesa) {
		int op;
		Scanner teclado = new Scanner(System.in);

		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------Turno de "+player.nombre+" ---------------");
		System.out.println("---------------------------Su Mano:");
		player.ver_mano();
		System.out.println("------------------------------Mesa:");
		mesa.ver_mesa();
		System.out.print("Desea 1.tirar o 2.robar? ");
		op = teclado.nextInt();
		if(op==1) {
			Carta temp= player.tirar();
			if(temp==null) {
				Main.turno(player, mesa);
			}
			else {
				mesa.add_toMesa(temp);
			}

		}
		else if (op==2) {
			int stat;
			stat = player.robar(mesa.pass_mazo());
			if(stat==-1) {
				Main.turno(player, mesa);
			}
		}
		else {
			System.out.print("opcion no valida");
			Main.turno(player, mesa);
		}
	}

	//funcion auxiliar para mostar cartas en consola
	/*public static void ver_cartas(Jugador j1,Jugador j2,Mesa mesa,Crupier crupier) {
			System.out.println("Mano de j1---------------------------");
			j1.ver_mano();
			System.out.println("Mano de j2---------------------------");
			j2.ver_mano();
			System.out.println("Mesa---------------------------------");
			mesa.ver_mesa();
			System.out.println("Mazo---------------------------------");
			crupier.mostrar_mazo();
			System.out.println("Fin");
		}*/

}
