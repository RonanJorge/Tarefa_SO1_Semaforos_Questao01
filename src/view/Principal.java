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
