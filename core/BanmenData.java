package core;

/**
 * Created by Akihiro on 6/25/2017.
 */
public class BanmenData {

    private int[][] system_ban;

    private int[] ai_system_mochi;
    private int[] pl_system_mochi;

    public BanmenData(Banmen ban){

        system_ban = new int[9][9];
        ai_system_mochi = new int[7];
        pl_system_mochi = new int[7];

        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                system_ban[x][y] = ban.get_system_ban_value_direct(x, y);
            }
        }

        for(int x = 0;x < 7;x++){
            ai_system_mochi[x] = ban.get_ai_mochi().at(x);
            pl_system_mochi[x] = ban.get_pl_mochi().at(x);
        }

    }

    int get_system_ban_value_direct_xy(int x, int y){
        return system_ban[x][y];
    }

    int get_ai_mochi_at(int index){
        return ai_system_mochi[index];
    }

    int get_pl_mochi_at(int index){
        return pl_system_mochi[index];
    }


}
