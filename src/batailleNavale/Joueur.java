package batailleNavale;

public abstract class Joueur {
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;

	private Joueur adversaire;
	private int tailleGrille;
	private String nom;

//Constructors
//--------------------------------

	public Joueur(int tailleGrille, String nom) {
		this.nom = nom;
		this.tailleGrille = tailleGrille;

	}

	public Joueur(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}

//Getters
//--------------------------------
	public int getTailleGrille() {
		return this.tailleGrille;
	}

	public String getNom() {
		return this.nom;
	}

	public void jouerAvec(Joueur j) {

		this.adversaire = j;
		j.adversaire =this;		
		deroulementJeu(this, j);
	}

	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
			Coordonnee c = attaquant.choisirAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);

			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
		}
		System.out.println("La partie est terminée");
	}

	protected abstract void retourAttaque(Coordonnee c, int etat);

	protected abstract void retourDefense(Coordonnee c, int etat);

	public abstract Coordonnee choisirAttaque();

	public abstract int defendre(Coordonnee c);

	public static void main(String[] args) {
		int t[] = { 2, 2, 2, 2, 2, 4, 4, 4, 4, 2, 2, 2 };

		GrilleNavale g1 = new GrilleNavale(10, t);
		GrilleNavale g2 = new GrilleNavale(10, t);

		JoueurTexte j1 = new JoueurTexte(g1, "amine");
		//JoueurTexte j2 = new JoueurTexte(g2, "divin");
		System.out.println(g1);
		System.out.println("GRILLE2"+"\n"+g2);
		JoueurAuto jAuto = new JoueurAuto(g2);
		
		j1.jouerAvec(jAuto);

		deroulementJeu(j1, jAuto);

	}

}