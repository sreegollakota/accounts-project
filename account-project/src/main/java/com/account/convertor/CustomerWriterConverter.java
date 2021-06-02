package com.account.convertor;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.account.model.Customer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriterConverter implements Converter<Customer, DBObject> {

    @Override
    public DBObject convert(final Customer cust) {
        final DBObject dbObject = new BasicDBObject();
        
        dbObject.put("custName", cust.getCustomerName());
        dbObject.put("dateOfBirth", cust.getDateOfBirth());
        dbObject.put("address", cust.getAddress());

        if (cust.getAccounts() != null) {
            final DBObject accountsDbObject = new BasicDBObject();
            accountsDbObject.put("value", cust.getAccounts().get(0));
            dbObject.put("accounts", accountsDbObject);
        }
        dbObject.removeField("_class");
        return dbObject;
    }

}


