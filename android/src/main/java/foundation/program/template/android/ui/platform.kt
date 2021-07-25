package foundation.program.template.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import foundation.program.template.shared.Platform

@Composable
@Preview(showBackground = true)
fun Greeting() {
    Text(text = Platform().platform)
}