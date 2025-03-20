package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;




public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	HashMap<String, Casilla> casillas=new HashMap<String, Casilla>();
	ArrayList<Casilla> tabla=new ArrayList<Casilla>();
    private static final Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN};
    Color color;


	public Tablero() {
		
		setLayout(new GridLayout(5,5));
		
		setPreferredSize (new Dimension(200,200));

		crearTablero();

	}
	

    public void crearTablero() {
        for (char f = 'a'; f < 'f'; f++) {
            for (int c = 0; c < 5; c++) {
                String coordenada = f + "" + c;
                Casilla casilla = new Casilla(coordenada);  // Crear casilla con coordenada
                casilla.setPreferredSize(new Dimension(40, 40));
                casillas.put(coordenada, casilla);
                add(casilla);
               
                
                // Añadir el evento de clic al a cada casilla
                casilla.addMouseListener(new MouseAdapter() {@Override
                    public void mouseClicked(MouseEvent e) { 
                	
    				// Cambiar el color al hacer clic en la casilla
                	if (e.getButton()==e.BUTTON1) {
                		color=colores[numRandom()];
                		casilla.setColor(color);
                		System.out.println(casilla.getNameColor());
                	}
                	
                	
                	
                		
                		//si las casillas vecinas son del mismo color se ponen gris
                		if (color!=Color.gray) {
                			
                			for (Casilla c:casillasVecinas(coordenada)) {
                				
                				if (c != null && c.getColor() == color) {	
                					Casilla[] casillasRelacionas=casillasRelacionadas(coordenada);
                					reiniciarColores(casillasRelacionas);
                				}
                    		}
                	  }
                	
                  }
                });
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
	
	public int numRandom () {
	Random random=new Random();
	return random.nextInt(6);
	}
	
	 // Método para cambiar el color de la casilla al azar
    public void cambiarColorCasilla(Casilla casilla,Color c) {
        // Cambiar el color al azar
        casilla.setColor(c);
        
        // Llamar a la función que verifica y actualiza las casillas vecinas
        verificarVecinasYActualizar(casilla);
    }

    // Verifica las vecinas y actualiza las relacionadas si el color de alguna vecina coincide
    public void verificarVecinasYActualizar(Casilla casilla) {
        String coordenada = casilla.getCoordenada();
        Color color = casilla.getColor();
        
        if (color != Color.gray) {
            Casilla[] vecinas = casillasVecinas(coordenada);
            for (Casilla vecina : vecinas) {
                if (vecina != null && vecina.getColor() == color) {
                    Casilla[] casillasRelacionadas = casillasRelacionadas(coordenada);
                    reiniciarColores(casillasRelacionadas);
                    
                }
            }
        }
    }



	


}
