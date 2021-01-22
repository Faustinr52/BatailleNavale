package batailleNavale;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.TransferHandler;

import java.awt.Color;


public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	 

	public GrilleNavaleGraphique(int taille)
	{
		
		
		super(taille,taille);
		
		
		grille = new GrilleGraphique(taille);
		
	}
	
	
	public GrilleGraphique getGrilleGraphique()
	{
			return this.grille;
			
			
	}

	public boolean ajouteNavire(Navire n)
	{
		    if (super.ajouteNavire(n))
		    {
		    	grille.colorie(n.getDebut(), n.getFin(), Color.green);
		    }
		  
	          return true;
	
	}
	public boolean recoitTir(Coordonnee c)
	{
		super.recoitTir(c);
		if (estALEau(c))
		{
			grille.colorie(c,Color.blue);
			
			{}
			
			
		}
		 if (estTouche(c))
		{
			grille.colorie(c, Color.red);
			
		
			return true;
		}
		return false;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrilleNavaleGraphique g = new GrilleNavaleGraphique(26);
		int []t = {2,4,3,5};
		g.placementAuto(t);
		System.out.print(g);
	
		

	}

}