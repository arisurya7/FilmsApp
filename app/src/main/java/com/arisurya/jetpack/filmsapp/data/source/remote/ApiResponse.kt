package com.arisurya.jetpack.filmsapp.data.source.remote

<<<<<<< HEAD
@Suppress("unused")
=======
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

<<<<<<< HEAD
        fun <T> empty(msg: String, body: T): ApiResponse<T> =
            ApiResponse(StatusResponse.EMPTY, body, msg)

        fun <T> error(msg: String, body: T): ApiResponse<T> =
            ApiResponse(StatusResponse.ERROR, body, msg)
=======
        fun <T> empty(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.EMPTY, body, msg)

        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, body, msg)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
    }
}