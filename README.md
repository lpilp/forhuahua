# 国密SM2， SM3， SM4各语言互通性总结
* 测试BC库java加密与js加密到通
* 网上的资料上都说java的使用库与其他语言不通，测试了下使用现在BC库的1.66版本是可以通的， 注意下java中文的转码问题，getBytes("UTF-8"), 要加上编码类型， 因为 getBytes()函数的缺省编码是随操作系统的，在中文版的windows中，缺省是GBK编码，就会出现问题了，在与其他的语言互通时就会有问题了，本测试的BC封装使用 https://github.com/ZZMarquis/gmhelper 的封装

* js采用 https://github.com/JuneAndGreen/sm-crypto 一个注意点就是： js的中文字符转成byte[]时，缺省的是unicode编码两字节，需要转成utf8的三字节编码，一个简单的方案 unescape(encodeURIComponent(str)) 然后再一个字节一个字节读就行了

* python版本 https://github.com/guanzhi/GmSSL，使用pip install gmssl安装就可， 已与上面的js测试过是互通的，要注意的就是在python2下 ， string与byte是可以自动转换的，在python3下需要将string转成byte

* 其他语言的不断加入测试中

* 总结见作者新项目 lpilp/phpsm2sm3sm4 的readme
