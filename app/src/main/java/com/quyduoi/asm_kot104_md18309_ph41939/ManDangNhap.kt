package com.quyduoi.assignment_kot104_ph41939

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.quyduoi.asm_kot104_md18309_ph41939.MainActivity
import com.quyduoi.asm_kot104_md18309_ph41939.R
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.ASM_KOT104_MD18309_PH41939Theme
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.gelasioFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.merriweatherFontFamily
import com.quyduoi.asm_kot104_md18309_ph41939.ui.theme.nunitosanFontFamily

class ManDangNhap : ComponentActivity() {
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
                    var email by remember {
                        mutableStateOf("")
                    }
                    var password by remember {
                        mutableStateOf("")
                    }
                    Column (modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(50.dp))
                        LogoUngDung()
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Hello !",
                            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight(400),
                                fontFamily = merriweatherFontFamily),
                            color = Color(0xFF909090),
                            modifier = Modifier.padding(start = 30.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "WELCOME BACK",
                            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight(700),
                                fontFamily = merriweatherFontFamily),
                            color = Color(0xFF303030),
                            modifier = Modifier.padding(start = 30.dp)
                        )
                        Spacer(modifier = Modifier.height(50.dp))
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
                                backgroundColor = Color.DarkGray,
                                textContent = {
                                    Text(
                                        text = "Forgot Password",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily, fontWeight = FontWeight(600))
                                    )
                                },
                                onClick = {

                                })
                            Spacer(modifier = Modifier.height(15.dp))
                            CustomButton(
                                width = 285.dp,
                                height = 50.dp,
                                cornerRadius = 4.dp,
                                backgroundColor = Color.Black,
                                textContent = {
                                    Text(
                                        text = "Log in",
                                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                                    )
                                },
                                onClick = {
                                    val intent = Intent(this@ManDangNhap, MainActivity::class.java)
                                    startActivity(intent)
                                })
                            Spacer(modifier = Modifier.height(15.dp))
                            CustomButton(
                                width = 285.dp,
                                height = 50.dp,
                                cornerRadius = 4.dp,
                                backgroundColor = Color.LightGray,
                                textContent = {
                                    Text(
                                        text = "SIGN UP",
                                        style = TextStyle(color = Color.Black, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                                    )
                                },
                                onClick = {
                                    val intent = Intent(this@ManDangNhap, ManDangKy::class.java)
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
fun KhungManDangNhap() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        LogoUngDung()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Hello !",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight(400),
                fontFamily = merriweatherFontFamily),
            color = Color(0xFF909090),
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "WELCOME BACK",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight(700),
                fontFamily = merriweatherFontFamily),
            color = Color(0xFF303030),
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
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
                backgroundColor = Color.DarkGray,
                textContent = {
                    Text(
                        text = "Forgot Password",
                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily, fontWeight = FontWeight(600))
                    )
                },
                onClick = {

                })
            Spacer(modifier = Modifier.height(15.dp))
            CustomButton(
                width = 285.dp,
                height = 50.dp,
                cornerRadius = 4.dp,
                backgroundColor = Color.Black,
                textContent = {
                    Text(
                        text = "Log in",
                        style = TextStyle(color = Color.White, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                    )
                },
                onClick = {

                })
            Spacer(modifier = Modifier.height(15.dp))
            CustomButton(
                width = 285.dp,
                height = 50.dp,
                cornerRadius = 4.dp,
                backgroundColor = Color.LightGray,
                textContent = {
                    Text(
                        text = "SIGN UP",
                        style = TextStyle(color = Color.Black, fontSize = 18.sp, fontFamily = gelasioFontFamily)
                    )
                },
                onClick = {

                })
        }

    }
}

@Composable
fun LogoUngDung() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dau_gach),
            contentDescription = null,
            modifier = Modifier
                .width(105.dp)
                .height(10.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = R.drawable.dau_gach),
            contentDescription = null,
            modifier = Modifier
                .width(105.dp)
                .height(10.dp)
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    isPassword: Boolean = false,
    textColor: Color = Color.Black,
    labelPadding: Int = 16,
    khungInput: Int = 10,
    keyboardType: KeyboardType = KeyboardType.Text,
    borderColor: Color = Color.Gray,
    borderWidth: Int = 1,
    cornerRadius: Int = 8,
    iconSize: Int = 24
) {
    var passwordVisibility by remember { mutableStateOf(!isPassword) }

    Column {
        Box(modifier = Modifier.padding(bottom = khungInput.dp)) {
            label()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = borderWidth.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(cornerRadius.dp)
                )
                .padding(labelPadding.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = textColor),
                singleLine = true
            )
            if (isPassword) {
                val icon = if (passwordVisibility) R.drawable.eye_show else R.drawable.eye_hide
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(20.dp),
                ) {
                    Image(painter = painterResource(id = icon), contentDescription = "Toggle password visibility", modifier = Modifier.size(iconSize.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewManDangNhap() {
    ASM_KOT104_MD18309_PH41939Theme {
        KhungManDangNhap()
    }
}