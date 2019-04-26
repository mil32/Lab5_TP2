package UTN;

import UTN.Entities.Gameboard;
import UTN.Entities.Player;

public class App 
{
    public static void main( String[] args )
    {

        Player.setGame(new Gameboard());
        System.out.println("-- WORD : "+Player.getGame().getWord().toUpperCase() +" --");

        Thread player1 = new Thread(new Player("CARLOS"));
        Thread player2 = new Thread(new Player("JULIO"));
        Thread player3 = new Thread(new Player("MANU"));

        player1.start();
        player2.start();
        player3.start();


    }
}
