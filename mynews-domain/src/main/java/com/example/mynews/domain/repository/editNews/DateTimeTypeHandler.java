package com.example.mynews.domain.repository.editNews;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

@MappedJdbcTypes(JdbcType.DATE)
@MappedTypes(DateTime.class)
public class DateTimeTypeHandler implements TypeHandler<DateTime> {

    @Override
    public void setParameter(PreparedStatement ps, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        if (dateTime != null) {
            ps.setTimestamp(i, new Timestamp(dateTime.getMillis()));
        } else {
            ps.setTimestamp(i, null);
        }
    }

    @Override
    public DateTime getResult(ResultSet rs, String columnName) throws SQLException {
        return toDateTime(rs.getTimestamp(columnName));
    }

    @Override
    public DateTime getResult(ResultSet rs, int columnIndex) throws SQLException {
        return toDateTime(rs.getTimestamp(columnIndex));
    }

    @Override
    public DateTime getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return  toDateTime(cs.getTimestamp(columnIndex));
    }

    private static DateTime toDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return new DateTime(timestamp.getTime(), DateTimeZone.UTC);
        } else {
            return null;
        }
    }
}
