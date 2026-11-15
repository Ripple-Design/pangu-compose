package art.rippledesign.pangu.compose.demo

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "pangu.kt × RUI demo",
        state = rememberWindowState(width = 480.dp, height = 800.dp),
    ) {
        DemoApp()
    }
}
