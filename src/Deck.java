import java.util.*;

public class Deck {

        Scanner eleccion= new Scanner(System.in);
        List<Card> Cartas;

        public void baraja(String[]valor, String[]palos) {

            Cartas = new ArrayList<>();

            for (int p = 0; p < palos.length; p++) {
                for (int v = 0; v < valor.length; v++) {
                    Card Carta = new Card();
                    if (palos[p].equals("Corazones") || palos[p].equals("Diamantes")) {
                        Carta.color = "Rojo";
                    }else{
                        Carta.color = "Negro";
                    }
                    Carta.palos = palos[p];
                    Carta.valor = valor[v];
                    Cartas.add(Carta);
                }
            }
        }

        public void shuffle(){
            Collections.shuffle(Cartas);
            System.out.println("Se mezclo el Deck");
        }

        public void head(){
            Card Carta = Cartas.get(0);
            System.out.println("{Palo: "+ Carta.palos + "} {Color: " + Carta.color + "} {Valor: " + Carta.valor + "}");
            Cartas.remove(0);
            System.out.println("Quedan " + Cartas.size() + " cartas");
        }

        public void pick(){
            Random cartaaleatoria = new Random();
            int r = cartaaleatoria.nextInt(Cartas.size());
            Card Carta = Cartas.get(r);
            System.out.println("{Palo: "+ Carta.palos + "} {Color: " + Carta.color + "} {Valor: " + Carta.valor + "}");
            Cartas.remove(r);
            System.out.println("Quedan " + Cartas.size() + " cartas");
        }

            //Definir parametro para hand "int x" significa que esta esperando un valor
            //Simplificacion del hardcode con un ciclo for
        public void hand(int x) {
            for (int i = 0; i < x; i++) {
                {
                    Random cs1 = new Random();
                    int c1 = cs1.nextInt(Cartas.size());
                    Card Carta = Cartas.get(c1);
                    System.out.println("{Palo: " + Carta.palos + "} {Color: " + Carta.color + "} {Valor: " + Carta.valor + "}");
                    Cartas.remove(c1);
                }
            }
                System.out.println("Quedan " + Cartas.size() + " cartas");


        }

        public void showMenu() throws Exception {
                boolean salir = false;
            int opciones;
            do{
                    //int opciones;
                    System.out.println( "\nBienvenidos a Poker!");
                    System.out.println("Selecciona una opción");
                    System.out.println("1 Mezclar deck");
                    System.out.println("2 Sacar una carta");
                    System.out.println("3 Carta al azar");
                    System.out.println("4 Generar una mano de 5 cartas");
                    System.out.println("0 Salir");
                    opciones = eleccion.nextInt();

                    switch (opciones){


                        case 1:
                            shuffle();
                            break;
                        case 2:
                            head();
                            break;
                        case 3:
                            pick();
                            break;

                            // Se agrego condicional para saber si el numero de cartas restantes es menor que un "hand"
                        case 4:

                            if(Cartas.size() <5){
                                int n = Cartas.size();
                                hand(n);
                            }else{
                                hand(5);
                            }
                            break;


                        default:
                            System.out.println("\n Opción no valida");
                            break;

                        case 0:
                            System.out.println("Seleccionado Correctamente. ¡Hasta la proxima!");
                            System.exit(0);
                            break;
                        }


                try {
                    if (Cartas.size() <= 0) {
                        throw new Exception("Se han agotado las cartas");
                    }
                } catch (Exception c) {
                    System.out.println(c.getMessage());
                    System.exit(0);
                }


            }while (opciones != 0);


        }

}
