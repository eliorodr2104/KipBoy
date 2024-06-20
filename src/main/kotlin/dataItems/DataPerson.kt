package dataItems

import enums.ColorsPipBoy
import enums.ColorsPipBoy.*
import enums.SpecialPipBoy
import enums.SpecialPipBoy.*
import kotlinx.serialization.Serializable

@Serializable
data class DataPerson(
    var name: String,
    var lastname: String,
    var dateOfBirth: String,
    var age: Int,
    var pointsSpecial: Int,
    var colorPipboy: ColorsPipBoy,
    var specialsUser: List<SpecialUser> = listOf(
        SpecialUser(STRENGTH, 0),
        SpecialUser(PERCEPTION, 0),
        SpecialUser(ENDURANCE, 0),
        SpecialUser(CHARISMA, 0),
        SpecialUser(INTELLIGENCE, 0),
        SpecialUser(AGILITY, 0),
        SpecialUser(LUCK, 0)
    ),
    val mapPerksUser: Map<SpecialPipBoy, PerksUser> = emptyMap()
) {
    constructor(): this(
        name = "",
        lastname = "",
        dateOfBirth = "",
        age = 0,
        pointsSpecial = 0,
        colorPipboy = GREEN
    )
}