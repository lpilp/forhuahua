# 国密SM2， SM3， SM4各语言互通性测试
* 测试BC库java加密与js加密到通
* 网上的资料上都说java的使用库与其他语言不能
* 本测试的BC封装使用 https://github.com/ZZMarquis/gmhelper 的封装， js采用 https://github.com/JuneAndGreen/sm-crypto的封装
* python版本 https://github.com/guanzhi/GmSSL，使用pip install gmssl安装就可， 已与上面的js测试过是互通的，要注意的就是在python2下 ， string与byte是可以自动转换的，在python3下需要将string转成byte
* 其他语言的不断加入测试中
