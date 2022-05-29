package keyforge.counter.android.core.callAdapter

import keyforge.counter.android.core.wrapper.Resource
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * @author Marcelo Esser
 * @author marcelo.v.esser@gmail.com
 *
 * @location Rio Grande do Sul, Brazil
 * @since 06/05/22
 */

class CallAdapter<T>(
    private val responseType: Type
) : CallAdapter<T, Call<Resource<T>>> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<T>): Call<Resource<T>> {
        return ResourceCall(call)
    }

}