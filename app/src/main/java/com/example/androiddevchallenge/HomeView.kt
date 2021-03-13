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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Column(Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.padding(40.dp))
            Search()
            BrowseThemes()
            Garden()
        }
    }
}

@Composable
fun Garden() {
    val categories = getPlants()
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.firstBaselineToTop(32.dp)
            )
            Icon(
                Icons.Outlined.FilterList,
                contentDescription = null,
                modifier = Modifier.width(24.dp).aspectRatio(1.0f),
                tint = MaterialTheme.colors.onPrimary,
            )
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        LazyColumn(
            content = {
                items(categories.size) { index ->
                    PlantCard(categories[index])
                }
            }
        )
    }
}

@Composable
fun PlantCard(plant: Plant) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        var selected by remember { mutableStateOf(false) }
        val (row, checkbox, divider) = createRefs()
        Row(
            Modifier
                .height(64.dp)
                .fillMaxWidth()
                .constrainAs(row) {
                    end.linkTo(checkbox.start)
                    start.linkTo(parent.start)
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoilImage(
                data = plant.posterUrl,
                null,
                Modifier
                    .fillMaxHeight()
                    .width(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Column {
                Text(
                    text = plant.name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.firstBaselineToTop(24.dp)
                )
                Text(
                    text = "This is a description",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Checkbox(
            checked = selected,
            onCheckedChange = { selected = !selected },
            modifier = Modifier.constrainAs(checkbox) {
                end.linkTo(parent.end)
                top.linkTo(parent.top, margin = 24.dp)
            }
        )
        Divider(
            Modifier
                .height(1.dp)
                .padding(start = 72.dp)
                .constrainAs(divider) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun BrowseThemes() {
    val categories = getCategories()
    Column {
        Text(
            "Browse themes",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.firstBaselineToTop(32.dp)
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        LazyRow(
            content = {
                items(categories.size) { index ->
                    CategoryCard(categories[index])
                }
            }
        )
    }
}

@Composable
fun CategoryCard(category: Category) {
    Card(
        Modifier
            .height(136.dp)
            .width(136.dp)
            .padding(vertical = 8.dp)
            .padding(end = 8.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        ConstraintLayout {
            val (image, name) = createRefs()
            CoilImage(
                data = category.posterUrl,
                null,
                Modifier
                    .height(96.dp)
                    .fillMaxWidth()
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = category.name,
                Modifier
                    .fillMaxWidth()
                    .constrainAs(name) {
                        top.linkTo(image.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 16.dp)
                    },
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun Search() {
    Box(Modifier.border(1.dp, MaterialTheme.colors.onPrimary, MaterialTheme.shapes.small)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                modifier = Modifier.padding(start = 18.dp),
                tint = MaterialTheme.colors.onPrimary,
            )
            TextField(
                value = "Search", onValueChange = { },
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
    }
}
