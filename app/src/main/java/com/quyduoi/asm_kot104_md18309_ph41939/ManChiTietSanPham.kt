package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManChiTietSanPham : ComponentActivity() {
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
                    KhungManChiTiet()
                }
            }
        }
    }
}

data class ChiTietSanPham(val ten: String, val gia: Double, val soLuong: Int, val saoDanhGia: Double, val luotReview: Int, val moTa: String)

val sanPham1 = ChiTietSanPham("Minimal Stand", 50.0, 1, 4.5, 50, "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.")

@Composable
fun KhungManChiTiet () {
    val context = LocalContext.current
    var soLuong by remember { mutableStateOf(sanPham1.soLuong) }
    Column (modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(455.dp)) {
            Image(
                painter = painterResource(id = R.drawable.anh_chi_tiet_sp),
                contentDescription = "Ảnh chi tiết sản phẩm",
                modifier = Modifier
                    .width(323.dp)
                    .height(455.dp)
                    .align(Alignment.TopEnd))
            IconButton(
                onClick = {
                    context.startActivity(Intent(context, ManTrangChu::class.java))
                },
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.TopStart)
                    .padding()
                    .offset(x = 35.dp, y = 45.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_home),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = sanPham1.ten, fontSize = 26.sp, fontFamily = gelasioFontFamily, fontWeight = FontWeight(500),
            color = Color.Black, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(14.dp))
        Row (modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "$ ${sanPham1.gia}", fontSize = 30.sp, fontFamily = nunitosanBold, fontWeight = FontWeight(700),
                color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    if (soLuong > 1) {
                        soLuong--
                    }
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.giam_so_luong),
                        contentDescription = "Giảm số lượng",
                        modifier = Modifier.size(35.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = soLuong.toString(), fontSize = 20.sp)
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(onClick = {
                    soLuong++
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.tang_so_luong),
                        contentDescription = "Tăng số lượng",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.star), contentDescription = "Sao đánh giá",
                modifier = Modifier.size(22.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "${sanPham1.saoDanhGia}", fontSize = 22.sp, fontWeight = FontWeight(700),
                fontFamily = nunitosanBold)
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "(${sanPham1.luotReview} reviews)", fontSize = 16.sp, fontWeight = FontWeight(700),
                fontFamily = nunitosanBold, color = Color.DarkGray)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = sanPham1.moTa, modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify, color = Color.DarkGray, fontSize = 16.sp,
            fontWeight = FontWeight(300), fontFamily = nunitosanFontFamily)
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(
                onClick = {
                    context.startActivity(Intent(context, ManYeuThich::class.java))
                },
                modifier = Modifier
                    .size(60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yeu_thich),
                    contentDescription = "Image Button",
                    modifier = Modifier.size(60.dp)
                )
            }
            CustomButton(
                width = 280.dp,
                height = 60.dp,
                cornerRadius = 10.dp,
                backgroundColor = Color.Black,
                textContent = {
                    Text(
                        text = "Add to cart",
                        style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = nunitosanBold)
                    )
                },
                onClick = {
                    context.startActivity(Intent(context, ManGioHang::class.java))
                })
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewManChiTiet () {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManChiTiet()
    }
}