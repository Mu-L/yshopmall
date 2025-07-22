

<h1 style="text-align: center">yshop意象商城系统</h1>

## 项目简介
yshop基于当前流行技术组合的前后端分离商城系统： SpringBoot2+MybatisPlus+SpringSecurity+jwt+redis+Vue的前后端分离的商城系统， 包含商品、多规格、运费模板、素材库、拼团、快递、 秒杀、优惠券、积分、分销、会员、充值等功能，更适合企业或个人二次开发；




## 官网体验地址(商业版本是springboot3+jdk17+vue3版本)
|  官网地址  |  https://www.yixiang.co |
|---|---|
| 商业版管理后台演示地址：  |   https://b2c.yixiang.co |
| 关注公众号体验商业版单商户H5  |  ![输入图片说明](https://images.gitee.com/uploads/images/2021/0121/154904_12c09826_477893.png) |


## 视频资料
如果对您有帮助，您可以点右上角 "Star" 支持一下，这样我们才有继续免费下去的动力，谢谢！ 如需要资料 (添加前，请在网页右上角点 "Star" )，申请加下面qq备注star的git用户哦，可以获取视频与文档教程哦！！

交流QQ：287499909

## 项目说明
```
- yshop-mall-boot     java工程
- yshop-mall-vue      后台前端工程
- yshop-mall-uniapp   uniapp工程，支持小程序、h5

```


## 本地安装
### 基本环境（必备）
- 1、JDK：8
- 2、Redis 3.0+
- 3、Maven 3.0+
- 4、MYSQL 5.7+
- 5、Node v8+
### 开发工具
Idea、hbuilder、vscode

### 后台系统工程（JAVA端）

1、请确保redis已经安装启动

2、idea打开yshop-mall-boot

3、idea打开项目加载依赖目录如下

4、导入数据库，配置开发环境数据库信息及其redis信息，文件路径如下：

![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163043_bd75fb21_477893.png "test2.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163103_927e6c40_477893.png "test3.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163118_29a4fa04_477893.png "test4.png")

5、然后在父级pom.xml输入命令 mvn clean install 或者用idea工具操作

![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163132_913fc5fd_477893.png "test5.png")

6、启动程序



### 后台前端工程（VUE端）
1、请确保本地已经安装node,建议node8或者node10

2、vscode打开yshop-mall-vue

3、cnpm install或者yarn install,当前所有命令必须当前工程目录下进行，目录结构如下：

![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163159_895e12de_477893.png "test8.png")


3、在控制台输入命令：npm run dev，控制台打印出如下画面，恭喜表示本项目启动成功拉。
![输入图片说明](https://images.gitee.com/uploads/images/2021/0811/163209_09ed1793_477893.png "test9.png")


4、打开浏览器输入地址如图：

默认超管账户密码：admin/123456

### 移动端工程（uniapp端）

1、hbuilder打开yshop-mall-uniapp

2、npm install

3、然后直接运行即可

4、详情教程可以加上面说的群交流获取更多文档



## nginx线上部署

### 后台系统（Java端）

1、mvn install 或者直接idea打成jar包

2、配置nginx ，加入交流群，群文件里有视频教程



### 后台前端工程（VUE端）
1、输入命令：npm run build:prod 编译打包

2、把打包后的dist目录代码上传到服务器

3、配置nginx如下，加入交流群，群文件里有视频教程


## docker部署

- 1、创建一个存储第三方软件服务Docker Compose文件目录：
```
     mkdir -p /yshop/soft
```
- 2、然后在该目录下新建一个docker-compose.yml文件：
```
    vim /yshop/soft/docker-compose.yml
```
- 3、接着创建上面docker-compose.yml里定义的挂载目录：
```
    mkdir -p /yshop/mysql/data /yshop/redis/data /yshop/redis/conf
```
- 4、创建Redis配置文件redis.conf：
```
    touch /yshop/redis/conf/redis.conf
```
- 5、docker 部署参考根目录docker文件夹
- 6、以上创建好之后参考docker下文件，先执行软件安装：
```
  cd /yshop/soft
  docker-compose up -d  启动
  docker ps -a 查看镜像
```
- 7、运行docker/applicatiion目录下 docker-compose,当然之前一定要打包jar包，构建镜像
  切换到Dockerfile 文件下：
  ```
  docker build -t yshop-admin .  
  ```



## 商城功能

* 一：商品模块：商品添加、规格设置，商品上下架等
* 二：订单模块：下单、购物车、支付，发货、收货、评价、退款等
* 三：营销模块：积分、优惠券、分销、拼团、秒杀、多门店等
* 四：微信模块：自定义菜单、自动回复、微信授权、图文管理、模板消息推送
* 五：配置模块：各种配置
* 六：用户模块：登陆、注册、会员卡、充值等
* 七：其他等



#### 系统预览
<table>
    <tr>
        <td><img src="assets/55.jpg"/></td>
        <td><img src="assets/6.jpg"/></td>
    </tr>
    <tr>
        <td><img src="assets/4.jpg"/></td>
        <td><img src="assets/3.jpg"/></td>
    </tr>
    <tr>
        <td><img src="assets/2.jpg"/></td>
        <td><img src="assets/1.jpg"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2019/1107/194017_9207632f_477893.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2019/1121/230257_5844f5f1_477893.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2019/1121/230051_971db503_477893.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2019/1121/230342_f379583e_477893.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2019/1121/230224_5f0dec5d_477893.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2019/1107/194207_7b3b1f53_477893.png"/></td>
    </tr>
</table>


### 技术选型
* 1 后端使用技术
    * 1.1 SpringBoot2
    * 1.2 mybatis、MyBatis-Plus
    * 1.3 SpringSecurity
    * 1.5 Druid
    * 1.6 Slf4j
    * 1.7 Fastjson
    * 1.8 JWT
    * 1.9 Redis
    * 1.10 Quartz
    * 1.11 Mysql
    * 1.12 swagger
    * 1.13 WxJava
    * 1.14 Lombok
    * 1.15 Hutool
        
* 前端使用技术
    * 2.1 Vue 全家桶
    * 2.2 Element
    * 2.3 uniapp



	
#### 反馈交流
- 喜欢这个商城后台的小伙伴留下你的小星星啦,star,star哦！

#### 使用须知
- 允许个人学习使用
- 允许用于学习、毕设等
- 允许进行商业使用，请自觉遵守使用协议，如需要商业使用推荐购买[商业版源码](https://www.yixiang.co/p/B2CPRO.html)
- 请遵守 Apache License2.0 协议，再次开源请注明出处



####  特别鸣谢
- eladmin:https://github.com/elunez/eladmin
- mybaitsplus:https://github.com/baomidou/mybatis-plus
- hutool:https://github.com/looly/hutool
- wxjava:https://github.com/Wechat-Group/WxJava
- vue:https://github.com/vuejs/vue
- element:https://github.com/ElemeFE/element
