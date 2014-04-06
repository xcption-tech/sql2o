package org.sql2o;

import org.sql2o.data.LazyTable;
import org.sql2o.data.Table;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author aldenquimby@gmail.com
 * @since 4/5/14
 */
public class AsyncExecutor
{
    private final ExecutorService executorService;
    private final Query query;

    public AsyncExecutor(ExecutorService executorService, Query query)
    {
        this.executorService = executorService;
        this.query = query;
    }

    public <T> Future<ResultSetIterable<T>> executeAndFetchLazy(final Class<T> returnType)
    {
        return executorService.submit(new Callable<ResultSetIterable<T>>() {
            public ResultSetIterable<T> call() throws Exception {
                return query.executeAndFetchLazy(returnType);
            }
        });
    }

    public <T> Future<List<T>> executeAndFetch(final Class<T> returnType)
    {
        return executorService.submit(new Callable<List<T>>() {
            public List<T> call() throws Exception {
                return query.executeAndFetch(returnType);
            }
        });
    }

    public <T> Future<T> executeAndFetchFirst(final Class<T> returnType)
    {
        return executorService.submit(new Callable<T>() {
            public T call() throws Exception {
                return query.executeAndFetchFirst(returnType);
            }
        });
    }

    public Future<LazyTable> executeAndFetchTableLazy()
    {
        return executorService.submit(new Callable<LazyTable>() {
            public LazyTable call() throws Exception {
                return query.executeAndFetchTableLazy();
            }
        });
    }

    public Future<Table> executeAndFetchTable()
    {
        return executorService.submit(new Callable<Table>() {
            public Table call() throws Exception {
                return query.executeAndFetchTable();
            }
        });
    }

    public Future<Connection> executeUpdate()
    {
        return executorService.submit(new Callable<Connection>() {
            public Connection call() throws Exception {
                return query.executeUpdate();
            }
        });
    }

    public <T> Future<T> executeScalar(final Class<T> returnType)
    {
        return executorService.submit(new Callable<T>() {
            public T call() throws Exception {
                return query.executeScalar(returnType);
            }
        });
    }

    public <T> Future<List<T>> executeScalarList(final Class<T> returnType)
    {
        return executorService.submit(new Callable<List<T>>() {
            public List<T> call() throws Exception {
                return query.executeScalarList(returnType);
            }
        });
    }

    public Future<Connection> executeBatch() throws Sql2oException
    {
        return executorService.submit(new Callable<Connection>() {
            public Connection call() throws Exception {
                return query.executeBatch();
            }
        });
    }
}
