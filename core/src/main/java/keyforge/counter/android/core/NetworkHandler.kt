package keyforge.counter.android.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import keyforge.counter.android.core.callAdapter.CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Marcelo Esser
 * @author marcelo.v.esser@gmail.com
 *
 * @location Rio Grande do Sul, Brazil
 * @since 06/05/22
 */


object NetworkHandler {
    //http://localhost:5000
    private const val baseUrl: String =
        "http://10.0.2.2:5004/esser-marcelo-keyforge-counter/us-central1/api/"

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gsonBuilder()))
        .addCallAdapterFactory(CallAdapterFactory())
        .client(httpClient())
        .baseUrl(baseUrl)
        .build()

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun gsonBuilder(): Gson {
        return GsonBuilder()
            .disableHtmlEscaping()
            .setLenient().create()
    }

    private fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    }
}