package com.example.koffi.Screens.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koffi.Screens.Menu.Components.MenuCategoryRow
import com.example.koffi.ui.theme.bgSpecialGray
import com.example.koffi.ui.theme.bgWhite
import com.example.koffi.ui.theme.koffiBrown

@Composable
fun MenuRoute(
        viewModel: MenuViewModel,
        onItemClick: (String) -> Unit
    ) {
    val uiState by viewModel.uiState.collectAsState()
    Menu(
        uiState = uiState,
        onCategorySelected = viewModel::onCategorySelected,
        onItemClick = onItemClick
    )
}

//@Preview
//@Composable
fun Menu(
    uiState: MenuUiState,
    onCategorySelected: (MenuCategory) -> Unit,
    onItemClick: (String) -> Unit
) {

}

@Preview
@Composable
fun MenuScreen() {
    val scrollState = rememberScrollState()
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(bgWhite)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(bgWhite)
        ) {
            Column ( // PARENT COL WITH SCROLL
                modifier = Modifier
                    .fillMaxSize()
                    .background(bgWhite)
                    .verticalScroll(scrollState)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(koffiBrown)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                                ambientColor = DefaultShadowColor,
                                spotColor = DefaultShadowColor
                            )

                    ) {
                        Text(
                            text = "our MENU",
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 12.dp),
                            fontSize = 22.sp,
                            color = bgWhite,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Default,
                            letterSpacing = 2.sp
                        )
                    }
                }
                // START MENU HERE
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    MenuCategoryRow(
                        categories = MenuCategory.entries,
                        selected = TODO(),
                        onCategorySelected = TODO()
                    )
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {  }
                }
            }
        }
    }
}