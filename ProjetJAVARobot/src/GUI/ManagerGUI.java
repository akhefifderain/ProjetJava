package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ManagerGUI implements ActionListener{
	ManagerGUI(int n){
		init();
		JButton bInit = new JButton("Init");
		JButton bPaP = new JButton("Pas à Pas");
		JButton bResol = new JButton("Resolution");
		GridLayout d = new GridLayout(n+1,n);
		JFrame fenetre = new JFrame("Projet Prolog L3");
		JPanel affichage = new JPanel();
		JPanel commande = new JPanel();
		Container c = fenetre.getContentPane();
		c.setLayout(d);
		commande.add(bPaP);
		commande.add(bInit);
		commande.add(bResol);
		c.add(commande);
		bInit.addActionListener(this);
		bPaP.addActionListener(this);
		affichage.setLayout(d);
		c.add(affichage);
		Manager.Affichage = fenetre;
	}
	public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		if (s.equals("Init")){
			System.out.println("Init");
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}