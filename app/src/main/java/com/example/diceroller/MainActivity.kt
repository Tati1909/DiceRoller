package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

            //создаем кубик и делаем бросок для отображения кубика в главном окне
        rollDice()
    }

    private fun rollDice() {
        // создаем кубик с 6 сторонами
        val dice = Dice(6)
        // значение нашего броска
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        //в переменную drawableResource возвращается значение нашего броска diceRoll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//Обновляем ImageView с правильным идентификатором доступного ресурса
        diceImage.setImageResource(drawableResource)

        // Обновляем описание картинки для слабовидящих
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}