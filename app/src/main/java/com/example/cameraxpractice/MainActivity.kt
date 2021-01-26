package com.example.cameraxpractice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cameraxpractice.R.string.app_name
import kotlinx.android.synthetic.main.activity_camera_x.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

typealias ImageListener = (imageProxy: ImageProxy) -> Unit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun goToCameraX(view: View){
        val intent = Intent(this,CameraX::class.java)
        startActivity(intent)
    }

    fun goToLiveED(view: View){
        val intent = Intent(this,LiveEdgeDetection::class.java)
        startActivity(intent)
    }


}