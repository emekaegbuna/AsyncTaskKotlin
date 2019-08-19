package com.example.asynctaskkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {

        var name: String?
        name = et_sort_data.text.toString()

        when(p0!!.id){
            R.id.btn_main_async ->{
                intent = Intent(this, FirstAsyncActivity::class.java)
            }

            R.id.btn_second_async ->{
                intent = Intent(this, SecondAsyncActivity::class.java)
            }

            R.id.btn_third_async ->{
                intent = Intent(this, ThirdAsyncActivity::class.java)
            }

            R.id.btn_last_async ->{
                intent = Intent(this, LastAsyncActivity::class.java)
            }
        }

        intent.putExtra(Constants.NAME, name)
        startActivityForResult(intent, 1)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_async.setOnClickListener(this)
        btn_second_async.setOnClickListener(this)
        btn_third_async.setOnClickListener(this)
        btn_last_async.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){

                tv_main.text = data?.getStringExtra(Constants.NAME)



            }
        }
    }



}
