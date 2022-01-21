package com.example.openfoodfacts

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment

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
        DrawableCompat.setTintList(view.findViewById<View>(R.id.circle_fat).background, ColorStateList.valueOf(resources.getColor(fat(arguments?.getString("nutritionFacts.fat.hundredGrams")?.replaceFirst(",",".")!!.toDouble()))))
        DrawableCompat.setTintList(view.findViewById<View>(R.id.circle_saturatedFat).background, ColorStateList.valueOf(resources.getColor(saturatedFat(arguments?.getString("nutritionFacts.saturatedFat.hundredGrams")?.replaceFirst(",",".")!!.toDouble()))))
        DrawableCompat.setTintList(view.findViewById<View>(R.id.circle_sugars).background, ColorStateList.valueOf(resources.getColor(sugars(arguments?.getString("nutritionFacts.sugars.hundredGrams")?.replaceFirst(",",".")!!.toDouble()))))
        DrawableCompat.setTintList(view.findViewById<View>(R.id.circle_salt)!!.background, ColorStateList.valueOf(resources.getColor(salt(arguments?.getString("nutritionFacts.salt.hundredGrams")?.replaceFirst(",",".")!!.toDouble()))))
        view.findViewById<TextView>(R.id.product_fat)?.text = getString(R.string.product_fat,arguments?.getString("nutritionFacts.fat.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.fat.unit")))
        view.findViewById<TextView>(R.id.product_saturatedFat)?.text = getString(R.string.product_saturatedFat, arguments?.getString("nutritionFacts.saturatedFat.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.saturatedFat.unit")))
        view.findViewById<TextView>(R.id.product_sugars)?.text = getString(R.string.product_sugars, arguments?.getString("nutritionFacts.sugars.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.sugars.unit")))
        view.findViewById<TextView>(R.id.product_salt)?.text = getString(R.string.product_salt, arguments?.getString("nutritionFacts.salt.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.salt.unit")))
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