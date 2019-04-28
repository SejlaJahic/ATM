package atm;

import java.util.ArrayList;

public class Racun {

	protected int brojRacuna;
	protected String imeVlasnika;
	protected double iznos;

	private int brojac = 0;
	public static ArrayList<Racun> racuni = new ArrayList<>();

	protected Racun(int brojRacuna) {
		this.brojRacuna = brojRacuna;
		
	}

	protected Racun(double iznos) {
		this.iznos = iznos;
		
	}

	public Racun(int brojRacuna, String imeVlasnika, double iznos) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.iznos = iznos;
		racuni.add(brojac, this);
		brojac++;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnika() {
		return imeVlasnika;
	}

	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public static void ispisSvihRacuna() {
		for (Racun e : racuni) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna=" + brojRacuna + ", imeVlasnika=" + imeVlasnika + ", iznos=" + iznos + "]";
	}

}
