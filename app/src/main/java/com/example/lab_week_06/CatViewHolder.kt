package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView = containerView.findViewById(R.id.cat_photo)
    private val catNameView: TextView = containerView.findViewById(R.id.cat_name)
    private val catBreedView: TextView = containerView.findViewById(R.id.cat_breed)
    private val catBiographyView: TextView = containerView.findViewById(R.id.cat_biography)
    private val catGenderView: TextView = containerView.findViewById(R.id.cat_gender)

    fun bindData(cat: CatModel) {
        containerView.setOnClickListener { onClickListener.onItemClick(cat) }

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            CatBreed.Bengal -> "Bengal"
            CatBreed.BritishShorthair -> "British Shorthair"
            CatBreed.MaineCoon -> "Maine Coon"
            CatBreed.Siamese -> "Siamese"
            CatBreed.Ragdoll -> "Ragdoll"
            CatBreed.Abyssinian -> "Abyssinian"
            CatBreed.Birman -> "Birman"
            CatBreed.Sphynx -> "Sphynx"
            CatBreed.NorwegianForestCat -> "Norwegian Forest Cat"
            CatBreed.TurkishVan -> "Turkish Van"
            CatBreed.ScottishFold -> "Scottish Fold"
            CatBreed.Persian -> "Persian"
            CatBreed.Burmese -> "Burmese"
            CatBreed.DevonRex -> "Devon Rex"
            CatBreed.Savannah -> "Savannah"
            CatBreed.Oriental -> "Oriental"
            CatBreed.Tonkinese -> "Tonkinese"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> "♀"
            Gender.Male -> "♂"
            else -> "?"
        }
    }
}