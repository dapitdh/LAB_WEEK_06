package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        val cats = listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Fred",
                "Silent and deadly",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Wilma",
                "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.Bengal,
                "Simba",
                "King of the sofa jungle",
                "https://cdn2.thecatapi.com/images/4tu.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BritishShorthair,
                "Luna",
                "Dreamy night stalker",
                "https://cdn2.thecatapi.com/images/mtk.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.MaineCoon,
                "Thor",
                "Gentle giant with thunder paws",
                "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.Siamese,
                "Cleo",
                "Talkative diva of the house",
                "https://cdn2.thecatapi.com/images/ai6.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.Ragdoll,
                "Shadow",
                "Sleeps all day, hunts at night",
                "https://cdn2.thecatapi.com/images/8jt.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.Abyssinian,
                "Leo",
                "Explorer of forbidden shelves",
                "https://cdn2.thecatapi.com/images/9ru.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.Birman,
                "Bella",
                "Sweet but dangerous",
                "https://cdn2.thecatapi.com/images/2oo.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.Sphynx,
                "Rex",
                "Alien overlord in disguise",
                "https://cdn2.thecatapi.com/images/aqe.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.NorwegianForestCat,
                "Freya",
                "Viking princess on patrol",
                "https://cdn2.thecatapi.com/images/b8b.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.TurkishVan,
                "Marble",
                "Water-loving adventurer",
                "https://cdn2.thecatapi.com/images/c2d.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.ScottishFold,
                "Ollie",
                "Ears folded, eyes wide open",
                "https://cdn2.thecatapi.com/images/7ii.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.Persian,
                "Misty",
                "Cloud of fur and elegance",
                "https://cdn2.thecatapi.com/images/3rb.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.Burmese,
                "Rocky",
                "Champion napper of the year",
                "https://cdn2.thecatapi.com/images/bpe.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.DevonRex,
                "Pixie",
                "Tiny but mischievous",
                "https://cdn2.thecatapi.com/images/d2f.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.Savannah,
                "Nala",
                "Wild spirit, domestic heart",
                "https://cdn2.thecatapi.com/images/6kl.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.Oriental,
                "Jasper",
                "Guardian of the snacks",
                "https://cdn2.thecatapi.com/images/5r7.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.Tonkinese,
                "Zara",
                "Purring bundle of mystery",
                "https://cdn2.thecatapi.com/images/6vf.jpg"
            )
        )



        catAdapter.setData(cats)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
