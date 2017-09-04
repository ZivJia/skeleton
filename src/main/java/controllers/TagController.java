package controllers;

import api.ReceiptResponse;
import dao.TagsDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagsDao tags;

    public TagController(TagsDao tags) {
        this.tags = tags;
    }

    @PUT
    @Path("/tags/{tag}")
    public String toggleTag(@PathParam("tag") String tagName, int id) {
       return tags.insert(tagName, id);
        // <your code here
    }
    @GET
    @Path("/tags/{tag}")
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tag) {
        List<ReceiptsRecord> receiptRecords = tags.getAllReceiptsFromTag(tag);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }

}


