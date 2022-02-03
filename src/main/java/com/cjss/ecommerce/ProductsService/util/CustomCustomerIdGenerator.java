package com.cjss.ecommerce.ProductsService.util;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CustomCustomerIdGenerator extends SequenceStyleGenerator {


    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%04d";
    public static final String VALUE_PREFIX_PARAMETER = "";
    public static final String VALUE_PREFIX_DEFAULT = "CUST";
    private String numberFormat;
    private String valuePrefix;


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

Connection connection = session.connection();
        return valuePrefix+String.format(numberFormat);
    }

}
