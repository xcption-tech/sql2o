package org.sql2o;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author alden@mark43.com
 * @since 4/5/14
 */
public class AsyncQuery extends Query
{
    public AsyncQuery(Connection connection, String queryText, String name, boolean returnGeneratedKeys)
    {
        super(connection, queryText, name, returnGeneratedKeys);
    }

    public AsyncQuery addParameter(String name, Object value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, InputStream value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, int value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Integer value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, long value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Long value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, String value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Timestamp value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Date value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, java.util.Date value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Time value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery addParameter(String name, Enum value)
    {
        super.addParameter(name, value);
        return this;
    }
    public AsyncQuery bind(Object bean)
    {
        super.bind(bean);
        return this;
    }
    public AsyncQuery setCaseSensitive(boolean caseSensitive)
    {
        super.setCaseSensitive(caseSensitive);
        return this;
    }
    public AsyncQuery setAutoDeriveColumnNames(boolean autoDeriveColumnNames)
    {
        super.setAutoDeriveColumnNames(autoDeriveColumnNames);
        return this;
    }
    public AsyncQuery addToBatch()
    {
        super.addToBatch();
        return this;
    }
    public AsyncQuery setColumnMappings(Map<String, String> mappings)
    {
        super.setColumnMappings(mappings);
        return this;
    }
    public AsyncQuery addColumnMapping(String columnName, String propertyName)
    {
        super.addColumnMapping(columnName, propertyName);
        return this;
    }

    private final ExecutorService executorService = new ScheduledThreadPoolExecutor(10);

    public <T> Future<ResultSetIterable<T>> asyncExecuteAndFetchLazy(final Class<T> returnType)
    {
        return executorService.submit(new Callable<ResultSetIterable<T>>() {
            public ResultSetIterable<T> call() throws Exception {
                return executeAndFetchLazy(returnType);
            }
        });
    }

    public <T> Future<List<T>> asyncExecuteAndFetch(final Class<T> returnType)
    {
        return executorService.submit(new Callable<List<T>>() {
            public List<T> call() throws Exception {
                return executeAndFetch(returnType);
            }
        });
    }

    /*
    public <T> T executeAndFetchFirst(Class<T> returnType);
    public LazyTable executeAndFetchTableLazy();
    public Table executeAndFetchTable();
    public Connection executeUpdate();
    public Object executeScalar();
    public <V> V executeScalar(Class<V> returnType);
    public <T> List<T> executeScalarList(Class<T> returnType);
    public Connection executeBatch() throws Sql2oException;
    */
}
