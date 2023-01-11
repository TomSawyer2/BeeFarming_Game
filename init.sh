#! /bin/bash
# This script is used to monitor the game
totalRound=$totalRound
upperOutputFilename=$upperOutputFilename
downOutputFilename=$downOutputFilename
actualRounds=$(($totalRound*2))

# 将code文件夹中的codeAHoney.java复制到当前目录，并重命名为HoneyBee.java
cp ./code/codeAHoney.java HoneyBee.java
# 将code文件夹中的codeBHornet.java复制到当前目录，并重命名为Hornet.java
cp ./code/codeBHornet.java Hornet.java
# 使用javac编译目录下所有java文件
javac -encoding UTF-8 -d . *.java
echo 0/$actualRounds >> ./Result/roundinfo
for i in $(seq 1 $totalRound)
do
    xvfb-run -a java BeeFarming outputFilename=$upperOutputFilename
    # 向/results/roundinfo文件写入当前回合数/actualRounds
    echo $i/$actualRounds >> ./Result/roundinfo
done

# 删除编译后的class文件
rm *.class
# 删除HoneyBee.java和Hornet.java
rm HoneyBee.java
rm Hornet.java
# 将code文件夹中的codeBHoney.java复制到当前目录，并重命名为HoneyBee.java
cp ./code/codeBHoney.java HoneyBee.java
# 将code文件夹中的codeAHornet.java复制到当前目录，并重命名为Hornet.java
cp ./code/codeAHornet.java Hornet.java
# 使用javac编译目录下所有java文件
javac -encoding UTF-8 -d . *.java
for i in $(seq 1 $totalRound)
do
    xvfb-run -a java BeeFarming outputFilename=$upperOutputFilename
    # 向/results/roundinfo文件写入(当前回合数totalRounds)+/actualRounds
    echo $(($i+$totalRound))/$actualRounds >> ./Result/roundinfo
done

# javac *.java
# java BeeFarming outputFilename=output123