package com.example.mad_practical5.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mad_practical5.R
import com.example.mad_practical5.screen.components.FormField

@Composable
fun RegisterForm(context: Context? = null, navController: NavHostController){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)){
        var name by remember { mutableStateOf("") }
        var number by remember { mutableStateOf(1234567890) }
        var city by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.guni_pink_logo), contentDescription = "Guni Logo",
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Card(elevation = CardDefaults.cardElevation(20.dp),
            shape = MaterialTheme.shapes.medium, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                FormField(label = "Name", textState = name, onTextChange = {name=it})
                FormField(label = "Number", isNumber = true, textState = number.toString(), onTextChange = {number=it.toInt()})
                FormField(label = "City", textState = city, onTextChange = {city=it})
                FormField(label = "Email", textState = email, onTextChange = {email=it})
                FormField(label = "Password", isPasswordField = true, textState = password, onTextChange = {password=it})
                FormField(label = "Confirm Password", isPasswordField = true, textState = confirmPassword, onTextChange = {confirmPassword=it})
            }
            Button(onClick = { showMsg(context!!, "") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)) {
                Text("Register", fontSize = 18.sp)
            }
        }
    }
}

fun showMsg(context: Context, msg:String){
    val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
    toast.show()
}
//@Preview(showBackground = true)
//@Composable
//fun RegisterPreview(){
//    RegisterForm(navController = navController)
//}