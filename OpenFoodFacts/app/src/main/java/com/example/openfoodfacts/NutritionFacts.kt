package com.example.openfoodfacts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFacts (
    var energy : NutritionFactsItem,
    var fat : NutritionFactsItem,
    var saturatedFat : NutritionFactsItem,
    var carbohydrates : NutritionFactsItem,
    var sugars : NutritionFactsItem,
    var fiber : NutritionFactsItem,
    var proteins : NutritionFactsItem,
    var salt : NutritionFactsItem,
    var sodium : NutritionFactsItem
) : Parcelable