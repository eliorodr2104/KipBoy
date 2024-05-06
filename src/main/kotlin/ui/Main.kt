package ui

import tools.videoPlayer.VideoPlayer
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay
import tools.videoPlayer.rememberVideoPlayerState
import java.awt.Dimension
import kotlin.io.path.Path
import enums.ColorsPipBoy.*
import enums.TypesColorsPipBoy.*


@Composable
@Preview
fun App() {
    var showImage by remember { mutableStateOf(true) }

    val backgroundColor = WHITE.colors[BACKGROUNDCOLOR]!!
    val selectColor = WHITE.colors[SELECTCOLOR]!!

    MaterialTheme {
        LaunchedEffect(showImage) {
            if (showImage) {
                delay(10)
                showImage = false
            }
        }

        if (showImage) {
            ShowImageScreen()

        } else {
            ManageMenuScreens(
                backgroundColor = backgroundColor,
                selectColor = selectColor
            )
        }
    }
}

@Composable
fun ShowImageScreen() {
    val state = rememberVideoPlayerState()

    VideoPlayer(
        url = """file:///${Path("/Users/elio0/IdeaProjects/KipBoy/src/main/resources/img/splash_screen/Pip-Boy-Boot.mp4")}""",
        state = state,
        onFinish = state::stopPlayback,
        modifier = Modifier
            .fillMaxSize()
    )
}

fun main() = application {
    val windowTitle by remember { mutableStateOf("Kip-Boy") }

    Window(
        onCloseRequest = ::exitApplication,
        title = windowTitle
    ) {
        window.minimumSize = Dimension(800, 600)
        App()
    }
}
