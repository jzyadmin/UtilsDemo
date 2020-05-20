package transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Connection;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/20 8:24
 **/
@Service
@EnableTransactionManagement
public class TransactionConfigDemo {
    @Test
    public void Start() {
        ApplicationContext context = new AnnotationConfigApplicationContext("transaction");

    }
}
