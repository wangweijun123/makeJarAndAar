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
