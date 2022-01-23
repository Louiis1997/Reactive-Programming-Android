package com.example.openfoodfacts

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.nutrition.view.*

class ProductDetailsNutritionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nutrition, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product : Product = ProductDetailsFragmentArgs.fromBundle(
            requireParentFragment().requireParentFragment().requireArguments()
        ).product

        DrawableCompat.setTintList(view.circle_fat.background, ColorStateList.valueOf(resources.getColor(fat(product.nutritionFacts.fat.hundredGrams.replaceFirst(",",".").toDouble()))))
        DrawableCompat.setTintList(view.circle_saturatedFat.background, ColorStateList.valueOf(resources.getColor(saturatedFat(product.nutritionFacts.saturatedFat.hundredGrams.replaceFirst(",",".").toDouble()))))
        DrawableCompat.setTintList(view.circle_sugars.background, ColorStateList.valueOf(resources.getColor(sugars(product.nutritionFacts.sugars.hundredGrams.replaceFirst(",",".").toDouble()))))
        DrawableCompat.setTintList(view.circle_salt.background, ColorStateList.valueOf(resources.getColor(salt(product.nutritionFacts.salt.hundredGrams.replaceFirst(",",".").toDouble()))))
        view.product_fat.text = getString(R.string.product_fat,product.nutritionFacts.fat.hundredGrams.plus(" ").plus(product.nutritionFacts.fat.unit))
        view.product_saturatedFat.text = getString(R.string.product_saturatedFat, product.nutritionFacts.saturatedFat.hundredGrams.plus(" ").plus(product.nutritionFacts.saturatedFat.unit))
        view.product_sugars.text = getString(R.string.product_sugars, product.nutritionFacts.sugars.hundredGrams.plus(" ").plus(product.nutritionFacts.sugars.unit))
        view.product_salt.text = getString(R.string.product_salt, product.nutritionFacts.salt.hundredGrams.plus(" ").plus(product.nutritionFacts.salt.unit))
    }

    private fun fat(value : Double) : Int {
        return if(value < 3)
            R.color.nutrient_level_low
        else if(3 < value && value < 20)
            R.color.nutrient_level_moderate
        else
            R.color.nutrient_level_high
    }

    private fun saturatedFat(value : Double) : Int {
        return if(value < 1.5)
            R.color.nutrient_level_low
        else if(1.5 < value && value < 5)
            R.color.nutrient_level_moderate
        else
            R.color.nutrient_level_high
    }

    private fun sugars(value : Double) : Int {
        return if(value < 5)
            R.color.nutrient_level_low
        else if(5 < value && value < 12.5)
            R.color.nutrient_level_moderate
        else
            R.color.nutrient_level_high
    }

    private fun salt(value : Double) : Int {
        return if(value < 0.3)
            R.color.nutrient_level_low
        else if(0.3 < value && value < 1.5)
            R.color.nutrient_level_moderate
        else
            R.color.nutrient_level_high
    }
}