package enums

import enums.MicroMenusPipBoy.*

enum class MacroMenusPipBoy(
    var microMenusPipBoy: List<MicroMenusPipBoy>,
    var realListMicroMenusPipBoy:  List<MicroMenusPipBoy>
) {
    STAT(
        listOf(
            NULL,
            NULL,
            STATUS,
            SPECIAL,
            PERKS
        ),
        listOf(
            STATUS,
            SPECIAL,
            PERKS
        )
    ),

    INV(
        listOf(
            NULL,
            NULL,
            NULL,
            NULL,
            NULL,
            NULL,
            WEAPONS,
            APPAREL,
            AID,
            MISC,
            JUNK,
            MODS,
            AMMO
        ),

        listOf(
            WEAPONS,
            APPAREL,
            AID,
            MISC,
            JUNK,
            MODS,
            AMMO
        )
    ),

    DATA(
        listOf(
            NULL,
            NULL,
            QUESTS,
            WORKSHOPS,
            STATS
        ),

        listOf(
            QUESTS,
            WORKSHOPS,
            STATS
        )
    ),

    MAP(
        listOf(
            NULL
        ),

        listOf(
            NULL
        )
    ),

    RADIO(
        listOf(
            NULL
        ),

        listOf(
            NULL
        )
    ),

    SETTING(
        listOf(
            NULL,
            NULL,
            PROFILE,
            COLORS,
            CONNECTIONS
        ),

        listOf(
            PROFILE,
            COLORS,
            CONNECTIONS
        )
    )
}