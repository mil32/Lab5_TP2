package UTN.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Gameboard {

        private String word;
        private List<Character> word2 = new ArrayList<>();
        private List<Character> guessedLetters = new ArrayList<>();
        private Set<Character> lettersToGuess = new HashSet<>();
        private String winner;

        public Gameboard (){

            this.word = "vieja";
            this.word2 = this.word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            this.lettersToGuess = this.word.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        }

        private void addGuesedLetter (Character ch){
            this.guessedLetters.add(ch);
        }

        public String getWord(){
            return this.word;
        }
        public void setWinner(String wn) {this.winner = wn; }
        public String getWinner(){return this.winner;}

        public boolean guessLetter (Character x) {
            if (this.word2.contains(Character.toLowerCase(x))) {
                this.addGuesedLetter(x);
                return true;
            } else {
                return false ;
            }
        }

        public boolean gameOver(){

            if(lettersToGuess.size() == guessedLetters.size()){
                return true;
            }else {
                return false;
            }

        }

        public void showCharacters(){
            this.word2.forEach(character -> {
                if(this.guessedLetters.contains(character)) {
                    System.out.print(character);
                    System.out.print(' ');
                }else {
                    System.out.print('_');
                    System.out.print(' ');
                }
            });

        }

}
