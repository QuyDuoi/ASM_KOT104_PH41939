package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.MainActivity
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.merriBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManThongBao : ComponentActivity() {
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
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xF808080)),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.padding(top = 100.dp))
                        Text(text = "SUCCESS!", fontSize = 38.sp, fontWeight = FontWeight(700),
                            fontFamily = merriBold, color = Color.Black, modifier = Modifier.padding(16.dp))
                        Spacer(modifier = Modifier.padding(top = 50.dp))
                        Image(painter = painterResource(id = R.drawable.anh_chuc_mung), contentDescription = "Ảnh chúc mừng thành công",
                            modifier = Modifier
                                .width(225.dp)
                                .height(195.dp))
                        Spacer(modifier = Modifier.padding(top = 10.dp))
                        Image(painter = painterResource(id = R.drawable.success), contentDescription = "Ảnh chúc mừng thành công",
                            modifier = Modifier.size(60.dp))
                        Spacer(modifier = Modifier.padding(top = 30.dp))
                        Text(text = "Your order will be delivered soon. Thank you for choosing our app!",
                            fontSize = 18.sp, fontWeight = FontWeight(700),
                            fontFamily = nunitosanFontFamily, color = Color.DarkGray, modifier = Modifier.padding(horizontal = 50.dp),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.padding(top = 30.dp))
                        CustomButton(
                            width = 335.dp,
                            height = 60.dp,
                            cornerRadius = 10.dp,
                            backgroundColor = Color.Black,
                            textContent = {
                                Text(
                                    text = "Track your orders",
                                    style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = nunitosanBold)
                                )
                            },
                            onClick = {

                            })
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        CustomButton(
                            width = 335.dp,
                            height = 60.dp,
                            cornerRadius = 10.dp,
                            backgroundColor = Color.White,
                            textContent = {
                                Text(
                                    text = "BACK TO HOME",
                                    style = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = nunitosanBold)
                                )
                            },
                            borderEnabled = true,
                            onClick = {
                                val intent = Intent(this@ManThongBao, MainActivity::class.java)
                                startActivity(intent)
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun KhungManThongBao() {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF808080)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(top = 100.dp))
        Text(text = "SUCCESS!", fontSize = 38.sp, fontWeight = FontWeight(700),
            fontFamily = merriBold, color = Color.Black, modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Image(painter = painterResource(id = R.drawable.anh_chuc_mung), contentDescription = "Ảnh chúc mừng thành công",
            modifier = Modifier
                .width(225.dp)
                .height(195.dp))
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Image(painter = painterResource(id = R.drawable.success), contentDescription = "Ảnh chúc mừng thành công",
            modifier = Modifier.size(60.dp))
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Text(text = "Your order will be delivered soon. Thank you for choosing our app!",
            fontSize = 18.sp, fontWeight = FontWeight(700),
            fontFamily = nunitosanFontFamily, color = Color.DarkGray, modifier = Modifier.padding(horizontal = 50.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(top = 30.dp))
        CustomButton(
            width = 335.dp,
            height = 60.dp,
            cornerRadius = 10.dp,
            backgroundColor = Color.Black,
            textContent = {
                Text(
                    text = "Track your orders",
                    style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = nunitosanBold)
                )
            },
            onClick = {

            })
        Spacer(modifier = Modifier.padding(top = 20.dp))
        CustomButton(
            width = 335.dp,
            height = 60.dp,
            cornerRadius = 10.dp,
            backgroundColor = Color.White,
            textContent = {
                Text(
                    text = "BACK TO HOME",
                    style = TextStyle(color = Color.Black, fontSize = 22.sp, fontFamily = nunitosanBold)
                )
            },
            borderEnabled = true,
            onClick = {
                context.startActivity(Intent(context, ManTrangChu::class.java))
            })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewKhungManThongBao() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManThongBao()
    }
}