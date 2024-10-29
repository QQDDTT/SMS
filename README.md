# 项目名称

SMS

基于 Spring MVC 学生管理系统

## 项目结构

- `src/main/java/` - 包含 Java 源代码
- `src/main/resources/` - 包含配置文件和静态资源
- `src/main/webapp/` - 包含网页文件
- `src/test/java/` - 包含测试代码
- `pom.xml` - Maven 构建配置文件

## 环境要求

- JDK 版本：17
- Maven 版本：4.0.0
- 操作系统：Windows / Linux
- 日志路径：/home/logs

## 安装和构建

1. **克隆项目**

   ```sh
   git clone https://github.com/QQDDTT/SMS.git

2. **修改配置文件，链接数据库**

    SMS.sql

3. **启动项目**

3.1 **Docker 启动**

   sh deploy_dockers.sh

3.2 **Windows 启动**

   双击执行 deploy_win.bat
