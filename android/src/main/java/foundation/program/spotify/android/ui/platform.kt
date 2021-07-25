package foundation.program.spotify.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import foundation.program.spotify.shared.Platform

@Composable
@Preview(showBackground = true)
fun Greeting() {
    Text(text = Platform().platform)
}