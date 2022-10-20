package com.bnyro.wallpaper.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bnyro.wallpaper.obj.Wallpaper

@Composable
fun WallpaperGrid(
    wallpapers: List<Wallpaper>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(wallpapers) {
            var showFullscreen by remember {
                mutableStateOf(false)
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
                    .clickable {
                        showFullscreen = true
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(4.dp)
                ) {
                    AsyncImage(
                        model = it.imgSrc,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

            if (showFullscreen) {
                WallpaperPreview(it) {
                    showFullscreen = false
                }
            }
        }
    }
}