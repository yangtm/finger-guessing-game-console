package GAME;

public abstract class Plaver{
        private String name; private int score;
        public String getName(){
            return name;}

        public void setName(String name){
            this.name =name;}
        public int getscore(){
            return score;
        }
        public void setscore(int score) {
            this.score =score;}

        public abstract int showFist();

    public int getScore() {
        return 0;
    }
}