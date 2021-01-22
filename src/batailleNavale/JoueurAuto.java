package batailleNavale;

public class JoueurAuto extends JoueurAvecGrille {
	
		public JoueurAuto(GrilleNavale g, String nom) {
			
			super(g, nom);
			
			
		}
		public JoueurAuto(GrilleNavale g) {
			super(g);
			
		}

		protected void retourAttaque(Coordonnee c, int etat) {
		
			System.out.println(etat+ "retour attaque joueur 2");
			
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

			
			System.out.println(etat +" retour defense joueur 2");
			
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
	               return (new Coordonnee((int) (Math.random() * super.getTailleGrille()),
					 (int) (Math.random() * super.getTailleGrille()))); //regarder si La coordonn�e c n'existe pas deja dans les tires recus
					
			
		}
		/*public static void main(String[] args) {
			// TODO Auto-generated method stub
			int []t = {3,2,5};
			JoueurTexte  j1 = new JoueurTexte (new GrilleNavale(10,t),"divin");
			JoueurTexte  j2 = new JoueurTexte (new GrilleNavale(10,t),"divin");
			GrilleNavale g =new GrilleNavale(3,t);
			System.out.println(g);
			j1.jouerAvec(j2);
			j2.jouerAvec(j1);
			j1.choisirAttaque();
			j1.retourAttaque(j1.choisirAttaque(), 2);
			
			
			
			System.out.println(g);
			
		 
			

		}*/
		

		}