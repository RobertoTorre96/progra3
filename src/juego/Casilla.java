package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

	/**
	 * Create the panel.
	 */
	public Casilla(String coordenada,Tablero tablero) {

		this.coordenada=coordenada;
		
		color=Color.gray;

        colores.add(Color.RED);
        colores.add(Color.GREEN);
        colores.add(Color.BLUE);
        colores.add(Color.YELLOW);
        colores.add(Color.MAGENTA);
        colores.add(Color.CYAN);
        
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 1); 
        this.setBorder(borde);  // Asigna el borde a la casilla
        
        setBackground(color);
   setPreferredSize(new Dimension(40,40));
        
        addMouseListener(new MouseAdapter() {
           
			@Override
            public void mouseClicked(MouseEvent e) {
                // Cambiar el color al hacer clic en la casilla
            	
            	if (e.getButton()==e.BUTTON1) {
            		color=colores.get(numeroRandom());
            		setColor(color);
            		System.out.println(getNameColor());
            	}
            	
            	
            	
            		
            		
            		if (color!=Color.gray) {
            			
            			for (Casilla c: tablero.casillasVecinas(coordenada)) {
            				
            				if (c != null && c.getColor() == color) {
            					
            					for (Casilla c2 : tablero.casillasRelacionadas(coordenada)) {
                                    if (c2 != null) {
                                        c2.setColor(Color.gray);  // Cambiar a gris
                                    }
                                }
            				}
            			
            			
            			
            		}
            	}
            }

			private String getNameColor() {
				// TODO Auto-generated method stub

		      
				if (color==Color.red) {
					return "rojo";
				}
				else if (color==Color.GREEN) {
					return "verde";
					
				}
				else if (color==Color.BLUE) {
					return "azul";

				}
				else if (color==Color.YELLOW) {
					return "amarillo";

				}
				else if (color==Color.MAGENTA) {
					return "magenta";

				}
				

				
				return "CYAN";
				}
        	});

	

		

	}
	
	
	 private int numeroRandom() {
		 Random random = new Random();
		   int randomNumber = random.nextInt(6); // Genera un número entre 0 y 5 (inclusive)		 
		 return randomNumber;
	 }
	 
	 public String getCoordenada() {
		 return coordenada;
	 }
	 
	 public void setColor(Color c) {
		 setBackground(c);
		 this.color=c;
		 repaint();
	 }
	 
	 public Color getColor () {
		 return this.color;
	 }


}
