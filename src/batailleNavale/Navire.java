package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	// 2.1
	public Navire(Coordonnee debut, int longueur, boolean estVertical) {

		if (longueur > 5 || longueur < 2)
			throw new IllegalArgumentException();

		int ligne;
		int colonne;
		this.debut = debut;
		if (estVertical) {
			colonne = debut.getColonne();
			ligne = debut.getLigne() + longueur - 1;
		} else {
			ligne = debut.getLigne();
			colonne = debut.getColonne() + longueur - 1;
		}
		this.fin = new Coordonnee(ligne, colonne);
		partiesTouchees = new Coordonnee[longueur];
		nbTouchees = 0;
	}

	// 2.2
	public String toString() {

		int longueur;
		boolean estVertical;
		if (debut.getLigne() == fin.getLigne()) {
			longueur = fin.getColonne() - debut.getColonne() + 1;
			estVertical = false;
		} else {
			longueur = fin.getLigne() - debut.getLigne() + 1;
			estVertical = true;
		}
		if (estVertical) {
			return "Navire (" + this.debut + " , " + longueur + " Vertical" + ")";
		} else {
			return "Navire (" + this.debut + " , " + longueur + " , horizontal " + ")";
		}
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return this.fin;

	}

	public boolean contient(Coordonnee c) {
		if (debut.getColonne() == fin.getColonne()) {
			if (debut.getColonne() == c.getColonne() && debut.getLigne() <= c.getLigne()
					&& fin.getLigne() >= c.getLigne()) {
				return true;
			} else {
				return false;
			}
		} else if (debut.getLigne() == fin.getLigne()) {
			if (debut.getLigne() == c.getLigne() && debut.getColonne() <= c.getColonne()
					&& fin.getColonne() >= c.getColonne()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean touche(Navire n) {

		if (this.debut.getLigne() <= n.fin.getLigne() && this.fin.getLigne() >= n.debut.getLigne()) {
			if (!(n.debut.getColonne() <= this.fin.getColonne() && this.debut.getColonne() <= n.fin.getColonne())) {
				if (this.debut.getColonne() == n.debut.getColonne() + 1
						|| this.fin.getColonne() == n.debut.getColonne() - 1)
					return true;
			}
		} else if (this.debut.getColonne() <= n.fin.getColonne() && this.fin.getColonne() >= n.debut.getColonne()) {
			if (!(n.debut.getLigne() <= this.fin.getLigne() && this.debut.getLigne() <= n.debut.getLigne())) {
				if (n.debut.getLigne() == this.debut.getLigne() + 1 || n.fin.getLigne() == this.debut.getLigne() - 1)
					return true;
			}
		}
		return false;
	}

	public boolean chevauche(Navire n) {

		if (this.debut.getLigne() <= n.fin.getLigne() && this.fin.getLigne() >= n.debut.getLigne()) {
			if (n.debut.getColonne() <= this.fin.getColonne() && this.debut.getColonne() <= n.fin.getColonne())
				return true;
		} else if (this.debut.getColonne() <= n.fin.getColonne() && this.fin.getColonne() >= n.debut.getColonne()) {
			if (n.debut.getLigne() <= this.fin.getLigne() && this.debut.getLigne() <= n.debut.getLigne())
				return true;
		}

		return false;

	}

	public boolean recoitTir(Coordonnee c) {
		if (this.contient(c)) {
			if (nbTouchees == 0) {
				partiesTouchees[nbTouchees] = c;
				nbTouchees += 1;
				return true;
			} else {
				for (int i = 0; i < nbTouchees; i++)
					if (partiesTouchees[i].equals(c))
						return false;

				partiesTouchees[nbTouchees] = c;
				nbTouchees += 1;
				return true;
			}
		}
		return false;
	}

	public boolean estTouche(Coordonnee c) {
		if (this.contient(c)) {
			if (nbTouchees == 0) {
				return false;
			} else {
				for (int i = 0; i < nbTouchees; i++) {
					if (partiesTouchees[i].equals(c))
						return true;
				}
				return false;
			}
		}
		return false;
	}

	public boolean estTouche() {
		
		return nbTouchees > 0;
	}
		

	public boolean estCoule() {

		return nbTouchees == partiesTouchees.length;
	}

	
	//-----------
//	test
	
	public static void main(String[] args) {
		Coordonnee c1 = new Coordonnee(2, 2);
		Coordonnee c2 = new Coordonnee(2, 3);
		Coordonnee d1 = new Coordonnee(2, 4);
//		System.out.println(c1);
		// test de constructeur Navire
		Navire nv1 = new Navire(c1, 3, false);
		Navire nv2 = new Navire(d1, 3, true);
		System.out.println(nv1.getDebut() + "--->" + nv1.fin);
		System.out.println(nv2.getDebut() + "--->" + nv2.fin);

		/*
		 * System.out.println(nv1.fin); System.out.println(nv1.debut);
		 */

		// test de la methode toString
//		System.out.println(nv1.toString());

		// test de la methode contient
//		System.out.println(nv1.contient(c1));

//		 test de la methode touche
//		 System.out.println(nv1.touche(nv2));
		// test de la methode chevauche
//		System.out.println(nv1.chevauche(nv2));
//	System.out.println("test de la methode rectoitTir");
		System.out.println(nv1.recoitTir(c1));
		System.out.println(nv1.recoitTir(c1));
		System.out.println(nv1.recoitTir(d1));
//		 System.out.println(nv1.recoitTir(c2));
		System.out.println("le navire est coulé :" + nv1.estCoule());
		// test de la methode estTouche(Coordonnee c)
//		 System.out.println(nv1.estTouche(c1));
//		 System.out.println(nv1.recoitTir(c1));

	}

}