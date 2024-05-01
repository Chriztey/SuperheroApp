package com.chris.superheroapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chris.superheroapp.model.Heroes
import com.chris.superheroapp.ui.theme.SuperheroAppTheme

@Composable
fun HeroCard (
    @StringRes name: Int,
    @StringRes desc: Int,
    @DrawableRes image: Int
) {
    Card (
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = name),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = desc),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
//                        modifier = Modifier
//                            .clip(MaterialTheme.shapes.small)
//                            .height(72.dp),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopCenter
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroList () {
    Scaffold(
        topBar = { TopApp() }
    ) {
            it -> LazyColumn(contentPadding = it) {
        items(Heroes.heroes) { hero -> HeroCard(name = hero.nameRes, desc = hero.descriptionRes, image = hero.imageRes )}
            }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApp() {
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge)}
    })
}


@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    SuperheroAppTheme(darkTheme = false) {
        HeroList()
    }
}

fun main() {
    // write your code here
    val shapeInput = readln().lowercase()
    var repeat: Int = when (shapeInput) {
        "triangle" -> 3
        "rectangle" -> 2
        "circle" -> 1
        else -> 0
    }

    val numberInput = mutableListOf<Double>()
    var numb: Double

    repeat(repeat) {
        numb = readln().toDouble()
        numberInput.add(numb)
    }




    val halfPerimeter: Double = if(shapeInput == "triangle") {
        (numberInput[0] + numberInput[1] + numberInput[2]) / 2
    } else {0.00}

    var areaFunction = when (shapeInput) {
        "triangle" -> kotlin.math.sqrt((halfPerimeter * (halfPerimeter - numberInput[0]) * (halfPerimeter - numberInput[1]) * ( halfPerimeter - numberInput[2])))
        "rectangle" -> numberInput[0] * numberInput[1]
        "circle" -> numberInput[0] * numberInput[0] * 3.14
        else -> {"Invalid Input"}
    }

    println (areaFunction)

}
