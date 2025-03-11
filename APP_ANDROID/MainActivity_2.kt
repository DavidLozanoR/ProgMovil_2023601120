package com.example.appsonidos

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIPrincipal()
        }
    }
}

@Composable
fun BotonSonido (imageRes: Int, soundRes: Int,Name: String){
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(Modifier.size(100.dp).clickable {
            MediaPlayer.create(context, soundRes).start()
        }, Alignment.Center){
            Image(painterResource(id = imageRes), null)
        }
        Text(text = Name, fontSize = 14.sp)
    }
}

@Composable
fun UIPrincipal(){
    val multimedios = listOf(
        Triple(R.drawable.anakin, R.raw.anakin_1,"Anakin 1"),
        Triple(R.drawable.anakin, R.raw.anakin_2,"Anakin 2"),
        Triple(R.drawable.anakin, R.raw.anakin_3,"Anakin 3"),
        Triple(R.drawable.anakin, R.raw.anakin_4,"Anakin 4"),
        Triple(R.drawable.anakin, R.raw.anakin_5,"Anakin 5"),
        Triple(R.drawable.chewie, R.raw.chewie,"Chewie"),
        Triple(R.drawable.han, R.raw.han,"han"),
        Triple(R.drawable.lando, R.raw.lando,"Lando"),
        Triple(R.drawable.luke, R.raw.luke,"Luke"),
        Triple(R.drawable.saber, R.raw.saber,"Saber"),
        Triple(R.drawable.vader, R.raw.vader,"Vader"),
        Triple(R.drawable.yoda, R.raw.yoda,"Yoda"),
    )
    Column(Modifier.fillMaxSize().padding(8.dp)
        .verticalScroll(rememberScrollState())) {
        for(i in multimedios.indices step 3){
            Row(Modifier.fillMaxWidth(),Arrangement.SpaceEvenly){
                for(j in 0 until 3){
                    if(i + j < multimedios.size){
                        BotonSonido(multimedios[i + j].first,
                            multimedios[i + j].second,
                            multimedios[i + j].third
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIPrincipal()
}