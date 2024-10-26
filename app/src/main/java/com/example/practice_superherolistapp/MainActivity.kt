package com.example.practice_superherolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                Surface(modifier = Modifier.fillMaxSize()) {


                }
            }
        }
    }
}


@Composable
fun SuperHeroCard(superHero: SuperHero, modifier: Modifier = Modifier) {
    Card(modifier){
        Row(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = stringResource(superHero.nameRes),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(superHero.descriptionRes),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 4.dp)
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