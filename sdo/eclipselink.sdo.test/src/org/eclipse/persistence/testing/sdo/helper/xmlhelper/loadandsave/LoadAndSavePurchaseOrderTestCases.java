/*******************************************************************************
 * Copyright (c) 1998, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.sdo.helper.xmlhelper.loadandsave;

import java.util.ArrayList;
import java.util.List;

import commonj.sdo.DataObject;
import commonj.sdo.Type;

import junit.textui.TestRunner;
import org.eclipse.persistence.sdo.SDOConstants;
import org.eclipse.persistence.sdo.SDOProperty;


public class LoadAndSavePurchaseOrderTestCases extends LoadAndSaveTestCases {
    public LoadAndSavePurchaseOrderTestCases(String name) {
        super(name);
    }

    public static void main(String[] args) {
        String[] arguments = { "-c", "org.eclipse.persistence.testing.sdo.helper.xmlhelper.loadandsave.LoadAndSavePurchaseOrderTestCases" };
        TestRunner.main(arguments);
    }

    protected String getControlFileName() {
        return ("./org/eclipse/persistence/testing/sdo/helper/xmlhelper/purchaseOrderNS.xml");
    }

    protected String getNoSchemaControlFileName() {
        return ("./org/eclipse/persistence/testing/sdo/helper/xmlhelper/purchaseOrderNSNoSchema.xml");
    }

    protected String getSchemaName() {
        return "./org/eclipse/persistence/testing/sdo/helper/xmlhelper/PurchaseOrder.xsd";
    }

    protected String getControlRootURI() {
        return NON_DEFAULT_URI;
    }

    protected String getControlRootName() {
        return "purchaseOrder";
    }

    protected String getRootInterfaceName() {
        return "PurchaseOrderType";
    }

    // Override package generation based on the JAXB 2.0 algorithm in SDOUtil.java
    protected List<String> getPackages() {
        List<String> packages = new ArrayList<String>();       
        packages.add(NON_DEFAULT_JAVA_PACKAGE_DIR);
        return packages;
    }
  
    protected void registerTypes() {
        Type intType = typeHelper.getType("commonj.sdo", "Int");
        Type stringType = typeHelper.getType("commonj.sdo", "String");
        Type dateType = typeHelper.getType("commonj.sdo", "YearMonthDay");
        Type addressType = registerAddressType();
        Type itemsType = registerItemsType();

        // create a new Type for Customers
        DataObject purchaseOrderTypeType = dataFactory.create("commonj.sdo", "Type");

        SDOProperty prop = (SDOProperty)purchaseOrderTypeType.getType().getProperty("uri");
        purchaseOrderTypeType.set(prop, getControlRootURI());

        prop = (SDOProperty)purchaseOrderTypeType.getType().getProperty("name");
        purchaseOrderTypeType.set(prop, "purchaseOrder");

        // create a orderDateProperty 
        addProperty(purchaseOrderTypeType, "orderDate", dateType);

        DataObject shipToProp = addProperty(purchaseOrderTypeType, "shipTo", addressType, true, false, true);

        DataObject billToProp = addProperty(purchaseOrderTypeType, "billTo", addressType, true, false, true);

        addProperty(purchaseOrderTypeType, "comment", stringType);

        DataObject itemsProp = addProperty(purchaseOrderTypeType, "items", itemsType, true, false, true);

        Type POType = typeHelper.define(purchaseOrderTypeType);

        DataObject propDO = dataFactory.create(SDOConstants.SDO_PROPERTY);
        propDO.set("name", getControlRootName());
        propDO.set("type", POType);
        typeHelper.defineOpenContentProperty(getControlRootURI(), propDO);
    }

    private Type registerAddressType() {
        Type stringType = typeHelper.getType("commonj.sdo", "String");

        // create a new Type for addressType
        DataObject addressType = dataFactory.create("commonj.sdo", "Type");

        SDOProperty prop = (SDOProperty)addressType.getType().getProperty("uri");
        addressType.set(prop, getControlRootURI());

        prop = (SDOProperty)addressType.getType().getProperty("name");
        addressType.set(prop, "AddressType");

        addProperty(addressType, "country", stringType);
        addProperty(addressType, "name", stringType);
        addProperty(addressType, "street", stringType);
        addProperty(addressType, "city", stringType);
        addProperty(addressType, "state", stringType);
        addProperty(addressType, "zip", stringType);

        return typeHelper.define(addressType);
    }

    private Type registerItemType() {
        Type stringType = typeHelper.getType("commonj.sdo", "String");
        Type intType = typeHelper.getType("commonj.sdo", "Int");
        Type floatType = typeHelper.getType("commonj.sdo", "Float");
        Type dateType = typeHelper.getType("commonj.sdo", "YearMonthDay");

        // create a new Type for addressType
        DataObject itemType = dataFactory.create("commonj.sdo", "Type");

        SDOProperty prop = (SDOProperty)itemType.getType().getProperty("uri");
        itemType.set(prop, getControlRootURI());

        prop = (SDOProperty)itemType.getType().getProperty("name");
        itemType.set(prop, "Item");

        addProperty(itemType, "partNum", stringType);
        addProperty(itemType, "productName", stringType);
        addProperty(itemType, "quantity", intType);
        addProperty(itemType, "USPrice", floatType);
        addProperty(itemType, "comment", stringType);
        addProperty(itemType, "shipDate", dateType);

        return typeHelper.define(itemType);

    }

    private Type registerItemsType() {
        Type stringType = typeHelper.getType("commonj.sdo", "String");
        Type itemType = registerItemType();

        // create a new Type for itemsType
        DataObject itemsType = dataFactory.create("commonj.sdo", "Type");

        SDOProperty prop = (SDOProperty)itemsType.getType().getProperty("uri");
        itemsType.set(prop, getControlRootURI());

        prop = (SDOProperty)itemsType.getType().getProperty("name");
        itemsType.set(prop, "Items");

        DataObject itemProp = addProperty(itemsType, "item", itemType, true, true, true);

        return typeHelper.define(itemsType);

    }
}