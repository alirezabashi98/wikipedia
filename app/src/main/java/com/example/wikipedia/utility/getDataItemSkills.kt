package com.example.wikipedia.utility

import com.example.wikipedia.R
import com.example.wikipedia.model.SkillsModel

fun getDataItemSkills(): ArrayList<SkillsModel> = arrayListOf(
    SkillsModel(
        icon = R.drawable.ic_android,
        title = "Android"
    ),
    SkillsModel(
        icon = R.drawable.ic_kotlin,
        title = "Kotlin"
    ),
    SkillsModel(
        icon = R.drawable.ic_java,
        title = "Java"
    ),
    SkillsModel(
        icon = R.drawable.ic_flutter,
        title = "Flutter"
    ),
    SkillsModel(
        icon = R.drawable.dart,
        title = "Dart"
    ),
)