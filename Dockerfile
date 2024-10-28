# 使用本地 Tomcat 镜像
FROM tomcat:latest

# 设置工作目录
WORKDIR /usr/local/tomcat

# 设置 Java 环境变量
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# 将应用的 WAR 文件复制到 Tomcat 的 webapps 目录
COPY target/*.war webapps/ROOT.war

# 暴露 Tomcat 的默认端口 8080
EXPOSE 8080

# 启动 Tomcat
CMD ["catalina.sh", "run"]
