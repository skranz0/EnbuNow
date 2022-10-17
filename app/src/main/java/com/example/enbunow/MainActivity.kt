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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enbunow.ui.theme.EnbuNowTheme

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
    val kataList: MutableState<String> = remember { mutableStateOf("...") }

    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.hakushinkai_logo),
                contentDescription = stringResource(R.string.logo_alt),
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
                    text = stringResource(R.string.app_description),
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
                onClick = { kataList.value = chooseKata(3) },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(text = "3 kata")
            }
            Button(
                onClick = { kataList.value = chooseKata(5) },
                modifier = Modifier.padding(6.dp)
            ) {
                Text(text = "5 kata")
            }
        }
        Text(
            text = stringResource(R.string.kata_head) + "\n" + kataList.value,
            fontSize = 24.sp,
            modifier = Modifier.padding(30.dp)
        )
        /*
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Hajime")
        }
        */
    }
}

fun chooseKata(number: Int): String {
    val znkr: List<String> = listOf(
        "01 - Mae", "02 - Ushiro", "03 - Ukenagashi",
        "04 - Tsukaate", "05 - Kesagiri", "06 - Morotezuki",
        "07 - Sampogiri", "08 - Ganmenate", "09 - Seotezuki",
        "10 - Shihogiri", "11 - Sogiri", "12 - Nukiuchi"
    )
    val randomElements = znkr.asSequence().shuffled().take(number).toList()
        .sorted()

    var katas = ""
    for (kata in randomElements) {
        katas += "> $kata \n"
    }

    return katas
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EnbuNowTheme {
        Homescreen()
    }
}