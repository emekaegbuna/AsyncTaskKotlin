package com.example.asynctaskkotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class FirstAsyncActivity : AppCompatActivity() {



    private var name: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = intent

        name = intent.getStringExtra(Constants.NAME)
        Log.d("Textlength ", ""+name)

        AsyncTask(name.toString()).execute()


    }

   inner class AsyncTask(nameNew: String) : android.os.AsyncTask<String,Void,String>(){

       var nameNew = name

       override fun onPreExecute() {
            super.onPreExecute()
            pb_and_j.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: String?): String {

            Thread.sleep(3000)

          //  Log.d("Textlength ", ""+p0)

            var name_len: String = nameNew.toString()
            Log.d("Textlength ", ""+name_len)

            return name_len.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            pb_and_j.visibility = View.GONE
            intent.putExtra(Constants.NAME, result)
            setResult(Activity.RESULT_OK, intent)
            finish()


        }

    }
}
