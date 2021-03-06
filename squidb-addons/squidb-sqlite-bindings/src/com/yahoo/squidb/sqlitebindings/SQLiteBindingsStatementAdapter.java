/*
 * Copyright 2015, Yahoo Inc.
 * Copyrights licensed under the Apache 2.0 License.
 * See the accompanying LICENSE file for terms.
 */
package com.yahoo.squidb.sqlitebindings;

import com.yahoo.squidb.data.ISQLitePreparedStatement;

import org.sqlite.database.sqlite.SQLiteStatement;

/**
 * Wrapper for the SQLiteBindings project version SQLiteStatement that implements the common
 * {@link ISQLitePreparedStatement} interface.
 */
public class SQLiteBindingsStatementAdapter implements ISQLitePreparedStatement {

    private final SQLiteStatement statement;

    SQLiteBindingsStatementAdapter(SQLiteStatement statement) {
        this.statement = statement;
    }

    @Override
    public void close() {
        statement.close();
    }

    @Override
    public void bindNull(int index) {
        statement.bindNull(index);
    }

    @Override
    public void bindLong(int index, long value) {
        statement.bindLong(index, value);
    }

    @Override
    public void bindDouble(int index, double value) {
        statement.bindDouble(index, value);
    }

    @Override
    public void bindString(int index, String value) {
        statement.bindString(index, value);
    }

    @Override
    public void bindBlob(int index, byte[] value) {
        statement.bindBlob(index, value);
    }

    @Override
    public void clearBindings() {
        statement.clearBindings();
    }

    @Override
    public void execute() {
        statement.execute();
    }

    @Override
    public int executeUpdateDelete() {
        return statement.executeUpdateDelete();
    }

    @Override
    public long executeInsert() {
        return statement.executeInsert();
    }

    @Override
    public long simpleQueryForLong() {
        return statement.simpleQueryForLong();
    }

    @Override
    public String simpleQueryForString() {
        return statement.simpleQueryForString();
    }
}
