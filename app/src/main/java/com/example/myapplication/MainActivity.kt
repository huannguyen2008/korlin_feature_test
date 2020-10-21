package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            setOneTimeWorkRequest()
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setOneTimeWorkRequest() {

        val workManager = WorkManager.getInstance(applicationContext)

//        val data: Data = Data.Builder()
//                .putInt(KEY_COUNT_VALUE,125)
//                .build()
        val constraints = Constraints.Builder()
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(true)
//                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
//
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
                .setInitialDelay(10,TimeUnit.HOURS)
                .setConstraints(constraints)
//                .setInputData(data)
                .build()

//        val filteringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
//                .build()
//        val compressingRequest= OneTimeWorkRequest.Builder(CompressingWorker::class.java)
//                .build()
//        val downloadingWorker= OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
//                .build()
//        val paralleWorks = mutableListOf<OneTimeWorkRequest>()
//        paralleWorks.add(downloadingWorker)
//        paralleWorks.add(filteringRequest)
        workManager
//                .beginWith(paralleWorks)
//                .then(compressingRequest)
//                .then(uploadRequest)
                .enqueue(uploadRequest)

        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
                .observe(this, Observer {
                    findViewById<TextView>(R.id.text_view).text = it.state.name
//                    if(it.state.isFinished){
//                        val data = it.outputData
//                        val message = data.getString(UploadWorker.KEY_WORKER)
//                        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
//                    }
                })


    }

}
