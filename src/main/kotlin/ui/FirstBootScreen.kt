
package ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import dataItems.DataPerson
import dataItems.SpecialUser
import enums.ColorsPipBoy
import enums.FirstBootMenus
import enums.FirstBootMenus.*
import enums.PrincipalScreens
import enums.SpecialPipBoy
import enums.TypesColorsPipBoy.BACKGROUNDCOLOR
import enums.TypesColorsPipBoy.SELECTCOLOR
import kotlinx.coroutines.delay
import tools.FileManager
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*
import kotlin.math.abs
import enums.PrincipalScreens.*
import java.time.Period

@Composable
fun ManagementBootScreens(
    fileManager: FileManager<DataPerson>,
    changeIndexPrincipalScreen: (PrincipalScreens) -> Unit,
    getInfoUser: (DataPerson) -> Unit
) {
    var indexScreen by remember {
        mutableStateOf(INSERT_FAVORITE_COLOR)
    }

    val infoUser by remember {
        mutableStateOf(DataPerson())
    }

    var colorUserBackground by remember {
        mutableStateOf(infoUser.colorPipboy.colors[BACKGROUNDCOLOR]!!)
    }

    var colorUserSelect by remember {
        mutableStateOf(infoUser.colorPipboy.colors[SELECTCOLOR]!!)
    }

    val pointsMax = 17f
    val pointsMin = 7f
    val ageMax = 100

    when(indexScreen) {
        INSERT_FAVORITE_COLOR -> {
            InsertFavoriteColor(
                changeIndexScreen = { indexScreen = it },
                getFavoriteColorPerson = {
                    infoUser.colorPipboy = it
                    colorUserBackground = infoUser.colorPipboy.colors[BACKGROUNDCOLOR]!!
                    colorUserSelect = infoUser.colorPipboy.colors[SELECTCOLOR]!!
                }
            )
        }

        INSERT_NAME -> {
            InsertName(
                changeIndexScreen = { indexScreen = it },
                getNamePerson = { infoUser.name = it },
                backgroundColor = colorUserBackground,
                selectColor = colorUserSelect
            )
        }

        INSERT_LASTNAME -> {
            InsertLastname(
                backgroundColor = colorUserBackground,
                selectColor = colorUserSelect,
                changeIndexScreen = { indexScreen = it },
                getLastnamePerson = { infoUser.lastname = it }
            )
        }

        INSERT_BIRTHDAY -> {
            InsertDate(
                colorUserBackground,
                colorUserSelect,
                changeIndexScreen = { indexScreen = it },
                getBirthdayPerson = {
                    infoUser.dateOfBirth = it
                    infoUser.age = calcAge(infoUser.dateOfBirth, "MM/dd/yyyy")
                    infoUser.pointsSpecial = (pointsMax - (pointsMax - pointsMin) * (infoUser.age.toDouble() / ageMax)).toInt()
                }
            )
        }

        SELECT_SPECIAL -> {
            InsertSpecialSelectLevel(
                user = infoUser,
                selectColor = colorUserSelect,
                changePointsSpecial = { infoUser.pointsSpecial = it },
                changeIndexScreen = {
                    fileManager.writeObjectToFile(infoUser)
                    getInfoUser(infoUser)
                    changeIndexPrincipalScreen(PIP_BOY_MENUS)
                },
                changeSpecials = { infoUser.specialsUser = it }
            )
        }
    }
}

@Composable
private fun InsertSpecialSelectLevel(
    user: DataPerson,
    selectColor: Color,

    changePointsSpecial: (Int) -> Unit,
    changeSpecials: (List<SpecialUser>) -> Unit,
    changeIndexScreen: (FirstBootMenus) -> Unit
) {
    var pointsSpecial by remember {
        mutableStateOf(user.pointsSpecial)
    }

    var specialListUser by remember {
        mutableStateOf(user.specialsUser)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        contentAlignment = Alignment.Center
    ) {
        WindowsContainerWithName(
            textWindow = "S.P.E.C.I.A.L",
            colorText = selectColor,
            colorBorderWindow = selectColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            SelectLevelSpecial(
                user = user,
                getSelectSpecialUser = { specialListUser = it },
                getSelectPointUser = { pointsSpecial = it },
                selectColor = selectColor
            )
        }

        Button(
            onClick = {
                changeSpecials(specialListUser)
                changePointsSpecial(pointsSpecial)
                changeIndexScreen(SELECT_SPECIAL)
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 26.dp,
                    end = 30.dp
                ),

            shape = CutCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectColor
            )
        ) {
            Text(
                text = "NEXT",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun SelectLevelSpecial(
    user: DataPerson,
    selectColor: Color,

    getSelectPointUser: (Int) -> Unit,
    getSelectSpecialUser: (List<SpecialUser>) -> Unit
) {
    var pointsSpecial by remember {
        mutableIntStateOf(user.pointsSpecial)
    }

    val specialListUser by remember {
        mutableStateOf(user.specialsUser)
    }

    var indexSpecialSelectable by remember {
        mutableIntStateOf(0)
    }

    var selectSpecial by remember {
        mutableStateOf(SpecialPipBoy.STRENGTH)
    }

    var usagePoints by remember {
        mutableIntStateOf(0)
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 15.dp,
                bottom = 20.dp,
                start = 10.dp,
                end = 10.dp
            )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Points: $pointsSpecial",
                color = selectColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(
                        bottom = 10.dp
                    )
            )

            for ((index, special) in specialListUser.withIndex()) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            indexSpecialSelectable = index
                            selectSpecial = special.specialAttribute
                        }
                        .fillMaxWidth(0.5f)
                        .background(
                            color = if (indexSpecialSelectable == index) selectColor else Color.Transparent
                        )
                        .padding(
                            all = 5.dp
                        )
                ) {
                    Text(
                        text = special.specialAttribute.name.lowercase().capitalize(),
                        color = if (indexSpecialSelectable == index) Color.Black else selectColor,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        if (indexSpecialSelectable == index && usagePoints > 0 && special.levelSpecial > 0) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clickable {
                                        pointsSpecial++
                                        usagePoints--
                                        special.levelSpecial--

                                        getSelectPointUser(pointsSpecial)
                                        getSelectSpecialUser(specialListUser)
                                    }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "delete point"
                                )
                            }
                        }

                        Text(
                            text = special.levelSpecial.toString().capitalize(),
                            color = if (indexSpecialSelectable == index) Color.Black else selectColor,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(
                                    start = 5.dp,
                                    end = 5.dp
                                )
                        )

                        if (indexSpecialSelectable == index && pointsSpecial > 0) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clickable {
                                        pointsSpecial--
                                        usagePoints++
                                        special.levelSpecial++

                                        getSelectPointUser(pointsSpecial)
                                        getSelectSpecialUser(specialListUser)
                                    }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                                    contentDescription = "add point"
                                )
                            }
                        }
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ImageCycler(
                modifier = Modifier
                    .height(220.dp),
                selectColor = selectColor,
                imagesList = selectSpecial.dataFrame.pathFrame,
                quantityFrames = selectSpecial.dataFrame.quantityFrame,
                intervalMillis = selectSpecial.dataFrame.millisFrames
            )

            Text(
                text = selectSpecial.descriptionSpecial,
                color = selectColor
            )
        }
    }
}

@Composable
private fun InsertFavoriteColor(
    changeIndexScreen: (FirstBootMenus) -> Unit,
    getFavoriteColorPerson: (ColorsPipBoy) -> Unit
) {
    var colorPerson by remember {
        mutableStateOf(ColorsPipBoy.GREEN)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        contentAlignment = Alignment.Center
    ) {
        WindowsContainerWithName(
            textWindow = "Favorite Color",
            colorText = colorPerson.colors[SELECTCOLOR]!!,
            colorBorderWindow = colorPerson.colors[SELECTCOLOR]!!,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            DefaultColorPicker(
                getFavoriteColorPerson = { colorPerson = it }
            )
        }

        Button(
            onClick = {
                getFavoriteColorPerson(colorPerson)
                changeIndexScreen(INSERT_NAME)
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 26.dp,
                    end = 30.dp
                ),

            shape = CutCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorPerson.colors[SELECTCOLOR]!!
            )
        ) {
            Text(
                text = "NEXT",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
private fun DefaultColorPicker(
    getFavoriteColorPerson: (ColorsPipBoy) -> Unit
) {
    var colorSelect by remember {
        mutableStateOf(ColorsPipBoy.GREEN)
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (colorDefault in ColorsPipBoy.entries) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                if (colorSelect == colorDefault) {
                    Text(
                        text = " ",
                    )
                }

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .background(
                            color = colorDefault.colors[SELECTCOLOR]!!
                        )
                        .clickable {
                            colorSelect = colorDefault
                            getFavoriteColorPerson(colorSelect)
                        }
                )

                if (colorSelect == colorDefault) {
                    Text(
                        text = colorDefault.name,
                        color = colorDefault.colors[SELECTCOLOR]!!
                    )
                }
            }
        }
    }
}

@Composable
private fun InsertDate(
    backgroundColor: Color,
    selectColor: Color,
    changeIndexScreen: (FirstBootMenus) -> Unit,
    getBirthdayPerson: (String) -> Unit
) {
    var birthdayPerson by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        contentAlignment = Alignment.Center
    ) {
        WindowsContainerWithName(
            textWindow = "Birthday",
            colorText = selectColor,
            colorBorderWindow = selectColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            DatePicker(
                selectColor,
                backgroundColor,
                getBirthday = { birthdayPerson = it }
            )
        }

        Button(
            onClick = {
                if (isValidDate(birthdayPerson)) {
                    getBirthdayPerson(birthdayPerson)
                    changeIndexScreen(SELECT_SPECIAL)
                }
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 26.dp,
                    end = 30.dp
                ),

            shape = CutCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectColor
            )
        ) {
            Text(
                text = "NEXT",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

private fun isValidDate(dateStr: String): Boolean {
    val dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US)

    return try {
        val parsedDate = LocalDate.parse(dateStr, dateFormatter)
        val reformattedDate = parsedDate.format(dateFormatter)
        dateStr == reformattedDate

    } catch (e: DateTimeParseException) {
        false
    }
}

@Composable
private fun DatePicker(
    selectColor: Color,
    backgroundColor: Color,
    getBirthday: (String) -> Unit
) {
    val currentDate = Date()
    val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    val dateString = dateFormat.format(currentDate).split("/")

    var dayBirthday by remember {
        mutableStateOf(dateString[1].toInt())
    }

    var monthBirthday by remember {
        mutableStateOf(dateString[0].toInt())
    }

    var yearBirthday by remember {
        mutableStateOf(dateString[2].toInt())
    }

    var indexBoxSelected by remember {
        mutableStateOf(0)
    }

    var sizeBox by remember {
        mutableStateOf(IntSize(0, 0))
    }

    val valueDp = LocalDensity.current.run {
        sizeBox.width.toDp()
    }

    var stateColorSelected by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        while (true) {
            stateColorSelected = !stateColorSelected
            delay(1000L)
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 0 until 3) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                if (indexBoxSelected == index) {
                    Box(
                        modifier = Modifier
                            .width(valueDp)
                            .clickable {
                                when(index) {
                                    0 -> {
                                        if (monthBirthday + 1 <= 12)
                                            monthBirthday++
                                        else
                                            monthBirthday = 1
                                    }

                                    1 -> {
                                        if (dayBirthday + 1 <= 31)
                                            dayBirthday++
                                        else
                                            dayBirthday = 1
                                    }

                                    2 -> yearBirthday++
                                }

                                getBirthday("${monthBirthday.toString().padStart(2, '0')}/${dayBirthday.toString().padStart(2, '0')}/$yearBirthday")
                            }
                    ) {
                        // Creating a canvas and creating a triangular path
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        ) {
                            val rect = Rect(Offset.Zero, size)

                            val trianglePath = Path().apply {
                                moveTo(rect.center.x, rect.center.y + rect.center.y/2)
                                lineTo(rect.bottomRight.x, rect.bottomRight.y)
                                lineTo(rect.bottomLeft.x, rect.bottomLeft.y)
                                close()
                            }

                            drawIntoCanvas { canvas ->
                                canvas.drawOutline(
                                    outline = Outline.Generic(trianglePath),
                                    paint = Paint().apply {
                                        color = selectColor
                                        //pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                                    }
                                )
                            }
                        }
                    }
                }

                DateBox(
                    modifier = Modifier
                        .width(
                            width = when(index) {
                                0, 1 -> 80.dp
                                2 -> 170.dp
                                else -> 0.dp
                            }
                        )
                        .padding(5.dp)
                        .background(
                            color = if (indexBoxSelected == index)
                                        if (!stateColorSelected) backgroundColor else selectColor
                                    else
                                        backgroundColor
                        )
                        .clickable {
                            //indexCharacter = charactersAlphabet.indexOf(charactersSelections[index])
                            indexBoxSelected = index
                        }
                        .onGloballyPositioned { layoutCoordinates ->
                            if (indexBoxSelected == index)
                                sizeBox = layoutCoordinates.size
                        },
                    text = when(index) {
                        0 -> monthBirthday.toString().padStart(2, '0')
                        1 -> dayBirthday.toString().padStart(2, '0')
                        2 -> yearBirthday.toString()
                        else -> dateString[index]
                    },
                    colorText = if (indexBoxSelected == index)
                                    if (!stateColorSelected) selectColor else backgroundColor
                                else
                                    selectColor
                )

                if (indexBoxSelected == index) {
                    Box(
                        modifier = Modifier
                            .width(valueDp)
                            .clickable {
                                when(index) {
                                    0 -> {
                                        if (monthBirthday - 1 >= 1)
                                            monthBirthday--
                                        else
                                            monthBirthday = 12
                                    }

                                    1 -> {
                                        if (dayBirthday - 1 >= 1)
                                            dayBirthday--
                                        else
                                            dayBirthday = 31
                                    }

                                    2 -> {
                                        if (yearBirthday - 1 >= 0)
                                            yearBirthday--

                                        else
                                            yearBirthday = dateString[2].toInt()
                                    }
                                }

                                getBirthday("${monthBirthday.toString().padStart(2, '0')}/${dayBirthday.toString().padStart(2, '0')}/$yearBirthday")
                            }
                    ) {
                        // Creating a canvas and creating a triangular path
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        ) {
                            val rect = Rect(Offset.Zero, size)

                            val trianglePath = Path().apply {
                                moveTo(rect.center.x, rect.center.y / 2)
                                lineTo(rect.topRight.x, rect.topRight.y)
                                lineTo(rect.topLeft.x, rect.topLeft.y)
                                close()
                            }

                            drawIntoCanvas { canvas ->
                                canvas.drawOutline(
                                    outline = Outline.Generic(trianglePath),
                                    paint = Paint().apply {
                                        color = selectColor
                                        //pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DateBox(
    modifier: Modifier,
    text: String,
    colorText: Color
) {
    Box(
        modifier = modifier
            .height(65.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = colorText,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
private fun InsertLastname(
    backgroundColor: Color,
    selectColor: Color,
    changeIndexScreen: (FirstBootMenus) -> Unit,
    getLastnamePerson: (String) -> Unit
) {
    var lastnameUser by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        contentAlignment = Alignment.Center
    ) {
        WindowsContainerWithName(
            textWindow = "Lastname",
            colorText = selectColor,
            colorBorderWindow = selectColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            CharacterPicker(
                backgroundColor = backgroundColor,
                selectColor = selectColor,
                getTextUser = { lastnameUser = it }
            )
        }

        Button(
            onClick = {
                getLastnamePerson(lastnameUser)
                changeIndexScreen(INSERT_BIRTHDAY)
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 26.dp,
                    end = 30.dp
                ),

            shape = CutCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectColor
            )
        ) {
            Text(
                text = "NEXT",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
private fun InsertName(
    backgroundColor: Color,
    selectColor: Color,
    changeIndexScreen: (FirstBootMenus) -> Unit,
    getNamePerson: (String) -> Unit
) {
    var nameUser by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            ),
        contentAlignment = Alignment.Center
    ) {
        WindowsContainerWithName(
            textWindow = "Name",
            colorText = selectColor,
            colorBorderWindow = selectColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            CharacterPicker(
                backgroundColor = backgroundColor,
                selectColor = selectColor,
                getTextUser = { nameUser = it }
            )
        }

        Button(
            onClick = {
                getNamePerson(nameUser)
                changeIndexScreen(INSERT_LASTNAME)
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 26.dp,
                    end = 30.dp
                ),

            shape = CutCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = selectColor
            )
        ) {
            Text(
                text = "NEXT",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
private fun CharacterPicker(
    backgroundColor: Color,
    selectColor: Color,
    getTextUser: (String) -> Unit
) {
    val charactersAlphabet = arrayOf(
        'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', ' '
    )

    val charactersSelections = remember {
        mutableStateListOf(
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' '
        )
    }

    var indexCharacter by remember {
        mutableStateOf(charactersAlphabet.size - 1)
    }

    var indexBoxSelected by remember {
        mutableStateOf(0)
    }

    var stateColorSelected by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        while (true) {
            stateColorSelected = !stateColorSelected
            delay(1000L)
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 0 until 10) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                if (indexBoxSelected == index) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                if ((indexCharacter + 1) >= charactersAlphabet.size) {
                                    indexCharacter = 0
                                    charactersSelections[index] = charactersAlphabet[0]

                                } else {
                                    indexCharacter++
                                    charactersSelections[index] = charactersAlphabet[indexCharacter]
                                }

                                getTextUser(charactersSelections.toList().filter { it != ' ' }.joinToString(separator = ""))
                            }
                    ) {
                        // Creating a canvas and creating a triangular path
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        ) {
                            val rect = Rect(Offset.Zero, size)

                            val trianglePath = Path().apply {
                                moveTo(rect.center.x, rect.center.y)
                                lineTo(rect.bottomRight.x, rect.bottomRight.y)
                                lineTo(rect.bottomLeft.x, rect.bottomLeft.y)
                                close()
                            }

                            drawIntoCanvas { canvas ->
                                canvas.drawOutline(
                                    outline = Outline.Generic(trianglePath),
                                    paint = Paint().apply {
                                        color = selectColor
                                        //pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                                    }
                                )
                            }
                        }
                    }
                }

                SingleLetterBox(
                    character = charactersSelections[index],
                    modifier = Modifier
                        .clickable {
                            indexCharacter = charactersAlphabet.indexOf(charactersSelections[index])
                            indexBoxSelected = index
                        }
                        .background(
                            color = if (indexBoxSelected == index)
                                        if (!stateColorSelected) backgroundColor else selectColor
                                    else
                                        backgroundColor
                        ),
                    selectColor = if (indexBoxSelected == index)
                                        if (stateColorSelected) backgroundColor else selectColor
                                  else
                                        selectColor
                )

                if (indexBoxSelected == index) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                if ((indexCharacter - 1) < 0) {
                                    indexCharacter = charactersAlphabet.size - 1
                                    charactersSelections[index] = charactersAlphabet[indexCharacter]

                                } else {
                                    indexCharacter--
                                    charactersSelections[index] = charactersAlphabet[indexCharacter]
                                }

                                getTextUser(charactersSelections.toList().filter { it != ' ' }.joinToString(separator = ""))
                            }
                    ) {
                        // Creating a canvas and creating a triangular path
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        ) {
                            val rect = Rect(Offset.Zero, size)

                            val trianglePath = Path().apply {
                                moveTo(rect.center.x, rect.center.y)
                                lineTo(rect.topRight.x, rect.topRight.y)
                                lineTo(rect.topLeft.x, rect.topLeft.y)
                                close()
                            }

                            drawIntoCanvas { canvas ->
                                canvas.drawOutline(
                                    outline = Outline.Generic(trianglePath),
                                    paint = Paint().apply {
                                        color = selectColor
                                        //pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SingleLetterBox(
    character: Char,
    modifier: Modifier,
    selectColor: Color
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .width(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = character.toString(),
            color = selectColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h3
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun WindowsContainerWithName(
    textWindow: String,
    colorText: Color = Color.Black,
    colorBorderWindow: Color,
    colorBackgroundWindow: Color = Color.Transparent,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var positionSubWindowIntoScreen by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    var positionTextIntoScreen by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    var sizeTextIntoScreen by remember {
        mutableStateOf(IntSize(0, 0))
    }

    val modifierMaxSize = Modifier.fillMaxSize()

    val window = LocalWindowInfo.current
    val screenWidth = window.containerSize.width
    val screenHeight = window.containerSize.height

    var finalLineUntilToText by remember {
        mutableStateOf(0f)
    }

    var yAxisElevation by remember {
        mutableStateOf(0f)
    }

    var xAxisTopLine by remember {
        mutableStateOf(0f)
    }

    var xAxisStartSecondTopLine by remember {
        mutableStateOf(0f)
    }

    var xAxisEndSecondTopLine by remember {
        mutableStateOf(0f)
    }

    var endScreenPlusPadding by remember {
        mutableStateOf(0f)
    }

    var bottomScreenPlusPadding by remember {
        mutableStateOf(0f)
    }

    Box(
        modifier = modifier
            .onGloballyPositioned { layoutCoordinates ->
                positionSubWindowIntoScreen = layoutCoordinates.positionInWindow()
            }
            .background(
                color = colorBackgroundWindow
            ),

        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = textWindow,
                color = colorText,
                modifier = Modifier
                    .onGloballyPositioned { layoutCoordinates ->
                        positionTextIntoScreen = layoutCoordinates.positionInWindow()
                        sizeTextIntoScreen = layoutCoordinates.size

                        //LINES CALC
                        finalLineUntilToText = abs((positionTextIntoScreen.x - positionSubWindowIntoScreen.x) - 10f)
                        yAxisElevation = abs(positionTextIntoScreen.y - 15f)
                        xAxisTopLine = finalLineUntilToText + 7f
                        xAxisStartSecondTopLine = sizeTextIntoScreen.width + 30f
                        xAxisEndSecondTopLine = xAxisStartSecondTopLine + 7f
                        endScreenPlusPadding = abs(abs(abs(screenWidth - 30f) - 7f) - positionSubWindowIntoScreen.x)
                        bottomScreenPlusPadding = screenHeight - (positionSubWindowIntoScreen.y * 2)
                    },
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = modifierMaxSize,
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }

        Canvas(
            modifier = modifierMaxSize
        ) {
            //INIZIO BOX FINO A TEXT
            drawLine(
                start = Offset(
                    x = 0f,
                    y = positionTextIntoScreen.y
                ),
                end = Offset(
                    x = finalLineUntilToText,
                    y = positionTextIntoScreen.y
                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA CHE RIALZA IL PRIMO PEZZO
            drawLine(
                start = Offset(
                    x = finalLineUntilToText,
                    y = positionTextIntoScreen.y
                ),
                end = Offset(
                    x = finalLineUntilToText,
                    y = yAxisElevation

                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA CHE VA A DESTRA RIALZATA
            drawLine(
                start = Offset(
                    x = finalLineUntilToText,
                    y = yAxisElevation
                ),
                end = Offset(
                    x = xAxisTopLine,
                    y = yAxisElevation

                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //SECONDA LINEA CHE VA A DESTRA RIALZATA
            drawLine(
                start = Offset(
                    x = xAxisStartSecondTopLine,
                    y = yAxisElevation
                ),
                end = Offset(
                    x = xAxisEndSecondTopLine,
                    y = yAxisElevation

                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA A DESTRA CHE SCENDE
            drawLine(
                start = Offset(
                    x = xAxisEndSecondTopLine,
                    y = yAxisElevation
                ),
                end = Offset(
                    x = xAxisEndSecondTopLine,
                    y = positionTextIntoScreen.y

                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA CHE VA FINO ALLA FINE DELLO SCHERMO
            drawLine(
                start = Offset(
                    x = xAxisEndSecondTopLine,
                    y = positionTextIntoScreen.y
                ),
                end = Offset(
                    x = endScreenPlusPadding,
                    y = positionTextIntoScreen.y

                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA SINISTRA CHE SCENDE
            drawLine(
                start = Offset(
                    x = 0f,
                    y = positionTextIntoScreen.y
                ),
                end = Offset(
                    x = 0f,
                    y = bottomScreenPlusPadding
                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA DESTRA CHE SCENDE
            drawLine(
                start = Offset(
                    x = endScreenPlusPadding,
                    y = positionTextIntoScreen.y
                ),
                end = Offset(
                    x = endScreenPlusPadding,
                    y = bottomScreenPlusPadding
                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )

            //LINEA INFERIORE CHE SCENDE
            drawLine(
                start = Offset(
                    x = 0f,
                    y = bottomScreenPlusPadding
                ),
                end = Offset(
                    x = endScreenPlusPadding,
                    y = bottomScreenPlusPadding
                ),
                color = colorBorderWindow,
                strokeWidth = 5f
            )
        }
    }
}

private fun String.capitalize(): String {
   return this.replaceFirstChar { if (it. isLowerCase()) it. titlecase(Locale. getDefault()) else it. toString() }
}

private fun calcAge(dateBornUser: String, format: String): Int {
    val formatter = DateTimeFormatter.ofPattern(format)
    val dateBorn = LocalDate.parse(dateBornUser, formatter)
    val today = LocalDate.now()
    val age = Period.between(dateBorn, today).years

    return age
}