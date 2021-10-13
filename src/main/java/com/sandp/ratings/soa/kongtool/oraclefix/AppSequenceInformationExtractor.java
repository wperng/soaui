package com.sandp.ratings.soa.kongtool.oraclefix;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorOracleDatabaseImpl;

public class AppSequenceInformationExtractor extends SequenceInformationExtractorOracleDatabaseImpl {
    
    public static final AppSequenceInformationExtractor INSTANCE = new AppSequenceInformationExtractor();
    
    @Override
    protected Long resultSetMinValue(ResultSet resultSet) throws SQLException {
       return resultSet.getBigDecimal("min_value").longValue();
    }

}
