package keyforge.counter.android.core.helper

import androidx.work.*
import kotlin.reflect.KClass


open class WorkScheduler(private val workManager: WorkManager) {

    fun <WorkerType : ListenableWorker> canEnqueueOneTimeWorker(
        worker: KClass<WorkerType>,
        data: Data? = null,
        tag: String = worker.java.name
    ) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val work = OneTimeWorkRequest.Builder(worker.java)
            .addTag(tag)
            .setConstraints(constraints)

        data?.let {
            work.setInputData(it)
        }

        workManager.enqueueUniqueWork(tag, ExistingWorkPolicy.KEEP, work.build())
    }

//    private fun isNetworkAvailable(): Boolean {
//        val connectivityManager =
//            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
//        val nw = connectivityManager.activeNetwork ?: return false
//        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
//
//        return when {
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            else -> true
//        }
//    }

}
