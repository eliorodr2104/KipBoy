package dataItems

import enums.PerksPipBoy
import kotlinx.serialization.Serializable

@Serializable
data class PerksUser(
    val userPerk: PerksPipBoy,
    var level: Int
)
