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

data class Category(
    val name: String,
    val posterUrl: String
)

data class Plant(
    val name: String,
    val posterUrl: String
)

fun getCategories() = arrayListOf(
    Category(
        name = "Desert chic",
        posterUrl = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=200&w=200"
    ),
    Category(
        name = "Tiny terrariums",
        posterUrl = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Category(
        name = "Jungle vibes",
        posterUrl = "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Category(
        name = "Easy care",
        posterUrl = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Category(
        name = "Statements",
        posterUrl = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
)

fun getPlants() = arrayListOf(
    Plant(
        name = "Monstera",
        posterUrl = "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Plant(
        name = "Aglaonema",
        posterUrl = "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Plant(
        name = "Peace lily",
        posterUrl = "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Plant(
        name = "Fiddle leaf",
        posterUrl = "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Plant(
        name = "Snake plant",
        posterUrl = "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
    Plant(
        name = "Pothos",
        posterUrl = "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=200&w=200"
    ),
)
