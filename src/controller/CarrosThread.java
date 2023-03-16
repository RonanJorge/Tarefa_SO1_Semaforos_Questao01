package controller;

import java.util.concurrent.Semaphore;

public class CarrosThread extends Thread{
	
	private String numCarro;
	private Semaphore semaforo;
	
	public CarrosThread(String numCarro, Semaphore semaforo) {
		this.numCarro = numCarro;
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			entraCruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally {
			semaforo.release();
		}
	}

	
	public void entraCruzamento() {
		System.out.println("O carro "+numCarro+" entrou no cruzamento!");
		saiCruzamento();
	}
	
	public void saiCruzamento() {
		System.out.println("O carro "+numCarro+" saiu do cruzamento!");
	}
}













