gradle 构建app工具

gradle 构建插件，因为它只是能编译java，c++，groovy语言


module 可以自动生成不带资源的jar与带资源aar

jar 位置: ./build/intermediates/bundles/default/classes.jar
aar 位置: ./build/outputs/aar/*.aar

提供给外部用



build variants(变种,多样式的),
签名配置(debug与release的签名都可以一致)
BuildConfig中debug的值,可以使用这个值来做开关,比如log

build.gradle 中配置的东西(变量)在BuildConfig.java中(自动生成),可以直接使用


生成不同的apk，主要是两个buildType与productFlavors的配置
buildType  (debug, release)


右上角的gradle图标打包时很有用


什么时候生成jar包或者生成aar文件，如果与功能清单文件或者资源文件无关，
就生成jar，否则生成aar文件


arr 其实是一个完整应用，只是不能自行安装，它需要内嵌到其他应用中去一起
安装，其实宿主应用只需要启动它就行了，提供一个入口


module 好处
1，封装
2，build的时候会增量编译




