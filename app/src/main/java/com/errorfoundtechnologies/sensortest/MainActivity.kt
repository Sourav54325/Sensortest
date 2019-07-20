package com.errorfoundtechnologies.sensortest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sManager: SensorManager = getSystemService(
                Context.SENSOR_SERVICE) as SensorManager
        val s: Sensor = sManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY)
        sManager.registerListener(
                object: SensorEventListener {

                    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

                    }
                    override fun onSensorChanged(p0: SensorEvent?) {
                        proximity_id1.text = ("Proximity Value : "+p0!!.values[0])
                    }
                },s,SensorManager.SENSOR_DELAY_NORMAL)


        var t: Sensor = sManager.getDefaultSensor(
                Sensor.TYPE_LIGHT)
         sManager.registerListener(
                object : SensorEventListener {
                    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

                    }

                    override fun onSensorChanged(p0: SensorEvent?) {
                        light_id1.text = ("Light sensor Value : " + p0!!.values[0])

                    }
                }, t, SensorManager.SENSOR_DELAY_NORMAL)


        var u: Sensor = sManager.getDefaultSensor(
                Sensor.TYPE_GRAVITY)
        sManager.registerListener(
                object: SensorEventListener {
                    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

                    }
                    override fun onSensorChanged(p0: SensorEvent?) {
                        gravity_id1.text =("gravity X Value : "+p0!!.values[0])
                        gravity_id2.text =(" gravity Y Value :"+p0!!.values[0])
                    }
                },u,SensorManager.SENSOR_DELAY_NORMAL)


    }
}
