package edu.puce.ec;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Tablero extends JPanel {

    private JToggleButton[][] buttom; 
    private ArrayList<Integer> sacados; 

    public Tablero() {
    	setBackground(new Color(255, 128, 64));
        setLayout(new GridLayout(9, 10)); 
        buttom = new JToggleButton[9][10]; 

        for (int i = 0; i < 9; i++) { 
            for (int j = 0; j < 10; j++) { 
                int numero = i * 10 + j + 1; 
                buttom[i][j] = new JToggleButton(Integer.toString(numero)); 
                buttom[i][j].setEnabled(false); 
                add(buttom[i][j]); 
            }
        }
    }

    public void setSacados(ArrayList<Integer> sacados) {
        this.sacados = sacados; 
    }

    public void marcarNumero(int numero) {
        int i = (numero - 1) / 10; 
        int j = (numero - 1) % 10; 
        buttom[i][j].setBackground(Color.CYAN); 
        buttom[i][j].setEnabled(false); 
        sacados.add(numero); 
    }
    public void reiniciar() {
    	for (int i = 0; i < 9; i++) { 
            for (int j = 0; j < 10; j++) { 
            	buttom[i][j].setBackground(null); 
            	buttom[i][j].setEnabled(true); 
            }
        }
        sacados.clear(); 
    }

    public boolean tablaLlena() {
        for (int i = 0; i < buttom.length; i++) { 
            for (int j = 0; j < buttom[i].length; j++) { 
                if (!buttom[i][j].getBackground().equals(Color.CYAN)) { 
                    return false; 
                }
            }
        }
        return true; 
    }

    }
    
    