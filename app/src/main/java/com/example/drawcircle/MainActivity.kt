package com.example.drawcircle

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style.STROKE
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  bitmap width and height
        val bitmap = Bitmap.createBitmap(1400, 2000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        //   canvas.drawARGB(255, 78, 168, 186)
        canvas.drawARGB(255, 242, 185, 170)


        var paint = Paint()
        paint.setColor(Color.parseColor("#FFFFFF"))
        //  paint.setStrokeWidth(1F)
        //  paint.setStyle(STROKE)
        paint.setAntiAlias(true)
        paint.setDither(true)

        //   get device dimensions
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        //  circle center
        Log.i("Width : " + displayMetrics.widthPixels, "Circle Position X")
        Log.i("Height : " + displayMetrics.heightPixels, "Circle Position Y")
        Log.i("2*Width : " + 2*displayMetrics.widthPixels, "Circle Position X")
        Log.i("Height/2 : " + displayMetrics.heightPixels/2, "Circle Position Y")

        /*var center_x = 1800F
        var center_y = 310F*/

        //  x-axis
        var center_x = 2*(displayMetrics.widthPixels).toFloat()

        //  y-axis
        var center_y = (displayMetrics.heightPixels/6).toFloat()

        //  size of circle
        var radius = 150F

        // draw circle
        canvas.drawCircle(center_x, center_y, radius, paint)
        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imageV.background = BitmapDrawable(getResources(), bitmap)
        }
    }
}
