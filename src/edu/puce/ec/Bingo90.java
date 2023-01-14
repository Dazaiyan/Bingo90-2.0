package edu.puce.ec;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Bingo90 extends JFrame {

    private ArrayList<Integer> List; 
    private Tablero board;
    private JLabel Num;
  
    private JButton btnBola;
   
    public static void main(String[] args) {
    	Bingo90 bingo = new Bingo90();
    	bingo.setVisible(true);
    	
    	}
    
    public Bingo90() {
    	setBackground(new Color(255, 0, 0));
    	getContentPane().setBackground(new Color(255, 255, 128));
        setTitle("BINGO90");
        
        setSize(542, 676);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setLayout(null);

        List = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	List.add(i);
        }
        Collections.shuffle(List);
        
        board = new Tablero();
        board.setBounds(10, 148, 505, 478);
        board.setSacados(List);
        
        getContentPane().add(board);

        Num = new JLabel();
        Num.setBackground(new Color(0, 0, 0));
        Num.setForeground(new Color(0, 0, 0));
        Num.setFont(new Font("Unispace", Font.PLAIN, 64));
        Num.setBounds(89, 19, 240, 118);
        getContentPane().add(Num);
        

        btnBola = new JButton("SACAR BOLA");
        btnBola.setBackground(Color.GREEN);
        btnBola.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnBola.setBounds(272, 49, 240, 88);
        btnBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (List.size() > 0 && !board.tablaLlena()) {
                    int numero = List.remove(0);
                    
                    Num.setText(Integer.toString(numero));
                    board.marcarNumero(numero);
                
                } else {
                	Num.setText("FIN");
                	btnBola.setEnabled(false);
                
                }
                }
                });
                getContentPane().add(btnBola);
                
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setForeground(new Color(128, 255, 255));
                lblNewLabel_1.setBackground(new Color(128, 255, 255));
                lblNewLabel_1.setBounds(0, 0, 526, 626);
                getContentPane().add(lblNewLabel_1);
                
            }

            	}
