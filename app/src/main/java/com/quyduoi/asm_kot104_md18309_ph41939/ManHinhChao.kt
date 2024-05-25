package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily

class ManHinhChao : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.statusBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        setContent {
            ASM_KOT104_MD18309_PH41939Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.nen_chao),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Text(text = "")
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 150.dp)
                        ) {
                            CustomButton(
                                width = 159.dp,
                                height = 54.dp,
                                cornerRadius = 4.dp,
                                backgroundColor = Color.Black,
                                textContent = {
                                    Text(
                                        text = "Get Started",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                                    )
                                },
                                onClick = {
                                    val intent = Intent(this@ManHinhChao, ManDangNhap::class.java)
                                    startActivity(intent)
                                })
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun KhungManHinhChao() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.nen_chao),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(text = "")
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 150.dp)
        ) {
            CustomButton(
                width = 159.dp,
                height = 54.dp,
                cornerRadius = 4.dp,
                backgroundColor = Color.Black,
                textContent = {
                    Text(
                        text = "Get Started",
                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                    )
                },
                onClick = {

                })
        }
    }
}

@Composable
fun CustomButton(
    width: Dp,
    height: Dp,
    cornerRadius: Dp,
    backgroundColor: Color,
    textContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    borderEnabled: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width, height)
            .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .clickable { onClick() }
            .then(
                if (borderEnabled) Modifier.border(
                    1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(cornerRadius)
                ) else Modifier
            ) // Thêm đường viền nếu borderEnabled là true
    ) {
        textContent()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GDManHinhChao() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManHinhChao()
    }
}

