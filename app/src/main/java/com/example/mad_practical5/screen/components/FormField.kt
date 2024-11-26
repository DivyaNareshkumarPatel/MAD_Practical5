package com.example.mad_practical5.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormField(label:String,
              textState:String="",
              onTextChange:(String)->Unit={},
              isNumber:Boolean=false,
              isPasswordField:Boolean=false){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Text(text = label, fontSize = 18.sp, modifier = Modifier.weight(1f))
        if(isNumber){
            OutlinedTextField(label = { Text("Enter $label") },
                placeholder = { Text(text = "Enter $label") },
                value=textState,
                onValueChange = onTextChange,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(2f),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        else{
            OutlinedTextField(value = textState,
                onValueChange = {
                    newValue->
                    if(newValue.all { it.isDigit() }){
                        onTextChange(newValue)
                    }
                },
                label = { Text("Enter $label") },
                placeholder = { Text("Enter $label") },
                modifier = Modifier
                    .padding(10.dp)
                    .weight(2f),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormPreview(){
    FormField(label = "Email")
}