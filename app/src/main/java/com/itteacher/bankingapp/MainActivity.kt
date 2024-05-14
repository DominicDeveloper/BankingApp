package com.itteacher.bankingapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.itteacher.bankingapp.design.TransferActivity
import com.itteacher.bankingapp.design.TransferToCards
import com.itteacher.bankingapp.ui.theme.BankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.theme_color)
            window.navigationBarColor = getColor(R.color.theme_color)
           Column(
               modifier = Modifier.fillMaxSize(),
               verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {

               Button(onClick = {
                   val navigate = Intent(this@MainActivity,TransferActivity::class.java)
                   startActivity(navigate)
               }) {
                   Text(text = "Transfer", fontSize = 18.sp)
               }

               Button(onClick = {
                   val navigate2 = Intent(this@MainActivity,TransferToCards::class.java)
                   startActivity(navigate2)
               }) {
                   Text(text = "Transfer to cards", fontSize = 18.sp)
               }

           }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankingAppTheme {
        Greeting("Android")
    }
}