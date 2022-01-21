package com.example.openfoodfacts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.empty_screen.view.*
import kotlinx.android.synthetic.main.product_card.view.*
import kotlinx.android.synthetic.main.product_list.*

class ProductsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val petitPois = Product(
            "Petits pois sélection 'tendres et fondants'",
            "Cassegraine",
            "3083680085304",
            "a",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            listOf("France","Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8%\n(salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            listOf(),
            listOf(),
            NutritionFacts(
                NutritionFactsItem("kj","?","293"),
                NutritionFactsItem("g","?","0,8"),
                NutritionFactsItem("g","?","0,1"),
                NutritionFactsItem("g","?","8,4"),
                NutritionFactsItem("g","?","5,2"),
                NutritionFactsItem("g","?","5,2"),
                NutritionFactsItem("g","?","4,8"),
                NutritionFactsItem("g","?","0,75"),
                NutritionFactsItem("g","?","0,295")
            )
        )

        val capellini = Product(
            "Capellini n.1",
            "Barilla",
            "3083680085305",
            "a",
            "https://static.openfoodfacts.org/images/products/807/680/019/5019/front_de.572.400.jpg",
            "500 g",
            listOf("Belgique", "France", "Allemagne", "Italie", "\nJapon", "Luxembourg", "Suède", "Suisse", "États-Unis"),
            listOf("Semoule de blé dur", "eau"),
            listOf("Gluten"),
            listOf(),
            NutritionFacts(
                NutritionFactsItem("kj","1293","1521"),
                NutritionFactsItem("g","1,7","2,0"),
                NutritionFactsItem("g","0,4","0,5"),
                NutritionFactsItem("g","60,3","70,9"),
                NutritionFactsItem("g","3,0","3,5"),
                NutritionFactsItem("g","2,6","3,0"),
                NutritionFactsItem("g","10,9","12,8"),
                NutritionFactsItem("g","0,011","0,013"),
                NutritionFactsItem("g","0,001","0,002")
            )
        )

        val chocapic = Product(
            "Céréales chocapic",
            "Nestlé",
            "3083680085306",
            "b",
            "https://static.openfoodfacts.org/images/products/761/303/462/6844/front_fr.199.400.jpg",
            "430 g",
            listOf("Belgique", "France", "Polynésie française", "Guadeloupe", "Martinique\n", "Maroc", "Nouvelle-Calédonie", "La Réunion", "Espagne", "Suisse"),
            listOf("BLE complet 33,5%", "chocolat en poudre 22,8% (sucre, cacao en poudre)\n", "farine de BLE 16,8%", "semoule de maïs", "sirop de glucose\n", "sucre", "extrait de malt d'ORGE (ORGE, ORGE malté)", "huile de tournesol", "carbonate de calcium\n", "émulsifiant : lécithine de tournesol ","sel", "arômes naturels", "fer", "vitamines B3", "B5", "D", "B6", "B1", "B2 et B9"),
            listOf("Gluten"),
            listOf("E322i - Lécithine"),
            NutritionFacts(
                NutritionFactsItem("kj","222","1625"),
                NutritionFactsItem("g","1,02","4,6"),
                NutritionFactsItem("g","0,48","1,3"),
                NutritionFactsItem("g","8,4","73,3"),
                NutritionFactsItem("g","3,9","24,9"),
                NutritionFactsItem("g","0,72","8"),
                NutritionFactsItem("g","2,07","8,6"),
                NutritionFactsItem("g","0,066","0,22"),
                NutritionFactsItem("g","0,001","0,002")
            )
        )

        val products = listOf(petitPois,capellini, chocapic)

        val adapter = MyAdapter(products,
            object : OnListItemClickListener {
                override fun onItemClicked(position: Int) {
                    val intent = Intent(context, ProductDetailsFragment::class.java)
                    intent.putExtra("product",products[position])
                    startActivity(intent)
                }
            }
        )

        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }
    }

    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val productImage : ImageView = view.product_image
        val productName : TextView = view.product_name
        val productBrand : TextView = view.product_brand
        val productNutriscore : TextView = view.product_nutriscore
        val productCalories : TextView = view.product_calories
    }

    class EmptyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val texte : TextView = view.texte
        val sousTexte : TextView = view.sous_texte
        val button : TextView = view.button
    }

    class MyAdapter(private val products : List<Product>, val listener : OnListItemClickListener) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val TYPE_EMPTY = 0
        private val TYPE_ITEM = 1

        override fun onCreateViewHolder(parent: ViewGroup, itemViewType: Int) : RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return when (itemViewType) {
                TYPE_EMPTY -> EmptyViewHolder(inflater.inflate(R.layout.empty_screen, parent, false))
                TYPE_ITEM -> ItemViewHolder(inflater.inflate(R.layout.product_card, parent, false))
                else -> EmptyViewHolder(inflater.inflate(R.layout.error, parent, false))
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val itemViewType = getItemViewType(position)

            when (itemViewType) {
                TYPE_ITEM -> {
                    Picasso.get().load(products[position].url).into((holder as ItemViewHolder).productImage)
                    holder.productName.text = products[position].name
                    holder.productBrand.text = products [position].brand
                    holder.productNutriscore.text = "Nutriscore :".plus(products[position].nutriscore.uppercase())
                    val calorie = if (products[position].nutritionFacts.energy.portion != "?") (products[position].nutritionFacts.energy.portion.toDouble() * 0.2388).toInt() else products[position].nutritionFacts.energy.portion
                    holder.productCalories.text = calorie.toString().plus(" kCal/part")
                    holder.itemView.setOnClickListener {listener.onItemClicked(holder.adapterPosition)}
                }
                TYPE_EMPTY -> {
                    (holder as EmptyViewHolder)
                    holder.texte.setText(R.string.texte)
                    holder.sousTexte.setText(R.string.sous_texte)
                    holder.button.setText(R.string.button)
                    holder.button.setOnClickListener {listener.onItemClicked(holder.adapterPosition)}
                }
            }
        }

        override fun getItemCount(): Int {
            return when (products.size) {
                0 -> 1
                else -> products.size
            }
        }

        override fun getItemViewType(position: Int): Int {
            return when (products.size) {
                0 -> TYPE_EMPTY
                else -> TYPE_ITEM
            }
        }
    }

    interface OnListItemClickListener {
        fun onItemClicked(position: Int)
    }
}
