package enums

import enums.PerksPipBoy.*

enum class SpecialPipBoy(
    perksList: List<PerksPipBoy>
) {
    STRENGTH(
        listOf(
            IRON_FIST,
            BIG_LEAGUES,
            ARMORER,
            BLACKSMITH,
            HEAVY_GUNNER,
            STRONG_BACK,
            STEAD_AIM,
            BASHER,
            ROOTED,
            PAIN_TRAIN
        )
    ),

    PERCEPTION(
        listOf(
            PICKPOCKET,
            RIFLEMAN,
            AWARENESS,
            LOCKSMITH,
            DEMOLITION_EXPERT,
            NIGHT_PERSON,
            REFRACTOR,
            SNIPER,
            PENETRATOR,
            CONCENTRATED_FIRE
        )
    ),

    ENDURANCE(
        listOf(
            TOUGHNESS,
            LEAD_BELLY,
            LIFE_GIVER,
            CHEM_RESIST,
            AQUABOY,
            RAD_RESIST,
            ADAMANTIUM_SKELETON,
            CANNIBAL,
            GHOULISH,
            SOLAR_POWERED
        )
    ),

    CHARISMA(
        listOf(
            CAP_COLLECTOR,
            LADY_KILLER,
            LONE_WANDERER,
            ATTACK_DOG,
            ANIMAL_FRIEND,
            LOCAL_LEADER,
            PARTY_BOY,
            INSPIRATIONAL,
            WASTELAND_WHISPERER,
            INTIMIDATION
        )
    ),

    INTELLIGENCE(
        listOf(
            VANS,
            MEDIC,
            GUN_NUT,
            HACKER,
            SCRAPPER,
            SCIENCE,
            CHEMIST,
            ROBOTICS_EXPERT,
            NUCLEAR_PHYSICIST,
            NERD_RAGE
        )
    ),

    AGILITY(
        listOf(
            GUNSLINGER,
            COMMANDO,
            SNEAK,
            MISTER_SANDMAN,
            ACTION_BOY,
            MOVING_TARGET,
            NINJA,
            QUICK_HANDS,
            BLITZ,
            GUN_FU
        )
    ),

    LUCK(
        listOf(
            FORTUNE_FINDER,
            SCROUNGER,
            BLOODY_MESS,
            MYSTERIOUS_STRANGER,
            IDIOT_SAVANT,
            BETTER_CRITICALS,
            CRITICAL_BANKER,
            GRIM_REAPERS_SPRINT,
            FOUR_LEAF_CLOVER,
            RICOCHET
        )
    )
}