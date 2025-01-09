package com.plcoding.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.plcoding.weatherapp.WeatherApp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx. compose. foundation. layout. Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow

@Composable
fun WeatherForecast(state: WeatherState, modifier: Modifier) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(
                text = "Today",
                fontSize = 20.sp,
                color = androidx.compose.ui.graphics.Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyDataDisplay(
                        weatherData = weatherData,
                        modifier = Modifier.height(100.dp).padding(horizontal = 16.dp)
                    )
                }
            }
            )
        }

    }
}
