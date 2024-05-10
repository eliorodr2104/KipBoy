package enums
import dataItems.PerkLevelAndPrice
import enums.SpecialPipBoy.*

enum class PerksPipBoy(
    specialAttribute: SpecialPipBoy,
    maxRank: Int,
    perkLevelAndPrice: PerkLevelAndPrice
) {
    //STRENGTH
    IRON_FIST(
        specialAttribute = STRENGTH,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    BIG_LEAGUES(
        specialAttribute = STRENGTH,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    ARMORER(
        specialAttribute = STRENGTH,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    BLACKSMITH(
        specialAttribute = STRENGTH,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    HEAVY_GUNNER(
        specialAttribute = STRENGTH,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    STRONG_BACK(
        specialAttribute = STRENGTH,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    STEAD_AIM(
        specialAttribute = STRENGTH,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    BASHER(
        specialAttribute = STRENGTH,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    ROOTED(
        specialAttribute = STRENGTH,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    PAIN_TRAIN(
        specialAttribute = STRENGTH,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //PERCEPTION
    PICKPOCKET(
        specialAttribute = PERCEPTION,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    RIFLEMAN(
        specialAttribute = PERCEPTION,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    AWARENESS(
        specialAttribute = PERCEPTION,
        maxRank = 1,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    LOCKSMITH(
        specialAttribute = PERCEPTION,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    DEMOLITION_EXPERT(
        specialAttribute = PERCEPTION,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    NIGHT_PERSON(
        specialAttribute = PERCEPTION,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    REFRACTOR(
        specialAttribute = PERCEPTION,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    SNIPER(
        specialAttribute = PERCEPTION,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    PENETRATOR(
        specialAttribute = PERCEPTION,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
    CONCENTRATED_FIRE(
        specialAttribute = PERCEPTION,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //ENDURANCE
    TOUGHNESS(
        specialAttribute = ENDURANCE,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    LEAD_BELLY(
        specialAttribute = ENDURANCE,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    LIFE_GIVER(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    CHEM_RESIST(
        specialAttribute = ENDURANCE,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    AQUABOY(
        specialAttribute = ENDURANCE,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    RAD_RESIST(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    ADAMANTIUM_SKELETON(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    CANNIBAL(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    GHOULISH(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    SOLAR_POWERED(
        specialAttribute = ENDURANCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //CHARISMA
    CAP_COLLECTOR(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    LADY_KILLER(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    LONE_WANDERER(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    ATTACK_DOG(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    ANIMAL_FRIEND(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    LOCAL_LEADER(
        specialAttribute = CHARISMA,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    PARTY_BOY(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    INSPIRATIONAL(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    WASTELAND_WHISPERER(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    INTIMIDATION(
        specialAttribute = CHARISMA,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //INTELLIGENCE
    VANS(
        specialAttribute = INTELLIGENCE,
        maxRank = 1,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    MEDIC(
        specialAttribute = INTELLIGENCE,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    GUN_NUT(
        specialAttribute = INTELLIGENCE,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    HACKER(
        specialAttribute = INTELLIGENCE,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    SCRAPPER(
        specialAttribute = INTELLIGENCE,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    SCIENCE( //Da mettere "!"
        specialAttribute = INTELLIGENCE,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    CHEMIST(
        specialAttribute = INTELLIGENCE,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    ROBOTICS_EXPERT(
        specialAttribute = INTELLIGENCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    NUCLEAR_PHYSICIST(
        specialAttribute = INTELLIGENCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    NERD_RAGE(
        specialAttribute = INTELLIGENCE,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //AGILITY
    GUNSLINGER(
        specialAttribute = AGILITY,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    COMMANDO(
        specialAttribute = AGILITY,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    SNEAK(
        specialAttribute = AGILITY,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    MISTER_SANDMAN(
        specialAttribute = AGILITY,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    ACTION_BOY(
        specialAttribute = AGILITY,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    MOVING_TARGET(
        specialAttribute = AGILITY,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    NINJA(
        specialAttribute = AGILITY,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    QUICK_HANDS(
        specialAttribute = AGILITY,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    BLITZ(
        specialAttribute = AGILITY,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    GUN_FU(
        specialAttribute = AGILITY,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    //LUCK
    FORTUNE_FINDER(
        specialAttribute = LUCK,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    SCROUNGER(
        specialAttribute = LUCK,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    BLOODY_MESS(
        specialAttribute = LUCK,
        maxRank = 4,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    MYSTERIOUS_STRANGER(
        specialAttribute = LUCK,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    IDIOT_SAVANT(
        specialAttribute = LUCK,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    BETTER_CRITICALS(
        specialAttribute = LUCK,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    CRITICAL_BANKER(
        specialAttribute = LUCK,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    GRIM_REAPERS_SPRINT(
        specialAttribute = LUCK,
        maxRank = 2,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    FOUR_LEAF_CLOVER(
        specialAttribute = LUCK,
        maxRank = 5,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),

    RICOCHET(
        specialAttribute = LUCK,
        maxRank = 3,
        perkLevelAndPrice = PerkLevelAndPrice(
            level = 1,
            price = 1
        )
    ),
}