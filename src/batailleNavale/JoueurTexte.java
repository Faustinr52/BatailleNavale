package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {

	private Scanner sc;

//-----------
//	constructeurs
	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
		sc = new Scanner(System.in);
	}

	public JoueurTexte(GrilleNavale g) {
		super(g);
		sc = new Scanner(System.in);
	}

	// -----------
//	methodes

	protected void retourAttaque(Coordonnee c, int etat) {

		System.out.println(etat + "retour attaque joueur 1");

		if (etat == 4)
			System.out.println("Vous avez gagné! ");
		else if (etat == 2)
			System.out.println("Votre tir a coulé un navire");
		else if (etat == 1)
			System.out.println("Votre tir a touché un navire");
		else
			System.out.println("Votre tir est tombé à l'eau");

	}

	protected void retourDefense(Coordonnee c, int etat) {

		System.out.println(etat + " retour defense joueur 1");

		if (etat == 4)
			System.out.println("GAMEOVER");
		else if (etat == 2)
			System.out.println("Un de vos navire a coulé");
		else if (etat == 1)
			System.out.println("Un de vos navire a été touché");
		else
			System.out.println("Vous avez reçu un tir dans l'eau");

	}

	public Coordonnee choisirAttaque() {
		System.out.println("entrez la coordonnee");
		String s = sc.nextLine();

		Coordonnee c = new Coordonnee(s);

		System.out.println(c.getLigne() + " --> " + c.getColonne());
		return c;
	}
	
	
	//-----------
//	test

	public static void main(String[] args) {

	}

}