package core;

/**
 * Created by Akihiro on 2017/05/27.
 */
public class Masume {

    private int x;
    private int y;

    public Masume(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Masume masume){
        return (this.x == masume.x && this.y == masume.y);
    }

    public boolean is_safe(){
        return (x >= 1 && x <= 9) && (y >= 1 && y <= 9);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
