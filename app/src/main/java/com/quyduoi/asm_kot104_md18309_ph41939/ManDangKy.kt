package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.merriweatherFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManDangKy : ComponentActivity() {
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
                    var name by remember {
                        mutableStateOf("")
                    }
                    var password by remember {
                        mutableStateOf("")
                    }
                    var email by remember {
                        mutableStateOf("")
                    }
                    var comfirmPassword by remember {
                        mutableStateOf("")
                    }
                    Column (modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(50.dp))
                        LogoUngDung()
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "WELCOME",
                            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight(700),
                                fontFamily = merriweatherFontFamily
                            ),
                            color = Color(0xFF303030),
                            modifier = Modifier.padding(start = 30.dp)
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)) {
                            CustomTextField(value = name, onValueChange = {name = it}, label = {
                                Text(text = "Name", style = TextStyle(
                                    color = Color(0xFF909090),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = nunitosanFontFamily
                                ))
                            }, isPassword = false, keyboardType = KeyboardType.Text, textColor = Color.Black,
                                cornerRadius = 8)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)) {
                            CustomTextField(value = email, onValueChange = {email = it}, label = {
                                Text(text = "Email", style = TextStyle(
                                    color = Color(0xFF909090),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = nunitosanFontFamily
                                ))
                            }, isPassword = false, keyboardType = KeyboardType.Email, textColor = Color.Black,
                                cornerRadius = 8)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)) {
                            CustomTextField(value = password, onValueChange = {password = it}, label = {
                                Text(text = "Password", style = TextStyle(
                                    color = Color(0xFF909090),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = nunitosanFontFamily
                                ))
                            }, isPassword = true, keyboardType = KeyboardType.Email, textColor = Color.Black,
                                cornerRadius = 8)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)) {
                            CustomTextField(value = comfirmPassword, onValueChange = {comfirmPassword = it}, label = {
                                Text(text = "Comfirm Password", style = TextStyle(
                                    color = Color(0xFF909090),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = nunitosanFontFamily
                                ))
                            }, isPassword = true, keyboardType = KeyboardType.Email, textColor = Color.Black,
                                cornerRadius = 8)
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomButton(
                                width = 285.dp,
                                height = 50.dp,
                                cornerRadius = 4.dp,
                                backgroundColor = Color.Black,
                                textContent = {
                                    Text(
                                        text = "SIGN UP",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                                    )
                                },
                                onClick = {
                                    val intent = Intent(this@ManDangKy, ManDangNhap::class.java)
                                    startActivity(intent)
                                })
                            Spacer(modifier = Modifier.height(15.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "Already have account?",
                                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight(600),
                                        fontFamily = nunitosanFontFamily
                                    ), color = Color(0xFF909090)
                                )
                                TextButton(
                                    onClick = {
                                        val intent = Intent(this@ManDangKy, ManDangNhap::class.java)
                                        startActivity(intent)
                                    },
                                    modifier = Modifier
                                ) {
                                    Text(
                                        text = "SIGN IN",
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = nunitosanFontFamily
                                        ),
                                        color = Color(0xFF303030)
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun KhungManDangKy () {
    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var comfirmPassword by remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        LogoUngDung()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "WELCOME",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight(700),
                fontFamily = merriweatherFontFamily
            ),
            color = Color(0xFF303030),
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            CustomTextField(value = name, onValueChange = {name = it}, label = {
                Text(text = "Name", style = TextStyle(
                    color = Color(0xFF909090),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = nunitosanFontFamily
                ))
            }, isPassword = false, keyboardType = KeyboardType.Text, textColor = Color.Black,
                cornerRadius = 8)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            CustomTextField(value = email, onValueChange = {email = it}, label = {
                Text(text = "Email", style = TextStyle(
                    color = Color(0xFF909090),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = nunitosanFontFamily
                ))
            }, isPassword = false, keyboardType = KeyboardType.Email, textColor = Color.Black,
                cornerRadius = 8)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            CustomTextField(value = password, onValueChange = {password = it}, label = {
                Text(text = "Password", style = TextStyle(
                    color = Color(0xFF909090),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = nunitosanFontFamily
                ))
            }, isPassword = true, keyboardType = KeyboardType.Email, textColor = Color.Black,
                cornerRadius = 8)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            CustomTextField(value = comfirmPassword, onValueChange = {comfirmPassword = it}, label = {
                Text(text = "Comfirm Password", style = TextStyle(
                    color = Color(0xFF909090),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = nunitosanFontFamily
                ))
            }, isPassword = true, keyboardType = KeyboardType.Email, textColor = Color.Black,
                cornerRadius = 8)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                width = 285.dp,
                height = 50.dp,
                cornerRadius = 4.dp,
                backgroundColor = Color.Black,
                textContent = {
                    Text(
                        text = "SIGN UP",
                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                    )
                },
                onClick = {

                })
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "Already have account?",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight(600),
                        fontFamily = nunitosanFontFamily
                   ), color = Color(0xFF909090)
                )
                TextButton(
                    onClick = {
                        // Xử lý sự kiện click tại đây
                    },
                    modifier = Modifier
                ) {
                    Text(
                        text = "SIGN IN",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = nunitosanFontFamily
                        ),
                        color = Color(0xFF303030)
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewManDangKy () {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManDangKy()
    }
}