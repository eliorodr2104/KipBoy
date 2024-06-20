package dataItems

import kotlinx.serialization.Serializable

@Serializable
data class FrameInfo(
    val pathFrame: String,
    val quantityFrame: Int,
    val millisFrames: Long
)
