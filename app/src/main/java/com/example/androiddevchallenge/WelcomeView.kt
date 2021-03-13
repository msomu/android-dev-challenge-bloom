/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.white

@Preview("Welcome Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview() {
    MyTheme {
        Welcome(rememberNavController())
    }
}

@Preview("Welcome Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome(rememberNavController())
    }
}

@Composable
fun Welcome(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(Modifier.fillMaxSize()) {
            val bg = if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_welcome_bg)
            else painterResource(id = R.drawable.ic_light_welcome_bg)
            Image(
                painter = bg,
                contentDescription = "background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.Center
            )
            Column(Modifier.fillMaxSize()) {
                val illos =
                    if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_welcome_illos)
                    else painterResource(id = R.drawable.ic_light_welcome_illos)
                val logo = if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_dark_logo)
                else painterResource(id = R.drawable.ic_light_logo)
                Image(
                    modifier = Modifier
                        .padding(start = 88.dp, top = 72.dp),
                    painter = illos,
                    contentDescription = "illos",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopStart
                )
                Column(Modifier.padding(16.dp)) {
                    Image(
                        modifier = Modifier.fillMaxWidth().padding(top = 32.dp).height(32.dp),
                        painter = logo,
                        contentDescription = "logo",
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "Beautiful home garden solutions",
                        modifier = Modifier
                            .firstBaselineToTop(24.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(19.dp))
                    Button(
                        onClick = {
                            navController.navigate("login")
                        },
                        modifier = Modifier
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
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("login")
                            },
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = if (isSystemInDarkTheme()) white else pink900
                    )
                }
            }
        }
    }
}
