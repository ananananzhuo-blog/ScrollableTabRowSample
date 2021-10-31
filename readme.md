## 概述
ScrollableTabRow就相当于以前开发中使用的TabLayout。

## 属性介绍
1. selectedTabIndex 当前选择的item的索引
2. backgroundColor背景颜色
3. indicator导航条的样式
4. divider 分割线属性
5. Tab用于实现单条的item

## 简单实现
### 代码
```
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

```
### 效果


![](https://files.mdnice.com/user/15648/858bcd1f-dd86-464e-bd26-cd9c3ba0539c.png)

