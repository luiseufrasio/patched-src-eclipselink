/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 1998, 2018 IBM Corporation and/or its affiliates. All rights reserved.
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
// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.
package org.eclipse.persistence.internal.sessions.coordination.rmi.iiop;

import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.rmi.Remote;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import org.eclipse.persistence.sessions.coordination.Command;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;

public class _RMIRemoteCommandConnectionImpl_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {

    private RMIRemoteCommandConnectionImpl target = null;
    private ORB orb = null;

    private static final String[] _type_ids = {
        "RMI:org.eclipse.persistence.internal.sessions.coordination.rmi.RMIRemoteCommandConnection:0000000000000000"
    };

    public void setTarget(Remote target) {
        this.target = (RMIRemoteCommandConnectionImpl) target;
    }

    public Remote getTarget() {
        return target;
    }

    public org.omg.CORBA.Object thisObject() {
        return this;
    }

    public void deactivate() {
        if (orb != null) {
            orb.disconnect(this);
            _set_delegate(null);
        }
    }

    public ORB orb() {
        return _orb();
    }

    public void orb(ORB orb) {
        orb.connect(this);
    }

    public void _set_delegate(Delegate del) {
        super._set_delegate(del);
        if (del != null)
            orb = _orb();
        else
            orb = null;
    }

    public String[] _ids() { 
        return (String [] )  _type_ids.clone();
    }

    public OutputStream _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 43: 
                    if (method.equals("executeCommand__org_omg_boxedRMI_seq1_octet")) {
                        return executeCommand__org_omg_boxedRMI_seq1_octet(in, reply);
                    }
                case 69: 
                    if (method.equals("executeCommand__org_eclipse_persistence_sessions_coordination_Command")) {
                        return executeCommand__org_eclipse_persistence_sessions_coordination_Command(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }

    private OutputStream executeCommand__org_eclipse_persistence_sessions_coordination_Command(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Command arg0 = (Command) in.read_value(Command.class);
        Object result = target.executeCommand(arg0);
        OutputStream out = reply.createReply();
        Util.writeAny(out,result);
        return out;
    }

    private OutputStream executeCommand__org_omg_boxedRMI_seq1_octet(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        byte[] arg0 = (byte[]) in.read_value(byte[].class);
        Object result = target.executeCommand(arg0);
        OutputStream out = reply.createReply();
        Util.writeAny(out,result);
        return out;
    }
}
