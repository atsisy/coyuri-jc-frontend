package core;

import java.util.ArrayList;

import static config.Values.EMPTY;

/**
 * Created by Akihiro on 2017/05/27.
 */
public class Wcm {

    public static ArrayList<Masume> null_wcm(){
        return new ArrayList<Masume>();
    }

    public static ArrayList<Masume> pl_hu_wcm(Banmen ban, Masume current){
        ArrayList<Masume> result = new ArrayList<>();
        if(ban.get_system_ban_value(current.getX(), current.getY() - 1) == EMPTY){
            result.add(new Masume(current.getX(), current.getY() - 1));
        }
        return result;
    }

}
