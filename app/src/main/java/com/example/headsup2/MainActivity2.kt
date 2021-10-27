package com.example.headsup2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var tv1:EditText
    lateinit var tv2:EditText
    lateinit var tv3:EditText
    lateinit var tv4:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        tv3=findViewById(R.id.tv3)
        tv4=findViewById(R.id.tv4)


        var but=findViewById<Button>(R.id.button)
        but.setOnClickListener {
            var name=tv1.text.toString()
            var taboo1=tv2.text.toString()
            var taboo2=tv3.text.toString()
            var taboo3=tv4.text.toString()
            val dbh = DBHelper(applicationContext)
            val status = dbh.saveData(name,taboo1,taboo2,taboo3)
            if(status>0) {
                Toast.makeText(applicationContext, "data is served", Toast.LENGTH_LONG)
                    .show()
            }else if (status<0){
                Toast.makeText(applicationContext, "fail to serve", Toast.LENGTH_LONG)

            }
        }



    }
}