package atm;

import java.util.ArrayList;

public class TransferNovca {

	protected Racun sourceRacun;
	protected Racun targetRacun;
	protected double iznosTransfera;

	private int brojac = 0;
	public static ArrayList<TransferNovca> transferi = new ArrayList<>();

	public TransferNovca(Racun sourceRacun, Racun targetRacun, double iznosTransfera) {
		this.sourceRacun = sourceRacun;
		this.targetRacun = targetRacun;
		this.iznosTransfera = iznosTransfera;
		transferi.add(brojac, this);
		brojac++;

	}

	public TransferNovca(Racun sourceRacun) {
		this.sourceRacun = sourceRacun;
	}

	public TransferNovca(double iznosTransfera) {
		this.iznosTransfera = iznosTransfera;
	}

	public void transfer(Racun sourceRacun, Racun targetRacun, double iznosTransfera) {
		targetRacun.setIznos(targetRacun.getIznos() + iznosTransfera);
		sourceRacun.setIznos(sourceRacun.getIznos() - iznosTransfera);
		System.out.println(sourceRacun.getImeVlasnika() + " uspješno ste prebacili " + iznosTransfera
				+ " KM, na raèun broj: " + targetRacun.getBrojRacuna());
	}

	public Racun getSourceRacun() {
		return sourceRacun;
	}

	public void setSourceRacun(Racun sourceRacun) {
		this.sourceRacun = sourceRacun;
	}

	public Racun getTargetRacun() {
		return targetRacun;
	}

	public void setTargetRacun(Racun targetRacun) {
		this.targetRacun = targetRacun;
	}

	public double getIznosTransfera() {
		return iznosTransfera;
	}

	public void setIznosTransfera(double iznosTransfera) {
		this.iznosTransfera = iznosTransfera;
	}

	public static void ispisSvihTransakcija() {
		for (TransferNovca e : transferi) {
			System.out.println(e);
		}

	}

	@Override
	public String toString() {
		return "TransferNovca [sourceRacun=" + sourceRacun + ", targetRacun=" + targetRacun + ", iznosTransfera="
				+ iznosTransfera + "]";
	}

}