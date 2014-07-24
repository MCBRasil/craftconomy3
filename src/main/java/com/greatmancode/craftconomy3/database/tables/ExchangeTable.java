/*
 * This file is part of Craftconomy3.
 *
 * Copyright (c) 2011-2014, Greatman <http://github.com/greatman/>
 *
 * Craftconomy3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Craftconomy3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Craftconomy3.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.greatmancode.craftconomy3.database.tables;

public class ExchangeTable extends DatabaseTable {

    public static final String TABLE_NAME = "exchange";

    public final String CREATE_TABLE_MYSQL = "CREATE TABLE `" + getPrefix() + TABLE_NAME + "` (" +
            "  `from_currency` VARCHAR(50) NOT NULL," +
            "  `to_currency` VARCHAR(50) NOT NULL," +
            "  `amount` double DEFAULT 1.0," +
            "  PRIMARY KEY (`from_currency`, to_currency)" +
            "  CONSTRAINT `fk_exchange_currencyfrom`" +
            "    FOREIGN KEY (from_currency)" +
            "    REFERENCES " + getPrefix() + CurrencyTable.TABLE_NAME + " (name)) ON UPDATE CASCADE ON DELETE CASCADE" +
            "  CONSTRAINT `fk_exchange_currencyto`" +
            "    FOREIGN KEY (to_currency)" +
            "    REFERENCES " + getPrefix() + CurrencyTable.TABLE_NAME + " (name)) ON UPDATE CASCADE ON DELETE CASCADE" +
            ") ENGINE=InnoDB;";

    public final String SELECT_ENTRY = "SELECT * FROM " + getPrefix() + TABLE_NAME + " " +
            "WHERE from_currency=? AND to_currency=?";

    public final String SELECT_ALL = "SELECT * FROM "+getPrefix() + TABLE_NAME;

    public final String INSERT_ENTRY = "INSERT INTO " + getPrefix() + TABLE_NAME + "(from_currency, to_currency, amount) " +
            "VALUES(?,?,?)";

    public final String UPDATE_ENTRY = "UPDATE " + getPrefix() + TABLE_NAME + " SET amount=? " +
            "WHERE from_currency.name=? AND to_currency.name=?";

    public ExchangeTable(String prefix) {
        super(prefix);
    }
}
