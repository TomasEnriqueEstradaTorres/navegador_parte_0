
package uF5.practicas.practica1.navegador_parte_0;

import java.util.Scanner;

public class ConsolaNavegador {

    //opciones menu principal
    final static int ENTRAR_URL = 1;
    final static int ENRERE = 2;
    final static int ENDAVANT = 3;
    final static int AFEGIR_PREFERITS = 4;
    final static int ELIMINAR_PREFERITS = 5;
    final static int VEURE_PREFERITS = 6;
    final static int VEURE_HISTORIAL = 7;
    final static int VEURE_VISITADES = 8;
    final static int SORTIR = 0;

    /**Mostra el men� principal de la aplicaci�n.      */
    public static void mostrarMenuPrincipal() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Anar a: ");  // ir a
        System.out.println("2. Enrere");  // atras
        System.out.println("3. Endavant"); // adelante
        System.out.println("4. Afegir a adreces d'interes");  // A�adir a direcciones de interes
        System.out.println("5. Eliminar d'adreces d'interes");  // Eliminar a direcciones de interes
        System.out.println("6. Veure adreces d'interes");  // Ver direcciones de interes
        System.out.println("7. Veure historial");  //  Ver historial
        System.out.println("8. Veure nombre visites");  // Ver n�mero visitas
        System.out.println("0. Sortir");
        System.out.print("\tOpcion: ");
    }
    
    /**Lee un entero que representa una opci�n de menos.
     * @return un entero, -1 si la entrada no se numerica      */
    public static int llegirOpcio() {
        Scanner lector = new Scanner(System.in);
        int opcio = 0;
        try {
            opcio = Integer.parseInt(lector.nextLine());
        } catch (NumberFormatException e) {
            opcio = -1;
        }
        return opcio;
    }
    
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Navegador firefox = new Navegador();
        int opcio;
        
        do {
        	System.out.println("\n===========NAVEGADOR===========");
            System.out.println(firefox.getURL());  // muestra la pagina actual.
            System.out.println("\n===============================");
            //Navegador.mostrarPila(firefox.getPilaEndavant());  //pila Adelante
            //Navegador.mostrarPila(firefox.getPilaEnrere());  //pila Atras
            System.out.println("\n----------------------------------------");
            System.out.println("ADELANTE:");
            Navegador.mostrarPila(firefox.getPilaAdelante());
            System.out.println("----------------------------------------");
            System.out.println("ATRAS:"); 
            Navegador.mostrarPila(firefox.getPilaAtras());  
            System.out.println("----------------------------------------");
            mostrarMenuPrincipal();  //Muestra el menu de opciones00
            opcio = llegirOpcio(); // sirve para elegir una opcion del menu
            switch (opcio) {
                case ENTRAR_URL:
                    String novaURL = llegirURL();
                    firefox.anarA(novaURL); // ir a / va a la pagina web indicada
                    break;
                case ENRERE: // Atras
                    firefox.enrere(); // 
                    break;
                case ENDAVANT: // Adelante
                    firefox.endavant(); // para adelante 
                    break;
                case AFEGIR_PREFERITS:  //A�adir a favoritos
                    firefox.afegirPreferit(firefox.getURL());
                    break;
                case ELIMINAR_PREFERITS://Eliminar favoritos
                    firefox.eliminarPreferits(firefox.getURL());
                    break;
                case VEURE_PREFERITS://Ver favoritos
                    firefox.veurePreferits();
                    break;
                case VEURE_HISTORIAL://Ver historial
                    firefox.veureHistorial();
                    break;
                case VEURE_VISITADES:// Ver visitadas
                    firefox.veureVisitades();
                    break;
                case SORTIR:
                    break;    
                default:
                    System.out.println("Opcio incorrecta");
                    break;
            }
        } while (opcio != SORTIR);
    }
    //--------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------
    
    
    /**Pide un c�digo de barras hasta que se entre un valor no vac�o.
     * @return c�digo de barras no vac�o      */
    public static String llegirURL() {
        String URL;
        Scanner lector = new Scanner(System.in);

        do {
            System.out.print("\nURL: ");
            URL = lector.nextLine();
        } while (URL.isEmpty());

        return URL;
    }
    
    
    

}
