package UI;

import core.Banmen;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class FrontBan {

    private Banmen[] overlap_banmen;

    public FrontBan(){
        overlap_banmen = new Banmen[3];

        for(Banmen banmen : overlap_banmen){
            banmen = new Banmen();
        }

    }

}
