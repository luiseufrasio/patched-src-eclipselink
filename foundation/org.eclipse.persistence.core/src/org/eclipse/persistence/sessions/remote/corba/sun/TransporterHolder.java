/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.sessions.remote.corba.sun;


/**
 * INTERNAL:
* org/eclipse/persistence/internal/remote/TransporterHolder.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from d:/StarTeam/DIDev/Pine/TopLink/DISource/IDLs/CorbaRemoteSessionControllerSun.idl
* Thursday, May 3, 2001 1:36:59 PM EDT
*/
public final class TransporterHolder implements org.omg.CORBA.portable.Streamable {
    public org.eclipse.persistence.internal.sessions.remote.Transporter value = null;

    public TransporterHolder() {
    }

    public TransporterHolder(org.eclipse.persistence.internal.sessions.remote.Transporter initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.type();
    }
}
