package com.quyduoi.asm_kot104_md18309_ph41939

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm.Screens
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.assignment_kot104_ph41939.KhungManNhanThongBao
import com.quyduoi.assignment_kot104_ph41939.KhungManThongTin
import com.quyduoi.assignment_kot104_ph41939.KhungManTrangChu
import com.quyduoi.assignment_kot104_ph41939.KhungManYeuThich
import com.quyduoi.assignment_kot104_ph41939.ManNhanThongBao
import com.quyduoi.assignment_kot104_ph41939.ManThongTinCaNhan
import com.quyduoi.assignment_kot104_ph41939.ManTrangChu
import com.quyduoi.assignment_kot104_ph41939.ManYeuThich

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ASM_KOT104_MD18309_PH41939Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val startFavoriteActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        // Handle the result if needed
    }
    Scaffold(bottomBar = {
        BottomAppBar(
            containerColor = Color.White
        ) {
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Home) Color.Black else Color(
                        0xFF999999
                    )
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Favorite
                    navigationController.navigate(Screens.Favourite.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Favorite) Color.Black else Color(
                        0xFF999999
                    )
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Notifications
                    navigationController.navigate(Screens.Notification.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Notifications) Color.Black else Color(
                        0xFF999999
                    )
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Person) Color.Black else Color(
                        0xFF999999
                    )
                )
            }

        }
    }) { paddingValues ->
        NavHost(
            navController = navigationController, startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { KhungManTrangChu() }
            composable(Screens.Favourite.screen) { KhungManYeuThich() }
            composable(Screens.Notification.screen) { KhungManNhanThongBao() }
            composable(Screens.Profile.screen) { KhungManThongTin() }
        }

    }
}