package atm;

import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		int odabir = -1;
	
		while (odabir != 0) {
			System.out.println("Dobrodošli! " +"\n" +  "\nZa kreiranje raèuna, pritisnite 1"
					+ "\nZa transfer novca na drugi raèun, pritisnite 2"
					+ "\nZa pregled postojeæih raèuna, pritisnite 3"
					+ "\nZa pregled transakcija, pritisnite 4"
					+ "\nZa izlaz iz programa, pritisnite 0");
			odabir = skener.nextInt();
			switch (odabir) {
			case 1:
				System.out.println("Unesite broj raèuna: ");
				int brojRacuna = skener.nextInt();

				ValidacijaRacuna brojRacunA = new ValidacijaRacuna(brojRacuna);
				if (brojRacunA.brojRacunaNegativan(brojRacuna) || (brojRacunA.postojiBrojRacuna(brojRacuna))) {
					System.out.println("Broj raèuna veæ postoji ili ste unijeli negativan broj, \nunesite ponovo:");
					brojRacuna = skener.nextInt();
				}

				System.out.println("Unesite ime vlasnika: ");
				String imeVlasnika = skener.next();

				System.out.println("Unesite iznos na raèunu: ");
				double iznos = skener.nextDouble();

				ValidacijaRacuna iznoS = new ValidacijaRacuna(iznos);
				if (iznoS.negativanIznos(iznos)) {
					System.out.println("Iznos mora biti pozitivan!");
					iznos = skener.nextDouble();
				}
				Racun racun = new Racun(brojRacuna, imeVlasnika, iznos);
				System.out.println(racun);
				break;

			case 2:
				int index = 0;
				int indexT = 0;
				
					System.out.println("Unesite broj source racuna: ");
					int brojSource = skener.nextInt();
					for (int i = 0; i < Racun.racuni.size(); i++) {
						if (Racun.racuni.get(i).brojRacuna == brojSource) {
							index = i;
						}
					}
					ValidacijaTransfera src = new ValidacijaTransfera(brojSource);
					if (src.nepostojeciSource(Racun.racuni.get(index))) {
						System.out.println("Ne postoji takav source raèun, unesite ponovo: ");
						brojSource = skener.nextInt();
					}
					System.out.println("Unesite broj target racuna: ");
					int brojTarget = skener.nextInt();
					for (int i = 0; i < Racun.racuni.size(); i++) {
						if (Racun.racuni.get(i).brojRacuna == brojTarget) {
							indexT = i;
						}
					}
					ValidacijaTransfera trg = new ValidacijaTransfera(brojTarget);
					if (trg.nepostojeciTarget(Racun.racuni.get(indexT))) {
						System.out.println("Ne postoji takav target raèun, unesite ponovo: ");
						brojTarget = skener.nextInt();
					}
					System.out.println("Unesite iznos transfera: ");
					double iznosTransfera = skener.nextDouble();
					ValidacijaTransfera iznosic = new ValidacijaTransfera(iznosTransfera);
					if (iznosic.nemaDovoljnoNovca(Racun.racuni.get(index), iznosTransfera)) {
						System.out.println("Nema dovoljno sredstava na racunu za transfer!");
						break;
					} else {
						TransferNovca transfer = new TransferNovca(Racun.racuni.get(index), Racun.racuni.get(indexT),
								iznosTransfera);
						transfer.transfer(Racun.racuni.get(index),Racun.racuni.get(indexT) , iznosTransfera);
					}
				break;

			case 3:
				Racun.ispisSvihRacuna();
				break;

			case 4:
				TransferNovca.ispisSvihTransakcija();
				break;

			}
		}

		skener.close();

	}

}
