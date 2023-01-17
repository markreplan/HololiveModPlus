package hololivemodplus.cards.summon;

import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

public abstract class AbstractSummonCard extends CustomCard {
    public static class Enums {
        @SpireEnum public static AbstractCard.CardTags SUMMON_CARD;
    }


    // Stats
    public int atk = 0;
    public int hp = 0;

    public AbstractSummonCard(
            String id,
            String name,
            String img,
            int cost,
            String description,
            CardType type,
            CardColor color,
            CardRarity rarity,
            CardTarget target) {
        super(id, name, img, cost, description, type, color, rarity, target);
        this.tags.add(Enums.SUMMON_CARD);
    }

    @Override
    public AbstractCard makeStatEquivalentCopy() {
        AbstractCard copy = super.makeStatEquivalentCopy();

        if (copy instanceof AbstractSummonCard) {
            copy.rawDescription = this.rawDescription;
            ((AbstractSummonCard) copy).atk = this.atk;
            ((AbstractSummonCard) copy).hp = this.hp;
        }

        return copy;
    }

    public void upgrade() {
    }

    public AbstractCard makeCopy() {
        return null;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        // Check for empty slot among orbs so summon card can be played
        for (AbstractOrb orb : AbstractDungeon.player.orbs) {
            if (orb instanceof EmptyOrbSlot) {
                return super.canUse(p, m);
            }
        }
        // Can't summon if no empty orb slots available
        return false;
    }
}
