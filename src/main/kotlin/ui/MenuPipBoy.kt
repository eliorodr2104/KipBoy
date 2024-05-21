package ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import dataItems.DataBottomBarPipBoy
import dataItems.DataPerson
import enums.MacroMenusPipBoy
import enums.MacroMenusPipBoy.*
import enums.MicroMenusPipBoy
import enums.MicroMenusPipBoy.*
import tools.audioPlayer.SoundsPlayer
import kotlin.math.abs

@Composable
fun ManageMenuScreens(
    backgroundColor: Color,
    selectColor: Color,
    infoUtente: DataPerson
) {
    var itemSelected by remember {
        mutableStateOf(STAT)
    }

    var subMenuItemSelected by remember {
        mutableStateOf(itemSelected.realListMicroMenusPipBoy[0])
    }

    val listDataBottomBarPipBoy = listOf(
        DataBottomBarPipBoy(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    bottom = 10.dp,
                ),
            firstElement = {
                Text(
                    text = "HP",
                    style = MaterialTheme.typography.body2,
                    color = selectColor,
                    fontWeight = FontWeight.Bold
                )
            },

            secondElement = {
                Text(
                    text = "80/100",
                    style = MaterialTheme.typography.body2,
                    color = selectColor,
                    fontWeight = FontWeight.Bold
                )
            }
        ),

        DataBottomBarPipBoy(
            modifier = Modifier
                .padding(
                    start = 5.dp,
                    bottom = 10.dp,
                    end = 5.dp
                ),
            firstElement = {
                Text(
                    text = "LEVEL 1",
                    style = MaterialTheme.typography.body2,
                    color = selectColor,
                    fontWeight = FontWeight.Bold
                )
            },

            secondElement = {
                LinearProgressIndicator(
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .sizeIn(
                            maxHeight = 15.dp
                        )
                        .fillMaxSize()
                        .clip(
                            shape = RoundedCornerShape(
                                size = 0.dp
                            )
                        )
                        .border(
                            width = 2.dp,
                            color = selectColor,
                            shape = RoundedCornerShape(
                                size = 0.dp
                            )
                        ),
                    color = Color.Transparent,
                    backgroundColor = Color.Transparent
                )
            }
        ),

        DataBottomBarPipBoy(
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    end = 10.dp
                ),
            firstElement = {
                Text(
                    text = "AP",
                    style = MaterialTheme.typography.body2,
                    color = selectColor,
                    fontWeight = FontWeight.Bold
                )
            },

            secondElement = {
                Text(
                    text = "70/70",
                    style = MaterialTheme.typography.body2,
                    color = selectColor,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),

        backgroundColor = Color.Black,

        topBar = {
            TopBarPipBoy(
                changeMenu = { itemSelected = it },
                itemSelected = itemSelected,
                changeSubMenuItemSelected = { subMenuItemSelected = it },
                selectColor = selectColor
            )
        },

        bottomBar = {
            BottomBarPipBoy(
                listDataBottomBarPipBoy = listDataBottomBarPipBoy,
                backgroundColor = backgroundColor
            )
        }
    ) {
        when(itemSelected) {
            STAT -> {
                when(subMenuItemSelected) {
                    STATUS -> {
                        StatusScreen(
                            backgroundColor = backgroundColor,
                            selectColor = selectColor,
                            infoPerson = infoUtente
                        )
                    }
                    SPECIAL -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    PERKS -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    else -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            INV -> {

            }

            DATA -> {

            }

            MAP -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                )
            }

            RADIO -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                )
            }

            SETTING -> {
                when(subMenuItemSelected) {
                    PROFILE -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    COLORS -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    CONNECTIONS -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    else -> TODO()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun TopBarPipBoy(
    changeMenu: (MacroMenusPipBoy) -> Unit,
    itemSelected: MacroMenusPipBoy,
    changeSubMenuItemSelected: (MicroMenusPipBoy) -> Unit,
    selectColor: Color
) {
    val window = LocalWindowInfo.current
    val screenWidth = window.containerSize.width

    val soundsPlayer = SoundsPlayer("audio/tracks/module_change.wav")

    val stringsMenu = listOf(
        STAT,
        INV,
        DATA,
        MAP,
        RADIO,
        SETTING
    )

    var coordinatesItemSelected by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    var sizeItemSelected by remember {
        mutableStateOf(IntSize(0, 0))
    }

    val PADDING_START_LINE_INTO_SCREEN = 20f
    val PADDING_TO_JOIN_LINES = 4f

    var finalLineUntilToItem by remember {
        mutableStateOf(0f)
    }

    var xAxisTopLine by remember {
        mutableStateOf(0f)
    }

    var xAxisSizeStandard by remember {
        mutableStateOf(0f)
    }

    var standardPaddingPlusItemSize by remember {
        mutableStateOf(0f)
    }

    var smallLineEnd by remember {
        mutableStateOf(0f)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                stringsMenu.forEach { item ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .onGloballyPositioned { layoutCoordinates ->
                                if (itemSelected == item) {
                                    coordinatesItemSelected = layoutCoordinates.positionInRoot()
                                    sizeItemSelected = layoutCoordinates.size

                                    finalLineUntilToItem = coordinatesItemSelected.x - 18f
                                    xAxisTopLine = abs(coordinatesItemSelected.x - PADDING_START_LINE_INTO_SCREEN)
                                    xAxisSizeStandard = abs(coordinatesItemSelected.x - 22f)
                                    standardPaddingPlusItemSize = (coordinatesItemSelected.x + PADDING_START_LINE_INTO_SCREEN) + sizeItemSelected.width
                                    smallLineEnd = abs(screenWidth - 22f)
                                }
                            }
                            .clickable {
                                soundsPlayer.playSound()
                                changeMenu(item)
                                changeSubMenuItemSelected(item.realListMicroMenusPipBoy[0])
                                //soundsPlayer.stopSound()
                            }
                    ) {
                        Text(
                            text = item.name,
                            color = selectColor,
                            style = MaterialTheme.typography.h5,
                            fontWeight = if (itemSelected == item) FontWeight.Bold else FontWeight.SemiBold
                        )
                    }
                }
            }

            Canvas(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {

                //Prima linea dalla partenza dello schermo fino alla collissione del primo Text
                drawLine(
                    start = Offset(
                        x = PADDING_START_LINE_INTO_SCREEN,
                        y = 0f
                    ),
                    end = Offset(
                        x = finalLineUntilToItem,
                        y = 0f
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //Riga che sale verso l'alto nel primo item
                drawLine(
                    start = Offset(
                        x = xAxisTopLine,
                        y = 0f
                    ),
                    end = Offset(
                        x = xAxisTopLine,
                        y = - coordinatesItemSelected.y
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //Riga in alto che va a destra nel primo item
                drawLine(
                    start = Offset(
                        x = xAxisSizeStandard,
                        y = - coordinatesItemSelected.y
                    ),
                    end = Offset(
                        x = coordinatesItemSelected.x,
                        y = - coordinatesItemSelected.y
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //2nd line
                drawLine(
                    start = Offset(
                        x = standardPaddingPlusItemSize,
                        y = 0f
                    ),
                    end = Offset(
                        x = standardPaddingPlusItemSize,
                        y = - coordinatesItemSelected.y
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                drawLine(
                    start = Offset(
                        x = coordinatesItemSelected.x + sizeItemSelected.width,
                        y = - coordinatesItemSelected.y
                    ),

                    end = Offset(
                        x = (coordinatesItemSelected.x + 22f) + sizeItemSelected.width,
                        y = - coordinatesItemSelected.y
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //Riga più lunga finale
                drawLine(
                    start = Offset(
                        x = (coordinatesItemSelected.x + 18f) + sizeItemSelected.width,
                        y = 0f
                    ),
                    end = Offset(
                        x = screenWidth - PADDING_START_LINE_INTO_SCREEN,
                        y = 0f
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //Riga iniziale che va giù
                drawLine(
                    start = Offset(
                        x = 22f,
                        y = 0f
                    ),
                    end = Offset(
                        x = 22f,
                        y = 15f
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )

                //Riga finale che va giù
                drawLine(
                    start = Offset(
                        x = smallLineEnd,
                        y = 0f
                    ),
                    end = Offset(
                        x = smallLineEnd,
                        y = 15f
                    ),
                    color = selectColor,
                    strokeWidth = 5f
                )
            }
        }

        when(itemSelected) {
            STAT -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = STAT.microMenusPipBoy,
                    realListMicroMenusPipBoy = STAT.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 1,
                    selectColor = selectColor
                )
            }
            INV -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = INV.microMenusPipBoy,
                    realListMicroMenusPipBoy = INV.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 2,
                    selectColor = selectColor
                )
            }
            DATA -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = DATA.microMenusPipBoy,
                    realListMicroMenusPipBoy = DATA.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 1,
                    selectColor = selectColor
                )
            }
            MAP -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = MAP.microMenusPipBoy,
                    realListMicroMenusPipBoy = MAP.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 1,
                    selectColor = selectColor
                )
            }
            RADIO -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = RADIO.microMenusPipBoy,
                    realListMicroMenusPipBoy = RADIO.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 1,
                    selectColor = selectColor
                )
            }

            SETTING -> {
                PagerSubMenu(
                    coordinatesItemSelected = Offset(x = coordinatesItemSelected.x - 15f, y = coordinatesItemSelected.y),
                    sizeSelectMenu = sizeItemSelected,
                    selectMenu = itemSelected,
                    microsMenusPipBoyList = SETTING.microMenusPipBoy,
                    realListMicroMenusPipBoy = SETTING.realListMicroMenusPipBoy,
                    changeItemSelected = { changeSubMenuItemSelected(it) },
                    amountItemsShowLeft = 1,
                    selectColor = selectColor
                )
            }
        }
    }
}

@Composable
private fun PagerSubMenu(
    coordinatesItemSelected: Offset,
    sizeSelectMenu: IntSize,
    selectMenu: MacroMenusPipBoy,
    microsMenusPipBoyList: List<MicroMenusPipBoy>,
    realListMicroMenusPipBoy: List<MicroMenusPipBoy>,
    changeItemSelected: (MicroMenusPipBoy) -> Unit,
    amountItemsShowLeft: Int,
    selectColor: Color
) {
    val soundsPlayer = SoundsPlayer("audio/tracks/submodule_change.wav")

    val microsMenusPipBoy = remember {
        microsMenusPipBoyList.toMutableList()
    }

    var subMenuItemSelect by remember {
        mutableStateOf(realListMicroMenusPipBoy.first())
    }

    var subMenuItemSelectSize by remember {
        mutableStateOf(IntSize(0, 0))
    }

    var firstNotSelectElementSize by remember {
        mutableStateOf(IntSize(0, 0))
    }

    var secondNotSelectElementSize by remember {
        mutableStateOf(IntSize(0, 0))
    }

    var firstNotSelectElement by remember {
        mutableStateOf(NULL)
    }

    var secondNotSelectElement by remember {
        mutableStateOf(NULL)
    }

    val itemsList = microsMenusPipBoy.count { it == NULL } - 1

    val showLeft = itemsList - amountItemsShowLeft

    var spacingWithElements: Float

    val valueDp = LocalDensity.current.run {
        spacingWithElements = abs(coordinatesItemSelected.x - firstNotSelectElementSize.width)
        spacingWithElements = abs(spacingWithElements - secondNotSelectElementSize.width)

        spacingWithElements = abs(spacingWithElements - abs(sizeSelectMenu.center.x - subMenuItemSelectSize.center.x))

        spacingWithElements.toDp()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = when {
                        firstNotSelectElement == NULL && selectMenu.name.length < 7 -> {
                            abs(valueDp.value + 7).dp
                        }

                        firstNotSelectElement == NULL && selectMenu.name.length >= 7 -> {
                            abs(valueDp.value + 33).dp
                        }

                        subMenuItemSelect.name.length == 6 && selectMenu.name.length >= 7 -> {
                            abs(valueDp.value + 15).dp
                        }

                        subMenuItemSelect.name.length == 3 -> {
                            if (valueDp.value - 5 < 0) 0.dp else abs(valueDp.value - 5).dp
                        }

                        subMenuItemSelect.name.length == 4 -> {
                            abs(valueDp.value - 12).dp
                        }

                        else -> {
                            valueDp
                        }
                    }
                ),
            horizontalArrangement = Arrangement.spacedBy(
                when {
                    selectMenu.name.length >= 7 && subMenuItemSelect.name.length <= 7 -> {
                        20.dp
                    }
                    else -> 10.dp
                }
            )
        ) {
            microsMenusPipBoy.forEachIndexed { index, item ->
                if (item != NULL && index > showLeft) {
                    Text(
                        softWrap = false,
                        text = item.name,
                        color = selectColor.copy(
                            alpha = when {
                                index == itemsList + 1 -> 1f
                                index == itemsList -> 0.50f
                                amountItemsShowLeft == 2 && index == itemsList - 1 -> 0.25f
                                index == itemsList + 2 -> 0.50f
                                index == itemsList + 3 -> 0.25f
                                else -> 0f
                            }
                        ),
                        style = MaterialTheme.typography.h6,
                        fontWeight = if (subMenuItemSelect == item) FontWeight.Light else FontWeight.Light,
                        modifier = Modifier
                            .clickable {
                                soundsPlayer.playSound()

                                if (
                                    subMenuItemSelect != item &&
                                    firstNotSelectElement != item &&
                                    secondNotSelectElement != item
                                    ) {
                                    val shiftedList = mutableListOf<MicroMenusPipBoy>()

                                    for (i in microsMenusPipBoy.indices) {
                                        val newIndex = (i + abs(index - (itemsList + 1))) % microsMenusPipBoy.size
                                        shiftedList.add(microsMenusPipBoy[newIndex])
                                    }

                                    microsMenusPipBoy.clear()
                                    microsMenusPipBoy.addAll(shiftedList)

                                    firstNotSelectElement = microsMenusPipBoy[itemsList]
                                    if (amountItemsShowLeft == 2) secondNotSelectElement = microsMenusPipBoy[itemsList - 1]
                                    subMenuItemSelect = microsMenusPipBoy[itemsList + 1]
                                    changeItemSelected(microsMenusPipBoy[itemsList + 1])
                                }

                                if (subMenuItemSelect != item) {
                                    val shiftedList = mutableListOf<MicroMenusPipBoy>()

                                    for (i in microsMenusPipBoy.indices) {
                                        //val newIndex = (i + abs(index - 2)) % stringTestSubMenu.size
                                        val newIndex = ((index + (itemsList + 2)) + i) % microsMenusPipBoy.size
                                        shiftedList.add(microsMenusPipBoy[newIndex])
                                    }

                                    microsMenusPipBoy.clear()
                                    microsMenusPipBoy.addAll(shiftedList)

                                    firstNotSelectElement = microsMenusPipBoy[itemsList]
                                    subMenuItemSelect = microsMenusPipBoy[itemsList + 1]
                                    changeItemSelected(microsMenusPipBoy[itemsList + 1])
                                }
                            }
                            .onGloballyPositioned { layoutSize ->
                                if (item == microsMenusPipBoy[itemsList + 1]) {
                                    subMenuItemSelectSize = layoutSize.size
                                }

                                if (microsMenusPipBoy[itemsList + 1] == NULL)
                                    subMenuItemSelectSize = IntSize(0, 0)

                                if (item == microsMenusPipBoy[itemsList]) {
                                    firstNotSelectElementSize = layoutSize.size
                                }

                                if (microsMenusPipBoy[itemsList] == NULL)
                                    firstNotSelectElementSize = IntSize(0, 0)

                                if (item == microsMenusPipBoy[itemsList - 1]) {
                                    secondNotSelectElementSize = layoutSize.size
                                }

                                if (microsMenusPipBoy[itemsList - 1] == NULL)
                                    secondNotSelectElementSize = IntSize(0, 0)
                            }
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomBarPipBoy(
    listDataBottomBarPipBoy: List<DataBottomBarPipBoy>,
    backgroundColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listDataBottomBarPipBoy.forEachIndexed { index, item ->
            ItemBottomBarPipBoy(
                modifier = if (index == 0 || index == 2) item.modifier.weight(0.5f) else item.modifier.weight(1f),
                firstElement = item.firstElement,
                secondElement = item.secondElement,
                backgroundColor = backgroundColor
            )
        }
    }
}

@Composable
private fun ItemBottomBarPipBoy(
    firstElement: @Composable () -> Unit,
    secondElement: @Composable () -> Unit,
    backgroundColor: Color,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
            .sizeIn(
                maxHeight = 30.dp
            )
            .background(
                color = backgroundColor
            )
            .padding(5.dp)

    ) {
        firstElement()

        secondElement()
    }
}