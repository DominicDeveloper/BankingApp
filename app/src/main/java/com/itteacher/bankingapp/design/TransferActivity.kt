package com.itteacher.bankingapp.design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itteacher.bankingapp.R
import com.itteacher.bankingapp.searching.MainViewModel
import com.itteacher.bankingapp.searching.PersonCards

class TransferActivity : ComponentActivity() {
    val listCards = listOf<PersonCards>(
        PersonCards(
            name = "DOMINIC",
            card = "9860060523431232"
        ),
        PersonCards(
            name = "BOBUR",
            card = "9860080513439638"
        ),
        PersonCards(
            name = "MARYAM",
            card = "9860989593499932"
        ),
        PersonCards(
            name = "FERUZ",
            card = "9860485573439630"
        ),
        PersonCards(
            name = "SHAHINA",
            card = "9860785573479737"
        )
    )
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            window.statusBarColor = getColor(R.color.theme_color)
            window.navigationBarColor = getColor(R.color.theme_color)

            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                Greeting2()
            }
            TopAppBar(title = { Text(text = "Transfer")},
                    navigationIcon = {
                        IconButton(onClick = {
                            onBackPressed()
                        }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back")
                        }
                    })
        }
    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2() {
    val listCards = arrayListOf<PersonCards>(
        PersonCards(
            name = "DOMINIC AZIMOV",
            card = "9860060523431232"
        ),
        PersonCards(
            name = "BOBUR TOSHMATOV",
            card = "9860080513439638"
        ),
        PersonCards(
            name = "MARYAM AZIMOVA",
            card = "9860989593499932"
        ),
        PersonCards(
            name = "FERUZ ALIMOV",
            card = "9860485573439630"
        ),
        PersonCards(
            name = "SHAHINA ISMOILOVA",
            card = "9860785573479737"
        )
    )
    var textState by remember {
        mutableStateOf("")
    }
    var isExst = false
    Column(modifier = Modifier
        .padding(10.dp)) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "To", fontSize = 18.sp)

        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
            Image(painter = painterResource(id = R.drawable.humo), contentDescription = "uzcard", modifier = Modifier
                .width(34.dp)
                .height(34.dp))
            OutlinedTextField(value = textState, label = {
                //  Text(text = "Enter card number")
            }, onValueChange = { card ->
                textState = card
                    for (i in 0..listCards.lastIndex){
                        var cd:String = listCards[i].card
                        if(cd == textState.toString()){
                            textState = "${listCards[i].name}\n9860 **** **** ${listCards[i].card.subSequence(listCards[i].card.lastIndex-3,listCards[i].card.lastIndex+1)}"
                            isExst = true
                        }else{
                            isExst = false
                        }
                    }
                if (textState.length == listCards[0].card.length){
                    if (isExst == false){
                        textState = "Karta egasi topilmadi"
                    }
                }

            },placeholder = { Text(text = "Enter card number") }, colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = colorResource(id = R.color.theme_color),
                focusedBorderColor = colorResource(id = R.color.theme_color),
                cursorColor = colorResource(id = R.color.theme_color)),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
                singleLine = false, modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = {
                        textState = ""
                    }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                    }
                },
                enabled = true, readOnly = false, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next,
                    autoCorrect = false)
            )
        }

        // second editText
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Transfer amount", fontSize = 18.sp)
        var amountText by remember {
            mutableStateOf("532 000")
        }
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(), value = amountText, onValueChange = {
            amountText = it
        }, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(id = R.color.theme_color), focusedBorderColor = colorResource(id = R.color.theme_color),cursorColor = colorResource(id = R.color.theme_color)
        ), textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next, autoCorrect = false), readOnly = true)

        Row(modifier =  Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Commission: 0.4%", fontSize = 13.sp)
            Text(text = "Limit: 599 176 000.00 UZS", fontSize = 13.sp, color = colorResource(id = R.color.theme_color))

        }
        
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Select a sender:")
        var senderCard by remember {
            mutableStateOf("TEMIROV ALI\n9860 **** **** 6539")
        }
        OutlinedTextField(value = senderCard, label = {
            //  Text(text = "Enter card number")
        }, onValueChange = {
            senderCard = it
        }, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(id = R.color.theme_color), focusedBorderColor = colorResource(
            id = R.color.theme_color), cursorColor = colorResource(id = R.color.theme_color)),
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp),
            singleLine = false, modifier = Modifier.fillMaxWidth(), leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.humo), contentDescription = "Card type image", modifier = Modifier
                        .width(24.dp)
                        .height(24.dp))
                }
            }, trailingIcon = {
                IconButton(onClick = {
                    //senderCard = ""
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "clear")
                }
            },
            enabled = true, readOnly = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next, autoCorrect = false)
        )
        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Text(text = "Mavjud:  576 000.00 UZS", fontSize = 14.sp, color = colorResource(id = R.color.theme_color))
        }

        Spacer(modifier = Modifier.height(30.dp))
        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Summa:", fontSize = 14.sp)
            Text(text = "532 000.00 UZS", fontSize = 14.sp, color = colorResource(id = R.color.black))
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Commission:", fontSize = 14.sp)
            Text(text = "2 040.00 UZS", fontSize = 14.sp, color = colorResource(id = R.color.black))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Total for payment:", fontSize = 14.sp)
            Text(text = "512 040.00 UZS", fontSize = 14.sp,color = colorResource(id = R.color.theme_color), fontWeight = FontWeight.Medium)
        }

        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                             // setOnClickListener
            },
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp, topEnd = 10.dp, topStart = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.theme_color),
                    contentColor = colorResource(id = R.color.white)
                )){
                Text(text = "TRANSFER MONEY", modifier = Modifier
                    .fillMaxWidth(), textAlign = TextAlign.Center)
            }
        }
    }
    
}


