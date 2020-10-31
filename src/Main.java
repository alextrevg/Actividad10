

public class Main {

    public static void main(String[] args) throws Exception {

        String[] palos = {"Corazones", "Picas", "Diamantes", "Treboles"};
        String[] valor = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        Deck dck = new Deck();
        dck.baraja(palos, valor);
        dck.showMenu();
        dck.shuffle();
        dck.head();
        dck.pick();
        dck.hand(5);



    }
}
