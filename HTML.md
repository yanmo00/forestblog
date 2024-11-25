# 前言

## **1.网页**

### **①定义**：

超文本**标记**语言——描述网页的语言，由标签组成

### **②网页**：

图片，文字，链接，声音，视频等元素组成，其实就是个**HTML文件**



## 2.常用浏览器

**IE Firefox Chrome Safari Opera**

## 3.Web标准

**1.定义：**W3C提出的一系列标准的集合

**2.优点：**更标准

**3.构成：**

**①结构**：网页元素的整理与分类——HTML

**②样式:**外观的版式，颜色，大小——CSS

**③行为:**交互——JavaScript

**4.最佳体验方案：**构成三部分相分离 译为 结构写到HTML文件，表现写到CSS文件，行为写到JavaScript

**注：结构（HTML）最重要**

## 4.HTML的语法规范

**1.类型**：双标签：开始标签:<html>,结束标签</html>；单标签：<br/>

**2.基本语法规范**：HTML标签是由尖括号包围的关键词，例如<html>

3.**双标签关系**：包含与并列

```html
## 包含关系
<head>
    <title></title>
</head>
## 并列关系
<head> </head>
<body> </body>
```



# HTML标签

## 1.结构标签

### ①html：根标签

```html
<html></html>
```



### ②head：头部标签

#### **1.<!DOCTYPE>：**声明标签

##### 文档类型声明，告诉浏览器使用哪种HTML版本来显示页面

```html
<!DOCTYPE html>
<!-- 这句代码的意思是:当前页面采取的是HTML5版本来显示网页. -->
```



#### **2.lang:**语言标签

语言种类,不妨碍文档英文或者中文的书写

对浏览器和搜索引擎有用

```html
<html lang="zh-CH">
```



**注：若标为x语网页，会进行自动翻译**



#### **3.charset**:

字符集，以便计算机能够识别和存储各种文字

在head标签内，可以通过<meta>标签的charset规定HTML应该用哪种字符编码

```HTML
<meta charset="UTF-8"/>
```

常用：GB2312(简体中文)，BIG5(繁体中文)，GBK(简/繁)，

​			**UTF-8——万国码**——**防止乱码！！**

#### 4.title:标题标签

```html
<title></title>
```



#### 5.总结

```html
以上三个代码vscode 自动生成基本不需要我们重写.
<!DOCTYPE html>文档类型声明标签, 告诉浏览器这个页面采取html 5版本来显示页面.
<html lang= "en” >告诉浏览器或者搜索引擎这是一个英文网站 本页面采取英文来显示
<meta charset="UTF-8" />必须写.采取UTF-8来保存文字.如果不写就会乱码.具体原理后面分析.

 注意：在head标签中，必须要设置的标签是title
```

### ③body:主体标签

```html
<body></body>
```

## 2.常用标签

### 文本标签

#### 1.标题标签:<h1>  <h6>

#### 2.段落标签：<p> </p>

#### 3.换行标签：<br />

#### 4.文本格式化标签：

①加粗：<strong></strong>（优先）或<b></b>

②倾斜：<em></em>（优先）或<i></i>

③删除线：<del></del>（优先）或<s></s>

④下划线： <ins></ins>（优先）或者<u></u>

#### 5.盒子

div：division，分区,布局，一行只能放一个<div>,大盒子

span：跨度,行中分隔，一行可以多个<span>,小盒子

#### 6.图像标签：



 ```html
 <img src="图像URL" /> (前提：图片在该文件夹内)
 <img src="图像URL" alt="xxx" />
 ```



| 属性   | 属性值   | 说明                                 |
| ------ | -------- | ------------------------------------ |
| src    | 图片路径 | 必须属性                             |
| alt    | 文本     | 替换文本。图像不能显示的文字         |
| title  | 文本     | 提示文本。鼠标放到图像上，显示的文字 |
| width  | 像素     | 设置图像的宽度                       |
| height | 像素     | 设置图像的高度                       |
| border | 像素     | 设置图像的边框粗细                   |



##### 图像路径：

###### 概念

①目录文件夹：普通文件夹，放素材的，如：html文件，图片

②根目录：打开目录文件夹的第一层就是根目录

###### 类型

①相对路径：图片相对于HTML页面的位置

![image-20230923103555775](https://minio-api.amjacks.cn/hjs/image-20230923103555775.png)

两个点一个杠上溯一级目录，再来一次就在上溯一级 

②绝对路径：盘符/网址

#### 7.超链接标签

```html
<a href="跳转目标" target="目标窗口的弹出模式">  文本或图像 </a>	
```



##### ①外部链接:

target：打开窗口的方式；

​			 _ self——当前窗口打开页面（默认值）

  		   _blank——新窗口打开页面

```html
<a href="https://www.bilibili.com/"target="_blank">bilibili</a>
```



##### ②内部链接：

```html
<a href="html/test/test.html" target="_blank">测试</a>
```



##### ③空链接：

```html
<a href="#" target="_blank">空</a>
```

##### ④下载链接：

如果href里面地址是一个文件或者压缩包， 会下载这个文件。

```html
<a href="xxx.zip" target="_blank">下载地址</a>
```

##### ⑤网页元素链接：

在网页中的各种网页元素	，如文本、图像等都可以添加超链接

```html
<a href="网址" target="_blank"><img src="xxxx.png" /></a>
```

##### ⑥锚点链接：

点链接时候，快速定位到页面中某个位置

●在链接文本的href属性中,设置属性值为#名字的形式

```html
<a href="#two">第2集</a>
```

 ●找到目标位置标签,里面添加一一个id属性=刚才的名字

```html
<h3 id="two" >第2集介绍</h3>
```

#### 8.注释标签	

```html
<!-- 快捷键:ctrl + / -->
```

#### 9.特殊字符：

| 特殊字符 | 描述   | 代码（英文分号） |
| -------- | ------ | ---------------- |
| &nbsp;   | 空格符 | &nbsp；          |
| <        | 小于号 | &lt；            |
| >        | 大于号 | &gt；            |


其余的使用很少,如果需要回头查阅即可



### 表格标签

#### 1.表格框架标签

&lt;table&gt; ：表格标签

&lt;  tr &gt; ：表行

&lt; td &gt; ：单元格

&lt; th &gt; ：表头标签（居中加粗）

#### 2.表格属性标签

cellpadding：文字与单元格的距离

cellspacing：单元格与单元格的距离

```html
<table>
    <tr>
        <td>单元格内的文字</td>
    </tr>
</table>
<!-- 
①<table></table>是用于定义表格的标签。

②<tr></tr>标签用于定义表格中的行，必须嵌套在<table></table>标签中

③<td></td>用于定义表格中的单元格，必须嵌套在<tr></tr>标签中

④字母td指表格数据，即数据单元格的内容
-->
```

| 属性名      | 属性值              | 描述                                             |
| ----------- | ------------------- | ------------------------------------------------ |
| align       | left、center、right | 规定表格相对周围元素的对齐方式                   |
| border      | 1或""               | 规定表格单元是否拥有边框，默认为“”，表示没有边框 |
| cellpadding | 像素值              | 规定单元边沿与其内容之间的空白，默认1像素        |
| width       | 像素值或百分比      | 规定表格的宽度                                   |



#### 3.表格的结构标签：

<thead></thead>：用于定义表格的头部。<thead> 内部必须拥有<tr>标签。一般是位于第一行

<tbody></tbody>：用于定义表格的主体,主要用于放数据本体。

注：以上标签都是放在<table> </table>标签中。



#### 4.合并单元格

##### 类型

跨行合并:rowspan="合并单元格个数"

跨列合并:colspan="合并单元格个数"

##### 目标单元格: (写合并代码)

●跨行:最上侧单元格为目标单元格，写合并代码

●跨列:最左侧单元格为目标单元格，写合并代码

##### 合并单元格三步曲:

  1.先确定是跨行还是跨列合并。
          2.找到目标单元格.写上合并方式=合并的单元格数量。比如:

 <td colspan= “2" > </td>。
          3.删除多余的单元格。

![image-20230929155716828](https://minio-api.amjacks.cn/hjs/image-20230929155716828.png)

### 列表标签

##### ①无序列表：<ul> 

（列表项：<li>)

```html
<ul>
    <li></li>
    <li></li>
    <li></li>
</ul>
```

##### ②有序列表：

```html
<ol>
    <li></li>
    <li></li>
    <li></li>
</ol>
```

##### ③自定义列表：

```html
<!-- 底部导航-->
<dl>
    <!--定义项目/名字 -->
    <dt></dt>
    <!--描述一个项目/名字 -->
    <dd></dd>
    <dd></dd>
    <dd></dd>
</dl>
```

**注：ul/ol只能放li，ul里不能输入其他标签/dl只能放dt、dd**

**<li>之间可以放任何元素**



### 表单标签

#### 1.表单域：

```html
<form action="url地址" method="提交方式" name="表单域名称">
    各种表单元素控件
</form>
```

| 属性   | 属性值   | 作用                                               |
| ------ | -------- | -------------------------------------------------- |
| action | url地址  | 用于指定接收并处理表单数据的服务器程序的url地址    |
| method | get/post | 用于设置表单数据的提交方式，其取值为get或post      |
| name   | 名称     | 用于指定表单的名称，以区分同一个页面中的多个表单域 |





#### 2.表单控件：

**常用**

##### 1.input标签

| 属性      | 属性值       | 描述                              |
| --------- | ------------ | --------------------------------- |
| name      | 由用户自定义 | 定义input元素的名称               |
| value     | 由用户自定义 | 规定input元素的值                 |
| checked   | checked      | 规定input元素首次加载时应当被选中 |
| maxlength | 正整数       | 规定输入字段中的字符的最大长度    |

type属性

| 属性值   | 描述                                                       |
| -------- | ---------------------------------------------------------- |
| button   | 定义可点击按钮                                             |
| checkbox | 定义复选框                                                 |
| file     | 定义输入字段和"浏览"按钮，供文件上传                       |
| hidden   | 定义隐藏的输入字段                                         |
| image    | 定义图像形式的提交按钮                                     |
| password | 定义密码字段。该字段中的字符被掩码                         |
| radio    | 定义单选按钮                                               |
| reset    | 定义重置按钮。重置按钮会清除表单的所有数据                 |
| submit   | 定义提交按钮。提交按钮会把表单数据发送到服务器             |
| text     | 定义单行的输入字段，用户可在其中输入文本。默认宽度20个字符 |

总结：

1.name 和value是每个表单元素都有的属性值主要给后台人员使用.

2.name 表单元素的名字，要求**单选按钮和复选框要有相同的name值**

3.**checked属性主要针对于单选按钮和复选框** 主要作用一打开页面,就要可以默认选中某个表单元素.

4.maxlength 是用户可以在表单元素输入的最大字符数-般较少使用.



##### 2.select标签:

①&lt;select&gt;中至少包含一对<option>
       ②在<option> 中定义selected =“ selected "时,当前项即为默认选中项。

```html
<select>
    <option>选项1</option>
    <option>选项2</option>
    <option>选项3</option>
</select>
```



##### 3.textarea标签：

使用场景：内容过多，评论，留言板

```html
<textarea rows="3" cols="20">文本内容</textarea>
<!--
1.通过<textarea>标签可以轻松地创建多行文本输入框，
2.cols= “每行中的字符数”, rows=“显示的行数”, 我们在实际开发中不会使用,都是用CSS来改变大小
-->
```

#### 3.提示信息

##### label标签

<label>标签为input元素定义标注(标签)

<label>用于绑定一个表单元素，当点击<label>标签内的文本时，浏览器就会自动将焦点(光标)赚到或者选择对应的表单元素上，用来增加用户体验。

核心：<label>标签的for属性应当与相关元素的id属性相同

语法：

```html
<label for="xxx">xxx</label>
<input type="xxx" name="xxx" id="xxx">
```



#### 4.表单框架标签

##### **fieldset与legend的使用**

fieldset可以为表单控件**分组**、legend 标签是**分组的标题**。

```html
<fieldset>
    <legend>
        主要信息
    </legend>
</fieldset>
```

##### **iframe内联框架标签**

```html
<iframe name="xx" width="xx" height="xx" frameborder="0/1">
    链接
</iframe>
```

应用：

1.在网页内嵌入广告

2.与超链接或表单的**target**配合，展示不同的内容，**target="name"**



## 3.新增标签

### 1 HTML5新增的语义化标签

```html
头部标签:<header>
导航标签:<nav>
内容标签:<article>
定义文档某个区域:<section>
侧边栏标签:<aside>
尾部标签:<footer> 
```



### 2.HTML5新增的多媒体标签

````html
音频: <audio>
视频: <video>
 <audio src="" controls="controls"></audio>
 <!-- 尽量使用 mp4格式-->
 <video src="" controls="controls"></video>1
````

#### **audio**

| 属性     | 值       | 描述                               |
| -------- | -------- | ---------------------------------- |
| autoplay | autoplay | 自动播放的效果                     |
| controls | controls | 向用户显示播放控件                 |
| loop     | loop     | 播放完是否继续播放该音频，循环播放 |
| src      | url      |                                    |



#### **video**

| 属性     | 值                                      | 描述                                                         |
| -------- | --------------------------------------- | ------------------------------------------------------------ |
| autoplay | autoplay                                | 注意： 在google浏览器上面，默认禁止了自动播放，如果想要自动播放的效果，需要设置 muted属性 |
| controls | controls                                | 向用户显示播放控件                                           |
| width    | pixels                                  | 设置播放器宽度                                               |
| height   | pixels                                  | 设置播放器高度                                               |
| loop     | loop                                    | 播放完是否继续播放该视频，循环播放                           |
| preload  | auto (预先加载视频）none (不应加载视频) | 规定是否预加载视频(如果有了autoplay就忽略该属性)             |
| src      | url                                     | 视频url地址                                                  |
| poster   | lmgurl                                  | 加载等待的画面图片                                           |
| muted    | muted                                   | 静音播放                                                     |



### 3.HTML5新增的input类型

```html
邮箱: <input type="email" />
网址: <input type="url" />
日期: <input type="date" />
时间: <input type="time" />
数量: <input type="number" />
手机号码: <input type="tel" />
搜索: <input type="search" />
颜色: <input type="color" />
```

重点记住：**number tel search**



### 4.HTML5新增的表单属性

![image-20231102090450327](https://minio-api.amjacks.cn/hjs/image-20231102090450327.png)
