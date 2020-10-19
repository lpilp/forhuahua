# 国密SM2， SM3， SM4各语言互通性测试
* 测试BC库java加密与js加密到通
* 网上的资料上都说java的使用库与其他语言不通，看BC库的git几个月前更新了一版，测试了下现在稳定的1.66版本是可以通的， 这其中有一个问题得注意：java中文的转码问题，getBytes("UTF-8"), 要加上编码类型， 因为 getBytes()函数的缺省编码是随操作系统的，在中文版的windows中，缺省是GBK编码，就会出现问题了，在LINUX上倒是没有问题，缺省是
* 本测试的BC封装使用 https://github.com/ZZMarquis/gmhelper 的封装， js采用 https://github.com/JuneAndGreen/sm-crypto的封装
* python版本 https://github.com/guanzhi/GmSSL，使用pip install gmssl安装就可， 已与上面的js测试过是互通的，要注意的就是在python2下 ， string与byte是可以自动转换的，在python3下需要将string转成byte
* 其他语言的不断加入测试中
