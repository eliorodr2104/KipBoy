package dataItems

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class DataBottomBarPipBoy(
    val modifier: Modifier,
    val firstElement: @Composable () -> Unit,
    val secondElement: @Composable () -> Unit
)
