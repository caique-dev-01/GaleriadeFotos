package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.galeriadefotos.ui.theme.GaleriaDeFotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotosTheme {
                GaleriaDeFotos()


            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun GaleriaDeFotos() {
   var imagens by remember { mutableStateOf(2)}
       val idImagem = when(imagens){
           1 -> R.drawable.fotosperfil
           2 -> R.drawable.cajado
           3 -> R.drawable.aletoria
           else -> R.drawable.ceu2
       }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 100.dp,
                bottom = 30.dp
            )
    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
             modifier = Modifier
                 .fillMaxWidth()
                 .height(400.dp)
                 .padding(end = 4.dp, start = 4.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Button(
                onClick = { imagens --},
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape()
            ){
            Text(
                text = "anterior",
                fontSize = 20.sp
                )
            }

            Button(
                onClick = { imagens ++}) {
                Text(
                    text = "proximo",
                    fontSize = 20.sp
                )
            }
        }
    }
}


