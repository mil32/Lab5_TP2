package UTN.Entities;

import java.util.*;

public class Player implements Runnable{

    static Gameboard game;
    static Set<Character> letters = new HashSet<>();
    static boolean available = true;
    //private static Integer wLenght;

    private String name;
    private Integer chances = 7;

    public Player(String name) {
        this.name = name;
    }


    public static void setGame(Gameboard gameb){
        game = gameb;
    }
    public static Gameboard getGame(){return game;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private synchronized void tryLetter () {

        Character x;

        while (!available) {
            try {
                System.out.println("** " +this.getName()+" pensando...");
                wait(300);
                System.out.println("** " +this.getName()+" Listo!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        available = false;

        do {
            x = (char) (new Random().nextInt(26) + 'a');
        } while (!letters.add(x));

        System.out.println(this.getName() + " tries letter -> " + x);

        if (!game.guessLetter(x) ){
            this.chances --;
            System.out.println("-- FAIL! :( " +this.getName() +" chances left -> " +this.chances);
        } else {
            System.out.print( "-- HIT! -> ");
            game.showCharacters();
            System.out.printf("\n");
        }

        if(game.gameOver()){
            game.setWinner(this.getName());
            System.out.println("------ GANEEEE! ------");
        }

        if(this.chances==0) {
            System.out.println("---- PERDI X( ---");
        }
        System.out.println("===============================");

        available = true;

        notifyAll();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
            while (!game.gameOver() && chances > 0) {
                tryLetter();
            }
    }
}
