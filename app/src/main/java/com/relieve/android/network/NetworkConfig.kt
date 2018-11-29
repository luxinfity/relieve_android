package com.relieve.android.network

private const val BASE_URL = "http://35.240.181.2"
private const val SUCCESS_REQEUST_STATUS = 200

fun Int.isRequestSuccess () = this == SUCCESS_REQEUST_STATUS

object Camar {
    private const val PATH = "v1"

    const val URL = "$BASE_URL/$PATH/"
}

object Bakau {
    private const val PATH = "v2"
    const val URL = "$BASE_URL/$PATH/"

    const val HEADER_SECRET = "secret"
    const val SECRET = "YTvZ3kG9X9Vz6MLHdNIwnaTefjs2Udph"
}