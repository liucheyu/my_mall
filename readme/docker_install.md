

centos 安裝，[連結](https://docs.docker.com/engine/install/centos/)

解除安裝舊版
```
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
```

設定repository
```
 sudo yum install -y yum-utils
 sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```


安裝
```
sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

啟動
```
sudo systemctl start docker
```

重新開機時自動啟動
```
sudo systemctl enable docker
```








