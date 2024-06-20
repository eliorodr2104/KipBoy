package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.adamratzman.spotify.*
import dataItems.DataPerson
import enums.PrincipalScreens.INSERT_DATA_USER
import enums.PrincipalScreens.PIP_BOY_MENUS
import enums.TypesColorsPipBoy.BACKGROUNDCOLOR
import enums.TypesColorsPipBoy.SELECTCOLOR
import kotlinx.coroutines.delay
import tools.FileManager
import tools.startServer
import tools.videoPlayer.VideoPlayer
import tools.videoPlayer.rememberVideoPlayerState
import java.awt.Desktop
import java.awt.Dimension
import java.net.URI
import java.security.SecureRandom
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.io.path.Path

@Composable
@Preview
fun App() {
    val fileManagerDataPerson = FileManager(
        pathFolder = "src/main/resources/serializable_object",
        nameSerializableFile = "user.cbor",
        serializer = DataPerson.serializer()
    )

    var showImage by remember { mutableStateOf(true) }

    var infoUtente by remember {
        mutableStateOf(fileManagerDataPerson.readObjectFromFile())
    }

    var indexPrincipalScreen by remember {
        mutableStateOf(if (infoUtente != null) PIP_BOY_MENUS else INSERT_DATA_USER)
    }

    var codePrimario by remember {
        mutableStateOf("")
    }

    /*
    if (codePrimario == "") {
        startServer { code ->
            println("Authorization code received: $code")
            // Scambia il codice per un token di accesso
            codePrimario = code
        }

    }
     */

    //spotifyandroidplayground://spotify-auth
    //spotifyandroidplayground://spotify-pkce

    /*
    LaunchedEffect(Unit, codePrimario) {
        val clientId = "05ab067536fd446cae15a10eb17d6573"
        val clientSecret = "952333ae9c454dacb36962ed7d95fbcd"

        val codeVerifier = generateRandomString(64)
        val codeChallenge = getSpotifyPkceCodeChallenge(codeVerifier)

        if (codePrimario == "") {
            val url = getSpotifyPkceAuthorizationUrl(
                SpotifyScope.UserLibraryModify,
                SpotifyScope.UserLibraryRead,
                clientId = clientId,
                redirectUri = "http://localhost:8080/callback",
                codeChallenge = codeChallenge
            )

            //if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            //    Desktop.getDesktop().browse(URI(url))
            //}

        } else {
            try {

                delay(5000L)

                val api = spotifyClientPkceApi(
                    clientId = clientId,
                    authorizationCode = codePrimario,
                    redirectUri = "http://localhost:8080/callback",
                    pkceCodeVerifier = codeChallenge

                ).build() // create and build api

                println(api.personalization.getTopTracks(limit = 5).items.map { it.name })
            }catch (e: Exception) {
                println(e.message)
            }
        }
        //println(api.search.searchTrack("track:Rosemary Deftones")[0].id)
    }
     */


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
            if (indexPrincipalScreen == PIP_BOY_MENUS) {
                ManageMenuScreens(
                    backgroundColor = infoUtente!!.colorPipboy.colors[BACKGROUNDCOLOR]!!,
                    selectColor = infoUtente!!.colorPipboy.colors[SELECTCOLOR]!!,
                    infoUtente = infoUtente!!,
                    fileManager = fileManagerDataPerson
                )

            } else {
                ManagementBootScreens(
                    fileManager = fileManagerDataPerson,
                    getInfoUser = { infoUtente = it },
                    changeIndexPrincipalScreen = { indexPrincipalScreen = it }
                )
            }
        }
    }
}

@OptIn(ExperimentalEncodingApi::class)
internal fun String.base64ByteEncode() = Base64.encode(toByteArray())

fun generateRandomString(length: Int): String {
    val possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val secureRandom = SecureRandom()
    val values = ByteArray(length)
    secureRandom.nextBytes(values)

    val stringBuilder = StringBuilder(length)
    for (i in values.indices) {
        val index = values[i].toInt() and 0xFF % possible.length
        stringBuilder.append(possible[index])
    }

    return stringBuilder.toString()
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
