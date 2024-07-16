package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorResource(id = R.color.background)
            ) {
                BusinessCardTheme {
                    CardPresentation()
                }
            }
        }
    }
}

@Composable
fun BusinessCardProfile(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            Icons.Rounded.Person,
            contentDescription = null,
            modifier.size(48.dp)
        )
        Text(
            text = stringResource(id = R.string.text_user),
            modifier = modifier,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text)
        )
        Text(
            text = stringResource(id = R.string.text_goal_job),
            modifier = modifier,
            color = colorResource(id = R.color.goal_information)
        )
    }
}

@Composable
fun BusinessCardInformation(
    icon: ImageVector,
    iconColor: Color = Color.Black,
    label: String,
    modifier: Modifier = Modifier,
) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier.padding(end = 8.dp),
            tint = iconColor
        )
        Text(
            text = label,
            modifier = modifier,
            color = colorResource(id = R.color.text)
        )
    }
}

@Composable
fun CardPresentation(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        BusinessCardProfile()

        Spacer(modifier = modifier.weight(1f))

        Column(
            modifier.padding(bottom =  16.dp)
        ) {
            BusinessCardInformation(
                icon = Icons.Rounded.Phone,
                iconColor = colorResource(id = R.color.icon_phone),
                label = stringResource(R.string.text_phone),
            )

            BusinessCardInformation(
                icon = Icons.Rounded.Email,
                iconColor = colorResource(id = R.color.icon_email),
                label = stringResource(R.string.text_email),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        BusinessCardTheme {
            CardPresentation()
        }
    }
}