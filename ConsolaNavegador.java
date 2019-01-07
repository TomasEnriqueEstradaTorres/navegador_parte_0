
package uF5.practicas.practica1.navegador_parte_0;

import java.util.Scanner;

/**
 *
 * @author pere
 */
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

    /**
     * Mostra el menú principal de la aplicación.
     */
    public static void mostrarMenuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Anar a: ");  // ir a
        System.out.println("2. Enrere");  // atras
        System.out.println("3. Endavant"); // adelante
        System.out.println("4. Afegir a adreces d'interes");  // Añadir a direcciones de interes
        System.out.println("5. Eliminar d'adreces d'interes");  // Eliminar a direcciones de interes
        System.out.println("6. Veure adreces d'interes");  // Ver direcciones de interes
        System.out.println("7. Veure historial");  //  Ver historial
        System.out.println("8. Veure nombre visites");  // Ver número visitas
        System.out.println("0. Sortir");
        System.out.print("Opcion? ");
    }

    /**
     * Pide un código de barras hasta que se entre un valor no vacío.
     *
     * @return código de barras no vacío
     */
    public static String llegirURL() {
        String URL;
        Scanner lector = new Scanner(System.in);

        do {
            System.out.print("URL: ");
            URL = lector.nextLine();
        } while (URL.isEmpty());

        return URL;
    }

    /**
     * Lee un entero que representa una opción de menos.
     *
     * @return un entero, -1 si la entrada no se numerica
     */
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

    public static void main(String[] args) {
        Navegador firefox = new Navegador();
        int opcio;

        do {
            System.out.println(firefox.getURL());
            Navegador.mostrarPila(firefox.getPilaEndavant());
            Navegador.mostrarPila(firefox.getPilaEnrere());
            mostrarMenuPrincipal();
            opcio = llegirOpcio();
            switch (opcio) {
                case ENTRAR_URL:
                    String novaURL = llegirURL();
                    firefox.anarA(novaURL);
                    break;
                case ENRERE: // vacía el carro
                    firefox.enrere();
                    break;
                case ENDAVANT:
                    firefox.endavant();
                    break;
                case AFEGIR_PREFERITS:
                    firefox.afegirPreferit(firefox.getURL());
                    break;
                case ELIMINAR_PREFERITS:
                    firefox.eliminarPreferits(firefox.getURL());
                    break;
                case VEURE_PREFERITS:
                    firefox.veurePreferits();
                    break;
                case VEURE_HISTORIAL:
                    firefox.veureHistorial();
                    break;
                case VEURE_VISITADES:
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

}
