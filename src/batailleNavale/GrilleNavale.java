package batailleNavale;

public class GrilleNavale {

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

//	constructeur 1
	public GrilleNavale(int taille, int[] taillesNavires) {
		if (taille < 3 || taille > 26 || taillesNavires.length < 1)
			throw new IllegalArgumentException("PAS DE PLACE");
		else {
			this.navires = new Navire[10];
			if (nbNavires >= taillesNavires.length - 2) {
				Navire[] nav = new Navire[navires.length * 2];
				for (int i = 0; i < navires.length; i++) {
					nav[i] = navires[i];
				}
				navires = nav;
			}
			nbNavires = 0;
			this.taille = taille;
			tirsRecus = new Coordonnee[taille * taille];
			nbTirsRecus = 0;
			placementAuto(taillesNavires);

		}
	}

//		constructeur 2

	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		tirsRecus = new Coordonnee[taille * taille];
		nbTirsRecus = 0;

		navires = new Navire[nbNavires];
		nbNavires = 0;
	}

//	accesseurs

	public int getTaille() {
		return this.taille;
	}

//	methodes

	public boolean ajouteNavire(Navire n) {
		
		if(!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin()))
			return false;
		
			for (int i = 0; i < nbNavires; i++) 
				if (this.navires[i].chevauche(n) || this.navires[i].touche(n))
					return false;
				
				this.navires[nbNavires] = n;
				nbNavires++;
				return true;
		}

	public String toString() {

//		 On crée une stringBuffer qui affichera les point sur chaque ligne jusqu'a taille puis reviendra a la ligne

		StringBuffer s1 = new StringBuffer();

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				s1.append('.');
			}
			s1.append("\n");

		}

//		On parcours la grille et on affiche 0 pour toutes les coordonnees présentes dans tirs reçus

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				for (int k = 0; k < nbTirsRecus; k++) {
					if (tirsRecus[k].equals(new Coordonnee(i, j))) {

						s1.setCharAt(i * (taille + 1) + j, '0');

					}

				}

			}
		}

//		On parcours la grille et on vérifie si un navir contient a été touché à cette coordonnee on affichera X s'il contient cette coordonne sans avoir ete touché on mettra #

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				for (int k = 0; k < nbNavires; k++) {
					if (navires[k].contient(new Coordonnee(i, j))) {

						if (navires[k].estTouche(new Coordonnee(i, j)))
							s1.setCharAt(i * (taille + 1) + j, 'X');
						else
							s1.setCharAt(i * (taille + 1) + j, '#');

					}

				}

			}

		}

//		sur la premiere ligne on affichera l'ordre alphabetique des coordonnes et sur sur la premiere colonne de chaque ligne le numero de la coordonnee

		String s = "   ";

		for (int i = 0; i < this.taille; i++) {
			s = s + " " + ((char) (i + 'A'));

		}

		for (int i = 0; i < this.taille; i++) {

			s = s + "\n";
			if (i + 1 < this.taille)
				s = s + (i + 1) + "  ";
			else
				s = s + (i + 1) + " ";

			for (int j = 0; j < this.taille; j++) {

				s = s + " " + s1.charAt(i * (taille + 1) + j);
			}
		}
		return s;
	}

	public void placementAuto(int[] taillesNavires) {

		for (int i = 0; i < taillesNavires.length; i++) {
			Coordonnee c = new Coordonnee((int) (Math.random() * taille), (int) (Math.random() * taille));
			if (c.getColonne() > 0 && c.getColonne() <= taille - 5 && c.getLigne() >= 0 && c.getLigne() <= taille - 5) {
				Navire n = new Navire(c, taillesNavires[i], Math.random() < 0.5);

				if (taillesNavires[i] >= 2 && taillesNavires[i] < 5)
					this.ajouteNavire(n);

			}
		}

	}

	private boolean estDansGrille(Coordonnee c)

	{
		for (int i = 0; i < taille; i++)
			for (int j = 0; j < taille; j++)
				if (c.getLigne() == i && c.getColonne() == j)
					return true;
		return false;

	}

	private boolean estDansTirsRecus(Coordonnee c) {
		if (nbTirsRecus == 0) {
			return false;
		} else {
			for (int i = 0; i < nbTirsRecus; i++) {
				if ((tirsRecus[i]).equals(c))
					return true;
			}
			return false;
		}
	}

	private boolean ajouteDansTirsRecus(Coordonnee c) {

		if (!estDansTirsRecus(c)) {
			tirsRecus[nbTirsRecus] = c;
			nbTirsRecus++;
			return true;
		}
		return false;
	}

	public boolean recoitTir(Coordonnee c) {
		if (estDansGrille(c)) {
			if (ajouteDansTirsRecus(c)) {
				for (int i = 0; i < nbNavires; i++)
					if (navires[i].recoitTir(c))
						return true;
			}
			return false;
		}
		return false;
	}

	public boolean estTouche(Coordonnee c) {

		if (nbTirsRecus == 0) {
			return false;
		} else {
			if (estDansTirsRecus(c)) {
				for (int i = 0; i < nbNavires; i++) {
					if (navires[i].estTouche(c))
						return true;
				}
			}
			return false;
		}
	}

	public boolean estALEau(Coordonnee c) {

		if (nbTirsRecus == 0) {
			return false;
		} else {
			if (estDansTirsRecus(c)) {
				for (int i = 0; i < nbNavires; i++) {
					if (navires[i].contient(c))
						return false;
				}
				return true;
			}
			return false;
		}
	}

	public boolean estCoule(Coordonnee c) {
		
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].contient(c) && navires[i].estCoule())
				return true;
		}
		return false;
	}

	public boolean perdu() {
		for (int i = 0; i < nbNavires; i++)
			if (!navires[i].estCoule())
				return false;
		
		return true;
		
	}

	public static void main(String[] args) { // TODO Auto-generated method stub
		int t[] = { 4, 2, 2, 2, 2, 4, 5, 5, 4, 3 };

		GrilleNavale g = new GrilleNavale(10, t);

		g.recoitTir(new Coordonnee(2, 1));
		g.recoitTir(new Coordonnee(2, 3));
		g.recoitTir(new Coordonnee(4, 1));
		g.recoitTir(new Coordonnee(2, 5));
		g.recoitTir(new Coordonnee(2, 2));
		g.recoitTir(new Coordonnee(3, 3));

		System.out.println(g);
//		test placement auto
		// g.ajouteNavire(n[1]);
		// g.ajouteDansTirsRecus(new Coordonnee(1,5));

		//
		// Navire n = new Navire(new Coordonnee(1, 1), taillesNavires[0], true);
		// Navire n1 = new Navire(new Coordonnee(5, 2), taillesNavires[1], true);

		// n.recoitTir(new Coordonnee(3,1));
		// Coordonnee c = new Coordonnee(5,2);
		// this.ajouteNavire(n);
		// this.ajouteNavire(n1);
		// n.recoitTir(c);
		// this.recoitTir(c);

		// this.ajouteDansTirsRecus(npartiesTouchees.lengthew Coordonnee(6, 2));

		// }

	}

}