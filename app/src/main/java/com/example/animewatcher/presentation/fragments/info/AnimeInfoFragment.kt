package com.example.animewatcher.presentation.fragments.info

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.bumptech.glide.Glide
import com.example.animewatcher.R
import com.example.animewatcher.databinding.FragmentAnimeBinding
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.presentation.fragments.favorite.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeInfoFragment : Fragment() {
    private val binding :FragmentAnimeBinding by lazy {
        FragmentAnimeBinding.inflate(layoutInflater)
    }
    private val viewModel: AnimeInfoViewModel by viewModels ()
    //Проверка на подключение к интернету
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return  capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val navController = findNavController(this)


            arguments.let {
                val animeItem :AnimeApiItemModel? = arguments?.getParcelable(animeKey)
                with(binding){
                    favoriteCard.setOnClickListener {
                        viewModel.addAnimeItemInDb(animeItem!!)
                    }
                    animeNameText.text = animeItem!!.materialData!!.title
                    Glide.with(requireActivity()).load(animeItem.materialData!!.posterUrl).into(backgroundImage)
                    Glide.with(requireActivity()).load(animeItem.materialData.posterUrl).into(posterAnime)
                    statusText.text = animeItem.materialData.animeStatus
                    if(animeItem.materialData.description != null){
                        animeDetailsText.text = animeItem.materialData.description
                    } else {  animeDetailsText.text = getString(R.string.description_error) }
                    binding.progressbarInPage.visibility = View.GONE
                }
                //перекидывание ссылки на сезон и проверка на подключение к интернету
                val stringNotPlayerError = getString(R.string.not_in_player)
                val stringInternetError = getString(R.string.internet_error)
                binding.playCard.setOnClickListener {
                    val seasonNumber:String = animeItem!!.seasons.keys.firstOrNull().toString()
                    if (hasInternetConnection(requireActivity())) {
                        if (animeItem!!.seasons[seasonNumber]!!.link != null) {
                            navController.navigate(
                                R.id.action_navigation_anime_info_to_navigation_player,
                                bundleOf(animeVideoKey to animeItem!!.seasons[seasonNumber]!!.link)
                            )
                        } else {
                            Toast.makeText(requireActivity(), stringNotPlayerError, Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(requireActivity(), stringInternetError, Toast.LENGTH_LONG).show()
                    }

                }
        }

        return binding.root
    }


        companion object{
            const val animeKey ="ANIME_KEY"
            const val animeVideoKey ="ANIME_VIDEO_KEY"
        }

}