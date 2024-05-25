package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.MainActivity
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanBold
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManGioHang : ComponentActivity() {
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
                @OptIn(ExperimentalMaterial3Api::class)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sanPhams = remember {
                        mutableStateListOf(
                            SanPhamGioHang(R.drawable.sp_gio_hang_1, "Minimal Stand", 25.0, 1),
                            SanPhamGioHang(R.drawable.sp_gio_hang_2, "Coffee Table", 20.0, 1),
                            SanPhamGioHang(R.drawable.sp_gio_hang_3, "Minimal Desk", 50.0, 1)
                        )
                    }
                    var code by remember { mutableStateOf("") }
                    var total by remember { mutableStateOf(0.0) }

                    LaunchedEffect(sanPhams) {
                        total = sanPhams.sumOf { it.gia * it.soLuong }
                    }

                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(40.dp))
                        CustomTieuDeTrang(leftIcon = R.drawable.quay_lai, title = "My cart", onLeftIconClick = {context ->
                            context.startActivity(Intent(context, MainActivity::class.java))
                        })
                        ListGioHang(
                            sanPhams = sanPhams,
                            onRemove = { sanPham -> sanPhams.remove(sanPham) },
                            updateTotal = {  }
                        )
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedTextField(
                                value = code,
                                onValueChange = { code = it },
                                placeholder = {
                                    Text(
                                        text = "Enter your promo code",
                                        fontSize = 18.sp,
                                        color = Color(0xFF999999),
                                        fontWeight = FontWeight(400),
                                        fontFamily = nunitosanFontFamily
                                    )
                                },
                                singleLine = true,
                                modifier = Modifier.width(320.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            IconButton(
                                onClick = {
                                    // Handle right icon click
                                },
                                modifier = Modifier.size(60.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.admit_code),
                                    contentDescription = "Right Icon",
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Total:",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray,
                                fontFamily = nunitosanBold
                            )
                            Text(
                                text = "$ ${String.format("%.2f", total)}",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontFamily = nunitosanBold
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CustomButton(
                                width = 335.dp,
                                height = 60.dp,
                                cornerRadius = 10.dp,
                                backgroundColor = Color.Black,
                                textContent = {
                                    Text(
                                        text = "Check out",
                                        style = TextStyle(color = Color.White, fontSize = 22.sp, fontFamily = gelasioFontFamily)
                                    )
                                },
                                onClick = {
                                    val intent = Intent(this@ManGioHang, ManThanhToan::class.java)
                                    startActivity(intent)
                                })
                        }
                    }
                }
            }
        }
    }
}

data class SanPhamGioHang(
    val hinhAnh: Int,
    val ten: String,
    val gia: Double,
    var soLuong: Int
) {
    val formattedPrice: String
        get() = String.format("%.2f", gia)
}

@Composable
fun ListGioHang(
    sanPhams: List<SanPhamGioHang>,
    onRemove: (SanPhamGioHang) -> Unit,
    updateTotal: (Double) -> Unit // Thêm tham số updateTotal vào hàm này
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .height(500.dp)
    ) {
        sanPhams.forEachIndexed  {index, sanPham ->
            GioHangItem(
                sanPham = sanPham,
                onRemove = { onRemove(sanPham) },
                onQuantityChange = { soLuong ->
                    sanPham.soLuong = soLuong
                    updateTotal(sanPham.gia * soLuong)
                },
                updateTotal = updateTotal
            )
            if (index < sanPhams.size - 1) {
                Divider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp), thickness = 1.dp)
            }
        }
    }
}

@Composable
fun GioHangItem(
    sanPham: SanPhamGioHang,
    onRemove: () -> Unit,
    onQuantityChange: (Int) -> Unit,
    updateTotal: (Double) -> Unit
) {
    var soLuong by remember { mutableStateOf(sanPham.soLuong) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
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

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    if (soLuong > 1) {
                        soLuong--
                        onQuantityChange(soLuong)
                        updateTotal(sanPham.gia * soLuong)
                    }
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.giam_so_luong),
                        contentDescription = "Giảm số lượng",
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(text = soLuong.toString(), fontSize = 16.sp)

                IconButton(onClick = {
                    soLuong++
                    onQuantityChange(soLuong)
                    updateTotal(sanPham.gia * soLuong)
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.tang_so_luong),
                        contentDescription = "Tăng số lượng",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }

        IconButton(
            onClick = { onRemove()
                updateTotal(0.0)},
            modifier = Modifier.align(Alignment.Top)
        ) {
            Image(
                painter = painterResource(id = R.drawable.xoa),
                contentDescription = "Xóa sản phẩm",
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

