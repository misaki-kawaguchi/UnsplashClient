package com.example.unsplashclient.common

// 通信状態を表現する時に使う
sealed class NetworkResponse<T>(
  val data: T? = null,
  val error: String? = null,
) {
  class Success<T>(data: T) : NetworkResponse<T>(data = data)
  class Failure<T>(error: String) : NetworkResponse<T>(error = error)
  class Loading<T> : NetworkResponse<T>()
}
