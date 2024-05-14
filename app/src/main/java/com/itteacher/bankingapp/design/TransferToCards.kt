package com.itteacher.bankingapp.design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itteacher.bankingapp.R
import com.itteacher.bankingapp.models.CardOwners

class TransferToCards : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.theme_color)
            window.navigationBarColor = getColor(R.color.theme_color)
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting3()
            }
            TopAppBar(title = { Text(text = "Transfer to cards")},
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

@Composable
fun Greeting3() {
    // Enter the recipient's card number
    var textRecepients by remember {
        mutableStateOf("Enter the recipient's card number")
    }
    Column(modifier = Modifier
        .padding(10.dp)) {
        Spacer(modifier = Modifier.height(55.dp))
        // EditText
        OutlinedTextField(value = textRecepients, label = {

        }, placeholder = {
            Text(text = "Enter the recipient's card number", color = Color.LightGray)
        }, onValueChange = {
            textRecepients = it
        }, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(id = R.color.theme_color), focusedBorderColor = colorResource(
            id = R.color.theme_color), cursorColor = colorResource(id = R.color.theme_color)), textStyle = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = {
                    // get card by scanner
                }) {
                    Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = "scanner")
                }
            }, enabled = true, readOnly = false, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search, autoCorrect = false)
        )

        Spacer(modifier = Modifier.height(55.dp))
        var amongCards by remember {
            mutableStateOf("Among my cards")
        }
        OutlinedTextField(value = amongCards, onValueChange = {
            amongCards = it
    }, enabled = true, readOnly = true, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(id = R.color.theme_color), focusedBorderColor = colorResource(id = R.color.theme_color), cursorColor = Color.White),
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp), singleLine = true, modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = {
                    // shaxsiy karta raqamlarni chiqarish uchun listener
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "My cards")
                }
            }, leadingIcon = {
                 IconButton(onClick = { /*TODO*/ }) {
                     Image(painter = painterResource(id = R.drawable.card), contentDescription = "card", modifier = Modifier
                         .width(20.dp)
                         .height(20.dp))
                 }
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next, autoCorrect = false)
        )
        Spacer(modifier = Modifier.height(10.dp))
        var liked by remember {
            mutableStateOf("Saved")
        }
        OutlinedTextField(value = liked, onValueChange = {
            liked = it
        }, enabled = true, readOnly = true, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(
            id = R.color.theme_color), focusedBorderColor = colorResource(id = R.color.theme_color), cursorColor = colorResource(
            id = R.color.white)),
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp), singleLine = true, modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Saved cards")
                }
            },
            leadingIcon = {
                 IconButton(onClick = { /*TODO*/ }) {
                     Image(painter = painterResource(id = R.drawable.star), contentDescription = "Star card", modifier = Modifier
                         .width(20.dp)
                         .height(20.dp))
                 }
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next, autoCorrect = false)
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(50F)
            .padding(0.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp), content = {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "LAST RECEIVERS", fontSize = 18.sp, modifier = Modifier.padding(10.dp), color = Color.Black)
                var textSearching by remember {
                    mutableStateOf("")
                }
                OutlinedTextField(value = textSearching, onValueChange = {
                    textSearching = it
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),enabled = true,readOnly = false, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = colorResource(
                    id = R.color.theme_color), focusedBorderColor = colorResource(id = R.color.theme_color), cursorColor = colorResource(
                    id = R.color.theme_color)), textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp), placeholder = {
                        Text(text = "Enter your search information", color = Color.LightGray)
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Search, autoCorrect = true),
                    trailingIcon = {
                        IconButton(onClick = {
                            // qidiruv uchun
                        }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search image")
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))
                val imageId = arrayOf(
                    R.drawable.humo,
                    R.drawable.uzcard,
                    R.drawable.mastercard,
                    R.drawable.humoo,
                    R.drawable.uzcardd,
                    R.drawable.masterr
                )
                val cardOwners = ArrayList<CardOwners>()
                cardOwners.add(CardOwners("TURAYEV BEKZOD","9860 **** **** 5486","humo"))
                cardOwners.add(CardOwners("ALIJONOVA MUBINA","8600 **** **** 9976","uzcard"))
                cardOwners.add(CardOwners("TOSHMATOV BOBUR","**78","master"))
                cardOwners.add(CardOwners("OLIMOVA OZODA","9860 **** **** 2436","humo"))
                cardOwners.add(CardOwners("AZIMOVA MARYAM","8600 **** **** 2986","uzcard"))
                cardOwners.add(CardOwners("DO`SMATOV DIYORBEK","**45","master"))

                MyApp(imageId = imageId, cardOwners = cardOwners)
            })
    }
}
@Composable
fun MyApp(
    imageId:Array<Int>,
    cardOwners:ArrayList<CardOwners>,
    modifier: Modifier = Modifier
){
  LazyColumn(contentPadding = PaddingValues(16.dp)) {
      val itemCount = imageId.size
      items(itemCount){ item ->
          ColumnItem(itemIndex = item,
              painter = imageId,
              cardOwners,
              modifier
              )
      }
  }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    cardOwners: ArrayList<CardOwners>,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(1.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp))
    {
        Row(modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            Image(painter = painterResource(id = painter[itemIndex]), contentDescription = "card images",
                modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(start = 5.dp))
            Column(modifier.padding(12.dp)) {
                Text(text = "${cardOwners!![itemIndex].name}", fontWeight = FontWeight.Medium, fontSize = 18.sp)
                Text(text = "${cardOwners!![itemIndex].cardNumber}", fontWeight = FontWeight.Normal, fontSize = 18.sp)
            }
        }
    }
}
