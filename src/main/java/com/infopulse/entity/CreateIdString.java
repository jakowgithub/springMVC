package com.infopulse.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.stream.Stream;

public class CreateIdString implements IdentifierGenerator {

    private  String idstring;

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format( "select %s from %s", session.getEntityPersister(obj.getClass().getName(), obj)
                             .getIdentifierPropertyName(),
                             obj.getClass().getSimpleName());

        Stream ids = session.createQuery(query).stream();

        Long max = ids.map(id -> id.toString().replaceAll("-", ""))
                                              .mapToLong(str -> Long.parseLong(str.toString()))
                                              .max()
                                              .orElse(0L);

        String idstring = String.valueOf(max+1);
        String string12;

        if(idstring.length()<=12) {

            StringBuilder stringTmp = new StringBuilder();

            for (int i=0; i<12-idstring.length(); i++) {
                stringTmp = stringTmp.append("0");
            }
            string12 = stringTmp.append(idstring).toString();
        }
        else  string12 = idstring.substring(0, 12);

        return string12.replaceAll(".{4}", "$0 ")
                       .trim()
                       .replace(" ", "-");
    }

}
