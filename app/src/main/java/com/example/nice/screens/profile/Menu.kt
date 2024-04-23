package com.example.nice.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nice.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuComponent(scope: CoroutineScope, menuState: DrawerState) {
    val items = listOf(
        MenuItem(
            Icons.Default.Home,
            "Главная страница"
        ),
        MenuItem(
            Icons.Default.Check,
            "Критерии работы"
        ),
        MenuItem(
            Icons.Default.Create,
            "Карточки"
        ),
        MenuItem(
            Icons.Default.Person,
            "Профиль"
        ),
        MenuItem(
            Icons.Default.Favorite,
            "О нас для вас"
        )
    )
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalDrawerSheet {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp), contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.backk), contentDescription = "Header")
        Spacer(modifier = Modifier.height(15.dp))
        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(text = item.title) },
                selected = selectedItem.value == item,
                onClick = {
                    scope.launch {
                        selectedItem.value = item
                        menuState.close()
                    }
                }
            )
        }
    }
}

data class MenuItem(
    val imageVector: ImageVector,
    val title: String
)