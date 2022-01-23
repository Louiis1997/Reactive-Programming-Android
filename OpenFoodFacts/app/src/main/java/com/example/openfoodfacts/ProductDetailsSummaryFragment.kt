package com.example.openfoodfacts

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sheet.*
import kotlinx.android.synthetic.main.sheet.view.*

class ProductDetailsSummaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        contrainer: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        return inflater.inflate(
            R.layout.sheet,
            contrainer,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product : Product = ProductDetailsFragmentArgs.fromBundle(
            requireParentFragment().requireParentFragment().requireArguments()
        ).product

        Picasso.get().load(product.url).into(product_image)
        view.product_name.text = product.name
        view.product_brand.text = product.brand
        view.product_barcode.setBoldValue(getString(R.string.product_barcode, product.barcode))
        view.product_nutriscore.setImageResource(resources.getIdentifier("com.example.openfoodfacts:drawable/nutriscore_${product.nutriscore}",null,null))
        view.product_quantity.setBoldValue(getString(R.string.product_quantity, product.quantity))
        view.product_distribution.setBoldValue(getString(R.string.product_distribution, empty(product.distributions)))
        view.product_ingredient.setBoldValue(getString(R.string.product_ingredient, empty(product.ingredients)))
        view.product_allergens.setBoldValue(getString(R.string.product_allergens, empty(product.allergens)))
        view.product_additives.setBoldValue(getString(R.string.product_additives, empty(product.additives)))
    }

    private fun TextView.setBoldValue(value : String) {
        val index = value.indexOf(':')
        val spannable = SpannableString(value)
        spannable.setSpan(StyleSpan(Typeface.BOLD),0,index,0)
        text = spannable
    }

    private fun empty(value: List<String>) : String {
        if(value.isEmpty())
            return "Aucune"
        return value.joinToString(", ")
    }
}