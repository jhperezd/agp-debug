package com.example.agpdebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.agpdebug.ui.theme.AgpdebugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgpdebugTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    @Suppress("DEPRECATION")
                    val info = application.packageManager.getPackageInfo(application.packageName, 0)
                    ShowVersionCode(info.longVersionCode.toString())
                }
            }
        }

    }
}

@Composable
fun ShowVersionCode(versionCode: String, modifier: Modifier = Modifier) {
    Text(
        text = "App Version Code: $versionCode",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ShowVersionCode() {
    AgpdebugTheme {
        ShowVersionCode("12345")
    }
}