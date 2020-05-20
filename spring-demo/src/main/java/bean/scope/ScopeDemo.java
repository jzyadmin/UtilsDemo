package bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/30 10:59
 **/
public class ScopeDemo implements Scope {
    private ThreadLocal<Object> local = new ThreadLocal();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (local.get() == null) {
            local.set(objectFactory.getObject());
        }
        return local.get();
    }

    @Override
    public Object remove(String name) {
        try {
            return local.get();
        }finally {
            local.set(null);
        }
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
