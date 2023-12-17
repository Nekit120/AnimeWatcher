package com.example.animewatcher.presentation.fragments.player

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.findNavController
import com.example.animewatcher.R
import com.example.animewatcher.databinding.FragmentAnimeBinding
import com.example.animewatcher.databinding.FragmentAnimePlayerBinding

@Suppress("DEPRECATION")
class AnimePlayerFragment : Fragment() {

    private val binding : FragmentAnimePlayerBinding by lazy {
        FragmentAnimePlayerBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val webView: WebView = binding.webWiew
        val webSettings: WebSettings = webView.settings
        //установка ориентации фрагменту
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        webView.setBackgroundColor(Color.BLACK)
        //устанавливает различные флаги для системного интерфейса (System UI)
        activity?.window?.decorView?.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or  //Скрыть строку состояния.
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or //Стабилизировать расположение всех элементов.
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or //Разместить содержимое так, чтобы оно не перекрывалось панелью навигации.
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or //Разместить содержимое так, чтобы оно не перекрывалось строкой состояния.
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or  //Скрыть панель навигации.
                        View.SYSTEM_UI_FLAG_FULLSCREEN or //Скрыть строку состояния.
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //: Системные бары (строка состояния и панель навигации) будут автоматически отображаться, если пользователь проведет жест от края экрана.
                )

        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        // Включение JavaScript
        webSettings.javaScriptEnabled = true

        // Настройки и подключение webView
        webView.fitsSystemWindows = true
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        val video ="<iframe src=\"https://kodik.info/season/94793/3750223aafd73b4602ae571ed483aecb/720p\" width=\"100%\" height=\"100%\" frameborder=\"0\" allowfullscreen allow=\"autoplay *; fullscreen *\"></iframe>"
        webView.loadData(video,"text/html","utf-8")


        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        showSystemUi()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hideSystemUi()
    }
    // показывает SystemUi после FullScreen
    private fun showSystemUi() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        WindowCompat.setDecorFitsSystemWindows(requireActivity().window, true)
        WindowInsetsControllerCompat(requireActivity().window, requireActivity().window.decorView)
            .show(WindowInsetsCompat.Type.systemBars())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S_V2)
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    // прячет SystemUi для FullScreen
    private fun hideSystemUi() {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        WindowCompat.setDecorFitsSystemWindows(requireActivity().window, false)
        WindowInsetsControllerCompat(
            requireActivity().window,
            requireActivity().window.decorView
        ).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S_V2)
            requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

}