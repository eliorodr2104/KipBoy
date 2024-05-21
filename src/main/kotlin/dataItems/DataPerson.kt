package dataItems

import enums.ColorsPipBoy
import enums.ColorsPipBoy.*

data class DataPerson(
    var name: String,
    var lastname: String,
    var dateOfBirth: String,
    var pointsSpecial: Int,
    var colorPipboy: ColorsPipBoy
) {
    constructor(): this(name = "",
        lastname = "",
        dateOfBirth = "",
        pointsSpecial = 0,
        colorPipboy = GREEN
    )
}