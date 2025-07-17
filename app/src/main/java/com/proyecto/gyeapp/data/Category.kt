package com.proyecto.gyeapp.data

import androidx.annotation.StringRes
import com.proyecto.gyeapp.R
import com.proyecto.gyeapp.model.Recommendation

sealed class Category (@StringRes val name: Int) {
    abstract fun getRecommendations(): List<Recommendation>
    object Parks: Category(name = R.string.parks) {
        override fun getRecommendations(): List<Recommendation> {
            val parkRecommendations = listOf<Recommendation>(
                Recommendation(
                    name = R.string.parks_samanes,
                    image = R.drawable.parque_samanes,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.parks_iguanas,
                    image = R.drawable.facing_the_church,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.parks_centenario,
                    image = R.drawable._ca21f3bc2538796fe4edcba5f55aab8_xl,
                    description = R.string.description
                )
            )
            return parkRecommendations
        }
    }
    object Cafeterias: Category(name = R.string.cafeterias) {
        override fun getRecommendations(): List<Recommendation> {
            val cafeteriaRecommendations = listOf<Recommendation>(
                Recommendation(
                    name = R.string.cafeterias_sweet,
                    image = R.drawable.caption,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.cafeterias_bombon,
                    image = R.drawable.local_de_9_de_octubre,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.cafeterias_ludica,
                    image = R.drawable.ludica_coffee_house,
                    description = R.string.description
                )
            )
            return cafeteriaRecommendations
        }
    }
    object Malls: Category(name = R.string.malls) {
        override fun getRecommendations(): List<Recommendation> {
            val mallRecommendations = listOf<Recommendation>(
                Recommendation(
                    name = R.string.malls_sol,
                    image = R.drawable.brvqhqneqe1kicly2um5,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.malls_sanma,
                    image = R.drawable.san_marino_shopping,
                    description = R.string.description
                ),
                Recommendation(
                    name = R.string.malls_dorado,
                    image = R.drawable.portada_el_cortijo,
                    description = R.string.description
                )
            )
            return mallRecommendations
        }
    }

    companion object CategoryList {
        val categoryList: List<Category> by lazy { listOf(Parks, Cafeterias, Malls) }
    }
}


