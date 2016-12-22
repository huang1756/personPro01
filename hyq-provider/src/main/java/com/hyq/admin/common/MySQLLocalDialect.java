package com.hyq.admin.common;


import org.hibernate.dialect.MySQLInnoDBDialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimeType;
import org.hibernate.type.TimestampType;

/**
 *
 */
public class MySQLLocalDialect extends MySQLInnoDBDialect {
    public MySQLLocalDialect() {
        this.registerFunction("datediff", new StandardSQLFunction("datediff", IntegerType.INSTANCE));
        this.registerFunction("timediff", new StandardSQLFunction("timediff", TimeType.INSTANCE));
        this.registerFunction("date_format", new StandardSQLFunction("date_format", StringType.INSTANCE));
        this.registerFunction("curdate", new NoArgSQLFunction("curdate", DateType.INSTANCE));
        this.registerFunction("curtime", new NoArgSQLFunction("curtime", TimeType.INSTANCE));
        this.registerFunction("current_date", new NoArgSQLFunction("current_date", DateType.INSTANCE, false));
        this.registerFunction("current_time", new NoArgSQLFunction("current_time", TimeType.INSTANCE, false));
        this.registerFunction("current_timestamp", new NoArgSQLFunction("current_timestamp", TimestampType.INSTANCE, false));
        this.registerFunction("date", new StandardSQLFunction("date", DateType.INSTANCE));
        this.registerFunction("day", new StandardSQLFunction("day", IntegerType.INSTANCE));
        this.registerFunction("dayofmonth", new StandardSQLFunction("dayofmonth", IntegerType.INSTANCE));
        this.registerFunction("dayname", new StandardSQLFunction("dayname", StringType.INSTANCE));
        this.registerFunction("dayofweek", new StandardSQLFunction("dayofweek", IntegerType.INSTANCE));
        this.registerFunction("dayofyear", new StandardSQLFunction("dayofyear", IntegerType.INSTANCE));
        this.registerFunction("from_days", new StandardSQLFunction("from_days", DateType.INSTANCE));
        this.registerFunction("from_unixtime", new StandardSQLFunction("from_unixtime", TimestampType.INSTANCE));
        this.registerFunction("hour", new StandardSQLFunction("hour", IntegerType.INSTANCE));
        this.registerFunction("last_day", new StandardSQLFunction("last_day", DateType.INSTANCE));
        this.registerFunction("localtime", new NoArgSQLFunction("localtime", TimestampType.INSTANCE));
        this.registerFunction("localtimestamp", new NoArgSQLFunction("localtimestamp", TimestampType.INSTANCE));
        this.registerFunction("microseconds", new StandardSQLFunction("microseconds", IntegerType.INSTANCE));
        this.registerFunction("minute", new StandardSQLFunction("minute", IntegerType.INSTANCE));
        this.registerFunction("month", new StandardSQLFunction("month", IntegerType.INSTANCE));
        this.registerFunction("monthname", new StandardSQLFunction("monthname", StringType.INSTANCE));
        this.registerFunction("now", new NoArgSQLFunction("now", TimestampType.INSTANCE));
        this.registerFunction("quarter", new StandardSQLFunction("quarter", IntegerType.INSTANCE));
        this.registerFunction("second", new StandardSQLFunction("second", IntegerType.INSTANCE));
        this.registerFunction("sec_to_time", new StandardSQLFunction("sec_to_time", TimeType.INSTANCE));
        this.registerFunction("sysdate", new NoArgSQLFunction("sysdate", TimestampType.INSTANCE));
        this.registerFunction("time", new StandardSQLFunction("time", TimeType.INSTANCE));
        this.registerFunction("timestamp", new StandardSQLFunction("timestamp", TimestampType.INSTANCE));
        this.registerFunction("time_to_sec", new StandardSQLFunction("time_to_sec", IntegerType.INSTANCE));
        this.registerFunction("to_days", new StandardSQLFunction("to_days", LongType.INSTANCE));
        this.registerFunction("unix_timestamp", new StandardSQLFunction("unix_timestamp", LongType.INSTANCE));
        this.registerFunction("utc_date", new NoArgSQLFunction("utc_date", StringType.INSTANCE));
        this.registerFunction("utc_time", new NoArgSQLFunction("utc_time", StringType.INSTANCE));
        this.registerFunction("utc_timestamp", new NoArgSQLFunction("utc_timestamp", StringType.INSTANCE));
        this.registerFunction("week", new StandardSQLFunction("week", IntegerType.INSTANCE));
        this.registerFunction("weekday", new StandardSQLFunction("weekday", IntegerType.INSTANCE));
        this.registerFunction("weekofyear", new StandardSQLFunction("weekofyear", IntegerType.INSTANCE));
        this.registerFunction("year", new StandardSQLFunction("year", IntegerType.INSTANCE));
        this.registerFunction("yearweek", new StandardSQLFunction("yearweek", IntegerType.INSTANCE));
        this.registerFunction("ifnull", new StandardSQLFunction("ifnull"));
    }
}

