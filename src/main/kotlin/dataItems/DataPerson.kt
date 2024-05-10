package dataItems

import enums.ColorsPipBoy

data class DataPerson(
    val name: String,
    val lastname: String,
    val dateOfBirth: String,
    var pointsSpecial: Int,
    var colorPipboy: ColorsPipBoy
)
