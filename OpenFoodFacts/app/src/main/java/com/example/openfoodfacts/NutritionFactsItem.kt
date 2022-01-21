package com.example.openfoodfacts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFactsItem (
    var unit : String,
    var portion : String,
    var hundredGrams : String,
) : Parcelable