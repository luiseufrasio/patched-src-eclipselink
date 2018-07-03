/*
 * Copyright (c) 2005, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2005, 2015 SAP. All rights reserved.
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
//     SAP - initial API and implementation

package org.eclipse.persistence.testing.models.wdf.jpa1.employee;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("-2")
public class ReadOnlyEntitySubclass extends ReadOnlyEntity {

    public ReadOnlyEntitySubclass() {
        super();
    }

    public ReadOnlyEntitySubclass(int i, String string) {
        super(i, string);
    }

    @Basic
    @Column(name = "ADDON")
    protected String addon;

    public String getNumber() {
        return addon;
    }

    public void setNumber(String addon) {
        this.addon = addon;
    }
}
