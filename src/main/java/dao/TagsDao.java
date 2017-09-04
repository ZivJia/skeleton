package dao;

import generated.tables.Receipts;
import generated.tables.Tag;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.omg.IOP.TAG_CODE_SETS;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
import static generated.Tables.TAG;

public class TagsDao {
    DSLContext dsl;

    public TagsDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public String insert(String tag, int id) {

        ReceiptsRecord receiptsRecord = dsl.selectFrom(RECEIPTS).where(RECEIPTS.ID.eq(id)).fetchOne();

        if(receiptsRecord==null){
            //do nothing
            return "no id found";
        }else{
            TagRecord tagRecord = dsl.selectFrom(TAG).where(TAG.ID.eq(id).and(TAG.TAG_.eq(tag))).fetchOne();
            if(tagRecord==null){
                //insert
                dsl.insertInto(TAG, TAG.ID, TAG.TAG_).values(id, tag).execute();
                return "insert successfully";
            }else{
                //delete
                dsl.deleteFrom(TAG).where(TAG.ID.eq(id)).execute();
                return "delete successfully";
            }
        }


    }
    public List<ReceiptsRecord> getAllReceiptsFromTag(String tag) {

        return dsl.selectFrom(RECEIPTS).where(RECEIPTS.ID.in(dsl.
                select(TAG.ID).from(TAG).where(TAG.TAG_.eq(tag)).fetch())).fetch();
    }
}

