package com.nmai.fruit

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Item(
    var name: String,
    var cost: Float,
    var calo: Float,
    var note: String,
    @DrawableRes var image: Int
) : Serializable
