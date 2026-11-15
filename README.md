# pangu-compose

Compose adapters for [pangu.kt](https://github.com/Ripple-Design/pangu-kt): drop-in text composables that apply CJK spacing from [pangu.js](https://github.com/vinta/pangu.js).

| Module | Wraps | Coordinates |
| --- | --- | --- |
| `pangu-compose-foundation` | `androidx.compose.foundation.text.BasicText` | `art.rippledesign:pangu-compose-foundation` |
| `pangu-compose-material2` | `androidx.compose.material.Text` | `art.rippledesign:pangu-compose-material2` |
| `pangu-compose-material3` | `androidx.compose.material3.Text` | `art.rippledesign:pangu-compose-material3` |
| `pangu-compose-rui` | `art.rippledesign.compose.rui.RText` | `art.rippledesign:pangu-compose-rui` |

Each module exposes `PanguText`, a `String`-only composable that runs `Pangu.spacingText` on the text and delegates to its base primitive. Pick the module that matches the text layer you already render with.

## Usage

```kotlin
import art.rippledesign.pangu.compose.material2.PanguText

PanguText("請問Jackie的鼻子有幾個？") // renders: 請問 Jackie 的鼻子有幾個？
```

The spacing is computed once per text value with `remember(text)`. To render the original string, use the base `Text`/`BasicText` directly.

## Modules and targets

All modules publish these Kotlin Multiplatform targets: `android`, `jvm`, `js`, `wasmJs`, `iosArm64`, `iosSimulatorArm64`.

## Local development

`pangu.kt` and RUI are not published yet. `settings.gradle.kts` includes sibling checkouts of `../pangu-kt` and `../rui-compose` as composite builds when they exist, so the declared Maven coordinates are substituted by the local projects. Keep the three repositories side by side:

```
workspace/
├── pangu-kt/
├── rui-compose/
└── pangu-compose/
```

Without the sibling checkouts, dependency resolution falls back to Maven, which requires published artifacts. `pangu-compose-rui` declares `art.rippledesign:compose-rui:1.0.0` and only resolves once RUI is published.

## License

Released under the [MIT License](LICENSE).
