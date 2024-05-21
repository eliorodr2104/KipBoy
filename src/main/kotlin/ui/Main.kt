package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dataItems.DataPerson
import enums.ColorsPipBoy.GREEN
import enums.ColorsPipBoy.PINK
import enums.TypesColorsPipBoy.BACKGROUNDCOLOR
import enums.TypesColorsPipBoy.SELECTCOLOR
import kotlinx.coroutines.delay
import tools.videoPlayer.VideoPlayer
import tools.videoPlayer.rememberVideoPlayerState
import java.awt.Dimension
import kotlin.io.path.Path

@Composable
@Preview
fun App() {
    var showImage by remember { mutableStateOf(true) }

    var infoUtente by remember {
        mutableStateOf(
            DataPerson(
                name = "Eliomar",
                lastname = "",
                dateOfBirth = "",
                pointsSpecial = 0,
                colorPipboy = PINK
            )
        )
    }

    val backgroundColor = infoUtente.colorPipboy.colors[BACKGROUNDCOLOR]!!
    val selectColor = infoUtente.colorPipboy.colors[SELECTCOLOR]!!

    MaterialTheme {
        LaunchedEffect(showImage) {
            if (showImage) {
                delay(10) //22000
                showImage = false
            }
        }

        if (showImage) {
            ShowImageScreen()

        } else {
            ManagementBootScreens(
                backgroundColor = backgroundColor,
                selectColor = selectColor
            )
            /*

             */

            /*
            ManageMenuScreens(
                backgroundColor = backgroundColor,
                selectColor = selectColor,
                infoUtente = infoUtente
            )
             */
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
    var keyUser by remember {
        mutableStateOf(KeyEvent(NativeKeyEvent()))
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = windowTitle,
        onKeyEvent = {
            keyUser = it
            true
        }
    ) {
        window.minimumSize = Dimension(800, 600)
        App()
    }
}
