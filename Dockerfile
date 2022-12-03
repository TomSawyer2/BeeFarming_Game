FROM alpine:edge

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apk/repositories
# 安装openjdk17
RUN apk add --no-cache openjdk17 xvfb-run

RUN mkdir -p /home/game
WORKDIR /home/game
COPY . /home/game

# 启动容器的方式 docker run --env totalRound=100 upperOutputFilename=upperOutput downOutputFilename=downOutput
ENTRYPOINT ["sh", "init.sh"]