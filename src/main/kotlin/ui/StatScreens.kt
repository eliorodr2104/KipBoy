package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import dataItems.DataPerson
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


@Composable
fun StatusScreen(
    backgroundColor: Color,
    selectColor: Color,
    infoPerson: DataPerson
) {
    Box(
        modifier = Modifier
            .padding(
                bottom = 45.dp
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LifePartsVaultBoy(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    top = 15.dp
                ),
            selectColor = selectColor
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .align(Alignment.TopCenter)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(330.dp)
                    .padding(
                        top = 130.dp
                    )
            ) {
                LifePartsVaultBoy(
                    selectColor = selectColor
                )

                LifePartsVaultBoy(
                    selectColor = selectColor
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(330.dp)
                    .padding(
                        top = 110.dp,
                        bottom = 60.dp
                    )
            ) {
                LifePartsVaultBoy(
                    selectColor = selectColor
                )

                LifePartsVaultBoy(
                    selectColor = selectColor
                )
            }
        }

        LifePartsVaultBoy(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    top = 320.dp
                ),
            selectColor = selectColor
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(110.dp)
                .width(320.dp)
                .padding(bottom = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(60.dp)
                            .background(
                                color = backgroundColor
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/pistol_icon.png"
                            ),
                            contentDescription = "Weapon",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(45.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = backgroundColor
                            )
                            .padding(
                                top = 5.dp,
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/aim_icon.png"
                            ),
                            contentDescription = "aim",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(17.dp)
                        )

                        Text(
                            text = "18",
                            color = selectColor,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(60.dp)
                            .background(
                                color = backgroundColor
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/helmet_icon.png"
                            ),
                            contentDescription = "Weapon",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(45.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = backgroundColor
                            )
                            .padding(
                                top = 5.dp,
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/shield_icon.png"
                            ),
                            contentDescription = "aim",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(17.dp)
                        )

                        Text(
                            text = "1140",
                            color = selectColor,
                            style = MaterialTheme.typography.body2
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = backgroundColor
                            )
                            .padding(
                                top = 5.dp,
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/energy_icon.png"
                            ),
                            contentDescription = "aim",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(17.dp)
                        )

                        Text(
                            text = "805",
                            color = selectColor,
                            style = MaterialTheme.typography.body2
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = backgroundColor
                            )
                            .padding(
                                top = 5.dp,
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 10.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(
                                resourcePath = "img/pip-boy_hud_icons/status/rad_icon.png"
                            ),
                            contentDescription = "aim",
                            colorFilter = ColorFilter.tint(
                                color = selectColor
                            ),
                            modifier = Modifier
                                .size(17.dp)
                        )

                        Text(
                            text = "1000",
                            color = selectColor,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }

            Text(
                text = infoPerson.name,
                color = selectColor
            )
        }

        ImageCycler(
            modifier = Modifier
                .align(
                    alignment = Alignment.TopCenter
                )
                .padding(
                    top = 45.dp
                ),
            selectColor = selectColor
        )
    }
}

@Composable
private fun LifePartsVaultBoy(
    modifier: Modifier = Modifier,
    selectColor: Color
) {
    Box(
        modifier = modifier
            .width(53.dp)
            .height(13.dp)
            .background(
                color = selectColor
            )
    ) {
        Text(
            text = " ",
            color = Color.Red
        )
    }
}

@Composable
private fun ImageCycler(
    modifier: Modifier,
    selectColor: Color
) {
    val imageList = listOf(
        "img/vault-boy-frames/frame_00_delay-0.1s.png",
        "img/vault-boy-frames/frame_01_delay-0.1s.png",
        "img/vault-boy-frames/frame_02_delay-0.1s.png",
        "img/vault-boy-frames/frame_03_delay-0.1s.png",
        "img/vault-boy-frames/frame_04_delay-0.1s.png",
        "img/vault-boy-frames/frame_05_delay-0.1s.png",
        "img/vault-boy-frames/frame_06_delay-0.1s.png",
        "img/vault-boy-frames/frame_07_delay-0.1s.png",
        "img/vault-boy-frames/frame_08_delay-0.1s.png",
        "img/vault-boy-frames/frame_09_delay-0.1s.png",
        "img/vault-boy-frames/frame_10_delay-0.1s.png",
        "img/vault-boy-frames/frame_11_delay-0.1s.png",
        "img/vault-boy-frames/frame_12_delay-0.1s.png",
        "img/vault-boy-frames/frame_13_delay-0.1s.png",
        "img/vault-boy-frames/frame_14_delay-0.1s.png",
        "img/vault-boy-frames/frame_15_delay-0.1s.png",
        "img/vault-boy-frames/frame_16_delay-0.1s.png",
        "img/vault-boy-frames/frame_17_delay-0.1s.png",
        "img/vault-boy-frames/frame_18_delay-0.1s.png",
        "img/vault-boy-frames/frame_19_delay-0.1s.png",
        "img/vault-boy-frames/frame_20_delay-0.1s.png"

    )

    val imageListTest = listOf(
        "img/frames-test/icon_luck_1.png",
        "img/frames-test/icon_luck_7.png",
        "img/frames-test/icon_luck_8.png",
        "img/frames-test/icon_luck_9.png",
        "img/frames-test/icon_luck_10.png",
        "img/frames-test/icon_luck_11.png",
        "img/frames-test/icon_luck_12.png",
        "img/frames-test/icon_luck_13.png"
    )


    val intervalMillis = 180

    var index by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(intervalMillis.toLong())
            index = (index + 1) % imageListTest.size
        }
    }

    val bitmap by produceState<ImageBitmap?>(null, index) {
        value = loadImageBitmapFromFile(imageListTest[index])
    }

    bitmap?.let {
        Image(
            bitmap = it,
            contentDescription = null,
            modifier = modifier
                .height(250.dp),
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(
                color = selectColor
            )
        )
    }

}

suspend fun loadImageBitmapFromFile(filePath: String): ImageBitmap {
    return withContext(coroutineContext) {
        useResource(filePath) { loadImageBitmap(it) }
    }
}
