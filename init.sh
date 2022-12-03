#! /bin/bash
# This script is used to monitor the game
totalRound=$totalRound
upperOutputFilename=$upperOutputFilename
downOutputFilename=$downOutputFilename

# 将code文件夹中的codeAHoney.java复制到当前目录，并重命名为HoneyBee.java
cp code/codeAHoney.java HoneyBee.java
# 将code文件夹中的codeBHornet.java复制到当前目录，并重命名为Hornet.java
cp code/codeBHornet.java Hornet.java
# 使用javac编译目录下所有java文件
javac -encoding UTF-8 -d . *.java
# java BeeFarming并传入totalRound和outputFilename
xvfb-run -a java BeeFarming totalRound=$totalRound outputFilename=$upperOutputFilename

# 删除编译后的class文件
rm *.class
# 删除HoneyBee.java和Hornet.java
rm HoneyBee.java
rm Hornet.java
# 将code文件夹中的codeBHoney.java复制到当前目录，并重命名为HoneyBee.java
cp code/codeBHoney.java HoneyBee.java
# 将code文件夹中的codeAHornet.java复制到当前目录，并重命名为Hornet.java
cp code/codeAHornet.java Hornet.java
# 使用javac编译目录下所有java文件
javac -encoding UTF-8 -d . *.java
# java BeeFarming并传入totalRound和outputFilename
xvfb-run -a java BeeFarming totalRound=$totalRound outputFilename=$downOutputFilename