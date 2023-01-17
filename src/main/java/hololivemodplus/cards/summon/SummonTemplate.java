package hololivemodplus.cards.summon;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hololivemodplus.characters.HololiveCorp;

import static hololivemodplus.HololiveModPlus.cardPath;
import static hololivemodplus.HololiveModPlus.makeID;

@AutoAdd.Ignore
public class SummonTemplate extends AbstractSummonCard {
    public static final String ID = makeID("${NAME}");
    private static final String IMG = cardPath("summon/${NAME}.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = HololiveCorp.Enums.HOLOLIVE_BLUE;


    private static final int COST = 0;
    private static final int ATK = 0;
    private static final int HP = 0;
    private static final int UPGRADE_COST = 0;
    private static final int UPGRADE_ATK = 0;
    private static final int UPGRADE_HP = 0;

    public SummonTemplate() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.atk = ATK;
        this.hp = HP;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public AbstractCard makeCopy() { return new SummonTemplate(); }

    @Override
    public void upgrade() {
        if(!this.upgraded) {
            this.upgradeName();
            upgradeDamage(UPGRADE_ATK);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
}
