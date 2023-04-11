# Db2Md

> *导出数据库表结构成markdown的工具* 



## 使用

```
mvn clean package
cd assembly/target
tar -zxvf db2md.tar.gz
cd db2md/bin
./db2md --help
```


example

```
./db2md -H 127.0.0.1 -P 3306 -u root -p 123456 -d mysql -t mysql -o .
```



## 支持的数据库

- [x] mysql
- [ ] sqlite
