package edu.temple.helloworld


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonGreet = findViewById<Button>(R.id.buttonGreet)
        val textMessage = findViewById<TextView>(R.id.textMessage)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val numberArray = Array(10){((it + 1) * 5)}

        // Remove default text
        textMessage.text = ""

        with(spinner) {
            adapter = TextSizeAdapter(this@MainActivity, numberArray)
            onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    parent?.run {
                        textMessage.textSize = getItemAtPosition(position).toString().toFloat()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Handle case when nothing is selected if needed
                }
            }
        }

        buttonGreet.setOnClickListener {
            val name = editTextName.text.toString()
            if (name.isNotEmpty()) {
                textMessage.text = getString(R.string.hello, name)
            } else {
                textMessage.text = getString(R.string.enter_name) // Ensure this string resource is correct
            }
        }
    }
}