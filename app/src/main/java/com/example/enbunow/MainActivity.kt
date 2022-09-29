package com.example.enbunow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enbunow.ui.theme.EnbuNowTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnbuNowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Homescreen()
                }
            }
        }
    }
}

@Composable
fun Homescreen() {
    var kataList = "Kata will be here ..." // TODO: update List

    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.hakushinkai_logo),
                contentDescription = "Logo of the Hakushinkai Halle e.V.",
                modifier = Modifier
                    .padding(3.dp)
                    .height(48.dp)
            )
            Column {
                Text(
                    text = "Enbu Now",
                    fontSize = 21.sp,
                    modifier = Modifier
                        .padding(start = 4.dp, top = 2.dp, end = 4.dp)
                )
                Text(
                    text = "Chooses kata for you!",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 4.dp, bottom = 2.dp, end = 4.dp)
                        .fillMaxWidth()
                )
            }
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = { kataList = chooseKata(3) },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(text = "3 kata")
            }
            Button(
                onClick = { kataList = chooseKata(5) },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(text = "5 kata")
            }
        }
        Text(text = kataList)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Hajime")
        }
    }
}

fun chooseKata(number: Int): String {
    val katas = IntArray(number) { Random.nextInt(1,13) }
    return katas.toString()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EnbuNowTheme {
        Homescreen()
    }
}