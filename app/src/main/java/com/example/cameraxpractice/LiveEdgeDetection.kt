package com.example.cameraxpractice

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import info.hannes.liveedgedetection.ScanConstants.IMAGE_NAME
import info.hannes.liveedgedetection.ScanConstants.SCANNED_RESULT
import info.hannes.liveedgedetection.activity.ScanActivity
import info.hannes.liveedgedetection.utils.*
import kotlinx.android.synthetic.main.activity_live_edge_detection.*
import java.io.File


class LiveEdgeDetection : AppCompatActivity() {
    private var filePath: String? = null

    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_edge_detection)

        startActivityForResult(Intent(this, ScanActivity::class.java), REQUEST_CODE)
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode,resultCode,data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) data?.extras?.let { bundle ->
                filePath = data.getStringExtra(SCANNED_RESULT)
                Log.i("FILEPATH", filePath.toString())
                filePath?.let {
                    val baseBitmap = it.decodeBitmapFromFile()
                    scanned_image.setImageBitmap(baseBitmap)
                    scanned_image.scaleType = ImageView.ScaleType.FIT_CENTER
                }
            }else if (resultCode == Activity.RESULT_CANCELED) {
                finish()
            }
        }
    }
}


//    }
//    private fun showSnackbar(text: String) {
//        var viewPos: View = findViewById<View>(R.id.coordinatorLayout)
//        if (viewPos == null) {
//            viewPos = findViewById(android.R.id.content)
//        }
//        val snackbar = Snackbar.make(viewPos!!, text, Snackbar.LENGTH_INDEFINITE)
//        val view = snackbar.view
//        when (val params = view.layoutParams) {
//            is CoordinatorLayout.LayoutParams -> {
//                val paramsC = view.layoutParams as CoordinatorLayout.LayoutParams
//                paramsC.gravity = Gravity.CENTER_VERTICAL
//                view.layoutParams = paramsC
//                snackbar.show()
//            }
//            is FrameLayout.LayoutParams -> {
//                val paramsC = view.layoutParams as FrameLayout.LayoutParams
//                paramsC.gravity = Gravity.BOTTOM
//                view.layoutParams = paramsC
//                snackbar.show()
//            }
//            else -> {
//                Toast.makeText(this, text + " " + params.javaClass.simpleName, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


