package enums

import dataItems.FrameInfo
import enums.PerksPipBoy.*
import kotlinx.serialization.Serializable

@Serializable
enum class SpecialPipBoy(
    val perksList: List<PerksPipBoy>,
    val descriptionSpecial: String,
    val dataFrame: FrameInfo
) {
    STRENGTH(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Strength is a measure of your raw physical power. It affects how much you can carry, and the damage of all melee attacks.",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/strength/icon_strength_",
            quantityFrame = 6,
            millisFrames = 170L
        )
    ),

    PERCEPTION(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Perception is your environmental awareness and sixth sense, and affects weapon accuracy in V.A.T.S.",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/perception/icon_perception_",
            quantityFrame = 7,
            millisFrames = 275L
        )
    ),

    ENDURANCE(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Endurance is a measure of your overall physical fitness. It affects your total Health and the Action Point drain from sprinting.",

        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/endurance/icon_endurance_",
            quantityFrame = 4,
            millisFrames = 170L
        )
    ),

    CHARISMA(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Charisma is your ability to charm and convince others. It affects your success to persuade in dialogue and prices when you barter.",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/charisma/icon_charisma_",
            quantityFrame = 6,
            millisFrames = 180L
        )
    ),

    INTELLIGENCE(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Intelligence is a measure of your overall mental acuity, and affects the number of Experience Points earned.",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/intelligence/icon_intelligence_",
            quantityFrame = 14,
            millisFrames = 150L
        )
    ),

    AGILITY(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Agility is a measure of your overall finesse and reflexes. It affects the number of Action Points in V.A.T.S and your ability to sneak.",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/agility/icon_agility_",
            quantityFrame = 4,
            millisFrames = 180L
        )
    ),

    LUCK(
        perksList = listOf(
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
        ),

        descriptionSpecial = "Luck is a measure of your general good fortune, and affects the recharge rate of Critical Hits",
        dataFrame = FrameInfo(
            pathFrame = "img/specials-frames/luck/icon_luck_",
            quantityFrame = 8,
            millisFrames = 150L
        )
    )
}