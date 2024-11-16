#!/bin/bash

# 定义颜色
ORANGE='\e[33m'
NC='\e[0m' # No Color

# 定义变量
APP_NAME="SMS"
WAR_FILE="SMS.war"
DOCKER_IMAGE_NAME="sms-image"
DOCKER_CONTAINER_NAME="sms-container"

# 第一步：停止并删除已存在的容器
if [ "$(docker ps -q -f name=$DOCKER_CONTAINER_NAME)" ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}停止并删除已存在的容器...${NC}"
    docker stop $DOCKER_CONTAINER_NAME
    docker rm $DOCKER_CONTAINER_NAME
fi

# 第二步：删除已存在的镜像
if [ "$(docker images -q $DOCKER_IMAGE_NAME)" ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}删除已存在的镜像...${NC}"
    docker rmi -f $DOCKER_IMAGE_NAME
fi

# 第三步：Maven 打包
echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}开始 Maven 打包...${NC}"
mvn clean package

if [ $? -ne 0 ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Maven 打包失败！${NC}"
    exit 1
fi

echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Maven 打包成功！${NC}"

# 第四步：构建 Docker 镜像
echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}构建 Docker 镜像...${NC}"
docker build -t $DOCKER_IMAGE_NAME .

if [ $? -ne 0 ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Docker 镜像构建失败！${NC}"
    exit 1
fi

echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Docker 镜像构建成功！${NC}"

# 第五步：创建 Docker 容器
IP_ADDRESS=$(hostname -I | awk '{print $1}')
echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}创建 Docker 容器...${NC}"
docker run -d --name $DOCKER_CONTAINER_NAME -p 8080:8080 --add-host=localhost:$IP_ADDRESS $DOCKER_IMAGE_NAME

if [ $? -ne 0 ]; then
    echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Docker 容器创建失败！${NC}"
    exit 1
fi

echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}Docker 容器创建成功！${NC}"

# 第六步：执行容器
echo "$(date +'%Y-%m-%d %H:%M:%S') ${ORANGE}执行 Docker 容器...${NC}"
docker exec -d -it $DOCKER_CONTAINER_NAME /bin/bash

# 等待容器启动
echo "${ORANGE}等待响应${NC}"
MAX_TIME=30
WAIT_TIME=0
while [ $WAIT_TIME -le $MAX_TIME ]; do
    sleep 1
    # 撤销上一行内容
    echo "\033[A\033[K${ORANGE}等待中... ${WAIT_TIME} 秒 ${NC}"
    # 检查 http://localhost:8080/ 是否有响应
    if curl -s http://localhost:8080/ > /dev/null; then
        echo "${ORANGE}启动成功${NC}"
        # 打开链接
        echo "${ORANGE}打开浏览器${NC}"
        explorer.exe http://localhost:8080/
        break
    fi
    WAIT_TIME=$((WAIT_TIME+1))
done

if [ $WAIT_TIME -gt $MAX_TIME ]; then
    echo "${ORANGE}启动超时，未检测到服务响应${NC}"
fi