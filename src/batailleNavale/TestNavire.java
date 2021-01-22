package batailleNavale;

public class TestNavire {

	public static void TestNavire() {
		// debut = B3 col=1, ligne=2
		// fin = F3 col=5, ligne =2
		// partiesTouchees=[null, null, null, null, null]
		// nbTouchees=0

		Navire n1 = new Navire(new Coordonnee("B3"), 5, false);

		System.out.println("1- Test : getDebut :");
		System.out.println(n1.getDebut());
		if (n1.getDebut().equals(new Coordonnee("B3")))
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		// System.out.println(n1.getDebut().equals(new Coordonnee("B3")));

		System.out.println("2- Test : getFin :");
		System.out.println(n1.getFin());
		if (n1.getFin().equals(new Coordonnee("F3"))) {
			System.out.println("Succès" + "\n");
		} else {
			System.out.println("Echec" + "\n");
		}

		// System.out.println(n1.getFin().equals(new Coordonnee("F3")));

		System.out.println("3- Test : contient(Coordonnee c) :");
		for (int j = 0; j < 5; j++) {
			// System.out.println(n1.contient(new Coordonnee(2,1+j)));
			n1.contient(new Coordonnee(2, 1 + j));
		}
		if (n1.contient(new Coordonnee(2, 0)) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec" + "\n");
		if (n1.contient(new Coordonnee(2, 6)) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec" + "\n");
		if (n1.contient(new Coordonnee(2, 2)) == true)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("4- Test : touche(Navire n) :");
		Navire n2 = new Navire(new Coordonnee("G3"), 2, false);
		Navire n3 = new Navire(new Coordonnee("Z2"), 4, true);

		if (n1.touche(n2) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		if (n1.touche(n3) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("5- Test : chevauche(Navire n) :");
		Navire n4 = new Navire(new Coordonnee("C3"), 2, false);
		if (n1.chevauche(n4) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		Navire n5 = new Navire(new Coordonnee("C3"), 2, true);
		if (n1.chevauche(n5) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		if (n1.chevauche(n2) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("6- Test : reçoitTir :");
		Navire n6 = new Navire(new Coordonnee("F5"), 3, true);
		if (n6.recoitTir(new Coordonnee("F6")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (n6.recoitTir(new Coordonnee("D3")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (n6.recoitTir(new Coordonnee("F6")) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("7- Test : estTouche(Coordonnee c) :");
		Navire n7 = new Navire(new Coordonnee("A6"), 2, false);
		//------------
		if (n7.estTouche(new Coordonnee("B6")) == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");
		//------------
		n7.recoitTir(new Coordonnee("B6"));
		System.out.println("\n");
		//------------
		if (n7.estTouche(new Coordonnee("B6")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		//------------
		n7.recoitTir(new Coordonnee("E2"));
		//------------
		if (n7.recoitTir(new Coordonnee("E1")) == true)
			System.out.println("Echec" + "\n");
		else
			System.out.println("Succès" + "\n");
		//------------
		if (n7.recoitTir(new Coordonnee("E2"))== false)
			System.out.println("Succès" + "\n");
		else 
			System.out.println("Echec" + "\n");

		System.out.println("8- Test : estTouche() :");
		Navire n8 = new Navire(new Coordonnee("G1"), 3, false);

		if (n8.estTouche() == false)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		n8.recoitTir(new Coordonnee("H1"));
		System.out.println("\n");
		n8.recoitTir(new Coordonnee("D1")); 

		if (n8.estTouche() == true)
			System.out.println("Succès" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("9- Test : estCoule() :");
		Navire n9 = new Navire(new Coordonnee("D4"), 2, true); 
		if (n9.estCoule() == false)
			System.out.println("Succès" + "\n");
		else 
			System.out.println("Echec" + "\n");
		
		n9.recoitTir(new Coordonnee("D4")); 
		n9.recoitTir(new Coordonnee("D5")); 
		System.out.println("\n");
		
		if (n9.estCoule() == true) 
			System.out.println("Succès" + "\n");
		else 
			System.out.println("Echec" + "\n");


		System.out.println("------ Fin des tests pour la classe Navire ------");
	}

	public static void main(String[] args) {
		TestNavire();
	}

}