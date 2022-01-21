package com.example.openfoodfacts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    var name: String,
    var brand: String,
    var barcode: String,
    var nutriscore: String,
    var url: String,
    var quantity: String,
    var distributions: List<String>,
    var ingredients: List<String>,
    var allergens: List<String>,
    var additives: List<String>,
    var nutritionFacts: NutritionFacts
) : Parcelable