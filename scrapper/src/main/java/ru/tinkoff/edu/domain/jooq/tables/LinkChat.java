/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.domain.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.tinkoff.edu.domain.jooq.Keys;
import ru.tinkoff.edu.domain.jooq.Public;
import ru.tinkoff.edu.domain.jooq.tables.records.LinkChatRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LinkChat extends TableImpl<LinkChatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.link_chat</code>
     */
    public static final LinkChat LINK_CHAT = new LinkChat();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LinkChatRecord> getRecordType() {
        return LinkChatRecord.class;
    }

    /**
     * The column <code>public.link_chat.chat_id</code>.
     */
    public final TableField<LinkChatRecord, Integer> CHAT_ID = createField(DSL.name("chat_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.link_chat.link_id</code>.
     */
    public final TableField<LinkChatRecord, Integer> LINK_ID = createField(DSL.name("link_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private LinkChat(Name alias, Table<LinkChatRecord> aliased) {
        this(alias, aliased, null);
    }

    private LinkChat(Name alias, Table<LinkChatRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.link_chat</code> table reference
     */
    public LinkChat(String alias) {
        this(DSL.name(alias), LINK_CHAT);
    }

    /**
     * Create an aliased <code>public.link_chat</code> table reference
     */
    public LinkChat(Name alias) {
        this(alias, LINK_CHAT);
    }

    /**
     * Create a <code>public.link_chat</code> table reference
     */
    public LinkChat() {
        this(DSL.name("link_chat"), null);
    }

    public <O extends Record> LinkChat(Table<O> child, ForeignKey<O, LinkChatRecord> key) {
        super(child, key, LINK_CHAT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<LinkChatRecord> getPrimaryKey() {
        return Keys.LINK_CHAT_PKEY;
    }

    @Override
    public List<ForeignKey<LinkChatRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LINK_CHAT__LINK_CHAT_CHAT_ID_FKEY, Keys.LINK_CHAT__LINK_CHAT_LINK_ID_FKEY);
    }

    private transient Chat _chat;
    private transient Link _link;

    /**
     * Get the implicit join path to the <code>public.chat</code> table.
     */
    public Chat chat() {
        if (_chat == null)
            _chat = new Chat(this, Keys.LINK_CHAT__LINK_CHAT_CHAT_ID_FKEY);

        return _chat;
    }

    /**
     * Get the implicit join path to the <code>public.link</code> table.
     */
    public Link link() {
        if (_link == null)
            _link = new Link(this, Keys.LINK_CHAT__LINK_CHAT_LINK_ID_FKEY);

        return _link;
    }

    @Override
    public LinkChat as(String alias) {
        return new LinkChat(DSL.name(alias), this);
    }

    @Override
    public LinkChat as(Name alias) {
        return new LinkChat(alias, this);
    }

    @Override
    public LinkChat as(Table<?> alias) {
        return new LinkChat(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public LinkChat rename(String name) {
        return new LinkChat(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LinkChat rename(Name name) {
        return new LinkChat(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public LinkChat rename(Table<?> name) {
        return new LinkChat(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link #convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link #convertFrom(Class, Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}