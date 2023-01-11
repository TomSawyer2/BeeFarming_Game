# 解析命令行参数currentRound python updateRedis.py (id)1 (currentRound)1

import sys
import redis

# 连接docker容器外的redis
r = redis.Redis(host="172.17.0.1", port=6380, db=1)
# 更新redis中的currentRound
r.set("bf:key" + sys.argv[1], sys.argv[2])
print("update redis success", sys.argv[1], sys.argv[2], "get: ", r.get("bf:key" + sys.argv[1]))