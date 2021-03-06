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

import androidx.compose.foundation.border
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
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun Login(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(Modifier.padding(16.dp).fillMaxSize()) {
            Text(
                text = "Log in with email",
                modifier = Modifier
                    .firstBaselineToTop(184.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Box(Modifier.border(1.dp, MaterialTheme.colors.onPrimary, MaterialTheme.shapes.small)) {
                TextField(
                    value = "Email address", onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        textColor = MaterialTheme.colors.onPrimary,
                        focusedIndicatorColor = MaterialTheme.colors.background,
                        unfocusedIndicatorColor = MaterialTheme.colors.background,
                    )
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Box(Modifier.border(1.dp, MaterialTheme.colors.onPrimary, MaterialTheme.shapes.small)) {
                TextField(
                    value = "Password (8+ characters)", onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        textColor = MaterialTheme.colors.onPrimary,
                        focusedIndicatorColor = MaterialTheme.colors.background,
                        unfocusedIndicatorColor = MaterialTheme.colors.background,
                    )
                )
            }
            val textValue = with(AnnotatedString.Builder()) {
                append("By clicking below you agree to out ")
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("Terms of Use ")
                pop()
                append("and contest to out ")
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("Privacy Policy.")
                toAnnotatedString()
            }
            Text(
                text = textValue,
                modifier = Modifier
                    .firstBaselineToTop(24.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button(
                onClick = {
                    navController.navigate("main")
                },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .clip(shapes.medium),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary
                )
            }
        }
    }
}
