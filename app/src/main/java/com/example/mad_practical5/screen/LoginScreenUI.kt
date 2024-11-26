package com.example.mad_practical5.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.example.mad_practical5.screen.components.FormField
import com.example.mad_practical5.R


@Composable
fun LoginForm(context: Context? = null, navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()){
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
                FormField(label = "Email", textState = email, onTextChange = {email=it})
                FormField(label = "Password", isPasswordField = true, textState = password, onTextChange = {password=it})
            }
            Button(onClick = {
                showMsg(context!!, "Login Successfully")
                navController.navigate("registration")
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)) {
                Text("Login", fontSize = 18.sp)
            }
        }
    }
}

fun showMsg(context: Context?=null, msg:String){
    val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
    toast.show()
}
//@Preview(showBackground = true)
//@Composable
//fun LoginPreview(){
//    LoginForm(navController = navController)
//
//}