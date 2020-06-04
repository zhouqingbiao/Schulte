package com.zhouqingbiao.schulte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.time.ExperimentalTime
import kotlin.time.nanoseconds

class Schulte4X4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schulte4_x4)
        // 初始化随机显示方格内数字
        randomSchulte()
    }

    // 方格ID
    private val schultes = listOf(
        R.id.schulte4x4_1,
        R.id.schulte4x4_2,
        R.id.schulte4x4_3,
        R.id.schulte4x4_4,
        R.id.schulte4x4_5,
        R.id.schulte4x4_6,
        R.id.schulte4x4_7,
        R.id.schulte4x4_8,
        R.id.schulte4x4_9,
        R.id.schulte4x4_10,
        R.id.schulte4x4_11,
        R.id.schulte4x4_12,
        R.id.schulte4x4_13,
        R.id.schulte4x4_14,
        R.id.schulte4x4_15,
        R.id.schulte4x4_16
    )

    // 方格数字
    private val strings = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16"
    )

    // 响应按钮初始化
    fun randomSchulte(view: View) {
        var tempsSchulte = schultes.toMutableList()
        var tempsString = strings.toMutableList()

        for (i in 1..schultes.size) {
            var schulte = tempsSchulte.random()
            var string = tempsString.random()

            findViewById<Button>(schulte).text = string

            tempsSchulte.remove(schulte)
            tempsString.remove(string)
        }
    }

    // onCreate初始化
    private fun randomSchulte() {
        var tempsSchulte = schultes.toMutableList()
        var tempsString = strings.toMutableList()
        for (i in 1..schultes.size) {
            var schulte = tempsSchulte.random()
            var string = tempsString.random()

            findViewById<Button>(schulte).text = string

            tempsSchulte.remove(schulte)
            tempsString.remove(string)
        }
    }

    // 定义时间列表
    val times = mutableListOf<Double>()

    // 响应开始按钮
    fun start(view: View) {
        // 清空时间列表
        times.clear()
        // 默认添加当前时间
        times.add(System.nanoTime().toDouble())
        // 点击按钮后状态变更为false
        view.isEnabled = false
        // 清空时间结果
        findViewById<TextView>(R.id.result4x4).text = ""
    }

    // 响应数字按钮
    @ExperimentalTime
    fun calcTime(view: View) {
        var button = findViewById<Button>(view.id)
        var result = findViewById<TextView>(R.id.result4x4)

        // 如果按钮数字和时间列表相等则合法
        if (times.size.toString() == button.text) {
            times.add(System.nanoTime().toDouble())
            // result.append(
                // button.text as String + "-->" + (times.last() - times[times.size - 2]).nanoseconds + "\t\t"
            // )
            // 如果时间列表大小和方格列表大小一致则结束
            if (times.size == schultes.size + 1) {
                // result.append("\n")
                // result.append("total-->" + (times.last() - times[0]).nanoseconds)
                result.append((times.last() - times[0]).nanoseconds.toString())
                randomSchulte()
            }
        }
    }
}