package art.rippledesign.pangu.compose.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import art.rippledesign.compose.rui.RText
import art.rippledesign.pangu.compose.rui.PanguText

private val Samples = listOf(
    "請問Jackie的鼻子有幾個？123個！",
    "Disney+上架了新片，今天來看公視+",
    "檔案在C:\\Users\\name\\，用C++寫的",
    "Switch OLED+健身環+保護貼",
    "vivo X70 Pro+開賣，血型是AB+的人",
)

@Composable
fun DemoApp() {
    MaterialTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                PanguText(
                    text = "原文 / pangu.kt 處理後",
                    style = MaterialTheme.typography.h6,
                )
                Samples.forEach { sample ->
                    ComparisonRow(sample)
                }
            }
        }
    }
}

@Composable
private fun ComparisonRow(text: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface.copy(alpha = CaptionAlpha),
        )
        PanguText(
            text = text,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary,
        )
    }
}

private const val CaptionAlpha = 0.6f
