FROM alpine:edge

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apk/repositories
# 安装openjdk17
RUN apk add --no-cache openjdk17
# 安装可以执行xvfb-run的虚拟显示器
RUN apk add --no-cache xvfb-run

RUN mkdir -p /home/game
WORKDIR /home/game
COPY . /home/game

# 启动容器的方式 docker run --env totalRound=100 outputFilename=output
ENTRYPOINT ["sh", "init.sh"]