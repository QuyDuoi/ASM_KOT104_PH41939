package com.quyduoi.assignment_kot104_ph41939

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManTrangChu : ComponentActivity() {
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
                    Column (modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(40.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = {
                                    // Handle left icon click
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .size(35.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.tim_kiem),
                                    contentDescription = "Left Icon",
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Column (
                                modifier = Modifier.width(280.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Make home",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight(400),
                                        textAlign = TextAlign.Center,
                                        color = Color(0xFF909090),
                                        fontFamily = gelasioFontFamily
                                    )
                                )
                                Text(
                                    text = "BEAUTIFUL",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF242424),
                                        fontFamily = gelasioFontFamily
                                    )
                                )
                            }

                            IconButton(
                                onClick = {
                                    val intent = Intent(this@ManTrangChu, ManGioHang::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .size(24.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.gio_hang),
                                    contentDescription = "Right Icon",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        MatHangRow(cacMatHang)
                        DanhSachSanPham(cacSanPham)
                    }
                }
            }
        }
    }
}

data class MatHang (val name: String, val image: Int)
data class SanPham(val ten: String, val gia: String, val hinhAnh: Int)

val cacMatHang = listOf(
    MatHang("Popular", R.drawable.popular),
    MatHang("Chair", R.drawable.chair),
    MatHang("Table", R.drawable.table),
    MatHang("Armchair", R.drawable.armchair),
    MatHang("Bed", R.drawable.bed),
    MatHang("Lamb", R.drawable.lamb)
)

val cacSanPham = listOf(
    SanPham("Black Simple Lamp", "$ 12.00", R.drawable.san_pham_1),
    SanPham("Minimal Stand", "$ 25.00", R.drawable.san_pham_2),
    SanPham("Coffee Chair", "$ 20.00", R.drawable.san_pham_3),
    SanPham("Simple Desk", "$ 50.00", R.drawable.san_pham_4),
    SanPham("Coffee Chair", "$ 20.00", R.drawable.san_pham_3),
    SanPham("Simple Desk", "$ 50.00", R.drawable.san_pham_4),
)

@Composable
fun KhungManTrangChu() {
    val context = LocalContext.current
    Column (modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    // Handle left icon click
                },
                modifier = Modifier
                    .weight(1f)
                    .size(35.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tim_kiem),
                    contentDescription = "Left Icon",
                    modifier = Modifier.size(24.dp)
                )
            }

            Column (
                modifier = Modifier.width(280.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Make home",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.Center,
                        color = Color(0xFF909090),
                        fontFamily = gelasioFontFamily
                    )
                )
                Text(
                    text = "BEAUTIFUL",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF242424),
                        fontFamily = gelasioFontFamily
                    )
                )
            }

            IconButton(
                onClick = {
                    context.startActivity(Intent(context, ManGioHang::class.java))
                },
                modifier = Modifier
                    .weight(1f)
                    .size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gio_hang),
                    contentDescription = "Right Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        MatHangRow(cacMatHang)
        DanhSachSanPham(cacSanPham)
    }
}

@Composable
fun MatHangRow(cacMatHang: List<MatHang>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    Spacer(modifier = Modifier.height(16.dp))
    LazyRow (
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ) {
        itemsIndexed(cacMatHang) { index, matHang ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { selectedIndex = index },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = matHang.image),
                    contentDescription = matHang.name,
                    modifier = Modifier.size(44.dp)
                )
                Text(
                    text = matHang.name,
                    fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal,
                    fontFamily = nunitosanFontFamily,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun SanPhamItem (sanPham: SanPham) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
            .clickable {
                context.startActivity(Intent(context, ManChiTietSanPham::class.java))
            }
    ) {
        Box(
            modifier = Modifier
                .size(width = 157.dp, height = 200.dp)
        ) {
            Image(
                painter = painterResource(id = sanPham.hinhAnh),
                contentDescription = sanPham.ten,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(
                onClick = {
                    context.startActivity(Intent(context, ManGioHang::class.java))

                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chi_tiet_san_pham),
                    contentDescription = "Drawer Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Text(
            text = sanPham.ten,
            style = TextStyle(fontSize = 16.sp, fontFamily = nunitosanFontFamily, fontWeight = FontWeight(400)),
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF606060)
        )
        Text(
            text = sanPham.gia,
            style = TextStyle(fontSize = 16.sp, fontFamily = nunitosanFontFamily, fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

@Composable
fun DanhSachSanPham(cacSanPham: List<SanPham>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(1.dp),
        modifier = Modifier.height(600.dp)
    ) {
        items(cacSanPham.size) { index ->
            SanPhamItem(sanPham = cacSanPham[index])
        }
    }
}

@Composable
fun CustomTieuDeTrang(
    leftIcon: Int,
    title: String,
    rightIcon: Int? = null,
    onLeftIconClick: (Context) -> Unit,
    onRightIconClick: ((Context) -> Unit)? = null
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                onLeftIconClick(context)
            },
            modifier = Modifier.size(35.dp)
        ) {
            Image(
                painter = painterResource(id = leftIcon),
                contentDescription = "Left Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF242424),
                fontFamily = gelasioFontFamily
            )
        )

        if (rightIcon != null) {
            IconButton(
                onClick = {
                    onRightIconClick?.let { it(context) }
                },
                modifier = Modifier.size(35.dp)
            ) {
                Image(
                    painter = painterResource(id = rightIcon),
                    contentDescription = "Right Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.size(35.dp))
        }
    }
}
