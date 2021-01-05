//package com.example.myapplication
//
//import android.content.Context
//import android.os.Environment
//import android.util.Log
//import androidx.work.Worker
//import androidx.work.WorkerParameters
//import java.io.File
//import java.io.IOException
//
//class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
//
////    companion object{
////        const val KEY_WORKER = "key_worker"
////    }
//
//    override fun doWork(): Result {
//        try {
////            val count = inputData.getInt(MainActivity.KEY_COUNT_VALUE,0)
////            File(Environment.getExternalStorageDirectory(), "text.txt").writeText("teststs")
//            Log.i("something","ok???????????")
////            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
////            val currentDate = time.format(Date())
////
////            val outPutData = Data.Builder()
////                .putString(KEY_WORKER,currentDate)
////                .build()
//            return Result.success()
//        } catch (e: Exception){
//            e.printStackTrace()
//            return Result.failure()
//        }
//    }
//}