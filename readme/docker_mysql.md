
```
sudo docker pull mysql:5.7
sudo docker pull mysql:5.7-stretch
```

```
sudo docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```


以上運行有問題的話，多半是/etc/mysql/conf.d沒有自動創建，
需要手動先在創建好或直接寫好映射 /etc/mysql/conf.d、/etc/mysql/mysql.conf.d
```
sudo docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf/conf_d:/etc/mysql/conf.d \
-v /mydata/mysql/conf/mysql_conf_d:/etc/mysql/mysql.conf.d \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```

my ubuntu
```

sudo docker run -p 3306:3306 --name mysql \
-v /home/liucheyu/db/mysql/log:/var/log/mysql \
-v /home/liucheyu/db/mysql/data:/var/lib/mysql \
-v /home/liucheyu/db/mysql/conf/conf.d:/etc/mysql/conf.d \
-v /home/liucheyu/db/mysql/conf/mysql.conf.d:/etc/mysql/mysql.conf.d \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```

修改配置
 - vi /mydata/mysql/conf/mysql_conf_d/my.cnf
 - vi /home/liucheyu/db/mysql/conf/mysql.conf.d/my.cnf
```
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve
```

```
docker restart mysql

docker update mysql --restart=always
```