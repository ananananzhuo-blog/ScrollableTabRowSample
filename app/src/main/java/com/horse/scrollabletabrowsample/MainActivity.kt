package com.horse.scrollabletabrowsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.horse.scrollabletabrowsample.ui.theme.ScrollableTabRowSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableTabRowSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val tabs = mutableListOf<String>(
        "安安安安卓",
        "鸿阳",
        "玉刚说",
        "成像魔影",
        "Android群英传",
        "code小生",
        "google开发者",
        "安安安安卓",
    )
    var selectIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "我是title") }, navigationIcon = {
            Icon(Icons.Default.ArrowBack, "")
        })
    }) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            ScrollableTabRow(
                selectedTabIndex = selectIndex,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                backgroundColor = Color(0xff098765),
                indicator = { positions ->//设置滑动条的属性，默认是白色的
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(positions[selectIndex]),
                        color = Color.Red
                    )
                },
                divider = {//设置底部的分割线
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.Cyan)) {

                    }
                }
            ) {
                tabs.forEachIndexed { index, data ->
                    Tab(
                        modifier = Modifier.fillMaxHeight(),//这里必须设置高度，否则会展示不正常
                        selected = index == selectIndex,
                        onClick = {
                            selectIndex = index
                        }) {
                        Text(text = tabs[index], style = TextStyle(color = Color.White))
                    }
                }
            }
        }
    }

}
