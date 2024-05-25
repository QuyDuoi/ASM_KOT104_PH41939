package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManNhanThongBao : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    KhungManNhanThongBao()
                }
            }
        }
    }
}

@Composable
fun KhungManNhanThongBao() {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF808080))) {
        Spacer(modifier = Modifier.height(40.dp))
        CustomTieuDeTrang(leftIcon = R.drawable.tim_kiem, title = "Notification", onLeftIconClick = { context ->
            context.startActivity(Intent(context, ManTrangChu::class.java))
        })
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xF808080))) {
            Row (modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sp_gio_hang_1),
                    contentDescription = "Ảnh sản phẩm",
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "Your order #123456789 has been confirmed", fontSize = 12.sp, fontFamily = nunitosanBold,
                        fontWeight = FontWeight(400), color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec.", fontSize = 10.sp, fontFamily = nunitosanFontFamily,
                        fontWeight = FontWeight(400), color = Color.DarkGray, textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewManNhanThongBao() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManNhanThongBao()
    }
}