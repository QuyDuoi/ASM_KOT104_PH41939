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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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

class ManThanhToan : ComponentActivity() {
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
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xF808080))) {
                        Spacer(modifier = Modifier.height(40.dp))
                        CustomTieuDeTrang(leftIcon = R.drawable.quay_lai, title = "Check out", onLeftIconClick = {

                        })
                        Spacer(modifier = Modifier.height(20.dp))
                        Row (modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Shipping Address", fontSize = 18.sp,
                                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                                color = Color.DarkGray
                            )
                            IconButton(
                                onClick = {  },
                                modifier = Modifier
                                    .size(26.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.edit),
                                    contentDescription = "Image Button",
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Column (modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .background(Color.White)) {
                            Text(text = "Bruno Fernandes", fontSize = 20.sp, fontWeight = FontWeight(700),
                                fontFamily = nunitosanBold, color = Color.Black, modifier = Modifier.padding(16.dp)
                            )
                            Image(painter = painterResource(id = R.drawable.diem_gach), contentDescription = "Phân cách",
                                modifier = Modifier.fillMaxWidth())
                            Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France", fontSize = 14.sp, fontWeight = FontWeight(700),
                                fontFamily = nunitosanFontFamily, color = Color.DarkGray, modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Justify
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row (modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Payment", fontSize = 18.sp,
                                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                                color = Color.DarkGray
                            )
                            IconButton(
                                onClick = {  },
                                modifier = Modifier
                                    .size(26.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.edit_2),
                                    contentDescription = "Image Button",
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .background(Color.White)) {
                            Row (modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Image(painter = painterResource(id = R.drawable.thanh_toan), contentDescription = "Card",
                                    modifier = Modifier
                                        .width(54.dp)
                                        .padding(6.dp))
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(text = "**** **** **** 3947", fontSize = 14.sp, fontFamily = nunitosanFontFamily,
                                    fontWeight = FontWeight(600), color = Color.Black
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row (modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Delivery method", fontSize = 18.sp,
                                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                                color = Color.DarkGray
                            )
                            IconButton(
                                onClick = {  },
                                modifier = Modifier
                                    .size(26.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.edit_2),
                                    contentDescription = "Image Button",
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .background(Color.White)) {
                            Row (modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 16.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(painter = painterResource(id = R.drawable.dhl), contentDescription = "Card",
                                    modifier = Modifier
                                        .width(89.dp)
                                        .height(20.dp))
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(text = "Fast (2-3days)", fontSize = 14.sp, fontFamily = nunitosanFontFamily,
                                    fontWeight = FontWeight(700), color = Color.Black
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column (modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .background(Color.White)) {
                            Row (modifier = Modifier
                                .padding(18.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Order:", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(400), color = Color.DarkGray
                                )
                                Text(text = "$ 95.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(600), color = Color.Black
                                )
                            }
                            Row (modifier = Modifier
                                .padding(horizontal = 18.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Delivery:", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(400), color = Color.DarkGray
                                )
                                Text(text = "$ 5.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(600), color = Color.Black
                                )
                            }
                            Row (modifier = Modifier
                                .padding(18.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Total:", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(400), color = Color.DarkGray
                                )
                                Text(text = "$ 100.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                                    fontWeight = FontWeight(600), color = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.height(28.dp))
                            Box(modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth()) {
                                CustomButton(
                                    width = 335.dp,
                                    height = 60.dp,
                                    cornerRadius = 10.dp,
                                    backgroundColor = Color.Black,
                                    textContent = {
                                        Text(
                                            text = "SUBMIT ORDER",
                                            style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = nunitosanBold)
                                        )
                                    },
                                    onClick = {
                                        val intent = Intent(this@ManThanhToan, ManThongBao::class.java)
                                        startActivity(intent)
                                    })
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun KhungManThanhToan() {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xF808080))) {
        Spacer(modifier = Modifier.height(40.dp))
        CustomTieuDeTrang(leftIcon = R.drawable.quay_lai, title = "Check out", onLeftIconClick = {context ->
            context.startActivity(Intent(context, ManTrangChu::class.java))
        })
        Spacer(modifier = Modifier.height(20.dp))
        Row (modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Shipping Address", fontSize = 18.sp,
                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                color = Color.DarkGray
            )
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White)) {
            Text(text = "Bruno Fernandes", fontSize = 20.sp, fontWeight = FontWeight(700),
                fontFamily = nunitosanBold, color = Color.Black, modifier = Modifier.padding(16.dp)
           )
            Image(painter = painterResource(id = R.drawable.diem_gach), contentDescription = "Phân cách",
                modifier = Modifier.fillMaxWidth())
            Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France", fontSize = 14.sp, fontWeight = FontWeight(700),
                fontFamily = nunitosanFontFamily, color = Color.DarkGray, modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Payment", fontSize = 18.sp,
                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                color = Color.DarkGray
            )
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit_2),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(Color.White)) {
            Row (modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Image(painter = painterResource(id = R.drawable.thanh_toan), contentDescription = "Card",
                    modifier = Modifier
                        .width(54.dp)
                        .padding(6.dp))
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = "**** **** **** 3947", fontSize = 14.sp, fontFamily = nunitosanFontFamily,
                    fontWeight = FontWeight(600), color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Delivery method", fontSize = 18.sp,
                fontWeight = FontWeight(600), fontFamily = nunitosanBold,
                color = Color.DarkGray
            )
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit_2),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(Color.White)) {
            Row (modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 16.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Image(painter = painterResource(id = R.drawable.dhl), contentDescription = "Card",
                    modifier = Modifier
                        .width(89.dp)
                        .height(20.dp))
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = "Fast (2-3days)", fontSize = 14.sp, fontFamily = nunitosanFontFamily,
                    fontWeight = FontWeight(700), color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White)) {
            Row (modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order:", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(400), color = Color.DarkGray
                )
                Text(text = "$ 95.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(600), color = Color.Black
                )
            }
            Row (modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Delivery:", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(400), color = Color.DarkGray
                )
                Text(text = "$ 5.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(600), color = Color.Black
                )
            }
            Row (modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total:", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(400), color = Color.DarkGray
                )
                Text(text = "$ 100.00", fontSize = 18.sp, fontFamily = nunitosanBold,
                    fontWeight = FontWeight(600), color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Box(modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()) {
                CustomButton(
                    width = 335.dp,
                    height = 60.dp,
                    cornerRadius = 10.dp,
                    backgroundColor = Color.Black,
                    textContent = {
                        Text(
                            text = "SUBMIT ORDER",
                            style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = nunitosanBold)
                        )
                    },
                    onClick = {
                        context.startActivity(Intent(context, ManThanhToan::class.java))
                    })
            }
        }

    }
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
fun PreviewManThanhToan () {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManThanhToan()
    }
}