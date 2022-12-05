FROM alpine:edge

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apk/repositories
# 安装openjdk17
RUN apk add --no-cache openjdk17-jdk xvfb xvfb-run
# 安装 fontconfig 和 ttf-dejavu字体
RUN apk add fontconfig \
    && apk add --update ttf-dejavu \
    && fc-cache --force

RUN mkdir -p /home/game
WORKDIR /home/game
COPY . /home/game

ENV totalRound=1
ENV upperOutputFilename="upper"
ENV downOutputFilename="lower"

# 启动容器的方式 docker run --env totalRound=100 upperOutputFilename=upperOutput downOutputFilename=downOutput
ENTRYPOINT ["sh", "init.sh"]