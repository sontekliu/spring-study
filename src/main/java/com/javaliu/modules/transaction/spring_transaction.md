# Spring 事物

1. 没有任何 transaction 配置时，数据自动提交，出现异常不回滚。代码如下：
```java
// 无任何事物相关的配置，并且没有 Transaction 注解。
@Override
public void addUser(User user) {
    // 执行完此代码，MySQL 数据库中已有数据
    userMapper.insertOne(user);
    // 此处发生异常，但是之前的数据不回滚
    System.out.println(1/0);
}
```
所以代码中必须配置事物。

2. 注意：spring事务是基于aop实现的。
    只有来自外部方法的调用才会被aop代理捕获,类的内部方法调用不会被aop代理，即使方法上面加了@Transactional注解
   
