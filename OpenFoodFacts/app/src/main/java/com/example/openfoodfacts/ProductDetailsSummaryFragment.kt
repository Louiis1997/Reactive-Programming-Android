package com.example.openfoodfacts

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sheet.*

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

        Picasso.get().load(arguments?.getString("url")).into(product_image)
        view.findViewById<TextView>(R.id.product_name)?.text = arguments?.getString("name")
        view.findViewById<TextView>(R.id.product_brand)?.text = arguments?.getString("brand")
        view.findViewById<TextView>(R.id.product_barcode)?.setBoldValue(getString(R.string.product_barcode, arguments?.getString("barcode")))
        view.findViewById<ImageView>(R.id.product_nutriscore)?.setImageResource(resources.getIdentifier("com.example.openfoodfacts:drawable/nutriscore_${arguments?.getString("nutriscore")}",null,null))
        view.findViewById<TextView>(R.id.product_quantity)?.setBoldValue(getString(R.string.product_quantity, arguments?.getString("quantity")))
        /*view.findViewById<TextView>(R.id.product_distribution)?.setBoldValue(getString(R.string.product_distribution, empty(arguments?.getParcelableArrayList<String>("distributions")))
        view.findViewById<TextView>(R.id.product_ingredient)?.setBoldValue(getString(R.string.product_ingredient, empty(petitPois.ingredients.joinToString(", "))))
        view.findViewById<TextView>(R.id.product_allergens)?.setBoldValue(getString(R.string.product_allergens, empty(petitPois.allergens.joinToString(", "))))
        view.findViewById<TextView>(R.id.product_additives)?.setBoldValue(getString(R.string.product_additives, empty(petitPois.additives.joinToString(", "))))*/
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