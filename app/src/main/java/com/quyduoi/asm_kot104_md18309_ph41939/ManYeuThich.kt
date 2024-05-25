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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManYeuThich : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.statusBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        setContent {
            ASM_KOT104_MD18309_PH41939Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().padding(bottom = 40.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sanPhams = remember {
                        mutableStateListOf(
                            SanPhamYeuThich(R.drawable.sp_gio_hang_2, "Coffee Table", 50.0),
                            SanPhamYeuThich(R.drawable.sp_yeu_thich_1, "Coffee Chair", 20.0),
                            SanPhamYeuThich(R.drawable.sp_gio_hang_1, "Minimal Stand", 25.0),
                            SanPhamYeuThich(R.drawable.sp_gio_hang_3, "Minimal Desk", 50.0),
                            SanPhamYeuThich(R.drawable.sp_yeu_thich_2, "Minimal Lamp", 12.0),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xF808080))
                    ) {
                        Spacer(modifier = Modifier.height(40.dp))
                        CustomTieuDeTrang(
                            leftIcon = R.drawable.tim_kiem,
                            title = "Favorites",
                            rightIcon = R.drawable.gio_hang,
                            onLeftIconClick = {}
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier.fillMaxSize()) {
                            ListYeuThich(
                                sanPhams = sanPhams,
                                onRemove = { sanPham -> sanPhams.remove(sanPham) })
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                CustomButton(
                                    width = 335.dp,
                                    height = 50.dp,
                                    cornerRadius = 10.dp,
                                    backgroundColor = Color.Black,
                                    textContent = {
                                        Text(
                                            text = "Add all to my cart",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 22.sp,
                                                fontFamily = gelasioFontFamily
                                            )
                                        )
                                    },
                                    onClick = {
                                        val intent =
                                            Intent(this@ManYeuThich, ManGioHang::class.java)
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

data class SanPhamYeuThich(
    val hinhAnh: Int,
    val ten: String,
    val gia: Double
) {
    val formattedPrice: String
        get() = String.format("%.2f", gia)
}

@Composable
fun KhungManYeuThich() {
    val sanPhams = remember {
        mutableStateListOf(
            SanPhamYeuThich(R.drawable.sp_gio_hang_2, "Coffee Table", 50.0),
            SanPhamYeuThich(R.drawable.sp_yeu_thich_1, "Coffee Chair", 20.0),
            SanPhamYeuThich(R.drawable.sp_gio_hang_1, "Minimal Stand", 25.0),
            SanPhamYeuThich(R.drawable.sp_gio_hang_3, "Minimal Desk", 50.0),
            SanPhamYeuThich(R.drawable.sp_yeu_thich_2, "Minimal Lamp", 12.0),
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF808080))
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        CustomTieuDeTrang(
            leftIcon = R.drawable.tim_kiem,
            title = "Favorites",
            rightIcon = R.drawable.gio_hang,
            onLeftIconClick = {

            },
            onRightIconClick = { context ->
                context.startActivity(Intent(context, ManGioHang::class.java))
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            ListYeuThich(sanPhams = sanPhams, onRemove = { sanPham -> sanPhams.remove(sanPham) })
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(vertical = 1.dp)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CustomButton(
                    width = 335.dp,
                    height = 50.dp,
                    cornerRadius = 10.dp,
                    backgroundColor = Color.Black,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    textContent = {
                        Text(
                            text = "Add all to my cart",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 22.sp,
                                fontFamily = gelasioFontFamily
                            )
                        )
                    },
                    onClick = {

                    })
            }
        }

    }
}

@Composable
fun ListYeuThich(sanPhams: List<SanPhamYeuThich>, onRemove: (SanPhamYeuThich) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .height(580.dp)
    ) {
        itemsIndexed(sanPhams) { index, sanPham ->
            SanPhamYeuThichItem(
                sanPham = sanPham,
                onRemove = { onRemove(sanPham) },
            )
            if (index < sanPhams.size - 1) {
                Divider(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                    thickness = 1.dp
                )
            }
        }
    }
}


@Composable
fun SanPhamYeuThichItem(
    sanPham: SanPhamYeuThich,
    onRemove: () -> Unit,
    onAddToCart: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        ) {
        Image(
            painter = painterResource(id = sanPham.hinhAnh),
            contentDescription = sanPham.ten,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = sanPham.ten,
                fontSize = 18.sp,
                color = Color(0xFF999999),
                fontWeight = FontWeight.SemiBold,
                fontFamily = nunitosanFontFamily
            )
            Text(
                text = "$ ${sanPham.formattedPrice}",
                fontSize = 16.sp,
                color = Color(0xFF242424),
                fontWeight = FontWeight.Bold,
                fontFamily = nunitosanBold
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = { onRemove() },
                modifier = Modifier.size(26.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.xoa),
                    contentDescription = "Xóa sản phẩm khỏi danh sách yêu thích",
                    modifier = Modifier.size(26.dp)
                )
            }
            Spacer(modifier = Modifier.height(45.dp))
            IconButton(
                onClick = { },
                modifier = Modifier.size(26.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chi_tiet_san_pham),
                    contentDescription = "Thêm sản phẩm vào giỏ hàng",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewManYeuThich() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManYeuThich()
    }
}