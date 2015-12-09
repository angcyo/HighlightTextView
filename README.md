# HighlightTextView
局部高亮的TextView,可以设置高亮字符开始的位置,高亮字符的个数,高亮字符的颜色

##项目说明
```
highlighttextview  为库项目
sample             示例项目
```
##使用方法
```
下载项目
compile project(':highlighttextview')
```

##xml可用属性
```xml
app:highlight_position="4"                  高亮开始的位置
app:highlight_num="3"                       高亮的个数
app:highlight_color="@color/colorAccent"    高亮的颜色
```

##可用方法
```java
highlightTextView.setHighlightPosition(2);
highlightTextView.setHighlightNum(3);
highlightTextView.setHighlightColor(Color.MAGENTA);
```
