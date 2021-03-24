package net.danielkchr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil
{
    private static Connection connection;

    private DBUtil(String dbUrl, String dbName, String dbUser, String dbPassword)
    {
        try
        {
            connection = DriverManager.getConnection(dbUrl + dbName, dbUser, dbPassword);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static <T> T executeQuery(String query, QueryHandler<T> handler, T nullValue)
    {
        T value = null;

        try (PreparedStatement ps = connection.prepareStatement(query))
        {
            return handler.run(ps);
        }
        catch (SQLException e)
        {
            System.out.println("SQL Execute Exception: " + e.getMessage());
        }
        return null;
    }

    public static <T> T executeQuery(String query, QueryHandler<T> handler)
    {
        return executeQuery(query, handler, null);
    }

    public static void initialize(String dbUrl, String dbName, String dbUser, String dbPassword)
    {

        new DBUtil(dbUrl, dbName, dbUser, dbPassword);
    }
}

