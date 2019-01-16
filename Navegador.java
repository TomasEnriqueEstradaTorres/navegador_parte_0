package uF5.practicas.practica1.navegador_parte_0;

import java.util.Stack;

// SOLO USAR: listas (List), conjuntos (Set), mapas o diccionarios (Map)

public class Navegador {

	private String URL;
	private Stack<String> pilaAtras = new Stack<String>();
	private Stack<String> pilaAdelante = new Stack<String>();

	// CONSTRUCTOR
	public Navegador() {
		// this.URL = "www.google.com";// es la pagina web por defecto
	}

	// SETTER Y GETTER
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	// Opcion 1
	public void anarA(String novaURL) { // va a la pagina web indicada
		// System.out.println("\n\tPagina web visitada: " + novaURL);
		pilaAtras.push(novaURL); // agrega la pagina a la pilaAtras
		URL = novaURL;// Mostrada la pagina actual.
	}

	// Opcion 2
	public void enrere() { // muestra la pagina web anterior
		try {
			String devuelto = pilaAtras.pop();
			pilaAdelante.push(devuelto);
			URL = devuelto;// Mostrada la pagina actual.
		} catch (Exception e) {
			// System.out.println(e); // indica que la pila esta vacia
			System.out.println("No hay mas paginas para atras");
		}
	}

	// Opcion 3
	public void endavant() {// muestra la pagina web posterior
		try {
			String devuelto = pilaAdelante.pop();
			pilaAtras.push(devuelto);
			URL = devuelto;// Mostrada la pagina actual.
		} catch (Exception e) {
			// System.out.println(e); // indica que la pila esta vacia
			System.out.println("No hay mas paginas para adelante");
		}
	}

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------
	public void mostrar() {
		for (String atras : pilaAtras) {
			System.out.println(atras);
		}

		System.out.println("\n------------------\n");

		for (String adelante : pilaAdelante) {
			System.out.println(adelante);
		}
	}
	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------

	public Object getPilaEndavant() {

		return null;
	}

	public Object getPilaEnrere() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void mostrarPila(Object object) {

	}

	public void afegirPreferit(String url) {
		// TODO Auto-generated method stub

	}

	public void eliminarPreferits(String url) {
		// TODO Auto-generated method stub

	}

	public void veurePreferits() {
		// TODO Auto-generated method stub

	}

	public void veureHistorial() {
		// TODO Auto-generated method stub

	}

	public void veureVisitades() {
		// TODO Auto-generated method stub

	}

}
