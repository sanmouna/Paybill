package com.astro.paybills.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.astro.paybills.R

@Composable
fun DineInTakeOut(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.restaurant_bg),
            contentDescription = "Restaurant Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .background(color =Color.White ,  shape = RoundedCornerShape(20))
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable {
                            navController.navigate("productHomeScreen")
                        },
            ) {

                Text(
                    text = "DineIn",
                    color = Color.Black,
                    fontSize = 40.sp)

            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .background(color =Color.White ,  shape = RoundedCornerShape(20))
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable {
                            navController.navigate("productHomeScreen")
                        }

            ) {
                Text(
                    text = "TakeOut",
                    color = Color.Black,
                    fontSize = 40.sp
                    )

            }
        }
    }
}
