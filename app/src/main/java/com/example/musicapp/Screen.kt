package com.example.musicapp

import androidx.annotation.DrawableRes

sealed class Screen (val title : String,val route : String){
    sealed class DrawerScreen(val dTitle: String,val dRoute : String, @DrawableRes val Icon : Int)
        : Screen(dTitle,dRoute){
        object Account : DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_account_box_24
        )
        object Subscribtion : DrawerScreen(
            "Subscribtion",
            "subscribtion",
            R.drawable.baseline_library_music_24
        )
        object AddAccount : DrawerScreen(
            "AddAccount",
            "addAccount",
            R.drawable.baseline_person_add_alt_1_24
        )
    }

    sealed class BottomScreen(val bTitle : String,val bRoute: String,
                              @DrawableRes val Icon : Int) :Screen(bTitle,bRoute)
    {
        object Home : BottomScreen(
            "Home",
            "home",
            R.drawable.baseline_home_24
        )
        object Library : BottomScreen(
            "Library",
            "library",
            R.drawable.baseline_library_music_24
        )
        object Browse : BottomScreen (
            "Browse",
            "Browse",
            R.drawable.baseline_search_24
        )
    }
}
val ScreenInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscribtion,
    Screen.DrawerScreen.AddAccount,
)

val ScreenInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)