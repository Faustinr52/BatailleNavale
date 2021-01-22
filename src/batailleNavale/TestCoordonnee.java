package batailleNavale;

public class TestCoordonnee {

	public static void TestCoordonnee() {
		System.out.println("------Tests Constructeur avec int en paramètre : ");

		try {
			System.out.println("1- Test avec null en paramètre : ");
			new Coordonnee(null);
			System.out.println("Echec");
		} catch (NullPointerException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("2- Test pour Coordonnee(0,-1)");
			new Coordonnee(0, -1);
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("3- Test pour Coordonnee (-1,0)");
			new Coordonnee(-1, 0);
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("4- Test pour Coordonnee (26,0)");
			new Coordonnee(26, 0);
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("5- Test pour Coordonnee (0,26)");
			new Coordonnee(0, 26);
			System.out.println("Succès" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		System.out.println("------Tests Constructeur avec String s en paramètre :");

		try {
			System.out.println("1- Test pour Coordonnee (\"AA\")");
			new Coordonnee("AA");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("2- Test pour Coordonnee (\"1B\")");
			new Coordonnee("1B");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("3- Test pour Coordonnee (\"33\")");
			new Coordonnee("33");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("4- Test pour Coordonnee (\"A27\")");
			new Coordonnee("A27");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("4-2- Test pour Coordonnee (\"A20\")");
			new Coordonnee("A20");
			System.out.println("Succès" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Echec" + "\n");
		}

		try {
			System.out.println("5- Test pour Coordonnee (\"00\")");
			new Coordonnee("00");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("6- Test pour Coordonnee (\"A0\")");
			new Coordonnee("A0");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("7- Test pour Coordonnee (\"0\")");
			new Coordonnee("0");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("8- Test pour Coordonnee (\"0A\")");
			new Coordonnee("0A");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("9- Test pour Coordonnee (\"bonjour\")");
			new Coordonnee("bonjour");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("10- Test pour Coordonnee (\"A1\")");
			new Coordonnee("A1");
			System.out.println("Succès" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Echec" + "\n");
		}

		try {
			System.out.println("10- Test pour Coordonnee (\"z1\")");
			new Coordonnee("z1");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("Test pour Coordonnee (\" 4\")");
			new Coordonnee(" 4");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		try {
			System.out.println("Test pour Coordonnee (\"@4\")");
			new Coordonnee("@4");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}
		
		try {
			System.out.println("Test pour Coordonnee (\"++\")");
			new Coordonnee("++");
			System.out.println("Echec" + "\n");
		} catch (IllegalArgumentException e) {
			System.out.println("Succès" + "\n");
		}

		System.out.println("------Tests méthodes : ");
		System.out.println("Test méthode compareTo : ");
		Coordonnee c1 = new Coordonnee(0, 1);
		Coordonnee c2 = new Coordonnee(3, 2);
		Coordonnee d1 = new Coordonnee(12, 14);
		Coordonnee d2 = new Coordonnee(12, 4);
		
		if (c1.compareTo(c2) == -1)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (c2.compareTo(c1) == 1)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (c1.compareTo(c1) == 0)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (d1.compareTo(d2) == 1)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		
		System.out.println("\n");
		System.out.println("Test méthode voisine : ");
		Coordonnee c3 = new Coordonnee(2, 2);
		Coordonnee c4 = new Coordonnee(2, 1);
		Coordonnee c5 = new Coordonnee(2, 2);
		Coordonnee c6 = new Coordonnee(10, 10);
		if (c3.voisine(c4) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (c5.voisine(c6) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("Test equals :");
		Coordonnee d3 = new Coordonnee(4, 3);
		Object d4 = new Coordonnee(4, 3);
		Coordonnee g3 = new Coordonnee(4, 3);
		Object g4 = new Navire(g3, 5, false);
		if (d3.equals(d4) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g3.equals(g4) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("Test méthode getColonne : ");
		Coordonnee c7 = new Coordonnee(4, 2);
		if (c7.getColonne() == 2)
			System.out.println("OK" + "\n");
		else
			System.out.println("Mauvaise colonne" + "\n");

		System.out.println("Test méthode getLigne : ");
		Coordonnee c8 = new Coordonnee(4, 2);
		if (c8.getLigne() == 4)
			System.out.println("OK" + "\n");
		else
			System.out.println("Échec" + "\n");

		System.out.println("------ Fin des tests pour la classe Coordonnee ------");

	}

	public static void main(String[] args) {
		TestCoordonnee();

	}

}