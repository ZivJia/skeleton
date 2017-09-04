/**
 * This class is generated by jOOQ
 */
package generated.tables;


import generated.Public;
import generated.tables.records.TagRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tag extends TableImpl<TagRecord> {

	private static final long serialVersionUID = -1248644087;

	/**
	 * The reference instance of <code>public.tag</code>
	 */
	public static final Tag TAG = new Tag();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TagRecord> getRecordType() {
		return TagRecord.class;
	}

	/**
	 * The column <code>public.tag.id</code>.
	 */
	public final TableField<TagRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.tag.tag</code>.
	 */
	public final TableField<TagRecord, String> TAG_ = createField("tag", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>public.tag</code> table reference
	 */
	public Tag() {
		this("tag", null);
	}

	/**
	 * Create an aliased <code>public.tag</code> table reference
	 */
	public Tag(String alias) {
		this(alias, TAG);
	}

	private Tag(String alias, Table<TagRecord> aliased) {
		this(alias, aliased, null);
	}

	private Tag(String alias, Table<TagRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tag as(String alias) {
		return new Tag(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Tag rename(String name) {
		return new Tag(name, null);
	}
}