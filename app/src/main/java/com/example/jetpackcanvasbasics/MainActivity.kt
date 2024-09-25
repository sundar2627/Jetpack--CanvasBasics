package com.example.jetpackcanvasbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcanvasbasics.ui.theme.JetpackCanvasBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCanvasBasicsTheme {
                CanvasUI()
            }
        }
    }
}

@Composable
fun CanvasUI() {


  Canvas(Modifier.fillMaxWidth()
      .height(700.dp)
      .padding(50.dp)
      .background(Color.Blue)) {

      val width = size.width
      val height =size.height

      val recWidth = 60.dp.toPx()
      val recHeight = 60.dp.toPx()

      drawRect(color = Color.Yellow,
          size = Size(recWidth,recHeight),
          topLeft = Offset(
              x= (width-recWidth)/2,
              y = (height - recHeight) /2
          )
      )

      drawCircle(brush = Brush.verticalGradient
          (listOf(Color.Yellow,Color.Red,Color.Cyan)),
                  center = Offset(
                      x=width/2,
                      y=60.dp.toPx() + 30.dp.toPx()),
          radius = 60.dp.toPx()
                  )


     /* val trianglePath = Path().apply {

          moveTo(width/2, height -100.dp.toPx())  // starting position set to pen

          lineTo((width/2)-100.dp.toPx(),height-100.dp.toPx())
          lineTo((width/2)+50.dp.toPx(),height-60.dp.toPx())
          lineTo((width/2),height-100.dp.toPx())

           drawPath(path = trianglePath, color = Color.Green)

      }*/


/*      val reverseTrianglePath = Path().apply {

          moveTo(width/2, height - 30.dp.toPx())  // starting position set to pen

          lineTo((width/2)+100.dp.toPx(),height-100.dp.toPx())
          lineTo((width/2)-100.dp.toPx(),height-100.dp.toPx())
          lineTo((width/2),height-30.dp.toPx())
      }
      drawPath(path = reverseTrianglePath, color = Color.Green)*/

      val sideTrianglePath = Path().apply {

          moveTo(width/2-width/4, height - 200.dp.toPx())  // starting position set to pen

          lineTo((width/2)-50.dp.toPx(),height/2+200.dp.toPx())
          lineTo((width/2)-50.dp.toPx(),height-300.dp.toPx())
          lineTo(width/2-width/4,height-200.dp.toPx())
      }

      drawPath(path = sideTrianglePath, color = Color.Green)


      drawArc(color = Color.Green, startAngle = 0f,
          sweepAngle = 45f,
          useCenter = true,  //for center reference if false then not correct look
          topLeft = Offset(100f,600f),
          size = Size(200f,200f),
          style = Stroke(width=3.dp.toPx())   //if need only stroke then add
      )

      drawOval(color = Color.Magenta,
          topLeft = Offset(500f,450f),
          size = Size(200f,300f)
      )
      drawLine(color = Color.Green,
          start = Offset(width/2 + 100.dp.toPx(),300f),
          end = Offset( width/2 + 150.dp.toPx(),300f),
          strokeWidth = 5.dp.toPx()
      )




  }

}
