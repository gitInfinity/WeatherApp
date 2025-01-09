package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        val formattedDate = data.time.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today is $formattedDate",
                    modifier = Modifier.align(Alignment.End),
                    color = androidx.compose.ui.graphics.Color.White
                )
                Spacer(modifier=Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier=Modifier.height(16.dp))
                Text(
                    text = "${data.temperatureCelsius}°C",
                    fontSize = 50.sp,
                    color = androidx.compose.ui.graphics.Color.White
                )
                Spacer(modifier=Modifier.height(16.dp))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = androidx.compose.ui.graphics.Color.White
                )
                Spacer(modifier=Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround
                )
                {
                    WeatherDataDisplay(
                        value = data.pressure.toInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = com.plcoding.weatherapp.R.drawable.ic_pressure),
                        iconTint = androidx.compose.ui.graphics.Color.White,
                        textStyle = androidx.compose.ui.text.TextStyle(color = androidx.compose.ui.graphics.Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.toInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = com.plcoding.weatherapp.R.drawable.ic_drop),
                        iconTint = androidx.compose.ui.graphics.Color.White,
                        textStyle = androidx.compose.ui.text.TextStyle(color = androidx.compose.ui.graphics.Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.toInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = com.plcoding.weatherapp.R.drawable.ic_wind),
                        iconTint = androidx.compose.ui.graphics.Color.White,
                        textStyle = androidx.compose.ui.text.TextStyle(color = androidx.compose.ui.graphics.Color.White)
                    )
                }
            }
        }
    }
}