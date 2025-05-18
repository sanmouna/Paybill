package com.astro.paybills.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.astro.paybills.R
import com.astro.paybills.data.model.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.weight(1.0f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = product.name, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "$${product.price}", fontSize = 18.sp, color = Color.Gray)
                }

                var isSelected by remember { mutableStateOf(product.isSelected) }

                val imageRes = if (isSelected) R.drawable.selectde_circle else R.drawable.add_icon
                val imageSize = if (isSelected) 32.dp else 40.dp

             Column (modifier = Modifier.size(40.dp) , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                 Image(
                     painter = painterResource(imageRes),
                     contentDescription = "My Drawable Image",
                     modifier = Modifier
                         .size(imageSize)
                         .clickable {
                             if (isSelected) {
                                 isSelected = false
                                 product.isSelected = isSelected
                             }else{
                                 isSelected = true
                                 product.isSelected = isSelected
                             }

                         }
                 )
             }

            }

        }
    }

}
