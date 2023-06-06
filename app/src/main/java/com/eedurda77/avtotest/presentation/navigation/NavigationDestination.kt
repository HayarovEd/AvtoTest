package com.eedurda77.avtotest.presentation.navigation

sealed class NavigationDestination (val destination: String) {
    object AutosListScreen: NavigationDestination("autosListScreen")
    object AutoInfoScreen: NavigationDestination("autoInfoScreen")
}
