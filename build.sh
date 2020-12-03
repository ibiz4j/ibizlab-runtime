echo "版本：$1";
mvn package -Pgateway
mvn package -Pallinone
cd boot
mvn docker:build -Pallinone
cd ..
docker tag ibiz4j/ibizlab-runtime:latest  ibiz4j/ibizlab-runtime:$1-RC1
docker push ibiz4j/ibizlab-runtime:$1-RC1
docker push ibiz4j/ibizlab-runtime:latest
docker tag ibiz4j/ibizlab-runtime:$1-RC1  registry.cn-shanghai.aliyuncs.com/ibizsys/ibizlab-runtime:$1-RC1
docker push registry.cn-shanghai.aliyuncs.com/ibizsys/ibizlab-runtime:$1-RC1
docker tag ibiz4j/ibizlab-runtime:latest  registry.cn-shanghai.aliyuncs.com/ibizsys/ibizlab-runtime:latest
docker push registry.cn-shanghai.aliyuncs.com/ibizsys/ibizlab-runtime:latest
