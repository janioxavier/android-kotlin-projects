package com.example.asynctaskexample

import android.os.AsyncTask
import android.widget.Button
import android.widget.TextView

class CounterTask(val btn : Button, val txtView: TextView) : AsyncTask<Int, Int, Unit>() {

    override fun onPreExecute() {
        super.onPreExecute()
        btn.isEnabled = false
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        btn.isEnabled = true
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        val contador = values[0]

        txtView.text = contador.toString()
    }

    override fun doInBackground(vararg params: Int?) {
        var max = params[0]!!

        for (i in 0..max) {
            Thread.sleep(500)
            publishProgress(i)
        }
    }

}