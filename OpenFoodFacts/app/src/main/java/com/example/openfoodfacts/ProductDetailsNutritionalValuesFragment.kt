package com.example.openfoodfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.nutritional_info.view.*

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

        val product : Product = ProductDetailsFragmentArgs.fromBundle(
            requireParentFragment().requireParentFragment().requireArguments()
        ).product

        view.product_energy.text = product.nutritionFacts.energy.hundredGrams.plus(" ").plus(product.nutritionFacts.energy.unit)
        view.product_energy_portion.text = product.nutritionFacts.energy.portion
        view.product_fat.text = product.nutritionFacts.fat.hundredGrams.plus(" ").plus(product.nutritionFacts.fat.unit)
        view.product_fat_portion.text = product.nutritionFacts.fat.portion
        view.product_saturatedFat.text = product.nutritionFacts.saturatedFat.hundredGrams.plus(" ").plus(product.nutritionFacts.saturatedFat.unit)
        view.product_saturatedFat_portion.text = product.nutritionFacts.saturatedFat.portion
        view.product_carbohydrates.text = product.nutritionFacts.carbohydrates.hundredGrams.plus(" ").plus(product.nutritionFacts.carbohydrates.unit)
        view.product_carbohydrates_portion.text = product.nutritionFacts.carbohydrates.portion
        view.product_sugars.text = product.nutritionFacts.sugars.hundredGrams.plus(" ").plus(product.nutritionFacts.sugars.unit)
        view.product_sugars_portion.text = product.nutritionFacts.sugars.portion
        view.product_fiber.text = product.nutritionFacts.fiber.hundredGrams.plus(" ").plus(product.nutritionFacts.fiber.unit)
        view.product_fiber_portion.text = product.nutritionFacts.fiber.portion
        view.product_proteins.text = product.nutritionFacts.proteins.hundredGrams.plus(" ").plus(product.nutritionFacts.proteins.unit)
        view.product_proteins_portion.text = product.nutritionFacts.proteins.portion
        view.product_salt.text = product.nutritionFacts.salt.hundredGrams.plus(" ").plus(product.nutritionFacts.salt.unit)
        view.product_salt_portion.text = product.nutritionFacts.salt.portion
        view.product_sodium.text = product.nutritionFacts.sodium.hundredGrams.plus(" ").plus(product.nutritionFacts.sodium.unit)
        view.product_sodium_portion.text = product.nutritionFacts.sodium.portion
    }
}