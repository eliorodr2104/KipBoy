package tools.audioPlayer

import androidx.compose.ui.res.useResource
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip


class SoundsPlayer(
    private val pathFile: String
) {
    private var clip: Clip? = null


    fun playSound() {
        try {

            useResource(pathFile) {
                clip = AudioSystem.getClip()

                val audioInputStream = AudioSystem.getAudioInputStream(
                    it
                )

                clip?.open(audioInputStream)
                clip?.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}