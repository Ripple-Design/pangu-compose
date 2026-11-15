package art.rippledesign.pangu.compose.demo.android

import android.app.Activity
import android.os.Bundle
import androidx.compose.ui.platform.ComposeView
import art.rippledesign.pangu.compose.demo.DemoApp

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent { DemoApp() }
            },
        )
    }
}
