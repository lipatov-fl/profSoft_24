package com.example.lesson_9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {
    private lateinit var message: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        message = intent.extras?.getString(STRING_EXTRA_KEY).orEmpty()
        setContent {
            SecondScreen(message)
        }
    }
}

@Composable
private fun SecondScreen(message: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomShapeRectangle()
        SetImage()
        ButtonSecondActivity(text = stringResource(id = R.string.btn_notification), message = message)
    }
}

@Composable
fun CustomShapeRectangle(
    bottomRightRadius: Dp = 32.dp,
    topLeftRadius: Dp = 16.dp,
) {
    Canvas(
        modifier = Modifier
            .padding(top = 50.dp)
            .size(width = 260.dp, height = 112.dp)
            .clip(
                RoundedCornerShape(
                    topStart = topLeftRadius,
                    bottomEnd = bottomRightRadius
                )
            )
            .background(Color.Red)
    ) {}
}

@Composable
private fun SetImage() {
    Image(
        modifier = Modifier
            .padding(top = 50.dp, bottom = 16.dp)
            .width(260.dp)
            .height(242.dp),
        painter = painterResource(id = R.drawable.squirrel), contentDescription = stringResource(
            id = R.string.img_squirrel_description
        )
    )
}

@Composable
private fun ButtonSecondActivity(text: String, message: String) {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.btn_rectangle)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = with(LocalDensity.current) { dimensionResource(R.dimen.app_size).toSp() },
        )
    }
}