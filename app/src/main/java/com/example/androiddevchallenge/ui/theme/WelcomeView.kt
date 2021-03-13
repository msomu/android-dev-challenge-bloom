package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

// Start building your app here!
@Composable
fun Welcome() {
    Surface(color = MaterialTheme.colors.primary) {
        Box(Modifier.fillMaxSize()) {
            val bg = if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_welcome_bg)
            else painterResource(id = R.drawable.ic_light_welcome_bg)
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = bg,
                contentDescription = "background"
            )
            Column(Modifier.padding(16.dp)) {
                val illos =
                    if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_welcome_illos)
                    else painterResource(id = R.drawable.ic_light_welcome_illos)
                val logo = if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_logo)
                else painterResource(id = R.drawable.ic_light_logo)
                Image(
                    modifier = Modifier.padding(start = 88.dp, top = 72.dp),
                    painter = illos,
                    contentDescription = "illos"
                )
                Spacer(modifier = Modifier.padding(48.dp))
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = logo,
                    contentDescription = "logo"
                )
                Text(
                    text = "Beautiful home garden solutions",
                    modifier = Modifier
                        .firstBaselineToTop(32.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(40.dp))
                Button(
                    onClick = {

                    }, modifier = Modifier
                        .padding(bottom = 8.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                        .clip(shapes.medium),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.onSecondary
                    )
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
                Text(
                    text = "Log in",
                    modifier = Modifier
                        .firstBaselineToTop(32.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.button,
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) white else pink900
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    // Check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        // Where the composable gets placed
        placeable.placeRelative(0, placeableY)
    }
}
