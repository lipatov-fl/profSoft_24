package com.example.lesson_9
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource

const val STRING_EXTRA_KEY = "string extra key"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview
@Composable
private fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingText(text = stringResource(id = R.string.greeting))
        ButtonFirstActivity(text = stringResource(id = R.string.btn_start_intent))
    }
}

@Composable
private fun GreetingText(text: String) {
    Text(
        text = text,
        fontSize = with(LocalDensity.current) { dimensionResource(R.dimen.app_size).toSp() },
        color = Color.Black,
        modifier = Modifier.padding(39.dp),
    )
}

@Composable
private fun ButtonFirstActivity(text: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(STRING_EXTRA_KEY, context.getString(R.string.greeting))
            }
            context.startActivity(intent)
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.btn_rectangle)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(39.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = with(LocalDensity.current) { dimensionResource(R.dimen.app_size).toSp() },
        )
    }
}