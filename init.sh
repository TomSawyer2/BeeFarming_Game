#! /bin/bash
# This script is used to start the game
totalRound=$totalRound
outputFilename=$outputFilename
# 使用javac编译目录下所有java文件
javac -encoding UTF-8 -d . *.java
# java BeeFarming并传入totalRound和outputFilename
xvfb-run -a java BeeFarming totalRound=$totalRound outputFilename=$outputFilename