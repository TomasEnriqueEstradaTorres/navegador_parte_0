package uF5.practicas.practica1.navegador_parte_0;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// SOLO USAR: listas (List), conjuntos (Set), mapas o diccionarios (Map)

public class Navegador {

	private String URL;
	private Stack<String> pilaAtras = new Stack<String>();
	private Stack<String> pilaAdelante = new Stack<String>();
	
	//No permite objetos que sean iguales por medio de la url.
	private Set<Favoritos> favoritos = new HashSet<>(); 
	private Favoritos listaFavoritos; // servira para poder saber si la pagina ya ha sido agregada
	//private ArrayList<String> favoritos = new ArrayList<String>();
	
	private ArrayList<Historial> historial = new ArrayList<Historial>();
	//private
	

	//private ArrayList<Historial> visitas = new ArrayList<Historial>();
	//private Visitas verVisitas;

	// CONSTRUCTOR
	public Navegador() {
	}

	// SETTER Y GETTER
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public Stack<String> getPilaAtras() { 
		//Navegador.mostrarPila(firefox.getPilaEnrere()); 
		return pilaAtras;
	}

	public Stack<String> getPilaAdelante() { 
		//Navegador.mostrarPila(firefox.getPilaEndavant()); 
		return pilaAdelante;
	}

	// METODOS

	// Opcion 1
	public void anarA(String novaURL) { // va a la pagina web indicada
		// System.out.println("\n\tPagina web visitada: " + novaURL);
		pilaAtras.push(novaURL); // agrega la pagina a la pilaAtras
		URL = novaURL;// Mostrada la pagina actual.
		historial.add(new Historial(novaURL, LocalDate.now(), LocalTime.now()));// Crea y agrega los datos al historial
	}

	// Opcion 2
	public void enrere() { // muestra la pagina web anterior
		try {
			String devuelto = pilaAtras.pop();
			pilaAdelante.push(devuelto);
			URL = devuelto;// Mostrada la pagina actual.
			historial.add(new Historial(getURL(), LocalDate.now(), LocalTime.now()));// Crea y agrega los datos al historial
		} catch (Exception e) {
			// System.out.println(e); // indica que la pila esta vacia
			System.out.println("\tNo hay mas paginas para atras");
		}
	}

	// Opcion 3
	public void endavant() {// muestra la pagina web posterior
		try {
			String devuelto = pilaAdelante.pop();
			pilaAtras.push(devuelto);
			URL = devuelto;// Mostrada la pagina actual.
			historial.add(new Historial(getURL(), LocalDate.now(), LocalTime.now()));// Crea y agrega los datos al historial
		} catch (Exception e) {
			// System.out.println(e); // indica que la pila esta vacia
			System.out.println("\tNo hay mas paginas para adelante");
		}
	}

	// Opcion 4
	public void afegirPreferit(String url) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\tIngrese Descripcion: ");
		String detalle = sc.nextLine();// guarda la descripcion de la pagina
		listaFavoritos = new Favoritos(url, detalle);
		boolean existe = favoritos.contains(listaFavoritos);// verifica si ya esta guardada la pagina
		if (existe) {
			System.out.println("\tLa pagina ya ha sido agregada.");
		}else {
			favoritos.add(listaFavoritos);
			System.out.println("\tPagina agregada: " + url);
		}
	}

	// Opcion 5
	public void eliminarPreferits(String url) {		
		// Se pasa favoritos a un iterador para poder borrar mientras se recorre la lista
		Iterator<Favoritos> iterator = favoritos.iterator();
		while (iterator.hasNext()){// mientras alla un siguiente mas adelante sigue
			// verifica el nombre que hay en cada objeto
		    String nombreURL = iterator.next().getNombreURL();
		    if(nombreURL.equals(url)){//comprueba si son iguales
		        iterator.remove();// remueve el objeto con el nombre de url igual
		        System.out.println("\tPagina borrada: " + url);
		    }
		}
	}

	// Opcion 6
	public void veurePreferits() {
		System.out.println("\nLISTA DE PAGINAS FAVORITAS");
		System.out.println("===============================");
		if (favoritos.isEmpty()) {
			System.out.println("No hay favoritos.");
		} else {
			for (Favoritos favorito : favoritos) {
				System.out.println(favorito);
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

	// ------------------------------------------------------------------------
	// ------------------------------------------------------------------------

	// Opcion 8
	public void veureVisitades() {
		
		

	}



	// Funcionamiento de las pilas, se podra ver en la consola
	public static void mostrarPila(Stack<String> pilas) {
		//System.out.println("\n-----------------------------------------------------------");
		for (String string : pilas) {
			System.out.println(string);
		}
		//System.out.println("\n-----------------------------------------------------------");
	}
}
