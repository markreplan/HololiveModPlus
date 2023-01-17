package hololivemodplus.characters;

import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

import static hololivemodplus.HololiveModPlus.characterPath;
import static hololivemodplus.HololiveModPlus.makeID;
import static hololivemodplus.util.GeneralUtils.rgbToColor;

public class HololiveCorp extends CustomPlayer {
    // Enums
    public static class Enums {
        @SpireEnum
        public static AbstractPlayer.PlayerClass HOLOLIVE_CORP;
        @SpireEnum(name = "HOLOLIVE_BLUE_COLOR") // These two HAVE to have the same absolutely identical name.
        public static AbstractCard.CardColor HOLOLIVE_BLUE;
        @SpireEnum(name = "HOLOLIVE_BLUE_COLOR") @SuppressWarnings("unused")
        public static CardLibrary.LibraryType LIBRARY_COLOR;
    }

    // Stats
    private static final int ENERGY_PER_TURN = 3;
    private static final int MAX_HP = 35;
    private static final int STARTING_GOLD = 66;
    private static final int ORB_SLOTS = 7;
    private static final int CARD_DRAW = 5;

    // Strings
    private static final String ID = makeID("HololiveCorp");
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    private static final String[] NAMES = characterStrings.NAMES;
    private static final String[] TEXT = characterStrings.TEXT;

    // Image paths
    private static final String SHOULDER_1 = characterPath("hololivecorp/shoulder1.png");
    private static final String SHOULDER_2 = characterPath("hololivecorp/shoulder2.png");
    private static final String CORPSE = characterPath("hololivecorp/corpse.png");
    private static final String CHAR_IMG = characterPath("hololivecorp/Hololive_Building.png");
    private static final String[] ORB_TEXTURES = new String[]{
            characterPath("hololivecorp/orb/layer1.png"),
            characterPath("hololivecorp/orb/layer2.png"),
            characterPath("hololivecorp/orb/layer3.png"),
            characterPath("hololivecorp/orb/layer4.png"),
            characterPath("hololivecorp/orb/layer5.png"),
            characterPath("hololivecorp/orb/layer6.png"),
            characterPath("hololivecorp/orb/layer1d.png"),
            characterPath("hololivecorp/orb/layer2d.png"),
            characterPath("hololivecorp/orb/layer3d.png"),
            characterPath("hololivecorp/orb/layer4d.png"),
            characterPath("hololivecorp/orb/layer5d.png"),
            characterPath("hololivecorp/orb/layer6d.png")};

    // Wtf is layer speed?
    private static final float[] LAYER_SPEED =
            new float[]{-40.0F, -32.0F, 20.0F, -20.0F, 0.0F, -10.0F, -8.0F, 5.0F, -5.0F, 0.0F};

    // Color
    private static final Color LIGHT_BLUE = rgbToColor(100.0F, 225.0F, 240.0F);

    public HololiveCorp(String name) {
        super(
                name,
                Enums.HOLOLIVE_CORP,
                ORB_TEXTURES,
                characterPath("hololivecorp/orb/vfx.png"),
                LAYER_SPEED,
                (String)null,
                (String)null);

        this.initializeClass(
                CHAR_IMG,
                SHOULDER_1,
                SHOULDER_2,
                CORPSE,
                this.getLoadout(),
                20.0F, -10.0F, 220.0F, 290.0F,
                new EnergyManager(ENERGY_PER_TURN));

        // Text bubble location
        this.dialogX = this.drawX + 0.0F * Settings.scale;
        this.dialogY = this.drawY + 220.0F * Settings.scale;
    }

    public ArrayList<String> getStartingDeck() {
        return null;
    }

    public ArrayList<String> getStartingRelics() {
        return null;
    }

    public CharSelectInfo getLoadout() {
        return null;
    }


    public String getTitle(PlayerClass playerClass) {
        return NAMES[1];
    }

    public AbstractCard.CardColor getCardColor() {
        return Enums.HOLOLIVE_BLUE;
    }

    public Color getCardRenderColor() {
        return LIGHT_BLUE;
    }

    public AbstractCard getStartCardForEvent() {
        return null;
    }

    public Color getCardTrailColor() {
        return LIGHT_BLUE;
    }

    public int getAscensionMaxHPLoss() {
        return 5;
    }

    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontBlue;
    }

    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_MAGIC_FAST_1", MathUtils.random(-0.1F, 0.1F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
    }

    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_MAGIC_FAST_1";
    }

    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    public AbstractPlayer newInstance() {
        return null;
    }

    public String getSpireHeartText() {
        return TEXT[1];
    }

    public Color getSlashAttackColor() {
        return LIGHT_BLUE;
    }

    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    public String getVampireText() {
        return TEXT[2];
    }
}
