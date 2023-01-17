package hololivemodplus.cards.summon;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hololivemodplus.characters.HololiveCorp;

import static hololivemodplus.HololiveModPlus.cardPath;
import static hololivemodplus.HololiveModPlus.makeID;

public class CallUruhaRushia extends AbstractSummonCard {
    public static final String ID = makeID("CallUruhaRushia");
    private static final String IMG = cardPath("summon/CallUruhaRushia.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON; // Change if needed
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = HololiveCorp.Enums.HOLOLIVE_BLUE;


    private static final int COST = 2;
    private static final int ATK = 5;
    private static final int HP = 5;
    private static final int UPGRADED_COST = 2; // Cost after upgrade
    private static final int UPGRADE_PLUS_ATK = 0; // ATK to add after upgrade
    private static final int UPGRADE_PLUS_HP = 0; // HP to add after upgrade

    public CallUruhaRushia() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.atk = ATK;
        this.hp = HP;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public AbstractCard makeCopy() {
        return new CallUruhaRushia();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
}
