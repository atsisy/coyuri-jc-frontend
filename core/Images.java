package core;

import javafx.scene.image.Image;

import java.nio.file.Paths;

import static config.Values.*;

/**
 * Created by Akihiro on 2017/05/21.
 */
public class Images {

    private Image[] images;

    public Images(){
        images = new Image[30];

        	/*
	*駒が置かれていない
	*/
        images[EMPTY] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\ban.png").toUri().toString());
        images[TARGET] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/target.png").toUri().toString());

	/*
	*味方
	*/
        images[HU] = new Image(Paths.get("image/hu.png").toUri().toString());
        images[KYOUSHA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/kyousha.png").toUri().toString());
        images[KEIMA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/keima.png").toUri().toString());
        images[GIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/gin.png").toUri().toString());
        images[KIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/kin.png").toUri().toString());
        images[HISHA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/hisha.png").toUri().toString());
        images[KAKU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/kaku.png").toUri().toString());
        images[TOKIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/tokin.png").toUri().toString());
        images[NARIKYOU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/narikyou.png").toUri().toString());
        images[NARIKEI] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/narikei.png").toUri().toString());
        images[NARIGIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/narigin.png").toUri().toString());
        images[RYU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/ryu.png").toUri().toString());
        images[UMA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/uma.png").toUri().toString());
        images[OU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/ou.png").toUri().toString());

	/*
	*敵側
	*/
        images[EN_HU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_hu.png").toUri().toString());
        images[EN_KYOUSHA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_kyousha.png").toUri().toString());
        images[EN_KEIMA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_keima.png").toUri().toString());
        images[EN_GIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_gin.png").toUri().toString());
        images[EN_KIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_kin.png").toUri().toString());
        images[EN_HISHA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_hisha.png").toUri().toString());
        images[EN_KAKU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_kaku.png").toUri().toString());
        images[EN_TOKIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_tokin.png").toUri().toString());
        images[EN_NARIKYOU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_narikyou.png").toUri().toString());
        images[EN_NARIKEI] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_narikei.png").toUri().toString());
        images[EN_NARIGIN] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_narigin.png").toUri().toString());
        images[EN_RYU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_ryu.png").toUri().toString());
        images[EN_UMA] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_uma.png").toUri().toString());
        images[EN_OU] = new Image(Paths.get("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/en_ou.png").toUri().toString());

	/*coyuri1の画像
        coyuri_images[DEFAULT] = new Image("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/c2_nor.png").toUri().toString());
        coyuri_images[SMILE] = new Image("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/c2_sm.png").toUri().toString());
        coyuri_images[UMM] = new Image("C:\\Users\\Akihiro\\IdeaProjects\\contem_front\\image\\/c2_dmd.png").toUri().toString());
    */

    }

    Image getImage(int index){
        return images[index];
    }

}
