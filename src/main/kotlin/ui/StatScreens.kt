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
    val imageList = "img/frames-test/icon_luck_"

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
                )
                .height(250.dp),
            selectColor = selectColor,
            imagesList = imageList,
            quantityFrames = 8,
            intervalMillis = 150L
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
fun ImageCycler(
    modifier: Modifier,
    selectColor: Color,

    imagesList: String,
    quantityFrames: Int,
    intervalMillis: Long
) {
    var index by remember { mutableStateOf(1) }

    LaunchedEffect(quantityFrames, intervalMillis) {
        while (true) {
            delay(intervalMillis)
            index = if (index + 1 <= quantityFrames) index + 1 else 1
        }
    }

    val bitmap by produceState<ImageBitmap?>(null, imagesList, index) {
        try {
            value = loadImageBitmapFromFile("$imagesList$index.png")
        } catch (_: Exception) {  }
    }

    bitmap?.let {
        Image(
            bitmap = it,
            contentDescription = null,
            modifier = modifier,
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
