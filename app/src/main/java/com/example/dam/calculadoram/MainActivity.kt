package com.example.dam.calculadoram

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Long.parseLong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orientation= resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            calcuH()
        }else{
            calcu()
        }

    }
    fun appendOnExpressionCalcu(string: String, Clear: Boolean) {

        if(Result.text.isNotEmpty()){
            Expression.text=""
        }

        if (Clear){
            Result.text = ""
            Expression.append(string)
        } else {
            Expression.append(Result.text)
            Expression.append(string)
            Result.text = ""
        }
    }

    var operacion = ""
    var calcula: Long=0
    var guarda=""
    var guarda2 = ""

    fun calcu(){
        Uno.setOnClickListener { appendOnExpressionCalcu(string = "1", Clear = true) }
        Dos.setOnClickListener { appendOnExpressionCalcu(string = "2", Clear = true) }
        Tres.setOnClickListener { appendOnExpressionCalcu(string = "3", Clear = true) }
        Cuatro.setOnClickListener { appendOnExpressionCalcu(string = "4", Clear = true) }
        Cinco.setOnClickListener { appendOnExpressionCalcu(string = "5", Clear = true) }
        Seis.setOnClickListener { appendOnExpressionCalcu(string = "6", Clear = true) }
        Siete.setOnClickListener { appendOnExpressionCalcu(string = "7", Clear = true) }
        Ocho.setOnClickListener { appendOnExpressionCalcu(string = "8", Clear = true) }
        Nueve.setOnClickListener { appendOnExpressionCalcu(string = "9", Clear = true) }
        Cero.setOnClickListener { appendOnExpressionCalcu(string = "0", Clear = true) }

        Clear.setOnClickListener { appendOnExpressionCalcu(string = "", Clear = false) }
        Memo.setOnClickListener { appendOnExpressionCalcu(string = "", Clear = false) }
        MemoMas.setOnClickListener { appendOnExpressionCalcu(string = "", Clear = false) }
        Div.setOnClickListener { appendOnExpressionCalcu(string = "/", Clear = false) }
        Por.setOnClickListener { appendOnExpressionCalcu(string = "*", Clear = false) }
        Mas.setOnClickListener { appendOnExpressionCalcu(string = "+", Clear = false) }
        Menos.setOnClickListener { appendOnExpressionCalcu(string = "-", Clear = false) }
        Borrar.setOnClickListener { appendOnExpressionCalcu(string = "", Clear = false) }
        Igual.setOnClickListener { appendOnExpressionCalcu(string = "", Clear = false) }
        Punto.setOnClickListener { appendOnExpressionCalcu(string = ".", Clear = false) }

        Clear.setOnClickListener{
            Expression.text=""
            Result.text=""
        }

        Borrar.setOnClickListener{
            val string = Expression.text.toString()
            if (string.isNotEmpty()){
                Expression.text = string.substring(0, string.length-1)
            }
            Result.text=""
        }

        Igual.setOnClickListener{
            try {
                val expression = ExpressionBuilder(Expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    Result.text = longResult.toString()
                } else {
                    Result.text = result.toString()
                }
            }catch(e:Exception){
                Log.d("Exception", "message : "+ e.message)
            }
        }

        var memoria: String = ""

        Memo.setOnClickListener {
            if(Expression.text.isNotEmpty()){
                memoria = Expression.text.toString()
            }else{
                Expression.setText(memoria)
            }

        }

        MemoMas.setOnClickListener{
            if(Expression.text.isNotEmpty()){
                Expression.setText(memoria + "+" + Expression.text.toString())
            }else{
                Expression.setText(memoria)
            }
        }
    }

    fun toHex (hex: String): Long{
        return parseLong(hex, 16)
    }



    fun calH(num1: Long, num2: Long) {
        when(operacion){

            "+" -> calcula=(num1+num2)
            "-" -> calcula=(num1-num2)
            "x" -> calcula=(num1*num2)
            "/" -> calcula=(num1/num2)

        }
        var hexString=java.lang.Long.toHexString(calcula)
        Expressionh.text= calcula.toString()
        Resulth.text = hexString.toUpperCase()
        guarda= Resulth.text.toString()
    }
    fun calcuH(){
        Ceroh.setOnClickListener() {
            guarda += "0"
            Expressionh.setText(guarda)
        }
        Unoh.setOnClickListener(){
            guarda+="1"
            Expressionh.setText(guarda)

        }
        Dosh.setOnClickListener(){
            guarda+="2"
            Expressionh.setText(guarda)

        }
        Tresh.setOnClickListener(){
            guarda+="3"
            Expressionh.setText(guarda)

        }
        Cuatroh.setOnClickListener(){
            guarda+="4"
            Expressionh.setText(guarda)

        }
        Cincoh.setOnClickListener(){
            guarda+="5"
            Expressionh.setText(guarda)

        }
        Seish.setOnClickListener(){
            guarda+="6"
            Expressionh.setText(guarda)

        }
        Sieteh.setOnClickListener(){
            guarda+="7"
            Expressionh.setText(guarda)

        }
        Ochoh.setOnClickListener(){
            guarda+="8"
            Expressionh.setText(guarda)

        }
        Nueveh.setOnClickListener(){
            guarda+="9"
            Expressionh.setText(guarda)

        }

        //Letras
        a.setOnClickListener(){
            guarda+="A"
            Expressionh.setText(guarda)

        }
        b.setOnClickListener(){
            guarda+="B"
            Expressionh.setText(guarda)

        }
        c.setOnClickListener(){
            guarda+="C"
            Expressionh.setText(guarda)

        }
        d.setOnClickListener(){
            guarda+="D"
            Expressionh.setText(guarda)

        }
        e.setOnClickListener(){
            guarda+="E"
            Expressionh.setText(guarda)

        }
        f.setOnClickListener(){
            guarda+="F"
            Expressionh.setText(guarda)
        }

        //Operaciones

        Mash.setOnClickListener(){
            operacion="+"
            guarda2 = guarda
            guarda=""
            Expressionh.text=guarda2+"+"
        }
        Menosh.setOnClickListener(){
            operacion="-"
            guarda2 = guarda
            guarda=""
            Resulth.text=guarda2+"-"
        }
        Porh.setOnClickListener(){
            operacion="*"
            guarda2 = guarda
            guarda=""
            Resulth.text=guarda2+"*"
        }
        Divh.setOnClickListener(){
            operacion="/"
            guarda2 = guarda
            guarda=""
            Resulth.text=guarda2+"/"
        }

        Clearh.setOnClickListener{
            Expressionh.text=""
            Resulth.text=""
            operacion = ""
            calcula = 0
            guarda=""
            guarda2 = ""
        }

        var memoriah: String = ""

        Memoh.setOnClickListener {
            if(Expressionh.text.isNotEmpty()){
                memoriah = Expressionh.text.toString()
            }else{
                Expressionh.setText(memoriah)
            }

        }

        MemoMash.setOnClickListener{
            guarda2=memoriah
            Resulth.text=guarda2+"+"
            operacion="+"
        }

        Borrarh.setOnClickListener{
            if(Expressionh.text.toString()==""){
                guarda=""
                Expressionh.setText(guarda)
            }else{
                var borrarHex=Expressionh.text
                val ultimo=borrarHex.length
                var borrado=borrarHex.substring(0,ultimo-1)
                guarda=borrado
                Expressionh.setText(guarda)
            }
        }

        Igualh.setOnClickListener(){
            if(guarda2=="") guarda2="0"
            try {
                calH(toHex(guarda2),toHex(guarda))
            }catch (e: ArithmeticException){
                Resulth.text="Indeterminación"
            }
        }

    }
}



