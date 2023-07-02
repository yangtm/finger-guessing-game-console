package GAME;

public class computer extends Plaver {
    @Override
    public int showFist(){
        int random=(int)(Math.random()*10)%3+1;
        return random;
    }
}
