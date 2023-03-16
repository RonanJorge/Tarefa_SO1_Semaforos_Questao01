/* Fazer uma aplicação que gerencie a figura abaixo:
Para tal, usar uma variável sentido, que será alterado pela Thread que
controla cada carro com a movimentação do carro. Quando a
Thread tiver a possibilidade de ser executada, ela deve imprimir em
console o sentido que o carro está passando. Só pode passar um carro
por vez no cruzamento. */

package view;
import java.util.concurrent.Semaphore;
import controller.CarrosThread;

public class Principal {

	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		String[] carros = {"de cima", "de baixo", "da direita", "da esquerda"};
		int maxCarros = 1;
		semaforo = new Semaphore(maxCarros);
		for(String i : carros) {
			Thread car = new CarrosThread(i, semaforo);
			car.start();
		}
	}

}
