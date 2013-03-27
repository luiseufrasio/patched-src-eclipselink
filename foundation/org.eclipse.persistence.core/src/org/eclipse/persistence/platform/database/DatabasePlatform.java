/*******************************************************************************
 * Copyright (c) 1998, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.platform.database;

/**
 * DatabasePlatform is private to EclipseLink. It encapsulates behavior specific to a database platform
 * (eg. Oracle, Sybase, DBase), and provides protocol for EclipseLink to access this behavior. The behavior categories
 * which require platform specific handling are SQL generation and sequence behavior. While database platform
 * currently provides sequence number retrieval behavior, this will move to a sequence manager (when it is
 * implemented).
 *
 * @see AccessPlatform
 * @see DB2Platform
 * @see DBasePlatform
 * @see OraclePlatform
 * @see SybasePlatform
 *
 * @since TOPLink/Java 1.0
 */
public class DatabasePlatform extends org.eclipse.persistence.internal.databaseaccess.DatabasePlatform {
    public static final int DEFAULT_VARCHAR_SIZE = 255;
    
    protected Boolean useJDBCStoredProcedureSyntax;
    protected String driverName;
    
    public DatabasePlatform() {
    	super();
    	useJDBCStoredProcedureSyntax = null;
    }
    
    /**
     * Returns true if this platform complies with the expected behavior from
     * a jdbc execute call. Most platforms do, some have issues:
     * 
     * @see PostgreSQLPlatform
     */
    public boolean isJDBCExecuteCompliant() {
        return true;
    }
    
    /**
     * During auto-detect, the driver name is set on the platform.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    /**
     * Return true if JDBC syntax should be used for stored procedure calls.
     */
    public boolean useJDBCStoredProcedureSyntax() {
        if (useJDBCStoredProcedureSyntax == null) {
            useJDBCStoredProcedureSyntax = this.driverName != null && this.driverName.equals("Oracle");
        }
        
        return useJDBCStoredProcedureSyntax;
    }
}
