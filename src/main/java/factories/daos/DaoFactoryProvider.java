package factories.daos;

import utils.FactoryTypes;

public class DaoFactoryProvider {
    public static DaoFactory getDaoFactory(FactoryTypes types) {
        return switch (types) {
            case DEFAULT -> new ProxyDaoFactory();
            case DYNAMIC -> new DynamicProxyDaoFactory();
        };
    }
}
