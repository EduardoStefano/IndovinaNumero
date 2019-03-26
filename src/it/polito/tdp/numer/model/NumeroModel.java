package it.polito.tdp.numer.model;

import java.security.InvalidParameterException;

public class NumeroModel {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public NumeroModel() {
		inGioco = false;
	}
	
	/**
	 * Avvia nuova partita
	 */
	public void newGame() {
		inGioco = true;
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
	}
	
	/**
	 * metodo per effettuare un tentativo
	 * @param t il tentativo
	 * @return 1 se il tentativo è troppo alto -1 se basso 0 se ha indovinato
	 */
	public int tentativo(int t) {
		if(!inGioco) {
			throw new IllegalStateException("la p è terminata");
		}
		
		//controllo se l'input è nel range corretto
		/*if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Inserisci numero tra 1 e "+NMAX));
		}*/
		
		this.tentativiFatti++;
		if(this.tentativiFatti==this.TMAX) {
			this.inGioco=false;
		}
	
		if(t == this.segreto) {
			this.inGioco=false;
			return 0;
		}
		
		if(t>this.segreto) {
			return 1;
		}
		
		return -1;
		
	}
	
	public boolean tentativoValido(int t) {
		if(t<1 || t>TMAX) {
			return false;
		}
		else return true;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}
	
	
	
}
