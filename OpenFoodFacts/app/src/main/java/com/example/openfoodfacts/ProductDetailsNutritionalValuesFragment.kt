package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProductDetailsNutritionalValuesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nutritional_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.product_energy)?.text = arguments?.getString("nutritionFacts.energy.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.energy.unit"))
        view.findViewById<TextView>(R.id.product_energy_portion)?.text = arguments?.getString("nutritionFacts.energy.portion")
        view.findViewById<TextView>(R.id.product_fat)?.text = arguments?.getString("nutritionFacts.fat.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.fat.unit"))
        view.findViewById<TextView>(R.id.product_fat_portion)?.text = arguments?.getString("nutritionFacts.fat.portion")
        view.findViewById<TextView>(R.id.product_saturatedFat)?.text = arguments?.getString("nutritionFacts.saturatedFat.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.saturatedFat.unit"))
        view.findViewById<TextView>(R.id.product_saturatedFat_portion)?.text = arguments?.getString("nutritionFacts.saturatedFat.portion")
        view.findViewById<TextView>(R.id.product_carbohydrates)?.text = arguments?.getString("nutritionFacts.carbohydrates.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.carbohydrates.unit"))
        view.findViewById<TextView>(R.id.product_carbohydrates_portion)?.text = arguments?.getString("nutritionFacts.carbohydrates.portion")
        view.findViewById<TextView>(R.id.product_sugars)?.text = arguments?.getString("nutritionFacts.sugars.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.sugars.unit"))
        view.findViewById<TextView>(R.id.product_sugars_portion)?.text = arguments?.getString("nutritionFacts.sugars.portion")
        view.findViewById<TextView>(R.id.product_fiber)?.text = arguments?.getString("nutritionFacts.fiber.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.fiber.unit"))
        view.findViewById<TextView>(R.id.product_fiber_portion)?.text = arguments?.getString("nutritionFacts.fiber.portion")
        view.findViewById<TextView>(R.id.product_proteins)?.text = arguments?.getString("nutritionFacts.proteins.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.proteins.unit"))
        view.findViewById<TextView>(R.id.product_proteins_portion).text = arguments?.getString("nutritionFacts.proteins.portion")
        view.findViewById<TextView>(R.id.product_salt)?.text = arguments?.getString("nutritionFacts.salt.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.salt.unit"))
        view.findViewById<TextView>(R.id.product_salt_portion)?.text = arguments?.getString("nutritionFacts.salt.portion")
        view.findViewById<TextView>(R.id.product_sodium)?.text = arguments?.getString("nutritionFacts.sodium.hundredGrams").plus(" ").plus(arguments?.getString("nutritionFacts.sodium.unit"))
        view.findViewById<TextView>(R.id.product_sodium_portion)?.text = arguments?.getString("nutritionFacts.sodium.portion")

    }
}