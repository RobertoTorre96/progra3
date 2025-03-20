package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;



public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	HashMap<String, Casilla> casillas=new HashMap<String, Casilla>();

	public Tablero() {
		
		setLayout(new GridLayout(5,5));
		
		setPreferredSize (new Dimension(200,200));

		CrearTablero();

	}
	

	public void CrearTablero() {
		
		for (char f='a';f<'f';f++) {
			for (int c=0;c<5;c++) {
				Casilla casilla = new Casilla(f + "" + c, this);  // Crear la casilla con su coordenada
                casilla.setPreferredSize(new Dimension(40, 40)); // Establecer el tamaño de cada casilla
                add(casilla);  // Añadir cada casilla al panel
                casillas.put(casilla.getCoordenada(), casilla);
			}
		}
	}
	
	
	public Casilla[] casillasVecinas (String coordenada) {

		char fila=coordenada.charAt(0);
		char col=coordenada.charAt(1);
		
		
		Casilla[] vecinas=new Casilla[2];
		Casilla casillaIzq=casillas.get(fila+""+(char)(col-1));
		Casilla casillaDer=casillas.get(fila+""+(char)(col+1));
		
		vecinas[0]=casillaIzq;
		vecinas[1]=casillaDer;
		
		return vecinas;
		
		
	}
	
	public Casilla[] casillasRelacionadas(String coordenada) {

		char fila=coordenada.charAt(0);
		char col=coordenada.charAt(1);
		Casilla[] modificar=new Casilla[5];
		
		Casilla casilla=casillas.get(coordenada);
		Casilla casillaIzq=casillas.get(fila+""+(char)(col-1));
		Casilla casillaDer=casillas.get(fila+""+(char)(col+1));
		Casilla casillaAbajo=casillas.get((char)(fila+1)+""+col);
		Casilla casillaarriba=casillas.get((char)(fila-1)+""+col);

		modificar[0]=casilla;
		modificar[1]=casillaIzq;
		modificar[2]=casillaDer;
		modificar[3]=casillaarriba;
		modificar[4]=casillaAbajo;
		
		return modificar;
	}
	
	
	public void reiniciarColores(Casilla[] casillas) {
		
		for (Casilla c:casillas) {
			
			if (c!=null) {
				
				c.setColor(Color.gray);
				
				
			}

			
		}
		
	}

	public HashMap<String, Casilla> getCasillas() {
		return casillas;
	}

	public Casilla getCasilla(String coordenada) {
		return casillas.get(coordenada);
	}
	


}
