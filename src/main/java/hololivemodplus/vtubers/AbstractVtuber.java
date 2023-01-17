package hololivemodplus.vtubers;

import basemod.abstracts.CustomOrb;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import hololivemodplus.abilities.AbstractAbility;

import java.util.ArrayList;

public abstract class AbstractVtuber extends CustomOrb {
    public int HP = 0;
    public int ATK = 0;
    public boolean Taunt = false;
    public boolean upgraded = false;
    public boolean isdead = false;
    public ArrayList<AbstractAbility> onDamageAbilities = new ArrayList();
    public ArrayList<AbstractAbility> onEvokeAbilities = new ArrayList();
    public ArrayList<AbstractAbility> onAttackAbilities = new ArrayList();
    public String DESCRIPTION;
    public String UPGRADE_DESCRIPTION;
    private float DamageTimer = 0.3F;
    private float HPFontScale;
    private float ATKFontScale;
    private float TriggerScale = 1.0F;
    private static Texture TauntImg = ImageMaster.loadImage("img/UI/students/TauntImg.png");

    public AbstractVtuber(String ID, String NAME, int basePassiveAmount, int baseEvokeAmount, String imgPath) {
        super(ID, NAME, basePassiveAmount, baseEvokeAmount, (String)null, (String)null, imgPath);
    }

    public void render(SpriteBatch sb) {
        if (this.DamageTimer < 0.3F) {
            sb.setColor(1.0F, 0.1F, 0.1F, 1.0F);
            this.DamageTimer += Gdx.graphics.getDeltaTime();
        } else {
            sb.setColor(this.c);
        }

        if (this.HPFontScale > 0.7F) {
            this.HPFontScale -= Gdx.graphics.getDeltaTime() * this.HPFontScale * 2.0F;
        }

        if (this.ATKFontScale > 0.7F) {
            this.ATKFontScale -= Gdx.graphics.getDeltaTime() * this.ATKFontScale * 2.0F;
        }

        if (this.TriggerScale > 1.0F) {
            this.TriggerScale -= Gdx.graphics.getDeltaTime() * this.TriggerScale * 1.5F;
        }

        sb.draw(this.img, this.cX - 48.0F + this.bobEffect.y / 4.0F, this.cY - 48.0F + this.bobEffect.y / 4.0F,
                48.0F, 48.0F, 96.0F, 96.0F,
                this.scale * this.TriggerScale, this.scale * this.TriggerScale,
                0.0F, 0, 0, 96, 96, false, false);

        if (this.Taunt) {
            sb.draw(TauntImg, this.cX - 75.0F + this.bobEffect.y / 4.0F, this.cY - 75.0F + this.bobEffect.y / 4.0F,
                    75.0F, 75.0F, 150.0F, 150.0F,
                    this.scale * this.TriggerScale, this.scale * this.TriggerScale,
                    0.0F, 0, 0, 150, 150, false, false);
        }

        this.renderText(sb);
        this.updateDescription();
        this.hb.render(sb);
    }
}
