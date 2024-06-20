package dataItems

import enums.SpecialPipBoy
import kotlinx.serialization.Serializable

@Serializable
data class SpecialUser(
    val specialAttribute: SpecialPipBoy,
    var levelSpecial: Int
)
