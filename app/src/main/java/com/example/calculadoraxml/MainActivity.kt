package com.example.calculadoraxml

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        // Encontrar el TextView y los botones en el layout
        textView = findViewById(R.id.textView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val buttonAC: Button = findViewById(R.id.buttonAC)
        val buttonC: Button = findViewById(R.id.buttonC)
        val buttonComa: Button = findViewById(R.id.buttonComa)
        val buttonDividir: Button = findViewById(R.id.buttonDividir)
        val buttonRestar: Button = findViewById(R.id.buttonRestar)
        val buttonMultiplicar: Button = findViewById(R.id.buttonMultiplicar)
        val buttonSumar: Button = findViewById(R.id.buttonSumar)
        val buttonIgual: Button = findViewById(R.id.buttonIgual)

        // Configura los listeners para cada botón
        button1.setOnClickListener { appendToTextView(button1.text) }
        button2.setOnClickListener { appendToTextView(button2.text) }
        button3.setOnClickListener { appendToTextView(button3.text) }
        button4.setOnClickListener { appendToTextView(button4.text) }
        button5.setOnClickListener { appendToTextView(button5.text) }
        button6.setOnClickListener { appendToTextView(button6.text) }
        button7.setOnClickListener { appendToTextView(button7.text) }
        button8.setOnClickListener { appendToTextView(button8.text) }
        button9.setOnClickListener { appendToTextView(button9.text) }
        button0.setOnClickListener { appendToTextView(button0.text) }
        buttonAC.setOnClickListener { textView.text = "" } // Limpia el texto
        buttonC.setOnClickListener { // Elimina el último carácter
            val currentText = textView.text.toString()
            if (currentText.isNotEmpty()) {
                textView.text = currentText.dropLast(1)
            }
        }
        buttonComa.setOnClickListener { appendToTextView(buttonComa.text) }
        buttonDividir.setOnClickListener { appendToTextView(buttonDividir.text) }
        buttonRestar.setOnClickListener { appendToTextView(buttonRestar.text) }
        buttonMultiplicar.setOnClickListener { appendToTextView(buttonMultiplicar.text) }
        buttonSumar.setOnClickListener { appendToTextView(buttonSumar.text) }
        buttonIgual.setOnClickListener {
            // Aquí puedes implementar la lógica para evaluar la expresión matemática si lo deseas
            // Por ahora, solo añadimos el texto al TextView
            appendToTextView(buttonIgual.text)
        }

        // Manejo de los insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun appendToTextView(text: CharSequence) {
        textView.append(text)
    }

    fun enableEdgeToEdge() {
        // Implementa aquí tu código para habilitar el modo Edge-to-Edge si es necesario
    }

}
