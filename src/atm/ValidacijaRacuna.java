package atm;

public class ValidacijaRacuna extends Racun {

	public ValidacijaRacuna(int brojRacuna, double iznos) {
		super(brojRacuna);
	}

	public ValidacijaRacuna(double iznos) {
		super(iznos);
	}

	public boolean brojRacunaNegativan(int brojRacuna) {
		if (brojRacuna < 0) {
			return true;
		}
		return false;
	}

	public boolean postojiBrojRacuna(int brojRacuna) {
		for (int i = 0; i < Racun.racuni.size(); i++) {
			if (Racun.racuni.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}
		return false;
	}

	public boolean negativanIznos(double iznos) {
		if (iznos < 0) {
			return true;
		}
		return false;
	}

}
