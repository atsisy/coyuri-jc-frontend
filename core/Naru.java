package core;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/06/13.
 */
public class Naru {

    static int naru(int type){

        switch (type){
            case HU:
                return TOKIN;
            case KYOUSHA:
                return NARIKYOU;
            case KEIMA:
                return NARIKEI;
            case GIN:
                return NARIGIN;
            case KIN:
                return KIN;
            case HISHA:
                return RYU;
            case KAKU:
                return UMA;
            case OU:
                return OU;
        }

        return HU;
    }

}
