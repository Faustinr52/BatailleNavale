package batailleNavale;

public class TestGrilleNavale {

	public static void TestGrilleNavale() {
		GrilleNavale g1 = new GrilleNavale(26, 5);
		Navire n1 = new Navire(new Coordonnee("A4"), 4, false);
		Navire n2 = new Navire(new Coordonnee("I3"), 5, true);
		Navire n3 = new Navire(new Coordonnee("E6"), 3, false);
		Navire n4 = new Navire(new Coordonnee("G2"), 3, true);
		Navire n5 = new Navire(new Coordonnee("D3"), 3, false);
		Navire n6 = new Navire(new Coordonnee("A3"), 4, true);
		Navire n7 = new Navire(new Coordonnee("L6"), 2, true);
		//Navire n8 = new Navire(new Coordonnee("M20"), 2, true);

		System.out.println("---- Test ajouteNavire(Navire n) ----");
		if (g1.ajouteNavire(n1) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n2) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n3) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n4) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n5) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n6) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		if (g1.ajouteNavire(n7) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
//		if (g1.ajouteNavire(n8) == false)
//			System.out.println("Succès");
//		else
//			System.out.println("Echec");
//		

	/*	System.out.println("---- Test estDansGrille(Coordonnee c) ----");
		if (g1.estDansGrille(new Coordonnee("A1")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		if (g1.estDansGrille(new Coordonnee("A26")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		System.out.println("---- Test estDansTirsRecus(Coordonnee c) ----");
		if (g1.estDansTirsRecus(new Coordonnee("D1")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("D1"));

		if (g1.estDansTirsRecus(new Coordonnee("D1")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		System.out.println("---- Test ajouteDansTirsRecus(Coordonnee c) ----");
		if (g1.ajouteDansTirsRecus(new Coordonnee("B3")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		// g1.recoitTir(new Coordonnee("B3"));

		if (g1.ajouteDansTirsRecus(new Coordonnee("B3")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");*/

		System.out.println("---- Test recoitTir(Coordonnee c) ----");
		if (n1.recoitTir(new Coordonnee("A4")) == true)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");
		if (n1.recoitTir(new Coordonnee("A4")) == false)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");
		if (n1.recoitTir(new Coordonnee("D3")) == false)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");

		if (n2.recoitTir(new Coordonnee("I5")) == true)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");
		if (n2.recoitTir(new Coordonnee("K1")) == false)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");

		if (n3.recoitTir(new Coordonnee("G6")) == true)
			System.out.println("SUCCES");
		else
			System.out.println("Echec");
		if (n3.recoitTir(new Coordonnee("H6")) == false)
			System.out.println("SUCCES" + "\n");
		else
			System.out.println("Echec" + "\n");

		System.out.println("---- Test estTouche(Coordonnee c) ----");
		if (n4.estTouche(new Coordonnee("G2")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		// ------------
		n4.recoitTir(new Coordonnee("G2"));
		// ------------
		if (n4.estTouche(new Coordonnee("G2")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		// ------------
		n1.recoitTir(new Coordonnee("E2"));
		// ------------
		if (n1.recoitTir(new Coordonnee("E2")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		// ------------
//		n1.recoitTir(new Coordonnee("D4"));
//		if (n1.recoitTir(new Coordonnee("D4")) == true)
//			System.out.println("Succès" + "\n");
//		else
//			System.out.println("Echec" + "\n");

		System.out.println("---- Test estALEau(Coordonnee c)");
		if (g1.estALEau(new Coordonnee("A16")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("A16"));

		if (g1.estALEau(new Coordonnee("A16")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("B4"));

		if (g1.estALEau(new Coordonnee("B4")) == false) // touche n1
			System.out.println("Succès");
		else
			System.out.println("Echec");

		System.out.println("---- Test estCoule(Coordonnee c)");
		if (g1.estCoule(new Coordonnee("G6")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("G6"));
		g1.recoitTir(new Coordonnee("F6"));
		g1.recoitTir(new Coordonnee("E6")); 

		if (g1.estCoule(new Coordonnee("E6")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");
		// ---------------------------------------------
		if (g1.estCoule(new Coordonnee("I3")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("I3"));
		g1.recoitTir(new Coordonnee("I4"));
		g1.recoitTir(new Coordonnee("I5"));

		if (g1.estCoule(new Coordonnee("I5")) == false)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("I6"));
		g1.recoitTir(new Coordonnee("I7"));

		if (g1.estCoule(new Coordonnee("I7")) == true)
			System.out.println("Succès");
		else
			System.out.println("Echec");

		System.out.println("---- Test perdu()"); // jouer sur le nombre de navire pour tester
		if (g1.perdu() == false) //aucun tir
			System.out.println("Succès");
		else 
			System.out.println("Echec");

		g1.recoitTir(new Coordonnee("F6")); 
		g1.recoitTir(new Coordonnee("G6")); 
		g1.recoitTir(new Coordonnee("E6")); //n3 coule
		g1.recoitTir(new Coordonnee("G2")); 
		g1.recoitTir(new Coordonnee("G3")); 
		g1.recoitTir(new Coordonnee("G4")); //n4 coule
		
		if (g1.perdu() == false)
			System.out.println("Succès");
		else 
			System.out.println("Echec");
		
		g1.recoitTir(new Coordonnee("A4")); 
		g1.recoitTir(new Coordonnee("B4")); 
		g1.recoitTir(new Coordonnee("C4")); 
		g1.recoitTir(new Coordonnee("D4")); //n1 coule
		
		g1.recoitTir(new Coordonnee("I3")); 
		g1.recoitTir(new Coordonnee("I4")); 
		g1.recoitTir(new Coordonnee("I5")); 
		g1.recoitTir(new Coordonnee("I6")); 
		g1.recoitTir(new Coordonnee("I7")); //n2 coule
		
		g1.recoitTir(new Coordonnee("L6")); 
		g1.recoitTir(new Coordonnee("L7")); //n7 coule 
		
		if (g1.perdu() == true)
			System.out.println("Succès");
		else 
			System.out.println("Echec");
		
	}

	public static void main(String[] args) {
		TestGrilleNavale();
	}

}