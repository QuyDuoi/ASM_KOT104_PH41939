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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.MainActivity
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManThongTinCaNhan : ComponentActivity() {
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
                    KhungManThongTin()
                }
            }
        }
    }
}

@Composable
fun KhungManThongTin() {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF808080))) {
        Spacer(modifier = Modifier.height(40.dp))
        CustomTieuDeTrang(leftIcon = R.drawable.tim_kiem, title = "Profile", rightIcon = R.drawable.dang_xuat, onLeftIconClick = { context ->
            context.startActivity(Intent(context, MainActivity::class.java))
        }, onRightIconClick = {
            context -> context.startActivity(Intent(context, ManDangNhap::class.java))
        })
        Row (modifier = Modifier
            .padding(18.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.anh_dai_dien),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column () {
                Text(text = "Nguyễn Sỹ Quý", fontSize = 20.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(700), color = Color.Black
                )
                Text(text = "quynsph41939@fpt.edu.vn", fontSize = 16.sp, fontFamily = nunitosanFontFamily,
                    fontWeight = FontWeight(400), color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        CustomThongTinCaNhan(tieuDe = "My orders", thongTin = "Already have 10 orders")
        Spacer(modifier = Modifier.height(12.dp))
        CustomThongTinCaNhan(tieuDe = "Shipping Addresses", thongTin = "03 Addresses")
        Spacer(modifier = Modifier.height(12.dp))
        CustomThongTinCaNhan(tieuDe = "Payment Method", thongTin = "You have 2 cards")
        Spacer(modifier = Modifier.height(12.dp))
        CustomThongTinCaNhan(tieuDe = "My reviews", thongTin = "Reviews for 5 items")
        Spacer(modifier = Modifier.height(12.dp))
        CustomThongTinCaNhan(tieuDe = "Setting", thongTin = "Notification, Password, FAQ, Contact")

    }
}

@Composable
fun CustomThongTinCaNhan(tieuDe: String, thongTin: String) {
    Box(modifier = Modifier
        .padding(horizontal = 18.dp)
        .fillMaxWidth()
        .background(Color.White)) {
        Row (modifier = Modifier
            .padding(18.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = tieuDe, fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(400), color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = thongTin, fontSize = 14.sp, fontFamily = nunitosanFontFamily,
                    fontWeight = FontWeight(400), color = Color.DarkGray
                )
            }
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.go_to),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewManThongTin() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManThongTin()
    }
}