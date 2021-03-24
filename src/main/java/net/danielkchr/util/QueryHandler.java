package net.danielkchr.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface QueryHandler<T>
{
    T run(PreparedStatement ps) throws SQLException;
}
