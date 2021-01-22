package com.example.cameraxpractice

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.getBitmap
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class PictureViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_view)

//        intent.getParcelableExtra<Uri>("imageUri")

//        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
//        val bitmap = MediaStore.Images.Media.getBitmap()

        val imageUri = Uri.parse(intent.getStringExtra("imageUri"))
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageURI(imageUri)
    }
}