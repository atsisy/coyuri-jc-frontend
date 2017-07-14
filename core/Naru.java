package core;

import static config.Values.*;
import static config.Values.EN_HISHA;
import static config.Values.EN_KEIMA;

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

    static int reset_koma(int type){

        switch (type){
            case TOKIN:
                return HU;
            case NARIKYOU:
                return KYOUSHA;
            case NARIKEI:
                return KEIMA;
            case NARIGIN:
                return GIN;
            case RYU:
                return HISHA;
            case UMA:
                return KAKU;
            case EN_TOKIN:
                return EN_HU;
            case EN_NARIKYOU:
                return EN_KYOUSHA;
            case EN_NARIKEI:
                return EN_KEIMA;
            case EN_NARIGIN:
                return EN_GIN;
            case EN_RYU:
                return EN_HISHA;
            case EN_UMA:
                return EN_KAKU;
        }

        return type;

    }

}
