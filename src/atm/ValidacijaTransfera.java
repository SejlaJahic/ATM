package atm;

public class ValidacijaTransfera extends TransferNovca {

	public ValidacijaTransfera(Racun sourceRacun, Racun targetRacun, double iznosTransfera) {
		super(sourceRacun, targetRacun, iznosTransfera);
	}

	public ValidacijaTransfera(Racun sourceRacun) {
		super(sourceRacun);
	}

	public ValidacijaTransfera(double iznosTransfera) {
		super(iznosTransfera);
	}

	public boolean nemaDovoljnoNovca(Racun sourceRacun, double iznosTransfera) {
		if (sourceRacun.iznos < iznosTransfera) {
			return true;
		}
		return false;
	}

	public boolean nepostojeciSource(Racun sourceRacun) {
		for (int i = 0; i < Racun.racuni.size(); i++) {
			if (Racun.racuni.get(i).getBrojRacuna() == sourceRacun.brojRacuna) {
				return false;
			}
		}
		return true;
	}

	public boolean nepostojeciTarget(Racun targetRacun) {
		for (int i = 0; i < Racun.racuni.size(); i++) {
			if (Racun.racuni.get(i).getBrojRacuna() == targetRacun.brojRacuna) {
				return false;
			}
		}
		return true;
	}

}
