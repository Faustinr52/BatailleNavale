package batailleNavale;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne;
	private int colonne;

	// ------ Constructeurs ------

	public Coordonnee(int ligne, int colonne) {
		if (ligne < 0 || ligne >= 26)
			throw new IllegalArgumentException("Erreur, entrer une ligne > 0 et <=25");
		else if (colonne < 0 || colonne >= 26)
			throw new IllegalArgumentException("Erreur, entrer une colonne > 0 et <=25");
		else {
			this.ligne = ligne;
			this.colonne = colonne;
		}
	}

	public Coordonnee(String s) {
		colonne = s.charAt(0) - 'A';

		if (s.charAt(0) < 'A' || s.charAt(0) > 'Z')
			throw new IllegalArgumentException("Entrer une lettre au début de la chaîne");

		ligne = Integer.parseInt(s.substring(1)) - 1;

		if (ligne < 0 || ligne > 25)
			throw new IllegalArgumentException("Erreur, entrer une ligne entre 0 et 25");

	}

	// ------- Méthodes -------

	public String toString() {
		return (char) (colonne + 'A') + "" + (ligne + 1);
	}

	public int getColonne() {
		return this.colonne;
	}

	public int getLigne() {
		return this.ligne;
	}

	public boolean equals(Object obj) {

		return (obj instanceof Coordonnee) && (this.ligne == ((Coordonnee) obj).ligne)
				&& (this.colonne == ((Coordonnee) obj).colonne);
	}

	public boolean voisine(Coordonnee c) {
		if ((this.ligne == c.ligne) && (this.colonne == c.colonne - 1 || this.colonne == c.colonne + 1))
			return true;

		if ((this.colonne == c.colonne) && (this.ligne == c.ligne - 1 || this.ligne == c.ligne + 1))
			return true;

		else
			return false;
	}

	public int compareTo(Coordonnee c) {
		if ((this.ligne < c.ligne) || (this.ligne == c.ligne && this.colonne < c.colonne))
			return -1;
		else if ((this.ligne == c.ligne) && (this.colonne == c.colonne))
			return 0;

		else
			return 1;
	}
	
//	---------------------
//	test

	public static void main(String[] args) {
		// System.out.println(new Coordonnee(2,2));
		// System.out.println(new Coordonnee(2,2).getColonne());
		// System.out.println(new Coordonnee("E4"));
		// Object c1 =new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0, 1);
		// Coordonnee c2 = new Coordonnee("B1");
		Coordonnee c = new Coordonnee(3, 2);
		System.out.println(c1.compareTo(c));
		// Coordonnee c = new Coordonnee ("A10");
		System.out.println(c.getLigne() == 9);
		System.out.println(c.getColonne() == 0);

		// c = new Coordonnee("C5"); System.out.println(g2);
		System.out.println(c.getLigne() == 4);
		System.out.println(c.getColonne() == 2);

		try {
			c = new Coordonnee("toto");
			System.out.println(false);
		} catch (Exception e) {
			System.out.println(true);
		}

		c = new Coordonnee("D8");
		System.out.println(c.toString().equals("D8"));

		// c = new Coordonnee(null);

		System.out.println(new Coordonnee(2, 2));
	}

}