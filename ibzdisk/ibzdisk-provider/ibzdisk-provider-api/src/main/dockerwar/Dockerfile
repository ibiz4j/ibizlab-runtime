FROM registry.cn-shanghai.aliyuncs.com/ibizops/tongweb:arm-7.0-withSSL

ENV TZ Asia/Shanghai
ENV LANG C.UTF-8

WORKDIR /opt/tongtech
ADD ibzdisk-provider-api.war .

RUN echo -e 'export LANG="zh_CN.UTF-8"\nexport LC_ALL="zh_CN.UTF-8"' > /etc/locale.conf
RUN unzip -oq ibzdisk-provider-api.war -d ./TongWeb7.0/deployment/jcyweb

ENTRYPOINT /opt/tongtech/TongWeb7.0/bin/startserver.sh
