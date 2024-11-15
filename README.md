# ManagementSystem
管理学生信息、图书信息、课程信息

本项目是一个功能完整的管理系统，主要面向学校或教育机构的管理需求，涵盖了用户管理、学生信息管理、课程信息管理、图书管理以及个人中心等模块。系统具备用户登录、注册、权限控制等基础功能，同时还包括学生、课程、图书等资源的增删改查操作，以及首页展示、个人信息管理等附加功能。

操作系统：Windows
前端：HBuilderX。使用Vue.js作为前端框架，并搭配ElementUI组件库进行页面开发。使用Axios进行HTTP请求处理。
后端：IntelliJ IDEA。使用Java作为后端开发语言，并搭配Spring、SpringBoot和Mybatis框架进行后端开发。
数据库：Navicat Premium 16。使用持久层框架MyBatis与数据库进行交互。

（一）用户模块
·	用户登录功能：通过前端表单输入手机号和密码（密码不可见），前端使用Axios将用户输入的数据发送到后端进行验证。后端接收请求后，进行用户身份验证，验证成功后跳转到首页。登录页面如下图所示。
 ![image](https://github.com/user-attachments/assets/3e342479-abe9-49bf-95e6-c1bf65286fcf)


