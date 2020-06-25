package com.patterns.designpatterns;

interface Connection {
    public void getConnection();
}

class SqlConnection implements Connection {

    @Override
    public void getConnection() {
        System.out.println("GOT 'Sql' Connection Instance");
    }
}

class OracleConnection implements Connection {

    @Override
    public void getConnection() {
        System.out.println("GOT 'Oracle' Connection Instance");
    }
}

class ConnectionFactory {

    Connection connection = null;

    public Connection getConnectionInstance(String connectionName) {

        if ("SQL".equalsIgnoreCase(connectionName)) {
            connection = new SqlConnection();
        } else if ("ORACLE".equalsIgnoreCase(connectionName)) {
            connection = new OracleConnection();
        }
        return connection;
    }
}

public class FactoryDesignPattern {

    public static void main(String[] args) {
        Connection con = new ConnectionFactory().getConnectionInstance("Oracle");
        con.getConnection();
    }
}
