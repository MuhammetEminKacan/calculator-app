package com.emin.kacan.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import com.emin.kacan.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

     fun btnTik(view: View){

         if (yeniOperator){
             binding.islemGoruntuleme?.setText("")
         }
         yeniOperator = false

         var btnSec = view as Button
         var btnTikDeger : String = binding.islemGoruntuleme?.text.toString()

         when(btnSec.id){
            binding.sayi00Btn?.id ->{
                btnTikDeger += "00"
            }
            binding.sayi0Btn?.id ->{
                 btnTikDeger += "0"
             }
            binding.noktaBtn?.id ->{
                 btnTikDeger += "."
             }
            binding.sayi1Btn?.id ->{
                 btnTikDeger += "1"
             }
            binding.sayi2Btn?.id ->{
                 btnTikDeger += "2"
             }
             binding.sayi3Btn?.id ->{
                 btnTikDeger += "3"
             }
             binding.sayi4Btn?.id ->{
                 btnTikDeger += "4"
             }
             binding.sayi5Btn?.id ->{
                 btnTikDeger += "5"
             }
             binding.sayi6Btn?.id ->{
                 btnTikDeger += "6"
             }
             binding.sayi7Btn?.id ->{
                 btnTikDeger += "7"
             }
             binding.sayi8Btn?.id ->{
                 btnTikDeger += "8"
             }
             binding.sayi9Btn?.id ->{
                 btnTikDeger += "9"
             }
             binding.negatifBtn?.id ->{
                 btnTikDeger="-"+btnTikDeger
             }

         }
         binding.islemGoruntuleme?.setText(btnTikDeger)
     }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true
    fun btnIslemler(view:View){
        var btnSec = view as Button
        when(btnSec.id){

            binding.bolmeBtn?.id -> {
                operator = "/"
            }
            binding.carpmaBtn?.id -> {
                operator = "X"
            }
            binding.toplamaBtn?.id -> {
                operator = "+"
            }
            binding.cikarmaBtn?.id -> {
                operator = "-"
            }
        }
        eskiSayi = binding.islemGoruntuleme?.text.toString()
        yeniOperator = true
    }

    fun btnSonuc(view:View){
        var yeniSayi = binding.islemGoruntuleme?.text.toString()
        var sonucSayisi:Double?=null
        when(operator){
            "/" -> {
                sonucSayisi = eskiSayi.toDouble()/yeniSayi.toDouble()
            }
            "X" -> {
                sonucSayisi = eskiSayi.toDouble()*yeniSayi.toDouble()
            }
            "-" -> {
                sonucSayisi = eskiSayi.toDouble()-yeniSayi.toDouble()
            }
            "+" -> {
                sonucSayisi = eskiSayi.toDouble()+yeniSayi.toDouble()
            }
        }
        if (sonucSayisi!! % 1.0 == 0.0) {
            binding.islemGoruntuleme.setText(sonucSayisi.toInt().toString())
            yeniOperator = true
        }else{
            binding.islemGoruntuleme.setText(sonucSayisi.toString())
            yeniOperator = true
        }



    }

    fun btnSil(view: View){
        binding.islemGoruntuleme?.setText("0")
        yeniOperator = true
    }

    fun btnYuzde(view: View){
        var yuzde :Double = binding.islemGoruntuleme?.text.toString().toDouble()/100
        binding.islemGoruntuleme?.setText(yuzde.toString())
        yeniOperator = true
    }

}