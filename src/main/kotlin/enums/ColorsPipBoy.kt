package enums

import androidx.compose.ui.graphics.Color
import enums.TypesColorsPipBoy.*

enum class ColorsPipBoy(val colors: HashMap<TypesColorsPipBoy, Color>) {
    GREEN(
        hashMapOf(
            BACKGROUNDCOLOR to Color(0xFF002f00), //0xFF245222 OLD COLORS
            SELECTCOLOR to Color(0xFF00ee00) //0xFF79fd9c OLD COLORS
        )
    ),

    AMBER(
        hashMapOf(
            BACKGROUNDCOLOR to Color(0xFF453d1a),
            SELECTCOLOR to Color(0xFFebc623)
        )
    ),

    PINK(
        hashMapOf(
            BACKGROUNDCOLOR to Color(0xFF451a42),
            SELECTCOLOR to Color(0xFFeb23e8)
        )
    ),

    WHITE(
        hashMapOf(
            BACKGROUNDCOLOR to Color(0xFF6e6a6e),
            SELECTCOLOR to Color(0xFFffffff)
        )
    ),

     BLUE(
         hashMapOf(
             BACKGROUNDCOLOR to Color(0xFF1a2745),
             SELECTCOLOR to Color(0xFF235ceb)
         )
     ),

    YELLOW(
        hashMapOf(
            BACKGROUNDCOLOR to Color(0xFF45441a),
            SELECTCOLOR to Color(0xFFebe123)
        )
    )
}