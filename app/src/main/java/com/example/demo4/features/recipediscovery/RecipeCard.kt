package com.example.demo4.features.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.demo4.R
import com.example.demo4.model.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(180.dp)
                .height(180.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = recipe.imageUrl,
            placeholder = painterResource(R.drawable.recipe_card_placeholder),
            contentDescription = "placeholder content description",
        )

        Text(
            text = recipe.title
        )
    }
}