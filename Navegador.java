package uF5.practicas.practica1.navegador_parte_0;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Stack;

// SOLO USAR: listas (List), conjuntos (Set), mapas o diccionarios (Map)

public class Navegador {

	private String URL;
	private Stack<String> pilaAtras = new Stack<String>();
	private Stack<String> pilaAdelante = new Stack<String>();
	private ArrayList<String> favoritos = new ArrayList<String>();
	
	private ArrayList<Historial> historial = new ArrayList<Historial>();
	private Historial verHistorial;

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
		//Crea los datos para el historial con URL, fecha y hora
		verHistorial = new Historial(novaURL, LocalDate.now(), LocalTime.now());
		historial.add(verHistorial);// agrega los datos al historial
	}

	// Opcion 2
	public void enrere() { // muestra la pagina web anterior
		try {
			String devuelto = pilaAtras.pop();
			pilaAdelante.push(devuelto);
			URL = devuelto;// Mostrada la pagina actual.
			
			//Crea los datos para el historial con URL, fecha y hora
			verHistorial = new Historial(getURL(), LocalDate.now(), LocalTime.now());
			historial.add(verHistorial);// agrega los datos al historial
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
			
			//Crea los datos para el historial con URL, fecha y hora
			verHistorial = new Historial(getURL(), LocalDate.now(), LocalTime.now());
			historial.add(verHistorial);// agrega los datos al historial
		} catch (Exception e) {
			// System.out.println(e); // indica que la pila esta vacia
			System.out.println("No hay mas paginas para adelante");
		}
	}
	
	// Opcion 4
	public void afegirPreferit(String url) {
		boolean existe = favoritos.contains(url);// verifica si ya esta guardada la pagina
		if (existe) {
			System.out.println("\tLa pagina ya ha sido agregada.");
		}else {
			favoritos.add(url);
			System.out.println("\tPagina agregada: " + url);
		}
	}

	// Opcion 5
	public void eliminarPreferits(String url) {
		boolean borrada = favoritos.contains(url);// verifica si ya esta eliminada la pagina
		if (borrada) {
			favoritos.remove(url);
			System.out.println("\tPagina borrada: " + url);
		}else {
			System.out.println("\tLa pagina ya ha sido borrada.");
		}
	}
	
	// Opcion 6
	public void veurePreferits() {
		System.out.println("\nLISTA DE PAGINAS FAVORITAS");
		System.out.println("===============================");
		if (favoritos.isEmpty()) {
			System.out.println("No hay favoritos.");
		}else {
			for (String lista : favoritos) {
				System.out.println(lista);
			}
		}
		System.out.println("===============================");
	}
	
	// Opcion 7
	public void veureHistorial() {
		System.out.println("\n=====================HISTORIAL========================");
		for (Historial listaHistorial : historial) {
			System.out.println(listaHistorial);
		}
		System.out.println("\n======================================================");
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
	
	
	public void veureVisitades() {
		// TODO Auto-generated method stub

	}
	
	
	
	
	
	
	
	
	
	

	public Object getPilaEndavant() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPilaEnrere() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void mostrarPila(Object object) {

	}



	

}
