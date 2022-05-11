package gov.ifms.common.config;

import org.hibernate.dialect.DB2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class Ifms2Db2Dialect extends DB2Dialect {
    public Ifms2Db2Dialect() {
        super();
        registerFunction("wf_user_name",new StandardSQLFunction("MASTER_V1.GET_WF_USER_NAME",new StringType()));
    }
}
