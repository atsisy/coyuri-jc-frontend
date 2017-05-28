package core;

import java.util.ArrayList;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/27.
 */
public class Wcm {

    public static ArrayList<Masume> null_wcm(){
        return new ArrayList<Masume>();
    }

    public static ArrayList<Masume> pl_hu_wcm(Banmen ban, Masume current){
        ArrayList<Masume> result = new ArrayList<>();
        if(ban.is_empty(current.getX(), current.getY() - 1)){
            result.add(new Masume(current.getX(), current.getY() - 1));
        }
        return result;
    }

    public static ArrayList<Masume> pl_kyousha_wcm(Banmen ban, Masume current){
        ArrayList<Masume> result = new ArrayList<>();
        for(int y = current.getY()-1;y >= 1;y--){
            if(ban.is_empty(current.getX(), y)){
                result.add(new Masume(current.getX(), y));
            }else{
                if(isAIs(ban, new Masume(current.getX(), y))){
                     result.add(new Masume(current.getX(), y));
                }
                break;
            }
        }
        return result;
    }

    private static boolean isMine(Banmen ban, Masume masume){
        return ban.get_system_ban_value(masume.getX(), masume.getY()) >= HU && ban.get_system_ban_value(masume.getX(), masume.getY()) <= OU;
    }

    private static boolean isAIs(Banmen ban, Masume masume){
        return ban.get_system_ban_value(masume.getX(), masume.getY()) >= EN_HU && ban.get_system_ban_value(masume.getX(), masume.getY()) <= EN_OU;
    }

}
