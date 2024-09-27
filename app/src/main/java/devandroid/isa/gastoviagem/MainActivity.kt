package devandroid.isa.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import devandroid.isa.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcular) {
            calcular()
        }
    }

    private fun isValid(): Boolean {
        return (binding.edtTxtDistancia.text.toString() != ""
                && binding.edtTxtPreco.text.toString() != ""
                && binding.edtTxtAutonomia.text.toString() != ""
                && binding.edtTxtAutonomia.text.toString().toFloat() != 0f

                )
    }

    private fun calcular() {
        if (binding.edtTxtDistancia.text.toString().isEmpty() ) {
            binding.edtTxtDistancia.setError("Não pode ser nulo")
        }

        if (isValid()) {
            val distance = binding.edtTxtDistancia.text.toString().toFloat()
            val preco = binding.edtTxtPreco.text.toString().toFloat()
            val autonomia = binding.edtTxtAutonomia.text.toString().toFloat()


            val valorTotal = (distance * preco) / autonomia

            binding.txtViewGastoValor.text = "R$ ${"%.2f".format(valorTotal)}"
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }



    }
}