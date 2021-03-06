import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Gui_poker extends JFrame  implements ActionListener{
 
    JLabel carta1;
    JLabel carta2;
    JLabel carta3;
    JLabel carta4;
    JLabel carta5;
    
    JCheckBox op1 = new JCheckBox();
    JCheckBox op2 = new JCheckBox();
    JCheckBox op3 = new JCheckBox();
    JCheckBox op4 = new JCheckBox();
    JCheckBox op5 = new JCheckBox();
    
    JTextArea aposta = new JTextArea();
       
    JButton confirma = new JButton("Confirmar");
    JButton troca = new JButton("Trocar cartas selecionadas");
    JButton entrar = new JButton("Começar novo jogo");
    
    
	public Gui_poker() throws IOException{
		
		super("Video Poker");
		this.setLayout(new CardLayout());
		Container cont = this.getContentPane();
		JPanel principal = new JPanel();
                
                int alt = 150;
		int larg = 200;
		
                
		ImageIcon im1 = new ImageIcon((ImageIO.read(new File("/home/USUARIOS/10734686/NetBeansProjects/graphic_vp/src/images/back_card.png"))).getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im2 = new ImageIcon(new ImageIcon("/home/USUARIOS/10734686/NetBeansProjects/graphic_vp/src/images/back_card.png").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im3 = new ImageIcon(new ImageIcon("/home/USUARIOS/10734686/NetBeansProjects/graphic_vp/src/images/back_card.png").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon im4 = new ImageIcon(new ImageIcon("/home/USUARIOS/10734686/NetBeansProjects/graphic_vp/src/images/back_card.png").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
                ImageIcon im5 = new ImageIcon(new ImageIcon("/home/USUARIOS/10734686/NetBeansProjects/graphic_vp/src/images/back_card.png").getImage().getScaledInstance(alt, larg, Image.SCALE_DEFAULT));
		ImageIcon fundo = new ImageIcon("./src/images/feltro.jpg");
		//JLabel back = new JLabel(fundo);
              
             
                
                
                setSize(1000,800);
		
		//principal.add(back);
                
                cont.add(principal);
		carta1 = new JLabel(im1);
		carta2 = new JLabel(im2);
		carta3 = new JLabel(im3);
		carta4 = new JLabel(im4);
                carta5 = new JLabel(im5);
                
                carta1.setIcon(im1);
                carta2.setIcon(im2);
                carta3.setIcon(im3);
                carta4.setIcon(im4);
                carta5.setIcon(im5);
                
		principal.add(carta1);
		principal.add(carta2);
		principal.add(carta3);
		principal.add(carta4);
		principal.add(carta5);
                
                principal.add(op1);
                principal.add(op2);
                principal.add(op3);
                principal.add(op4);
                principal.add(op5);
                
                aposta.setSize(200, 20);
                principal.add(aposta);
                principal.add(confirma);
                principal.add(troca);
                
                troca.setEnabled(false);
                
		op1.addActionListener(this);
                op2.addActionListener(this);
                op3.addActionListener(this);
                op4.addActionListener(this);
                op5.addActionListener(this);
                
                aposta.addKeyListener((KeyListener) this);
                
                troca.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        int valor = 0;
                       
                        try{
                            valor = Integer.parseInt(aposta.getText());
                        }
                        catch(NumberFormatException ex){
                            troca.setText("Valor Inválido");
                            troca.setEnabled(false);
                        }
                        
                        if(valor <= 0){
                            troca.setText("Valor Inválido");
                            troca.setEnabled(false);
                        }
                        
                        
                        
                        
                    }
                
                
                });
                
            
                aposta.getDocument().addDocumentListener((DocumentEvent e) -> {
                });
                
            
		setLocation(600,300);
	
		setVisible(true);
               
                        
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(op1.isSelected() || op2.isSelected() || op3.isSelected() || op4.isSelected() || op5.isSelected())
            troca.setEnabled(true);
        else
            troca.setEnabled(false);
        
        
        
        
    }
	
}
