package com.mud.bizcardcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mud.bizcardcomposeapp.ui.theme.BizCardComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardComposeAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(
                    200.dp
                )
                .height(
                    390.dp
                )
                .padding(
                    12.dp
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(
                corner = CornerSize(15.dp)
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider()
                CreateInfoSection()
                Button(onClick = {
                    buttonClickState.value = !buttonClickState.value

                }) {
                    Text(text = "Portofolio", style = MaterialTheme.typography.bodyLarge)
                }
            }
            if (buttonClickState.value) {
                Content()
            } else {
                Box {

                }
            }

        }
    }
}

@Preview
@Composable
fun Content() {
    val portfolioItems = listOf(
        Pair("BTN Smart Residence", R.drawable.smart_residence),
        Pair("KelolaHR", R.drawable.kelolahr)
    )

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = portfolioItems)
        }
    }
}

@Composable
fun Portfolio(data: List<Pair<String, Int>>) {
    LazyColumn() {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.second),
                        contentDescription = "Project image",
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item.first, fontWeight = FontWeight.Bold)
                        Text(
                            text = "A great Project",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfoSection() {
    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        Text(
            text = "Pramudia Angga Prahasta",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "Middle Mobile Developer",
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = "@King Of Mobile Developer",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSurface.copy(
            alpha = 0.5f
        ),
        shadowElevation = 4.dp,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardComposeAppTheme {
        CreateBizCard()
    }
}