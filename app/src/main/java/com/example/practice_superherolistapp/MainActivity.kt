package com.example.practice_superherolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_superherolistapp.data.SuperHero
import com.example.practice_superherolistapp.data.SuperHeroRepository
import com.example.practice_superherolistapp.ui.theme.Practice_SuperheroListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_SuperheroListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(WindowInsets.statusBars.asPaddingValues())
                            .padding(bottom = dimensionResource(R.dimen.padding_medium)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            Text(
                                text = stringResource(R.string.superheroes),
                                style = MaterialTheme.typography.displayLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                    }) { innerPadding ->
                    SuperHeroCardList(SuperHeroRepository.superHeroes, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SuperHeroCard(superHero: SuperHero, modifier: Modifier = Modifier) {
    Card(modifier.shadow(elevation = 2.dp, shape = MaterialTheme.shapes.medium)
    ){
        Row(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .width(256.dp)) {
                Text(
                    text = stringResource(superHero.nameRes),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(superHero.descriptionRes),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(superHero.imageRes),
                contentDescription = stringResource(superHero.nameRes),
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.medium),
            )
        }
    }
}

@Composable
fun SuperHeroCardList(superHeroes: List<SuperHero>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(superHeroes) { superHero ->
            SuperHeroCard(
                superHero,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperHeroCardPreview(){
    Practice_SuperheroListAppTheme{
        Surface {
            SuperHeroCard(
                superHero = SuperHeroRepository.superHeroes[0],
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperHeroCardListPreview(){
    Practice_SuperheroListAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(R.string.superheroes),
                        style = MaterialTheme.typography.displayLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }) { innerPadding ->
            SuperHeroCardList(SuperHeroRepository.superHeroes, Modifier.padding(innerPadding))
        }
    }
}