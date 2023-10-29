package com.example.unsplashclient.presentation

// 全画面のRouteを管理する
sealed class ScreenRoute(val route: String) {
  object SearchPhotosScreen: ScreenRoute("search_photos_screen")
  object PhotoDetailScreen: ScreenRoute("photo_detail_screen")
}
