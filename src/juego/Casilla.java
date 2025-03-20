package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class Casilla extends JPanel {
    private ArrayList<Color> colores = new ArrayList<>();
    private Color color;
    private String coordenada;
    private static final long serialVersionUID = 1L;

    public Casilla(String coordenada) {
        this.coordenada = coordenada;
        color = Color.gray;

        colores.add(Color.RED);
        colores.add(Color.GREEN);
        colores.add(Color.BLUE);
        colores.add(Color.YELLOW);
        colores.add(Color.MAGENTA);
        colores.add(Color.CYAN);

        setBackground(color);
        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    }

 

    public String getCoordenada() {
        return coordenada;
    }

    public void setColor(Color c) {
        setBackground(c);
        this.color = c;
        repaint();
    }

    public Color getColor() {
        return this.color;
    }

    public String getNameColor() {
    	
    	
        if (color ==Color.RED) {
        	return "rojo";
        }
        else if (color == Color.BLUE) {
        	return "azul";
        }
        else if (color ==  Color.GREEN) {
        	return "verde";
        }
        else if (color == Color.YELLOW) {
        	return "amarillo";
        }
        else if (color == Color.MAGENTA) {
        	return "magenta";
        }
        return "cyan";
       
    }
}
