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
        if(isMovable(ban, new Masume(current.getX(), current.getY() - 1))){
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
                if(isMovable(ban, new Masume(current.getX(), y))){
                     result.add(new Masume(current.getX(), y));
                }
                break;
            }
        }
        return result;
    }

    public static ArrayList<Masume> pl_keima_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() - 2))){
            result.add(new Masume(masume.getX() - 1, masume.getY() - 2));
        }
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() - 2))){
            result.add(new Masume(masume.getX() + 1, masume.getY() - 2));
        }
        return result;
    }

    public static ArrayList<Masume> pl_gin_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();

        //正面
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() - 1))){
            result.add(new Masume(masume.getX(), masume.getY() - 1));
        }

        //右斜め上
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() - 1));
        }

        //左斜め上
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() - 1));
        }

        //右斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() + 1));
        }

        //左斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() + 1));
        }


        return result;
    }

    public static ArrayList<Masume> pl_kin_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();

        //正面
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() - 1))){
            result.add(new Masume(masume.getX(), masume.getY() - 1));
        }

        //右斜め上
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() - 1));
        }

        //左斜め上
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() - 1));
        }

        //右
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY()))){
            result.add(new Masume(masume.getX() - 1, masume.getY()));
        }

        //左
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY()))){
            result.add(new Masume(masume.getX() + 1, masume.getY()));
        }

        //後ろ
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() + 1))){
            result.add(new Masume(masume.getX(), masume.getY() + 1));
        }


        return result;
    }

    public static ArrayList<Masume> pl_ou_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();

        //正面
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() - 1))){
            result.add(new Masume(masume.getX(), masume.getY() - 1));
        }

        //右斜め上
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() - 1));
        }

        //左斜め上
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() - 1));
        }

        //右
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY()))){
            result.add(new Masume(masume.getX() - 1, masume.getY()));
        }

        //左
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY()))){
            result.add(new Masume(masume.getX() + 1, masume.getY()));
        }

        //右斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() + 1));
        }

        //左斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() * 1));
        }

        //後ろ
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() + 1))){
            result.add(new Masume(masume.getX(), masume.getY() + 1));
        }


        return result;
    }

    public static ArrayList<Masume> pl_hisha_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();
        Masume i_t_i;

        int i = 1;

        //上方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX(), masume.getY() - i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)){
                break;
            }
            i++;
        }

        i = 1;
        //下方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX(), masume.getY() + i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        i = 1;
        //右方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() - i, masume.getY()))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        i = 1;
        //左方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() + i, masume.getY()))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        return result;
    }

    public static ArrayList<Masume> pl_ryu_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = pl_hisha_wcm(ban, masume);


        //右斜め上
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() - 1));
        }

        //左斜め上
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() - 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() - 1));
        }

        //右斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() - 1, masume.getY() + 1));
        }

        //左斜め後ろ
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY() + 1))){
            result.add(new Masume(masume.getX() + 1, masume.getY() * 1));
        }

        return result;
    }

    public static ArrayList<Masume> pl_kaku_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = new ArrayList<>();
        Masume i_t_i;

        int i = 1;

        //右斜め上方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() - i, masume.getY() - i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        i = 1;
        //左斜め上方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() + i, masume.getY() - i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        i = 1;
        //右斜め下方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() - i, masume.getY() + i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        i = 1;
        //左方向
        while(isMovable(ban, i_t_i = new Masume(masume.getX() + i, masume.getY() + i))){
            result.add(i_t_i);
            if(isAIs(ban, i_t_i)) {
                break;
            }
            i++;
        }

        return result;
    }

    public static ArrayList<Masume> pl_uma_wcm(Banmen ban, Masume masume){
        ArrayList<Masume> result = pl_kaku_wcm(ban, masume);

        //正面
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() - 1))){
            result.add(new Masume(masume.getX(), masume.getY() - 1));
        }

        //右
        if(isMovable(ban, new Masume(masume.getX() - 1, masume.getY()))){
            result.add(new Masume(masume.getX() - 1, masume.getY()));
        }

        //左
        if(isMovable(ban, new Masume(masume.getX() + 1, masume.getY()))){
            result.add(new Masume(masume.getX() + 1, masume.getY()));
        }

        //後ろ
        if(isMovable(ban, new Masume(masume.getX(), masume.getY() + 1))){
            result.add(new Masume(masume.getX(), masume.getY() + 1));
        }

        return result;
    }


    private static boolean isMine(Banmen ban, Masume masume){
        return ban.get_system_ban_value(masume.getX(), masume.getY()) >= HU && ban.get_system_ban_value(masume.getX(), masume.getY()) <= OU;
    }

    private static boolean isAIs(Banmen ban, Masume masume){
        return ban.get_system_ban_value(masume.getX(), masume.getY()) >= EN_HU && ban.get_system_ban_value(masume.getX(), masume.getY()) <= EN_OU;
    }

    private static boolean isMovable(Banmen ban, Masume masume){
        if(!masume.is_safe()){
            return false;
        }
        return isAIs(ban, masume) || ban.is_empty(masume);
    }

}
