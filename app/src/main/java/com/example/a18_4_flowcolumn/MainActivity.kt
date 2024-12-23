package com.example.a18_4_flowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Start() {

    val persons = listOf<Person>(
        Person(fName = "Дмитрий", sName = "Гухман", position = "Junior", salary = 150_000),
        Person(fName = "Анна", sName = "Котлиновна", position = "Middle", salary = 260_000),
        Person(fName = "Василий", sName = "Явович", position = "Senior", salary = 370_000),

        Person(fName = "Евгения", sName = "Ассемблеровна", position = "CEO", salary = 1700_000),
        Person(fName = "Надежда", sName = "Фортрановна", position = "CTO", salary = 850_000),
        Person(fName = "Илья", sName = "Питонович", position = "Project manager", salary = 330_000),

        Person(fName = "Борис", sName = "Растович", position = "Anykey", salary = 110_000),
        Person(fName = "Инга", sName = "Рубиевна", position = "Teamlead", salary = 520_000),
        Person(
            fName = "Владимир",
            sName = "Яваскриптович",
            position = "Security Engineer",
            salary = 420_000
        ),

        Person(
            fName = "Артём",
            sName = "Обжектсивович",
            position = "Software Architect",
            salary = 480_000
        ),
        Person(
            fName = "Валентина",
            sName = "Тайпскриптович",
            position = "QA Engineer",
            salary = 130_000
        ),
        Person(
            fName = "Мария",
            sName = "Скалавич",
            position = "Frontend middle developer",
            salary = 220_000
        ),

        )

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                FlowColumn(
                    Modifier
                        .horizontalScroll(rememberScrollState()),
                    maxItemsInEachColumn = 3
                ) {
                    val sortedPersons = persons.sortedWith(compareBy({ it.position }, { it.fName }))
                    sortedPersons.forEach { person ->
                        Column(
                            Modifier
                                .padding(0.dp, 12.dp, 12.dp, 0.dp)
                                .width(screenWidthDp - 12.dp)
                                .background(Color.LightGray)
                        ) {
                            Text(
                                text = person.fName,
                                Modifier
                                    .padding(8.dp, 8.dp, 0.dp, 0.dp),
                                fontSize = 24.sp
                            )
                            Text(
                                text = person.sName,
                                Modifier
                                    .padding(horizontal = 8.dp),
                                fontSize = 20.sp
                            )
                            Text(
                                text = person.position,
                                Modifier
                                    .padding(horizontal = 8.dp),
                                fontSize = 18.sp
                            )
                            Text(
                                text = person.salary.toString(),
                                Modifier
                                    .padding(8.dp, 0.dp, 0.dp, 8.dp),
                                fontSize = 14.sp
                            )

                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Start()
}